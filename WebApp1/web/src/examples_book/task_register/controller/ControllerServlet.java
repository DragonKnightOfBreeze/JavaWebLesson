package examples_book.task_register.controller;

import examples_book.task_register.domain.RegisterFormBean;
import examples_book.task_register.domain.UserBean;
import examples_book.task_register.utils.DBUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ControllerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req,resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");

		//获取用户注册时表单提交的参数信息
		String name=req.getParameter("name");
		String password = req.getParameter("password");
		String rePassword = req.getParameter("rePassword");
		String email = req.getParameter("email");
		//将获取的参数封装到注册表单相关的RegisterFormBean类中
		RegisterFormBean formBean = new RegisterFormBean();
		formBean.setName(name);
		formBean.setPassword(password);
		formBean.setRePassword(rePassword);
		formBean.setEmail(email);
		//验证参数填写是否符合要求，如果不符合，则转发到register.jsp重新填写
		if(!formBean.validate()){
			req.setAttribute("formBean",formBean);
			req.getRequestDispatcher("/register.jsp").forward(req,resp);
			return;
		}
		//如果参数填写符合要求，则将数据封装到UserBean类中
		UserBean userBean = new UserBean();
		userBean.setName(name);
		userBean.setPassword(password);
		userBean.setEmail(email);
		//调用DBUtils的insertUser()方法执行添加操作，并返回一个boolean类型的标志
		boolean b = DBUtils.getInstance().insertUser(userBean);
		//如果返回为false，表示注册的用户已存在，则重定向到register.jsp重新编写
		if(!b){
			req.setAttribute("DBMsg","你注册的用户已存在。");
			req.setAttribute("formBean",formBean);
			req.getRequestDispatcher("/register.jsp").forward(req,resp);
			return;
		}

		resp.getWriter().print("恭喜你注册成功，3秒钟后自动跳转");
		//将成功注册的用户信息添加到Session中
		//TODO：cookie相关
		req.getSession().setAttribute("userBean",userBean);
		resp.setHeader("refresh","3;url=loginSuccess.jsp");
	}
}
