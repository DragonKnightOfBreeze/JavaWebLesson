package tests.part8_jdbc.example1;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import static tests.part8_jdbc.example1.Consts.*;

public class ModifyInfo extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		var lastId = Integer.parseInt(req.getParameter("lastId"));
		var id = Integer.parseInt(req.getParameter("id"));
		var name = req.getParameter("name");
		var score = Integer.parseInt(req.getParameter("score"));

		String sql = "update Student set id=?,name=?,score=? where id=?";

		try{
			Class.forName(DRIVER);
			out.print("数据库加载成功！<br>");
			Connection con = DriverManager.getConnection(URL,USER,PW);
			out.println("数据库连接成功！<br>");

			var pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			pstmt.setString(2,name);
			pstmt.setInt(3,score);
			pstmt.setInt(4,lastId);
			pstmt.executeUpdate();

			out.println("修改成功！<br>");
			pstmt.close();
			con.close();

			resp.sendRedirect("list-info");
		}catch (Exception e){
			out.println("操作失败！<br>");
			e.printStackTrace();
		}
	}
}

