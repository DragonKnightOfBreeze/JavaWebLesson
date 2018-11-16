package tests.part8_jdbc.example1;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import static tests.part8_jdbc.example1.Consts.*;

public class EditInfo extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		var id = Integer.parseInt(req.getParameter("id"));
		String sql = "select id,name,score from Student where id=?";

		try{
			Class.forName(DRIVER);
			out.print("数据库加载成功！<br>");
			Connection con = DriverManager.getConnection(URL,USER,PW);
			out.println("数据库连接成功！<br>");

			var pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			var rs = pstmt.executeQuery();

			if(rs.next()){
				var tempId = rs.getInt(1);
				var tempName = rs.getString(2);
				var tempScore = rs.getInt(3);
				out.println("<form method='post' action='modify-info'>" +
						"<p>lastId:"+tempId+"+</p>"+
						"<p>id:<input type='text' name='id' value='"+tempId+"'></p>"+
						"<p>name:<input type='text' name='name'  value='"+tempName+"'></p>"+
						"<p>score:<input type='text' name='score'  value='"+tempScore+"'></p>"+
						"<input type='hidden' name='lastId' value='"+tempId+"'>"+
						"<p><input type='submit' value='提交'></p>"+
						"</form>");
			}

			out.println("操作成功！<br>");
			pstmt.close();
			con.close();
		}catch (Exception e){
			e.printStackTrace();
			out.println("操作成功！<br>");
		}
	}
}

