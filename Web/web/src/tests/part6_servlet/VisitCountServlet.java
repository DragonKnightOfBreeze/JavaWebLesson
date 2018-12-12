//网站访问次数计数器
//NOTE 找cookie和添加cookie一般在同一段代码内

package tests.part6_servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "VisitCountServlet",urlPatterns = "/tests/visitCount")
public class VisitCountServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");

//		int count;
//		try {
//			count = (int) request.getSession().getAttribute("count");
//			request.getSession().setAttribute("count",count+1);
//		} catch(Exception e) {
//			count = 0;
//			request.getSession().setAttribute("count",0);
//		}
		//通过Cookie实现网站计数器

		Cookie countCookie = null;
		var cookies = request.getCookies();
		if(cookies != null) {
			for(var cookie : cookies) {
				if("count".equals(cookie.getName())) {
					countCookie = cookie;
					break;
				}
			}
		}
		if(countCookie == null) {
			countCookie = new Cookie("count", "1");
		} else {
			countCookie.setValue(String.valueOf(Integer.parseInt(countCookie.getValue()) + 1));
		}
		countCookie.setMaxAge(24 * 60 * 60);
		response.addCookie(countCookie);
	}
}
