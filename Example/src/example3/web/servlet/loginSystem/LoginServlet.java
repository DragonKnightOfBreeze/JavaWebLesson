package example3.web.servlet.loginSystem;

import dk_breeze.utils.ext.StringExt;
import example3.dao.DaoFactory;
import example3.domain.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/example/example3/login")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName").trim();
		String password = req.getParameter("password").trim();
		String identity = req.getParameter("identity");

		Student student = new Student();
		student.setName(userName);
		student.setPassword(password);

		if(StringExt.equals(identity, "学生")) {
			try {
				student = DaoFactory.getStudentDao().register(student);
			} catch(Exception e) {
				e.printStackTrace();
			}
			if(student == null) {
				resp.sendRedirect("example/error.jsp");
			} else {
				req.setAttribute("student", student);
				req.getRequestDispatcher("/loginSuccess.jsp").forward(req, resp);
			}
		}
		//TODO


	}
}
