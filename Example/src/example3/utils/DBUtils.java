package example3.utils;

import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * 数据库连接工具类
 * @noinspection unused, Duplicates
*/
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
			prop.load(DBUtils.class.getClassLoader().getResourceAsStream("examples/example2/example3.examples.Utils/config.properties"));
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
	public static void closeConnection(@NotNull Connection con){
		try{
			con.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
