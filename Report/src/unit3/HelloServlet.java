//report3_2_1,report3_2_2
package unit3;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloServlet", urlPatterns = "/report/unit3/hello")
public class HelloServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		int count = Integer.parseInt(req.getParameter("count").trim());
		String name = req.getParameter("name").trim();
		String[] hobbies = req.getParameterValues("hobby");
		String hobby = String.join("，", hobbies);
		resp.getWriter().println("次数：" + count + "\n姓名：" + name + "\n爱好：" + hobby);
	}
}
