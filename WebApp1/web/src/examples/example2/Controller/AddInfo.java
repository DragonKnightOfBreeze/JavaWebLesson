package examples.example2.Controller;

import examples.example2.DAO.StudentDAO;
import examples.example2.POJO.Student;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddInfo extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		var	stuId = req.getParameter("addId").trim();
		var name = req.getParameter("addName").trim();
		var score = Integer.parseInt(req.getParameter("addScore").trim());
		StudentDAO stuDAO = new StudentDAO();
		stuDAO.insert(new Student(1,stuId,name,score));

		resp.sendRedirect("list-info");
	}
}
