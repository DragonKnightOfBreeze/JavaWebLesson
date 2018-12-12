<%--@elvariable id="userBean" type="examples_book.task_register.example3.domain.UserBean"--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<html>
<head>
	<title>注册成功</title>
	<style>
		#main{
			width:500px;
			height:auto;
		}
		#main div{
			width: 200px;
			height:auto;
		}
		ul{
			padding-top: 1px;
			padding-left: 1px;
			list-style: none;
		}
	</style>
</head>

<body>
	<%
		if(session.getAttribute("userBean") == null){
	%>
	<jsp:forward page="/examples_book/task_register/jsp/register.jsp"/>
	<%
		return;
		}
	%>
	<div id="main">
		<div id="welcome">恭喜你，登录成功</div>
		<hr/>
		<div>您的信息：</div>
		<div>
			<ul>
				<li>您的姓名：${userBean.name}</li>
				<li>您的邮箱：${userBean.email}</li>
			</ul>
		</div>
	</div>
</body>
</html>
