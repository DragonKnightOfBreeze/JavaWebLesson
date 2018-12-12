<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<%
	for(int i = 0; i < Integer.parseInt(request.getParameter("count").trim()); i++) {
%>
	<%=request.getParameter("content")%>
<%
	}
%>

<%
	for(int i = 0; i < Integer.parseInt(request.getParameter("count").trim()); i++) {
%>
		${param.content}
<%
	}
%>
</body>
</html>
