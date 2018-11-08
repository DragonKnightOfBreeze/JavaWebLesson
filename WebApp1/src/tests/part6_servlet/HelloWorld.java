package tests.part6_servlet;

import javax.servlet.*;
import java.io.IOException;

public class HelloWorld extends GenericServlet {
	@Override
	public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
		var writer = servletResponse.getWriter();
		writer.print("Hello World!");
	}
}