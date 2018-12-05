package example3.dao;

/**
 * Dao的工厂类
 */
public class DaoFactory {
	public static IStudentDao getStudentDao(){
		return new StudentDao();
	}
}
