<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
    HelloWorld!
    <a href="${pageContext.request.contextPath}/testEL">连接</a>
    <form action="test.jsp" method="post">
        <input type="text" name="num" value="StringExt"/>
        <input type="submit" value="提交"/>
    </form>

</body>
</html>
