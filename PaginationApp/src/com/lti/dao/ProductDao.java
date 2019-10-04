package com.lti.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lti.exception.DataAccessException;
import com.lti.model.Product;

//Data Access Object // also called as repository
//classes which contain code to interact
//DAO classes
public class ProductDao {
	public Connection connect(){
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","sys as sysdba","Newuser123");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public List<Product> fetch(int from,int to)throws DataAccessException{
		Connection conn = connect();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{

			String sql ="SELECT * "
					+ "FROM (SELECT t.*,rownum r "
					+ "FROM TBL_PRODUCTS t) "
					+ "WHERE r between ? and ? "
					+ "ORDER BY ID";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, from);
			stmt.setInt(2, to);
			rs = stmt.executeQuery();

			List<Product> list = new ArrayList<Product>();
			while(rs.next()){
				Product product = new Product();
				product.setId(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getDouble(3));
				product.setQuantity(rs.getInt(4));
				list.add(product);
			}
			return list;
		}
		catch (Exception e) {

			throw new DataAccessException("Problem while fetching",e);
		}
		finally {
			try{rs.close();}catch (Exception e) {}
			try{stmt.close();}catch (Exception e) {}
			try{conn.close();}catch (Exception e) {}
		}
	}


	public void add(Product product){
		Connection conn = connect();
		PreparedStatement stmt = null;
		try {
			String sql = "insert into TBL_PRODUCTS values(?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,product.getId());
			stmt.setString(2,product.getName());
			stmt.setDouble(3,product.getPrice());
			stmt.setInt(4, product.getQuantity());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
