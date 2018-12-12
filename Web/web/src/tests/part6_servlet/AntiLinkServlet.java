//利用Refer请求头实现“防盗链”

package tests.part6_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AntiLinkServlet",urlPatterns = "/tests/antiLink")
public class AntiLinkServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

		var out = resp.getWriter();
		String referer = req.getHeader("referer");
		//获取访问地址
		String sitePart = "http://"+ req.getServerName();
		//判断referer头是否为空，这个头的地址是否是以sitePart开始的
		if(referer !=null && referer.startsWith(sitePart)){
			//处理正在下载的请求
			out.println("正在下载...");
		}else{
			//非法下载请求跳转到download.html页面
			req.getRequestDispatcher("/download.html").forward(req,resp);
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
}
