package tests.part8_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static tests.part8_jdbc.Consts.*;

public class Test2 {
	public static void main(String[] args) {
		update1();
	}

	//使用Statement进行数据库修改操作
	public static void update1(){
		int id = 3;
		String name="3";
		String password = "mldn";
		int age = 25;
		String sex = "男";
		String sql = "update user set name='"+name+"',password='"+password+"',age="+age+",sex='"+sex+"'where id="+id;

		try{
			Class.forName(DRIVER);
			System.out.println("数据库加载成功！");
			Connection con = DriverManager.getConnection(URL,USER,PW);
			System.out.println("数据库连接成功！");

			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);

			stmt.close();
			con.close();
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("数据库连接失败！");
		}
	}

	//使用PreparedStatement进行数据库修改操作
	//也可以用来防范注入式攻击
	public static void update2(){
		String name="3";
		String password = "mldn";
		int age = 25;
		String sex = "男";
		String sql = "insert into user(name,password,age,sex)"+"values(?,?,?,?)";

		try{
			Class.forName(DRIVER);
			System.out.println("数据库加载成功！");
			Connection con = DriverManager.getConnection(URL,USER,PW);
			System.out.println("数据库连接成功！");

			var pstmt = con.prepareStatement(sql);
			pstmt.setString(1,name);
			pstmt.setString(2,password);
			pstmt.setInt(3,age);
			pstmt.setString(4,sex);
			pstmt.executeUpdate();

			pstmt.close();
			con.close();
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("数据库连接失败！");
		}
	}
}
