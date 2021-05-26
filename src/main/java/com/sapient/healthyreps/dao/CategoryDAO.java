package com.sapient.healthyreps.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sapient.healthyreps.entity.Category;
import com.sapient.healthyreps.interfaces.ICategoryDAO;
import com.sapient.healthyreps.utils.DbConnect;

@Service
public class CategoryDAO implements ICategoryDAO {

	@Override
	public boolean insertCategory(Category category) {
		
		String sql = "insert into category (category_name) values (?)	";
		try {

			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setString(1, category.getCategoryName());

			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Category> getAllCategory() {
		String sql = "select category_id, category_name from category";

		List<Category> list = new ArrayList<>();
		try (PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Category cat = new Category();
				cat.setCategoryID(rs.getInt(1));
				cat.setCategoryName(rs.getString(2));
				list.add(cat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Category getCategoryById(int category_id) {

		String sql = "select category_id, category_name from category where category_id = ?";
		Category cat = new Category();
		try (PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);) {
			ps.setInt(1, category_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				cat.setCategoryID(rs.getInt(1));
				cat.setCategoryName(rs.getString(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cat;
	}

	@Override
	public boolean removeCategory(int category_id) {
		String sql = "delete from category where category_id = ?";

		try (PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql)) {
			ps.setInt(1, category_id);
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateCategory(Category category) {

		String sql = "update category set category_name=? where category_id = ?";

		try {
			PreparedStatement ps = DbConnect.getMySQLConn().prepareStatement(sql);
			ps.setString(1, category.getCategoryName());
			ps.setInt(2, category.getCategoryID());

			return ps.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

}
