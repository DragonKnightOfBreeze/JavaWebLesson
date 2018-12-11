package example3.web.servlet;

import example3.dao.DaoFactory;
import example3.domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 编辑信息的Servlet
 *  @noinspection Duplicates
*/
@WebServlet(urlPatterns = {"/example3/edit"})
public class EditServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		var id=Integer.parseInt(req.getParameter("id").trim());

		Student student = null;
		try {
			student = DaoFactory.getStudentDao().findById(id);
		}catch (Exception e){
			e.printStackTrace();
		}
		if(student == null) {
			resp.getWriter().println("查询失败！");
			return;
		}


		req.setAttribute("student",student);
		req.getRequestDispatcher("/example3/jsp/editPage.jsp").forward(req,resp);
	}
}

