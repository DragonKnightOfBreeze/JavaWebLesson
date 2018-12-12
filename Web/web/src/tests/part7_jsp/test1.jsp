<%--测试：处理错误--%>
<%@ page contentType="text/html;utf-8" pageEncoding="utf-8" %>
<%@ page errorPage="test1_error.jsp" %>
<% int result = 0; %>
<html>
<head>
<title>Hello World!</title>
</head>
<body style="text-align: center;">
    <h1>Hello World!</h1>
<%
    for(int i = 0; i < 100; i++) {
%>
        <%="HelloWord"%>
<%
    }
%>
    <%=result%>

</body>
</html>

