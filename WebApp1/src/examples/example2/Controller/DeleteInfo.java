package examples.example2.Controller;

import examples.example2.Util.DBUtil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import static examples.Consts.*;

public class DeleteInfo extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		Connection con = DBUtil.getConnection();

		try{
			var id = Integer.parseInt(req.getParameter("id"));
			String sql = "delete from Student where id=?";

			var pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			pstmt.executeUpdate();
			pstmt.close();

			out.println("删除成功！<br>");
			resp.sendRedirect("list-info");
		}catch (Exception e){
			out.println("删除失败！<br>");
			e.printStackTrace();
		}finally {
			DBUtil.closeConnection(con);
		}
	}
}
