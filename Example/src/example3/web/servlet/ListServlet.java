package example3.web.servlet;

import example3.dao.DaoFactory;
import example3.domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 列举信息的Servlet
 */
@WebServlet(urlPatterns = {"/example/example3/list"})
public class ListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		int pageIndex;
		try {
			pageIndex = Integer.parseInt(req.getParameter("pageIndex").trim());
		} catch (Exception e) {
			pageIndex = 1;
		}
		int pageCount = 30;

		List<Student> studentList = new ArrayList<>();
		int pageNumber = 1;
		try {
			studentList = DaoFactory.getStudentDao().findAllInPage(pageIndex, pageCount);
			pageNumber = DaoFactory.getStudentDao().getPageNumber(pageCount);
		} catch (Exception e) {
			e.printStackTrace();
		}

		req.setAttribute("pageIndex", pageIndex);
		req.setAttribute("pageNumber", pageNumber);
		req.setAttribute("studentList", studentList);
		req.getRequestDispatcher("/example3/jsp/list.jsp").forward(req, resp);
	}
}
