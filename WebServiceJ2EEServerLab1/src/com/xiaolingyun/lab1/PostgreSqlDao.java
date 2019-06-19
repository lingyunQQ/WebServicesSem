package com.xiaolingyun.lab1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgreSqlDao {
    private Connection connection;

    public PostgreSqlDao(){};

    public PostgreSqlDao(Connection connection) {
        this.connection = connection;
    }

    public List<BeautyProduct> findAllBeautyProducts() {
        List<BeautyProduct> beautyProducts = new ArrayList<>();
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

                BeautyProduct beautyProduct = new BeautyProduct(id, name, producingСountry, vendorСode, category, price);
                beautyProducts.add(beautyProduct);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSqlDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return beautyProducts;
    }


    public List<BeautyProduct> findBeautyProduct(String id, String name, String producingСountry, String vendorСode, String category, String price) {
        ArrayList<String> query_where = new ArrayList<String>();
        if (!id.isEmpty()) query_where.add("id='" + id + "'");
        if (!name.isEmpty()) query_where.add("name='" + name + "'");
        if (!producingСountry.isEmpty()) query_where.add("producingСountry='" + producingСountry + "'");
        if (!vendorСode.isEmpty()) query_where.add("vendorСode='" + vendorСode + "'");
        if (!category.isEmpty()) query_where.add("category=" + category + "");
        if (!price.isEmpty()) query_where.add("price=" + price + "");

        String query = new String();
        if (query_where.size() > 0)
            query = "select * from \"BeautyProducts\" where " + String.join(" and ", query_where);

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

                BeautyProduct beautyProduct = new BeautyProduct(id, name, producingСountry, Integer.parseInt(vendorСode), category, Double.parseDouble(price));
                beautyProducts.add(beautyProduct);
                System.out.println("get beautyProduct");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSqlDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return beautyProducts;
    }
}
