package example1;

import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class ModifyInfo extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		var id = Integer.parseInt(req.getParameter("id"));
		var stuId = req.getParameter("stuId").trim();
		var name = req.getParameter("name").trim();
		var score = Integer.parseInt(req.getParameter("score").trim());

		String sql = "update Student set stuId=?,name=?,score=? where id=?";

		try{
			Class.forName(Consts.DRIVER);
			out.print("数据库加载成功！<br>");
			Connection con = DriverManager.getConnection(Consts.URL, Consts.USER, Consts.PW);
			out.println("数据库连接成功！<br>");

			var pstmt = con.prepareStatement(sql);
			pstmt.setString(1,stuId);
			pstmt.setString(2,name);
			pstmt.setInt(3,score);
			pstmt.setInt(4,id);
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

