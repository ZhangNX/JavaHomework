package cn.edu.bjfu.en.im.homework_7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import cn.edu.bjfu.en.im.homework_7.*;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class RegisterDAO extends BaseDAO {

	public boolean add(RegisterVO vo) {
		Connection conn = open();
		boolean f = false;
		try {

			// ���ʺŵ�sql���
			String sql = "insert into register (name,pwd) values (?,?)";
			// 3.��ȡPreparedStatement��������ִ��sql��� 
			PreparedStatement ps = (PreparedStatement) conn
					.prepareStatement(sql);
			// sql�ص�?�滻Ϊ����ֵ, setInt, setString,��Ŵ�1��ʼ
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getPwd());
			// 4.ͨ��PreparedStatement����ִ��sql���
			int count = ps.executeUpdate();// ִ��sql��
			// ���أ������ݿ����м�����¼�ܵ���Ӱ��
			if (count > 0) {
				f = true;
			} else {
				f = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.close(conn);
		}
		return f;
	}
	
	public boolean updateAge(RegisterVO vo) {

		Connection conn = this.open();
		boolean f = false;
		// ���ʺŵ�sql���
		String sql = "update register set pwd=?  where name=?";
		// 3.��ȡPreparedStatement��������ִ��sql���
		try {
			PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
			// sql�ص�?�滻Ϊ����ֵ, setInt, setString,��Ŵ�1��ʼ
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getPwd());
			// 4.ͨ��PreparedStatement����ִ��sql���
			int count = ps.executeUpdate();// ִ��sql��
			// ���أ������ݿ����м�����¼�ܵ���Ӱ��
			if (count > 0)
				f=true;
			else 
				f=false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			close(conn);
		}
		return f;
	}
	
	public RegisterVO findByName(String name){
		Connection conn = open();
		String sql="select name,pwd from register where name =?";
		RegisterVO vo = null;
		String thisName = null;String thisPwd = null;
		try {
			PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs=(ResultSet) ps.executeQuery();	
			while(rs.next()){
				thisName=rs.getString("name");
				thisPwd=rs.getString("pwd");
			}
			if(thisName==null)
				 vo=new RegisterVO(thisName, thisPwd);
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
		return vo;
	}
	
//	public static void main(String[] args){
//		StudentVO vo = new StudentVO(2, "abcdef", 20);
//		StudentDAO sDAO=new StudentDAO(); 
//		boolean bool=sDAO.updateAge(vo);
//		if(bool==true)
//		{
//			System.out.println("OK");//����
//		}else {
//			System.out.println("NO");
//		}
		
//		RegisterDAO sDAO=new RegisterDAO(); 
//		RegisterVO vo = sDAO.findByName("zxm");
//		System.out.println(vo.toString());
//	}
}