package unit2;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AjaxDemo02", urlPatterns = "/report/unit2/ajaxDemo02")
public class AjaxDemo02 extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String name = request.getParameter("name").trim();
		if("hello".equals(name)) {
			response.getWriter().print(name + "注册成功！");
		} else {
			response.getWriter().print(name + "注册失败！");
		}
	}

}
