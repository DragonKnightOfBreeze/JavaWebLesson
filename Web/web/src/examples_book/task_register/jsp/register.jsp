<%--@elvariable id="formBean" type="examples_book.task_register.example3.domain.RegisterFormBean"--%>
<%--@elvariable id="DBMsg" type="java.lang.String"--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<html>
<head>
	<title>用户注册</title>
	<style>
		h3{
			margin-left: 100px;
		}
		#outer{
			width: 750px;
		}
		span{
			color:#ff0000;
		}
		div{
			height:20px;
			margin-bottom: 10px;
		}
		.label{
			width:80px;
			text-align: right;
			float:left;
		}
		.ip{
			width:500px;
			float:left;
		}
		.ip>input{
			margin-right:20px;
		}
		#bt{
			margin-left:50px;
		}
		#bt>input {
			margin-right: 30px;
		}
	</style>
</head>

<body>
<form action="examples_book/task_register/register" method="post">
		 <h3>用户注册</h3>
		 <div id="outer">
			 <div>
				 <div class="label">姓名：</div>
				 <div class="ip">
					 <input type="text" name="name" value="${formBean.name}"/>
					 <span>${formBean.errorMap.name}${DBMsg}</span>
				 </div>
			 </div>
			 <div>
				 <div class="label">密码：</div>
				 <div class="ip">
					 <input type="text" name="password" value="${formBean.password}"/>
					 <span>${formBean.errorMap.password}</span>
				 </div>
			 </div>
			 <div>
				 <div class="label">确认密码：</div>
				 <div class="ip">
					 <input type="text" name="rePassword" value="${formBean.rePassword}"/>
					 <span>${formBean.errorMap.rePassword}</span>
				 </div>
			 </div>
			 <div>
				 <div class="label">邮箱：</div>
				 <div class="ip">
					 <input type="text" name="email" value="${formBean.email}"/>
					 <span>${formBean.errorMap.email}</span>
				 </div>
			 </div>
			<div id="bt">
				<input type="reset" value="重置"/>
				<input type="submit" value="注册"/>
			</div>
		 </div>
	 </form>
</body>
</html>
