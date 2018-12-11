package example2.Controller;

import example2.POJO.Student;
import example2.DAO.StudentDAO;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ModifyInfo extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		var id = Integer.parseInt(req.getParameter("id"));
		var stuId = req.getParameter("stuId").trim();
		var name = req.getParameter("name").trim();
		var score = Integer.parseInt(req.getParameter("score").trim());
		StudentDAO stuDAO = new StudentDAO();
		stuDAO.modify(new Student(id,stuId,name,score));

		resp.sendRedirect("list-info");
	}
}

