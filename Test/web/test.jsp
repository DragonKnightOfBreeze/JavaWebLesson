<%--<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql_rt" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="num" type="java.lang.String"--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--<jsp:useBean id="num" scope="page" type="java.lang.String"/>--%>
    <%--${num + "233"}&emsp;--%>
    <%--${num}--%>
    <%--<c:set var="a" value="aVar"/>--%>
    <%--${a}--%>
    <%--<!--变量名，变量值，要存储到的JavaBean，要存储到的JavaBean属性-->--%>
    <%--<c:set var="b" value="aVar" target="num" property="2234"/>--%>
    <%--${num}--%>
    <%
        int[] range= new int[]{1,2,3};
        pageContext.setAttribute("range",range);
    %>
    <c:forEach var="e" items="${range}" varStatus="va">
        ${va}
    </c:forEach>

</body>
</html>
