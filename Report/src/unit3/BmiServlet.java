//report3_1_2
package unit3;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BmiServlet", urlPatterns = "/report/unit3/bmi")
public class BmiServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		float h = Float.parseFloat(req.getParameter("h").trim());
		float w = Float.parseFloat(req.getParameter("w").trim());
		float bmi = w / h / h;
		resp.getWriter().printf("%.2f", bmi);

	}
}
