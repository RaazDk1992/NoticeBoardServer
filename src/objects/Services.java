package objects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import db.Db;
import db.Queries;

public class Services extends Queries {
	public Services(){
		
	}
	
	public JSONArray addServices(String ServiceTitle, String RequiredDocuments, String Process, String RespectiveEmployee, String Amount){
		
		JSONArray response = new JSONArray();
		JSONObject obj = new JSONObject();
		PreparedStatement stmt = null;
		
		Connection conn = new Db().connect();
		try {
			 stmt = conn.prepareStatement(STORE_SERVICES);
			 stmt.setString(1, ServiceTitle);
			 stmt.setString(2, RequiredDocuments);
			 stmt.setString(3, Process);
			 stmt.setString(4, Amount);
			 stmt.setString(5, RespectiveEmployee);
			 int result = stmt.executeUpdate();
			 if(result >0){
				
				 obj.put("success", "Data added successfully!!");
			 } else {
				 obj.put("fail", "Data could not be added !!");
			 }
		} catch (SQLException | JSONException e) {
			// TODO Auto-generated catch block
			try {
				obj.put("ex", e.getMessage());
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}finally{
				try {
					stmt.close();
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
			}
			//e.printStackTrace();
		}
		response.put(obj);
		return response;
	}
	public JSONArray updateServices(int SN , String ServiceTitle, String RequiredDocuments, String Process, String RespectiveEmployee, String Amount){
		JSONArray response = new JSONArray();
		
		return response;
	}
	public JSONArray deleteServices(int SN){
		JSONArray response = new JSONArray();
		
		return response;
	}
	public JSONArray loadServices(){
		JSONArray response = new JSONArray();
		Connection conn = new Db().connect();
		JSONObject obj = null;
		PreparedStatement stmt = null;
		ResultSet result = null;
		ResultSetMetaData meta;
		try {
			stmt = conn.prepareStatement(FETCH_SERVICES);
			result = stmt.executeQuery();
			meta = result.getMetaData();
			while(result.next()){
				obj = new JSONObject();
				obj.put(meta.getColumnLabel(1), result.getString(1));
				obj.put(meta.getColumnLabel(2), result.getString(2));
				obj.put(meta.getColumnLabel(3), result.getString(3));
				obj.put(meta.getColumnLabel(4), result.getString(4));
				obj.put(meta.getColumnLabel(5), result.getString(5));
				obj.put(meta.getColumnLabel(6), result.getString(6));
				response.put(obj);
				
			}
		} catch (SQLException | JSONException e) {
			// TODO Auto-generated catch block
			try {
				obj = new JSONObject();
				obj.put("ex", e.getMessage());
				response.put(obj);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally{
			try {
				//result.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return response;
	}



}
