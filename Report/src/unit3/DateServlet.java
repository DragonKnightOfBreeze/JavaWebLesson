//report3_1_1
package unit3;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "DateServlet", urlPatterns = "/report/unit3/date")
public class DateServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		resp.getWriter().println("今天是 " + dateStr);
	}
}
