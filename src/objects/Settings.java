package objects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.json.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import db.Db;
import db.Queries;

public class Settings extends Queries {
	
	public  Settings(){
		
	}
	public JSONArray getSettings(){
		
		PreparedStatement stmt = null;
		JSONArray response = new JSONArray();
		ResultSet result = null;
		JSONObject obj = new JSONObject();
		
		Connection conn = new Db().connect();
		try {
			stmt = conn.prepareStatement(LOAD_SETTINGS_Q);
			result  = stmt.executeQuery();
			while(result.next()){
				
				obj.put(result.getString(1), result.getString(2));
				
			}
			response.put(obj) ;
		} catch (SQLException | JSONException e) {
			// TODO Auto-generated catch block
			try {
				obj.put("ex", e.getMessage());
				response.put(obj);
				
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				result.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return response;
	}
public JSONArray settingsAsArray(){
		
		PreparedStatement stmt = null;
		JSONArray response = new JSONArray();
		ResultSet result = null;
		JSONObject obj = null;
		
		
		Connection conn = new Db().connect();
		try {
			stmt = conn.prepareStatement(LOAD_SETTINGS_Q);
			result  = stmt.executeQuery();
			while(result.next()){
				 obj = new JSONObject();
				 obj.put("field_name", result.getString(1));
				obj.put("field_value", result.getString(2));
				response.put(obj);
			}
			//response.put(obj) ;
		} catch (SQLException | JSONException e) {
			// TODO Auto-generated catch block
			try {
				obj.put("ex", e.getMessage());
				response.put(obj);
				
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				result.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return response;
	}
	
	public JSONArray  updateSettings(String  FieldName, String FieldValue){
		JSONArray response = new JSONArray();
		
		return response;
	}

}
