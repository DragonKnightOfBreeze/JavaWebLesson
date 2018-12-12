package tests.part9_jtl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TestELServlet",urlPatterns = "/testEL")
public class TestELServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("abc","aaaaaaaaa");
		request.getRequestDispatcher("index.jsp").forward(request,response);
	}
}
