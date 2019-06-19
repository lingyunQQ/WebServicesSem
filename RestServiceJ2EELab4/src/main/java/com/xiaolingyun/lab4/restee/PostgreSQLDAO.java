package com.xiaolingyun.lab4.restee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgreSQLDAO {
	private Connection connection;

	public PostgreSQLDAO(Connection connection) {
		this.connection = connection;
	}

	public List<BeautyProduct> getBeautyProducts() {
		List<BeautyProduct> beautyProducts = new ArrayList<BeautyProduct>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from \"BeautyProducts\"");

			while (rs.next()) {
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String producingСountry = rs.getString("producingСountry");
				Integer vendorСode = rs.getInt("vendorСode");
				String category = rs.getString("category");
				Double price = rs.getDouble("price");

				BeautyProduct beautyProduct = new BeautyProduct(id, name, producingСountry, vendorСode, category,
						price);
				beautyProducts.add(beautyProduct);
			}
		} catch (SQLException ex) {
			Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return beautyProducts;
	}

	public List<BeautyProduct> findBeautyProduct(String id, String name, String producingСountry, String vendorСode,
			String category, String price) {
		System.out.println("Debug findBeautyProduct params: " + id + " " + name + " " + producingСountry + " "
				+ vendorСode + " " + price);

		ArrayList<String> query_where = new ArrayList<String>();
		if ((id != null) && !id.isEmpty())
			query_where.add("id=" + id + "");
		if ((name != null) && !name.isEmpty())
			query_where.add("name='" + name + "'");
		if ((producingСountry != null) && !producingСountry.isEmpty())
			query_where.add("producingСountry='" + producingСountry + "'");
		if ((vendorСode != null) && !vendorСode.isEmpty())
			query_where.add("vendorСode='" + vendorСode + "'");
		if ((category != null) && !category.isEmpty())
			query_where.add("category=" + category + "");
		if ((price != null) && !price.isEmpty())
			query_where.add("price=" + price + "");

		String query = new String();
		if (query_where.size() > 0)
			query = "select * from \"BeautyProducts\" where " + String.join(" and ", query_where);
		System.out.println("Debug findBeautyProduct query: " + query);

		List<BeautyProduct> beautyProducts = findBeautyProduct(query);
		return beautyProducts;
	}

	public List<BeautyProduct> findBeautyProduct(String query) {
		List<BeautyProduct> beautyProducts = new ArrayList<>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String producingСountry = rs.getString("producingСountry");
				String vendorСode = rs.getString("vendorСode");
				String category = rs.getString("category");
				String price = rs.getString("price");

				BeautyProduct beautyProduct = new BeautyProduct(id, name, producingСountry,
						Integer.parseInt(vendorСode), category, Double.parseDouble(price));
				beautyProducts.add(beautyProduct);
				System.out.println("get beautyProduct");
			}
		} catch (SQLException ex) {
			Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return beautyProducts;
	}
}
