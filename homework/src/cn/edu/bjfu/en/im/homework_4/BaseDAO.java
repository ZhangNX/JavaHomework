package cn.edu.bjfu.en.im.homework_4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
	public Connection open() {
		Connection conn = null;
		try {
			// 1. 加载驱动
			//Class.forName("com.mysql.jdbc.Driver");
			// 2. 获取到指定数据库的连接对象
			String url = "jdbc:mysql://localhost/im2016";
			conn = DriverManager.getConnection(url, "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void close(Connection conn) {
		if (conn == null)
			return;
		try {
			conn.close();// 关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
