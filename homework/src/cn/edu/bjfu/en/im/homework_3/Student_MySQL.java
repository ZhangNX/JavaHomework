package cn.edu.bjfu.en.im.homework_3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import com.mysql.jdbc.PreparedStatement;

public class Student_MySQL {

	public static Connection open() {
		Connection conn = null;
		try {
			// 1. ��������
			Class.forName("com.mysql.jdbc.Driver");
			// 2. ��ȡ��ָ�����ݿ�����Ӷ���
			String url = "jdbc:mysql://localhost/im2016";
			conn = DriverManager.getConnection(url, "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void insert(int no, String name, int age) throws SQLException {

		Connection conn = open();
		// ���ʺŵ�sql���
		String sql = "insert into testIt (no,name,age) values (?,?,?)";
		// 3.��ȡPreparedStatement��������ִ��sql���
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
		// sql�ص�?�滻Ϊ����ֵ, setInt, setString,��Ŵ�1��ʼ
		ps.setInt(1, no);
		ps.setString(2, name);
		ps.setInt(3, age);
		// 4.ͨ��PreparedStatement����ִ��sql���
		int count = ps.executeUpdate();// ִ��sql��
		// ���أ������ݿ����м�����¼�ܵ���Ӱ��
		if (count > 0)
			{
			System.out.println("insert ok.");
			}
		close(conn);
	}

	public static void updateAge(int no, int age) throws SQLException {

		Connection conn = open();
		// ���ʺŵ�sql���
		String sql = "update testIt set age=? where no=?";
		// 3.��ȡPreparedStatement��������ִ��sql���
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
		// sql�ص�?�滻Ϊ����ֵ, setInt, setString,��Ŵ�1��ʼ
		ps.setInt(2, no);
		ps.setInt(1, age);
		// 4.ͨ��PreparedStatement����ִ��sql���
		int count = ps.executeUpdate();// ִ��sql��
		// ���أ������ݿ����м�����¼�ܵ���Ӱ��
		if (count > 0)
			System.out.println("update ok.");
		close(conn);
	}
	
	public static void delete(int no) throws SQLException {

		Connection conn = open();
		// ���ʺŵ�sql���
		String sql = "delete from testIt where no=?";
		// 3.��ȡPreparedStatement��������ִ��sql���
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
		// sql�ص�?�滻Ϊ����ֵ, setInt, setString,��Ŵ�1��ʼ
		ps.setInt(1, no);
		// 4.ͨ��PreparedStatement����ִ��sql���
		int count = ps.executeUpdate();// ִ��sql��
		// ���أ������ݿ����м�����¼�ܵ���Ӱ��
		if (count > 0)
			System.out.println("delete ok.");
		close(conn);
	}
	public static void close(Connection conn) {
		if (conn == null)
			return;
		try {
			conn.close();// �ر�����
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = open();
		insert(1, "ABC", 20);
		insert(2, "A2", 19);
		insert(3, "C3", 20);
		updateAge(3, 18);// �޸�ѧ��Ϊ3�ŵ�ͬѧΪ18��
		delete(2);// ɾ��ѧ��Ϊ2�ŵ�ͬѧ

	}

}