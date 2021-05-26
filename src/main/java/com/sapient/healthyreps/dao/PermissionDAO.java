package com.sapient.healthyreps.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sapient.healthyreps.exception.InvalidID;
import com.sapient.healthyreps.interfaces.IPermissionDAO;
import com.sapient.healthyreps.utils.DbConnect;

import org.springframework.stereotype.Service;

@Service
public class PermissionDAO implements IPermissionDAO {

    @Override
    public boolean isIDPresent(int id, String tableName) throws InvalidID  {

		String sqlForException = "SELECT " + tableName + "_id FROM " + tableName + " WHERE " + tableName
				+ "_id=?";
            try {
                PreparedStatement psException = DbConnect.getMySQLConn().prepareStatement(sqlForException);
                psException.setInt(1, id);
                ResultSet rs = psException.executeQuery();
                if (!rs.next()) {
                    throw new InvalidID(tableName);
                }
            } catch (SQLException e1) {
				System.out.println("error traced");
                e1.printStackTrace();
            }
            	
        return false;
    }

    @Override
	public int getLastID(String tableName) {

		String sql = "SELECT "+tableName+"_id from "+tableName+" ORDER BY "+tableName+"_id DESC LIMIT 1";

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