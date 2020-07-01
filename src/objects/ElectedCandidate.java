package objects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mysql.jdbc.ResultSetMetaData;

import db.Db;
import db.Queries;

public class ElectedCandidate extends Queries{
	
	public ElectedCandidate(){
		
	}
	public JSONArray addCandidate(String candidateName, String designation,String contact, String imagePath, int CandidateWeight){
		JSONObject obj = new  JSONObject();
		JSONArray response = new JSONArray();
		Connection conn = new Db().connect();
		try {
			PreparedStatement stmt = conn.prepareStatement(ADD_ELECTED_Q);
			stmt.setString(1, candidateName);
			stmt.setString(2, designation);
			stmt.setString(3, contact);
			stmt.setString(4, imagePath);
			stmt.setInt(5, CandidateWeight);
			int result = stmt.executeUpdate();
			if(result>0){
				obj.put("success", "Data added successfully!!");
			}else {
				obj.put("fail", "Data could not be stored");
			}
			conn.close();
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
	public JSONArray updateCandidate(int candidateId , String candidateName, String designation, String imagePath, int SN){
		JSONArray response = new JSONArray();
		
		return response;
	}
	public JSONArray deleteCandidate(int candidateId){
		JSONArray response = new JSONArray();
		
		return response;
	}
	public JSONArray fetchCandidate(String IpAddress, int Port){
		JSONArray response = new JSONArray();
		Connection conn = new Db().connect();
		PreparedStatement stmt = null;
		ResultSet result = null;
		JSONObject obj = null;
		java.sql.ResultSetMetaData meta;
		try {
			stmt = conn.prepareStatement(fetch_candidate);
			result = stmt.executeQuery();
			meta = result.getMetaData();
			while(result.next()){
				obj = new JSONObject();
				obj.put(meta.getColumnLabel(1), result.getString(1));
				obj.put(meta.getColumnLabel(2), result.getString(2));
				obj.put(meta.getColumnLabel(3), result.getString(3));
				obj.put(meta.getColumnLabel(4), result.getString(4));
				obj.put(meta.getColumnLabel(5), "http://"+IpAddress+":"+Port+result.getString(5));
				obj.put(meta.getColumnLabel(6), result.getString(6));
				response.put(obj);
			}
			
			
		} catch (SQLException | JSONException e) {
			// TODO Auto-generated catch block
			obj = new JSONObject();
			try {
				obj.put("ex", e.getMessage());
				response.put(obj);
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally{
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
	
}