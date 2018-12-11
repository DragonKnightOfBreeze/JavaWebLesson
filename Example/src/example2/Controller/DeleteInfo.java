package example2.Controller;

import example2.DAO.StudentDAO;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteInfo extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		var id = Integer.parseInt(req.getParameter("id"));
		StudentDAO stuDAO = new StudentDAO();
		stuDAO.delete(id);

		resp.sendRedirect("list-info");
	}
}
