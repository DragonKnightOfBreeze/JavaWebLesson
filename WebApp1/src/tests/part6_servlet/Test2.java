package tests.part6_servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static tests.part8_jdbc.Consts.*;

public class Test2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.service(req, resp);
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		try{
			Class.forName(DRIVER);
			System.out.println("数据库加载成功！");
			Connection con = DriverManager.getConnection(URL,USER,PW);
			System.out.println("数据库连接成功！");

			Statement stmt = con.createStatement();
			String sql = "select * from Student";
			var rs =  stmt.executeQuery(sql);
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("数据库连接失败！");
		}
	}
}
