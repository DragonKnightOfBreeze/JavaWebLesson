//report4_1_2
//使用JspSmartUpload插件实现文件下载

package unit4;

import com.jspsmart.upload.SmartUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FileDownloadServlet", urlPatterns = "/report/unit4/fileDownload")
public class FileDownloadServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		String fileName = req.getParameter("fileName").trim();
		SmartUpload su = new SmartUpload();
		su.initialize(getServletConfig(), req, resp);
		//禁止浏览器自动打开文件
		su.setContentDisposition(null);
		//下载文件
		try {
			su.downloadFile(getServletContext().getRealPath("/download") + "/" + fileName);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
