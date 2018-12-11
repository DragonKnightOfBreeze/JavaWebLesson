<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
<title>Title</title>
</head>
<body>
<%
    String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
%>
<%="今天是 " + dateStr%>
</body>
</html>
