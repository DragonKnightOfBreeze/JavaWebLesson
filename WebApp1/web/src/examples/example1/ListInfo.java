package examples.example1;

import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import static examples.Consts.*;

public class ListInfo extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		String sql = "select id,stuId,name,score from Student";

		try {
			Class.forName(DRIVER);
			out.println("数据库加载成功！<br>");
			Connection con = DriverManager.getConnection(URL, USER, PW);
			out.println("数据库连接成功！<br>");

			var pstmt = con.prepareStatement(sql);
			var rs = pstmt.executeQuery();

			out.print("<table>");
			out.println("<tr>");
			out.println("<td>stuId</td>");
			out.println("<td>name</td>");
			out.println("<td>score</td>");
			out.println("<td>operate</td>");
			out.println("</tr>");
			while(rs.next()){
				var id = rs.getInt("id");
				var stuId = rs.getString("stuId");
				var name = rs.getString("name");
				var score = rs.getInt("score");
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

			out.println("操作成功！<br>");
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			out.println("操作失败！<br>");
		}
	}
}
