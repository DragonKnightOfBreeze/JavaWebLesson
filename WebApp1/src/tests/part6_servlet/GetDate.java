package tests.part6_servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//注意request应该设置为utf-8编码
//		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		var out = resp.getWriter();
		var sdf = new SimpleDateFormat("yyyy-MM-dd");
		var date = sdf.format(new Date());
		out.println("今天是："+date);
	}
}
