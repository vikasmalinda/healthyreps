package com.sapient.healthyreps.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sapient.healthyreps.entity.Comment;
import com.sapient.healthyreps.interfaces.ICommentDAO;
import com.sapient.healthyreps.utils.DbConnect;

import org.springframework.stereotype.Service;

@Service
public class CommentDAO implements ICommentDAO {

	@Override
	public boolean insertComment(Comment comment) {
		String sql = "insert into comment (Description,ModifiedAt,AnswerID,UserID,Reliability) values(?,?,?,?,?)";
		try {

			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setString(1, comment.getDescription());
			ps.setString(2, comment.getModifiedAt());
			ps.setInt(3, comment.getAnswerID());
			ps.setInt(4, comment.getUserID());
			ps.setInt(5, comment.getReliability());

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Comment getCommentByCommentID(int CommentID) {

		String sql = "select CommentID, Description, ModifiedAt, AnswerID, UserID, Reliability from comment where CommentID=?";
		try {

			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, CommentID);
			ResultSet rs = ps.executeQuery();

			rs.next();

			Comment comment = new Comment();
			comment.setCommentID(rs.getInt(1));
			comment.setDescription(rs.getString(2));
			comment.setModifiedAt(rs.getString(3));
			comment.setAnswerID(rs.getInt(4));
			comment.setUserID(rs.getInt(5));
			comment.setReliability(rs.getInt(6));

			return comment;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<Comment> getAllComments(int AnswerID) {

		String sql="select commentID, description, modifiedAt, answerID, userID, reliability from comment where AnswerID= ?";

		List<Comment> list=new ArrayList<Comment>();
		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, AnswerID);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Comment comment = new Comment();
				comment.setCommentID(rs.getInt(1));
				comment.setDescription(rs.getString(2));
				comment.setModifiedAt(rs.getString(3));
				comment.setAnswerID(rs.getInt(4));
				comment.setUserID(rs.getInt(5));
				comment.setReliability(rs.getInt(6));

				list.add(comment);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean deleteComment(int CommentID) {
		

		try {
			String sql = "DELETE from comment where CommentID= ? ";
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, CommentID);

			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteCommentsByAnswerID(int AnswerID) {
		
		try {
			String sql = "DELETE from comment where AnswerID= ? ";
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, AnswerID);

			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean updateCommentByCommentID(Comment comment) {
		
		String sql = "UPDATE comment SET Description=?,ModifiedAt=?,AnswerID=?,UserID=?,Reliability=? WHERE CommentID=?";

		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setString(1, comment.getDescription());
			ps.setString(2, comment.getModifiedAt());
			ps.setInt(3, comment.getAnswerID());
			ps.setInt(4, comment.getUserID());
			ps.setInt(5, comment.getReliability());
			ps.setInt(6, comment.getCommentID());

			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	

	@Override
	public boolean updateComment(Comment comment) {

		String sql = "UPDATE comment SET Description=?, ModifiedAt=?, AnswerID=?, UserID=?, Reliability=? WHERE commentID = ?";

		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setString(1, comment.getDescription());
			ps.setString(2, comment.getModifiedAt());
			ps.setInt(3, comment.getAnswerID());
			ps.setInt(4, comment.getUserID());
			ps.setInt(5, comment.getReliability());
			ps.setInt(6, comment.getCommentID());

			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
}
