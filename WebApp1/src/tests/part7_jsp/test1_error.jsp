<%--测试：错误的处理页--%>
<%@ page contentType="text/html;utf-8" pageEncoding="utf-8" %>
<%--表示此页面可以处理错误--%>
<%@ page isErrorPage="true" %>

<%--表示此页面没有错误--%>
<% response.setStatus(200) %>
<h1>程序出现了错误！</h1>
