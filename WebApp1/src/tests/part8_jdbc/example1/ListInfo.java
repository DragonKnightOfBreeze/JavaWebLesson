package tests.part8_jdbc.example1;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import static tests.part8_jdbc.example1.Consts.*;

public class ListInfo extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		String sql = "select id,name,score from Student";

		try {
			Class.forName(DRIVER);
			out.println("数据库加载成功！<br>");
			Connection con = DriverManager.getConnection(URL, USER, PW);
			out.println("数据库连接成功！<br>");

			var pstmt = con.prepareStatement(sql);
			var rs = pstmt.executeQuery();

			out.print("<table>");
			out.println("<tr>");
			out.println("<td>id</td>");
			out.println("<td>name</td>");
			out.println("<td>score</td>");
			out.println("</tr>");
			while(rs.next()){
				var id = rs.getInt("id");
				var name = rs.getString("name");
				var score = rs.getInt("score");
				out.println("<tr>");
				out.println(String.format("<td>%d</td>", id));
				out.println(String.format("<td>%s</td>", name));
				out.println(String.format("<td>%d</td>", score));
				out.println(String.format("<td><a href='delete-info?id=%d'>删除</a>&emsp;<a href='edit-info?id=%d'>修改</a></td>",id,id));
				out.println("</tr>");
			}
			out.print("</table>");

			out.println("操作成功！<br>");
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			out.println("操作失败！<br>");
		}
	}
}
