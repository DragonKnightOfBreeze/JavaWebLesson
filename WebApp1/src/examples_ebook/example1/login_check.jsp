<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="examples.example2.Utils.DBUtils" %>

<html>
<head>
    <title>登录验证</title>
</head>

<body>
<%
    boolean flag=false;
    String name=null;

    Connection con =  DBUtils.getConnection();
    try{
    	//TODO
        String sql = "select name from user where userId=? and password = ?";
        PreparedStatement pstmt = con.prepareStatement(sql);
        pstmt.setString(1,request.getParameter("id"));
        pstmt.setString(2,request.getParameter("password"));
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
        	name = rs.getString(1);
        	flag = true;
        }
        rs.close();
        pstmt.close();
        DBUtils.closeConnection(con);
    }catch (Exception e){
    	e.printStackTrace();
    }
%>
<%
    if(flag){
%>      <!--执行跳转操作-->
        <jsp:forward page="login_success.jsp">
            <jsp:param name="uname" value="<%=name%>>"/>
        </jsp:forward>
<%
    }else{
%>      <!--执行跳转操作-->
        <jsp:forward page="login_failure.html"/>
<%
    }
%>
</body>
</html>
