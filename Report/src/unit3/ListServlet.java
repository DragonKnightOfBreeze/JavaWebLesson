package unit3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListServlet", urlPatterns = "/report/unit3/list")
public class ListServlet extends HttpServlet {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/JavaWebLesson";
	private static final String USER = "Windea";
	private static final String PW = "BreezesLanding";

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		List<Employee> list = new ArrayList<>();
		String sql = "select userName,salary,age from employee";
		Connection con = null;
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PW);
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setUserName(rs.getString(1));
				emp.setSalary(rs.getInt(2));
				emp.setAge(rs.getInt(3));
				list.add(emp);
			}
			pstmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		req.setAttribute("list", list);
		req.getRequestDispatcher("/unit3/list.jsp").forward(req, resp);
	}
}
