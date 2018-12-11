//report3_5_1
package unit3;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet(name = "AddServlet", urlPatterns = "/report/unit3/add")
public class AddServlet extends HttpServlet {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/JavaWebLesson";
	private static final String USER = "Windea";
	private static final String PW = "BreezesLanding";

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		String userName = req.getParameter("userName").trim();
		int salary = Integer.parseInt(req.getParameter("salary"));
		int age = Integer.parseInt(req.getParameter("age"));


		String sql = "insert into employee (userName,salary,age) value(?,?,?)";
		Connection con = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PW);
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setInt(2, salary);
			pstmt.setInt(3, age);
			pstmt.executeUpdate();
			pstmt.close();
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("数据库连接失败！");
		}finally {
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
