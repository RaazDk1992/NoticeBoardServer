package objects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.sun.xml.internal.ws.api.addressing.WSEndpointReference.Metadata;

import db.Db;
import db.Queries;

public class Staff extends Queries{
	public Staff(){
		
	}
	public JSONArray addStaff(String staffName, String staffDesignation,String Contact, String imagePath, int Weight){
		JSONArray response = new JSONArray();
		JSONObject obj  = new JSONObject();
		Connection conn = new Db().connect();
		PreparedStatement stmt = null ;
		try {
			stmt = conn.prepareStatement(ADD_EMPLOYEE_Q);
			stmt.setString(1, staffName);
			stmt.setString(2, staffDesignation);
			stmt.setString(3, Contact);
			stmt.setString(4, imagePath);
			stmt.setInt(5, Weight);
			int count = stmt.executeUpdate();
			if(count >0){
				obj.put("success", "Data added successfully!!");
			}else {
				obj.put("fail", "Data could not be added!!");
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
		} finally{
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			//	e.printStackTrace();
			}
		}
		response.put(obj);
		return response;
	}
	public JSONArray updateStaff(int staffId, String staffName, String staffDesignation, String imagePath, int Weight){
		JSONArray response = new JSONArray();
		
		return response;
	}
	public JSONArray deleteStaff(int staffId){
		JSONArray response = new JSONArray();
		
		return response;
	}
	public JSONArray fetchStaff(String IpAddress, int  Port){
		JSONArray response = new JSONArray();
		JSONObject obj ;
		Connection conn = new Db().connect();
		PreparedStatement stmt;
		ResultSet result;
		try {
			stmt = conn.prepareStatement(FETCH_EMPLOYEES);
			stmt.setBoolean(1, true);
			result = stmt.executeQuery();
			String FullPath;
			while(result.next()){
				obj = new JSONObject();
				ResultSetMetaData meta = result.getMetaData();
				FullPath = "http://"+IpAddress+":"+Port+result.getString(5);
				obj.put(meta.getColumnLabel(2), result.getString(2));
				obj.put(meta.getColumnLabel(3), result.getString(3));
				obj.put(meta.getColumnLabel(4), result.getString(4));
				obj.put(meta.getColumnLabel(5), FullPath);
				response.put(obj);
				
			}
			
		} catch (SQLException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return response;
	}
	
}