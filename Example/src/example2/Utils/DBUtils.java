package example2.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtils {

	private static String driver;
	private static String url;
	private static String user;
	private static String password;

	public static String getDriver() {
		return driver;
	}

	public static String getUrl() {
		return url;
	}

	public static String getUser() {
		return user;
	}

	public static String getPassword() {
		return password;
	}

	static {
		Properties prop=new Properties();
		try {
			prop.load(DBUtils.class.getClassLoader().getResourceAsStream("example2/Utils/config.properties"));
			//prop.load(new FileReader(new File("config.properties")));
			driver=prop.getProperty("Driver").trim();
			url=prop.getProperty("Url").trim();
			user=prop.getProperty("User").trim();
			password=prop.getProperty("Password").trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * 得到连接。
	 */
	public static Connection getConnection(){
		Connection con = null;
		try{
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
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
