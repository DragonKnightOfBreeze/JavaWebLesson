package example1;

import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import static example1.Consts.*;

public class DeleteInfo extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		var id = Integer.parseInt(req.getParameter("id"));
		String sql = "delete from Student where id=?";

		try{
			Class.forName(DRIVER);
			out.print("数据库加载成功！<br>");
			Connection con = DriverManager.getConnection(URL,USER,PW);
			out.println("数据库连接成功！");

			var pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			pstmt.executeUpdate();

			out.println("操作成功！<br>");
			pstmt.close();
			con.close();

			resp.sendRedirect("list-info");
		}catch (Exception e){
			e.printStackTrace();
			out.println("操作失败！<br>");
		}
	}
}
