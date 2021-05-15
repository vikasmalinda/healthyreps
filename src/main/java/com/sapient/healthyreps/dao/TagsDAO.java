package com.sapient.healthyreps.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import java.sql.*;
//import java.util.*;

import com.sapient.healthyreps.entity.Tags;
import com.sapient.healthyreps.interfaces.ITagsDAO;
import com.sapient.healthyreps.utils.DbConnect;





public class TagsDAO implements ITagsDAO{

	@Override
	public List<Tags> getAllTagsByPostId(int pid) {
		
		List<Tags> tags = new ArrayList<>();
		String sql = "select TID, PID, content from Tags_post WHERE PID=?";
		
		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, pid);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Tags tag = new Tags(rs.getInt(1),
						rs.getInt(2),
						rs.getString(3));
				
				tags.add(tag);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tags;
	}

	@Override
	public List<Tags> getAllTags() {
		List<Tags> tags = new ArrayList<>();
		String sql = "select TID, PID, content from Tags_post";
		
		PreparedStatement ps;
		try {
			ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Tags tag = new Tags(rs.getInt(1),
						rs.getInt(2),
						rs.getString(3));
				
				tags.add(tag);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return tags;
	}

	@Override
	public boolean deleteTagbyId(int id) {
		String sql = "DELETE FROM Tags_post WHERE TID = ?";
		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, id);
			
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteAllTagsByPostId(int pid) {
		String sql = "DELETE FROM Tags_post WHERE PID = ?";
		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, pid);
			
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateTag(int id, String content) {
		String sql = "UPDATE Tags_post SET content=? WHERE TID=?";
		
		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setString(1, content);
			ps.setInt(2, id);
			
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	@Override
	public boolean insertTag(int id, int pid, String content) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO Tags_post(TID,PID, content) values (?,?,?)";
		
		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, pid);
			ps.setString(3, content);
			
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	@Override
	public boolean insertTag(int pid, String content) {
		// TODO Auto-generated method stub
		
		String sql = "INSERT INTO Tags_post(PID, content) values (?,?)";
		
		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, pid);
			ps.setString(2, content);
			
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	

}
