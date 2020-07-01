package objects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.json.JsonObject;
import javax.json.bind.JsonbException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import db.Db;
import db.Queries;

public class Budget extends Queries{
	public Budget(){
		
	}
	public JSONArray addBudget(String FileLocation, String Description){
		JSONArray response = new JSONArray();
		JSONObject obj = new JSONObject();
		Connection conn = new Db().connect();
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(ADD_PlANS_AND_BUDGET);
			stmt.setString(1, FileLocation);
			stmt.setString(2, Description);
			int count = stmt.executeUpdate();
			if(count >0){
				obj.put("success", "Data added sucessfully");
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
		}finally {
			try {
				
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return response;
	}
	public JSONArray fetchBudget(String IpAddress, int Port){
		JSONArray response = new JSONArray();
		Connection conn = new Db().connect();
		JSONObject obj;
		PreparedStatement stmt;
		ResultSet result;
		try {
			stmt = conn.prepareStatement(FETCH_BUDGETS);
			result = stmt.executeQuery();
			while(result.next()){
				obj = new JSONObject();
				obj.put(result.getMetaData().getColumnLabel(1), result.getString(1));
				obj.put(result.getMetaData().getColumnLabel(2), "http://"+IpAddress+":"+Port+result.getString(2));
				obj.put(result.getMetaData().getColumnLabel(3), result.getString(3));
				response.put(obj);
			}
			return response;
		} catch (SQLException | JSONException  e) {
			// TODO Auto-generated catch block
			
			obj = new JSONObject();
			try {
				obj.put("ex", e.getMessage());
				response.put(obj);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
		return response;
	}
	public JSONArray updateBudget(){
		JSONArray response = new JSONArray();
		
		return response;
	}
	public JSONArray deleteBudget(){
		JSONArray response = new JSONArray();
		
		return response;
		
	}
	
}