package example1;

import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class AddInfo extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		var	stuId = req.getParameter("addId").trim();
		var name = req.getParameter("addName").trim();
		var score = Integer.parseInt(req.getParameter("addScore").trim());
		String sql = "insert into Student (stuId,name,score) values(?,?,?)";

		try{
			Class.forName(Consts.DRIVER);
			out.println("数据库加载成功！<br>");
			Connection con = DriverManager.getConnection(Consts.URL, Consts.USER, Consts.PW);
			out.println("数据库连接成功！<br>");

			var pstmt = con.prepareStatement(sql);
			pstmt.setString(1,stuId);
			pstmt.setString(2,name);
			pstmt.setInt(3,score);
			pstmt.executeUpdate();

			pstmt.close();
			con.close();

			resp.sendRedirect("list-info");
		}catch (Exception e){
			out.println("操作失败！<br>");
			e.printStackTrace();
		}
	}
}
