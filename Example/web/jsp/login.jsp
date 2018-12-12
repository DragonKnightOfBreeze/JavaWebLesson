<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>注册页面</title>
</head>
<body>
<form action="example/example3/login" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td><label for="userName">用户名</label></td>
            <td><input type="text" id="userName" name="userName" placeholder="请输入用户名" required></td>
        </tr>
        <tr>
            <td><label for="password">密&nbsp;&nbsp;码</label></td>
            <td><input type="password" id="password" name="password" placeholder="请输入密码" required></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="radio" id="user" name="identity" value="用户" checked/>
                <label for="user">用户</label>&emsp;
                <input type="radio" id="admin" name="identity" value="管理员"/>
                <label for="admin">管理员</label>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="reset" value="重置"/>&emsp;
                <input type="submit" value="确认"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
