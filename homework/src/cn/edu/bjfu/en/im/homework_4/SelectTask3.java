package cn.edu.bjfu.en.im.homework_4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PseudoColumnUsage;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class SelectTask3 {

	public static void selectById(){
		Connection conn = null;
		try {
			// 1. 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 2. 获取到指定数据库的连接对象
			String url = "jdbc:mysql://localhost/im2016";
			conn = DriverManager.getConnection(url, "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String sql="select no, name,age from testit where no =?";
		try {
			PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
			ps.setInt(1, 3);
			ResultSet rs=(ResultSet) ps.executeQuery();
			while(rs.next()){
				int no=rs.getInt("no");
				String name=rs.getString("name");
				int age=rs.getInt("age");
				System.out.println(no+"-"+name+"-"+age);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		selectById();
	}

}
