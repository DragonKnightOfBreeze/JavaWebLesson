<!--report4_1_1-->

<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
<title>文件上传</title>
</head>
<body>
<form action="report/unit4/fileUpload" method="post" enctype="multipart/form-data">
    选择文件：
    <input type="file" name="fileName" size="30"/>
    <input type="submit" value="上传"/>
</form>
</body>
</html>
