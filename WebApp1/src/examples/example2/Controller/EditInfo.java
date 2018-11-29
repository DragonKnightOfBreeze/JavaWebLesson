package examples.example2.Controller;

import examples.example2.DAO.StudentDAO;
import examples.example2.POJO.Student;
import examples.example2.Utils.DBUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

public class EditInfo extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();

		var id=Integer.parseInt(req.getParameter("id").trim());
		StudentDAO stuDAO=new StudentDAO();
		var student=stuDAO.edit(id);

		if (student != null) {
			var stuId=student.getStuId();
			var name=student.getName();
			var score=student.getScore();
			out.println("<form method='post' action='modify-info'>" + "<p>StuId:" + stuId + "+</p>" + "<p>stuId:<input type='text' name='stuId' value='" + stuId + "'></p>" + "<p>name:<input type='text' name='name' value='" + name + "'></p>" + "<p>score:<input type='text' name='score' value='" + score + "'></p>" + "<input type='hidden' name='id' value='" + id + "'>" + "<p><input type='submit' value='提交'></p>" + "</form>");
		}
	}
}

