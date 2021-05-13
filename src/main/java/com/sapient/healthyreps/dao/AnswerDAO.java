package com.sapient.healthyreps.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sapient.healthyreps.entity.Answer;
import com.sapient.healthyreps.exception.InvalidID;
import com.sapient.healthyreps.interfaces.IAnswerDAO;
import com.sapient.healthyreps.utils.DbConnect;

@Service
public class AnswerDAO implements IAnswerDAO {

	@Override
	public boolean insertAnswer(Answer answer) {

		String sql = "insert into answer (Description,Votes,ModifiedAt,QuestionID,UserID,Reliability) values(?,?,?,?,?,?)";
		try {

			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setString(1, answer.getDescription());
			ps.setInt(2, answer.getVotes());
			ps.setString(3, answer.getModifiedAt());
			ps.setInt(4, answer.getQuestionID());
			ps.setInt(5, answer.getUserID());
			ps.setInt(6, answer.getReliability());

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public Answer getAnswerByAnswerID(int AnswerID) {



		String sql = "select AnswerID,Description,Votes,ModifiedAt,QuestionID,UserID,Reliability from answer where AnswerID=?";
		try {

			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, AnswerID);
			ResultSet rs = ps.executeQuery();

			rs.next();

			Answer answer = new Answer();
			answer.setAnswerID(rs.getInt(1));
			answer.setDescription(rs.getString(2));
			answer.setVotes(rs.getInt(3));
			answer.setModifiedAt(rs.getString(4));
			answer.setQuestionID(rs.getInt(5));
			answer.setUserID(rs.getInt(6));
			answer.setReliability(rs.getInt(7));

			return answer;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<Answer> getAllAnswersByQuestionID(int QuestionID,String order) {
		


		String sql = "select AnswerID,Description,Votes,ModifiedAt,QuestionID,UserID,Reliability from answer where QuestionID= ? order by Votes "+order;

		List<Answer> list;
		list = new ArrayList<Answer>();
		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, QuestionID);
//			ps.setString(2, order);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Answer answer = new Answer();
				answer.setAnswerID(rs.getInt(1));
				answer.setDescription(rs.getString(2));
				answer.setVotes(rs.getInt(3));
				answer.setModifiedAt(rs.getString(4));
				answer.setQuestionID(rs.getInt(5));
				answer.setUserID(rs.getInt(6));
				answer.setReliability(rs.getInt(7));

				list.add(answer);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	

	@Override
	public boolean deleteAnswer(int AnswerID) {
	
		try {
			String sql = "DELETE from answer where AnswerID= ? ";
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, AnswerID);

			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	@Override
	public boolean deleteAnswersByQuestionID(int QuestionID) {
		

		try {
			String sql = "DELETE from answer where QuestionID= ? ";
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setInt(1, QuestionID);

			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	@Override
	public boolean updateAnswerByAnswerID(Answer answer) {

		

		String sql = "UPDATE answer SET Description=?,Votes=?,ModifiedAt=?,QuestionID=?,UserID=?,Reliability=? WHERE AnswerID=?";

		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setString(1, answer.getDescription());
			ps.setInt(2, answer.getVotes());
			ps.setString(3,answer.getModifiedAt());
			ps.setInt(4, answer.getQuestionID());
			ps.setInt(5, answer.getUserID());
			ps.setInt(6, answer.getReliability());
			ps.setInt(7, answer.getAnswerID());

			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	@Override
	public int getLatestAnswerID() {

		String sql = "SELECT AnswerID from answer ORDER BY AnswerID DESC LIMIT 1";

		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			rs.next();

			return rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;

	}

	

}
