package tests.part8_jdbc;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

import static tests.part8_jdbc.Consts.*;

public class AddInfo extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		String sql = "insert into Student(name,score)"+"values(?,?)";
		String name = req.getParameter("name");
		int score = Integer.parseInt(req.getParameter("score"));

		try{
			Class.forName(DRIVER);
			out.print("数据库加载成功！<br>");
			Connection con = DriverManager.getConnection(URL,USER,PW);
			out.println("数据库连接成功！");

			var pstmt = con.prepareStatement(sql);
			pstmt.setString(1,name);
			pstmt.setInt(2,score);
			pstmt.executeUpdate();

			pstmt.close();
			con.close();
		}catch (Exception e){
			e.printStackTrace();
			out.print("数据库连接失败！<br>");
		}
	}
}
