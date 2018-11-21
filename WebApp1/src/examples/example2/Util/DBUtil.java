package examples.example2.Util;

import java.sql.Connection;
import java.sql.DriverManager;

import static examples.Consts.*;

public class DBUtil {

	/**
	 * 得到连接。
	 */
	public static Connection getConnection(){
		Connection con = null;
		try{
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PW);
		}catch (Exception e){
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * 关闭连接。
	 */
	public static boolean closeConnection(Connection con){
		if(con==null)
			return false;
		try{
			con.close();
			return true;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}


}
