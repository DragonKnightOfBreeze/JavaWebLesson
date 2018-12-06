<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>信息列表</title>
    <link rel="stylesheet" href="../css/main.css">
</head>

<body>
<div id="main-div">
    <jsp:include page="top.jsp"/>

    <!--中部div-->
    <div id="center-div">
        <div id="left-div">
            <ul>
                <li class="open">学生管理
                    <ul>
                        <li class="add"><a href="#" target="_self">新增</a></li>
                        <li class="edit"><a href="#" target="_self">修改</a></li>
                        <li class="del"><a href="#" target="_self">删除</a></li>
                    </ul>
                </li>
            </ul>
        </div>

        <div id="right-div">
            <form action="example3/modify" method="post">
                <table>
                    <thead>
                    <tr>
                        <th style="width:80px;">ID</th>
                        <th style="width:100px;">学生编号</th>
                        <th style="width:80px;">姓名</th>
                        <th style="width:200px;">分数</th>
                    </tr>
                    <tr>
                        <jsp:useBean id="student" scope="request" type="example3.domain.Student"/>
                        <td>${student.id}
                            <input type="hidden" name="id" value="${student.id}"/>
                        </td>
                        <td><input type="text" name="stuId" value="${student.stuId}"/></td>
                        <td><input type="text" name="name" value="${student.name}"/></td>
                        <td><input type="text" name="score" value="${student.score}"/></td>
                        <td>
                            <input type="reset" value="重置"/>
                            &emsp;
                            <input type="submit" value="提交"/>
                        </td>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </form>
        </div>
    </div>

    <jsp:include page="bottom.jsp"/>
</div>
</body>
</html>

