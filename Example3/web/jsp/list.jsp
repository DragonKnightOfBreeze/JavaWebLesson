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
            <table>
                <thead>
                <tr>
                    <th style="width:80px;">ID</th>
                    <th style="width:100px;">学生编号</th>
                    <th style="width:80px;">姓名</th>
                    <th style="width:200px;">分数</th>
                </tr>
                </thead>
                <tbody>
                <jsp:useBean id="studentList" scope="request" type="java.util.List<example3.domain.Student>"/>
                <c:forEach var="student" items="studentList">
                    <td>${student.getId()}</td>
                    <td>${student.getStuId()}</td>
                    <td>${student.getName()}</td>
                    <td>${student.getScore()}</td>
                    <td>
                        <c:url value="/edit" var="editUrl">
                            <c:param name="id" value="${student.getId()}"/>
                        </c:url>
                        <a href="${editUrl}">编辑</a>
                        &emsp;
                        <c:url value="/delete" var="deleteUrl">
                            <c:param name="id" value="${student.getId()}"/>
                        </c:url>
                        <a href="${deleteUrl}">删除</a>
                    </td>
                </c:forEach>
                </tbody>
            </table>

            <div>
                <a href="list?pageIndex=1">&lt;首页&gt;</a>&nbsp;

                <jsp:useBean id="pageIndex" scope="request" type="java.lang.Integer"/>
                <jsp:useBean id="pageNumber" scope="request" type="java.lang.Integer"/>
                <%
                    for (int i = 1; i <= pageNumber; i++) {
                    	if (i == pageIndex){
                %>
                &lt;<%=i%>页&gt;&nbsp;
                <%
                        }else{
                %>
                <a  href="list?pageIndex=<%=i%>">&lt;<%=i%>页&gt;</a>&nbsp;
                <%
                        }
                    }
                %>

                <a href="list?pageIndex=<%=pageNumber%>">&lt;尾页&gt;</a>
            </div>
        </div>
    </div>

    <jsp:include page="bottom.jsp"/>
</div>
</body>
</html>
