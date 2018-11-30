package examples_book.task_register.utils;

import org.jetbrains.annotations.NotNull;
import examples_book.task_register.domain.UserBean;
import java.util.HashMap;

public class DBUtils {

	private static volatile DBUtils instance;
	private DBUtils() {
		userMap.put("jack",new UserBean("Jack","123456","jack@it315.org"));
		//...
	}

	/**
	 * 单例模式 - 双重校验锁
	 * @return 类的单例
	 */
	public static DBUtils getInstance() {
		if(instance == null) {
			synchronized(DBUtils.class) {
				if(instance == null) {
					instance = new DBUtils();
				}
			}
		}
		return instance;
	}

	/** 定义users集合，用于模拟数据库 */
	private HashMap<String, UserBean> userMap = new HashMap<>();

	/**
	 * 获取模拟数据库中的数据
	 * @param userName
	 * @return
	 */
	public UserBean getUser(@NotNull String userName){
		return userMap.get(userName);
	}

	public boolean insertUser(@NotNull UserBean user){
		String userName = user.getName();
		if(userMap.get(userName) != null)
			return false;
		userMap.put(userName,user);
		return true;
	}

}
