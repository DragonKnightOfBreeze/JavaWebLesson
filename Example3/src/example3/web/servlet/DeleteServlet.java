package example3.web.servlet;

import example3.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除信息的Servlet
 *  @noinspection Duplicates
 *  */
@WebServlet(urlPatterns = {"/delete"})
public class DeleteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		var id = Integer.parseInt(req.getParameter("id").trim());

		try {
			DaoFactory.getStudentDao().doDelete(id);
		}catch (Exception e){
			e.printStackTrace();
		}

		resp.sendRedirect("list");
	}
}
