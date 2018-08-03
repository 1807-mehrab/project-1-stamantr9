package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Request;
import com.revature.util.ConnectionUtil;

public class RequestDao {
	public List<Request> getAllRequests() {
		PreparedStatement ps = null;
		Request c = null;
		List<Request> requests = new ArrayList<>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM request";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int request_id = rs.getInt("request_id");
				int requester_id = rs.getInt("employee_id");
				int request_amount = rs.getInt("request_amount");
				int resolved = rs.getInt("resolved");
				int resolver = rs.getInt("manager_id");
				
				c = new Request(request_id, requester_id, request_amount, resolved, resolver);
				requests.add(c);
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return requests;
	}
	
	public List<Request> getAllPendingRequests() {
		PreparedStatement ps = null;
		Request c = null;
		List<Request> requests = new ArrayList<>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM request";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int request_id = rs.getInt("request_id");
				int requester_id = rs.getInt("employee_id");
				int request_amount = rs.getInt("request_amount");
				int resolved = rs.getInt("resolved");
				int resolver = rs.getInt("manager_id");
				
				c = new Request(request_id, requester_id, request_amount, resolved, resolver);
				if(c.getResolved() == 0)
					requests.add(c);
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return requests;
	}
	
	public List<Request> getAllResolvedRequests() {
		PreparedStatement ps = null;
		Request c = null;
		List<Request> requests = new ArrayList<>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM request";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int request_id = rs.getInt("request_id");
				int requester_id = rs.getInt("employee_id");
				int request_amount = rs.getInt("request_amount");
				int resolved = rs.getInt("resolved");
				int resolver = rs.getInt("manager_id");
				
				c = new Request(request_id, requester_id, request_amount, resolved, resolver);
				if(c.getResolved() != 0)
					requests.add(c);
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return requests;
	}
	
	public void createRequest(int EID, int AMT) {
		CallableStatement cs = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "{CALL SP_CREATE_REQUEST(?, ?, ?, ?)}";
			cs = conn.prepareCall(sql);
			cs.setInt(1, EID);
			cs.setInt(2, AMT);
			cs.setInt(3, 0);
			cs.setInt(4, EID);
			
			Boolean result = cs.execute();
			if (!result) {
				System.out.println("Created Request");
			} else {
				System.out.println("Failed to create request");
			}
			
			cs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public void updateRequest(int RID, int RES, int MNG) {
		CallableStatement cs = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "{CALL SP_UPDATE_REQUEST(?, ?, ?)}";
			cs = conn.prepareCall(sql);
			cs.setInt(1, RID);
			cs.setInt(2, RES);
			cs.setInt(3, MNG);
			
			Boolean result = cs.execute();
			if (!result) {
				System.out.println("Created Request");
			} else {
				System.out.println("Failed to create request");
			}
			
			cs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public List<Request> getYourRequests(int email) {
		PreparedStatement ps = null;
		Request c = null;
		List<Request> requests = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(email);
		
		try (Connection conn = ConnectionUtil.getConnection()) {
		String sql = "SELECT * FROM REQUEST WHERE Employee_ID = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, email);
		
		rs = ps.executeQuery();
			while (rs.next()) {
				int request_id = rs.getInt("request_id");
				int requester_id = rs.getInt("employee_id");
				int request_amount = rs.getInt("request_amount");
				int resolved = rs.getInt("resolved");
				int resolver = rs.getInt("manager_id");
				
				c = new Request(request_id, requester_id, request_amount, resolved, resolver);
				requests.add(c);
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return requests;
	}


public List<Request> getYourFilterRequests(int email, int result) {
	PreparedStatement ps = null;
	Request c = null;
	List<Request> requests = new ArrayList<>();
	ResultSet rs = null;
	System.out.println(email);
	
	try (Connection conn = ConnectionUtil.getConnection()) {
	String sql = "SELECT * FROM REQUEST WHERE Employee_ID = ?";
	ps = conn.prepareStatement(sql);
	ps.setInt(1, email);
	
	rs = ps.executeQuery();
		while (rs.next()) {
			int request_id = rs.getInt("request_id");
			int requester_id = rs.getInt("employee_id");
			int request_amount = rs.getInt("request_amount");
			int resolved = rs.getInt("resolved");
			int resolver = rs.getInt("manager_id");
			
			c = new Request(request_id, requester_id, request_amount, resolved, resolver);
			if(result == 0) {	
				if(c.getResolved() == 0) {
					requests.add(c);
				}
			}
			else if(result == 1) {
				if(c.getResolved() != 0) {
					requests.add(c);
				}
		}
		}
		rs.close();
		ps.close();
	} catch (Exception ex) {
		ex.printStackTrace();
	}
	
	return requests;
}
}
