//report4_1_1
//使用JspSmartUpload插件实现文件上传

package unit4;

import com.jspsmart.upload.SmartUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FileUploadServlet", urlPatterns = "/report/unit4/fileUpload")
public class FileUploadServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		SmartUpload su = new SmartUpload();
		su.initialize(this.getServletConfig(), req, resp);
		//设置上传限制和上传数据总长度
		su.setMaxFileSize(1024 * 1024 * 10);
		su.setTotalMaxFileSize(1024 * 1024 * 20);
		//上传文件并保存到指定目录下
		try {

			su.upload();
			su.save("upload");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
