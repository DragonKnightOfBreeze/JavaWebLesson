package examples_lesson.part10_ajax;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AjaxDemo02",urlPatterns = "/ajaxDemo02")
public class AjaxDemo02 extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name").trim();
		if("hello".equals(name)) {
			out.print(name + "注册成功！");
		} else {
			out.print(name + "注册失败！");
		}
		out.close();
	}

}
