package tests.part6_servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "FileDownloadServlet",urlPatterns = "/tests/fileDownload")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//设置ContentType字段值
		response.setContentType("text/html;charset=utf-8");
		//设置相应消息编码
		response.setCharacterEncoding("utf-8");
		//设置请求消息编码
		request.setCharacterEncoding("utf-8");
		//获取所要下载的文件名称
		String filename = request.getParameter("filename");
		//对文件名称编码
		filename = new String(filename.trim().getBytes("iso8859-1"), StandardCharsets.UTF_8);
		//下载文件所在目录
		String folder = "/download/";
		// 通知浏览器以下载的方式打开
		response.addHeader("Content-Type", "application/octet-stream");
		response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, StandardCharsets.UTF_8));
		// 通过文件流读取文件
		InputStream in = getServletContext().getResourceAsStream(folder + filename);
		// 获取response对象的输出流
		OutputStream out = response.getOutputStream();
		byte[] buffer = new byte[1024];
		int len;
		//循环取出流中的数据
		while((len = in.read(buffer)) != -1) {
			out.write(buffer, 0, len);
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse
			response) throws IOException {
		doGet(request, response);
	}
}
