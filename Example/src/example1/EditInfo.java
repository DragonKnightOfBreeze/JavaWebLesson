package example1;

import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class EditInfo extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		var id = Integer.parseInt(req.getParameter("id"));
		String sql = "select stuId,name,score from Student where id=?";

		try{
			Class.forName(Consts.DRIVER);
			out.print("数据库加载成功！<br>");
			Connection con = DriverManager.getConnection(Consts.URL, Consts.USER, Consts.PW);
			out.println("数据库连接成功！<br>");

			var pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,id);
			var rs = pstmt.executeQuery();

			if(rs.next()){
				var stuId = rs.getString(1);
				var name = rs.getString(2);
				var score = rs.getInt(3);
				out.println("<form method='post' action='modify-info'>" +
						"<p>StuId:"+stuId+"+</p>"+
						"<p>stuId:<input type='text' name='stuId' value='"+stuId+"'></p>"+
						"<p>name:<input type='text' name='name' value='"+name+"'></p>"+
						"<p>score:<input type='text' name='score' value='"+score+"'></p>"+
						"<input type='hidden' name='id' value='"+id+"'>"+
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

