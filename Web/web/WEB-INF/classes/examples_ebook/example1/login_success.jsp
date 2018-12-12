<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>登录成功页</title>
    <style>
        *{margin: 5em auto;}
        .name{color:red;}
    </style>
</head>
<body>
    <h1>登录操作</h1>
    <h2>登录成功</h2>
    <h2>欢迎<span class="name"><%=request.getParameter("uname")%></span>光临！</h2>
</body>
</html>
