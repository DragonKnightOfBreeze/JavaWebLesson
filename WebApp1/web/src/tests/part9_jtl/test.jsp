<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        request.setAttribute("range",new int[]{1,2,3});
        int[] ints = new int[];

    %>
    ${abc}
    <c:forEach var="item" items="${range}">
        ${item}
    </c:forEach>
</body>
</html>
