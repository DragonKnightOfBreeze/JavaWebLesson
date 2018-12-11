package example2.Controller;

import example2.DAO.StudentDAO;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ListInfo extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		StudentDAO stuDAO = new StudentDAO();
		var studentList =  stuDAO.list();

		out.print("<table border='1'>");
		out.println("<tr>");
		out.println("<td>stuId</td>");
		out.println("<td>name</td>");
		out.println("<td>score</td>");
		out.println("<td>operate</td>");
		out.println("</tr>");
		for (var student : studentList) {
			var id = student.getId();
			var stuId = student.getStuId();
			var name = student.getName();
			var score = student.getScore();
			out.println("<tr>");
			out.println(String.format("<td>%s</td>", stuId));
			out.println(String.format("<td>%s</td>", name));
			out.println(String.format("<td>%d</td>", score));
			out.println(String.format("<td><a href='delete-info?id=%d'>删除</a>&emsp;<a href='edit-info?id=%d'>修改</a></td>",id,id));
			out.println("</tr>");
		}
		out.println("</table>");

		out.println("<form method='post' action='add-info'>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<td><input type='text' name='addStuId'></td>");
		out.println("<td><input type='text' name='addName'></td>");
		out.println("<td><input type='text' name='addScore'></td>");
		out.println("<td><input type='submit' value='添加数据'></a></td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</form>");
	}
}
