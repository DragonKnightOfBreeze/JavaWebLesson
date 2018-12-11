//report4_1_3
//将页面数据导出到本地Excel

package unit4;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "ContextToExcelServlet")
public class ContextToExcelServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		//CSV：逗号分隔符文本格式，用"\n"代表tr，用","代表td

		//设置编码为utf-8
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//得到文件名和一组参数
		String fileName = "hobby.csv";
		String[] strArray = req.getParameterValues("hobby");
		//通知浏览器以下载模式打开
		resp.addHeader("Content-Type", "application/octet-stream");
		resp.addHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(fileName, StandardCharsets.UTF_8));
		// 获取response对象的输出流
		ServletOutputStream out = resp.getOutputStream();
		//写入这组参数
		for(String str : strArray) {
			out.println("hobby" + "," + str);
		}
	}
}
