//连接数据库
package tests.part8_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import static tests.part8_jdbc.Consts.*;

public class Test1 {

	public static void main(String[] args) {
		connect();
	}

	public static void connect(){
		Connection con = null;
		//加载驱动程序
		try{
			Class.forName(Consts.DRIVER);
		}catch (Exception e){
			e.printStackTrace();
		}
		//连接数据库，指定数据库名、用户名和密码
		try{
			con = DriverManager.getConnection(URL, USER, PW);
		}catch (Exception e){
			e.printStackTrace();
		}
		//打印数据
		System.out.println(con);
		//关闭数据库
		try{
			con.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}

