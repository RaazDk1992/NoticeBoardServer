package objects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import db.Db;
import db.Queries;

public class NewsFeed extends Queries{
	
	public NewsFeed(){
		
	}
	
	public JSONArray addNewsFeed(String title, String body){
		
		Connection conn = new Db().connect();
		JSONArray response = new JSONArray();
		JSONObject obj = new  JSONObject();
		try {
			PreparedStatement stmt = conn.prepareStatement(ADD_NOTICE_Q);
			stmt.setString(1, title);
			stmt.setString(2, body);
			int result = stmt.executeUpdate();
			if(result >0){
				obj.put("success", "Data Added sucessfully!!");
			}else {
				obj.put("success", "Could not store newsfeed");
			}
			
		} catch (SQLException | JSONException e) {
			// TODO Auto-generated catch block
			try {
				obj.put("ex", e.getMessage());
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		response.put(obj);
		return response;
	}
	public JSONArray updateNewsFeed(int feedId, String title, String body){
		
		JSONArray response = new JSONArray();
		
		return response;
	}
	public JSONArray fetchNewsFeed(){
		JSONArray response = new JSONArray();
		JSONObject obj;
		Connection conn = new Db().connect();
		ResultSet result;
		try {
			PreparedStatement stmt = conn.prepareStatement(fetch_newsfeed);
			result = stmt.executeQuery();
			while(result.next()){
				obj = new JSONObject();
				obj.put(result.getMetaData().getColumnLabel(1), result.getString(1));
				obj.put(result.getMetaData().getColumnLabel(2), result.getString(2));
				obj.put(result.getMetaData().getColumnLabel(3), result.getString(3));
				response.put(obj);
			}
		} catch (SQLException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response;
	}
	public JSONArray deleteNewsFeed(int feedId){
		
		JSONArray response = new JSONArray();
		
		return response;
	}
	
	
	
}