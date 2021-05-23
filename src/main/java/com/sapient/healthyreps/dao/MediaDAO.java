package com.sapient.healthyreps.dao;

import java.sql.*;
import java.util.*;

import com.sapient.healthyreps.entity.*;
import com.sapient.healthyreps.interfaces.IMediaDAO;
import com.sapient.healthyreps.utils.DbConnect;

public class MediaDAO implements IMediaDAO{

	@Override
	public boolean createMedia(int postId, String link) {
		String sql = "INSERT INTO Media_post(link, postId) VALUES (?,?)";
		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			
			ps.setString(1, link);
			ps.setInt(2, postId);
			
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
	}

	@Override
	public String getMediaByPostId(int postId) {
		String post_media="";
		String sql = "Select link From Media_post where postId=?";
		try {
				PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
				ps.setInt(1, postId);
				ResultSet rs = ps.executeQuery();	
				while(rs.next()) {		
						post_media = new String(rs.getString(1));
					}
			} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
			
		return post_media;
	}
	
	@Override
	public boolean deleteMediaByPostId(int postId)
	{
		String sql = "DELETE FROM Media_post WHERE postId = ?";
		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, postId);
			
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean updateMediaByPostId(int postId, String link) {
		
		String sql = "UPDATE Media_post SET link=? WHERE postId=?";
		
		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setString(1, link);
			ps.setInt(2, postId);
			
			return ps.executeUpdate() > 0;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	

}
// abcd