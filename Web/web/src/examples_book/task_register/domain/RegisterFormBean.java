package examples_book.task_register.domain;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * 封装表单信息
 */
public class RegisterFormBean {
	private String name;
	private String password;
	private String rePassword;
	private String email;

	/**
	 * 错误集合，用于封装表单验证时的错误信息
	 */
	private Map<String, String> errorMap = new HashMap<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Map<String, String> getErrorMap() {
		return errorMap;
	}

	/**
	 * 验证属性
	 */
	public boolean validate() {
		boolean flag = true;
		if(isEmpty(name)) {
			errorMap.put("name", "请输入姓名。");
			flag = false;
		}

		if(isEmpty(password)) {
			errorMap.put("password", "请输入密码。");
			flag = false;
		} else if(password.length() > 12 || password.length() < 6) {
			errorMap.put("password", "请输入6-12个字符。");
			flag = false;
		}

		if(!isEmpty(password) && !password.equals(rePassword)) {
			errorMap.put("rePasswrod", "两次输入的密码不匹配。");
			flag = false;
		}

		if(isEmpty(email)) {
			errorMap.put("email", "请输入邮箱。");
			flag = false;
		} else if(!email.matches("[\\w|-]*@[\\fw|-]*(?:\\.[f\\w|-]*)*")) {
			errorMap.put("email", "邮箱格式错误。");
			flag = false;
		}

		return flag;
	}

	/**
	 * 向Map集合errors中添加错误信息
	 */
	public void setErrorMsg(@NotNull String error, @NotNull String errorMsg) {
		errorMap.put(error, errorMsg);
	}


	private boolean isEmpty(String str) {
		return str == null || str.trim().equals("");
	}

}
