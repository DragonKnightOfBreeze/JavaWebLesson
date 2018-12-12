package tests.part6_servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddCookieServlet" ,urlPatterns = "/tests/addCookie")
public class AddCookieServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Cookie cookie = new Cookie("name","Tom");
		response.addCookie(cookie);
		cookie.setMaxAge(60*3);
		//删除cookie
		cookie.setValue(null);
		//设置路径为"/"
		cookie.setPath("/");
		response.getWriter().println(cookie);
	}
}
