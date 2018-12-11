package tests.part6_servlet;

import tests.part6_servlet.utils.DBUtils;

import javax.servlet.http.*;
import java.io.*;
import java.sql.Connection;

public class TestBatch extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		Connection con = DBUtils.getConnection();
		String sql="insert into Student (stuId, name, score) value (?,?,?)";
		try {
			con.setAutoCommit(false);
			var pstmt = con.prepareStatement(sql);
			for(int i = 0; i < 100; i++) {
				pstmt.setString(1,"stuId"+i);
				pstmt.setString(2,"name"+i);
				pstmt.setInt(3,100);
				pstmt.addBatch();
			}
			int[] nums = pstmt.executeBatch();
			con.commit();
			pstmt.close();

		}catch(Exception e){
			e.printStackTrace();
			try{
				con.rollback();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
		DBUtils.closeConnection(con);
	}
}
