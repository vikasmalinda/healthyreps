package com.sapient.healthyreps.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sapient.healthyreps.interfaces.IMediaDAO;
import com.sapient.healthyreps.utils.DbConnect;

public class MediaDAO implements IMediaDAO {

	@Override
	public boolean createMedia(int postId, String link) {
		String sql = "INSERT INTO mediaPost(link, postId) VALUES (?,?)";
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
		String post_media = "";
		String sql = "Select link From mediaPost where postId=?";
		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, postId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				post_media = new String(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return post_media;
	}

	@Override
	public boolean deleteMediaByPostId(int postId) {
		String sql = "DELETE FROM mediaPost WHERE postId = ?";
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

		String sql = "UPDATE mediaPost SET link=? WHERE postId=?";

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