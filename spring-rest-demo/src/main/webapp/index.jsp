<%--
  Created by IntelliJ IDEA.
  User: mishcma
  Date: 3/28/2022
  Time: 12:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring Rest Demo</title>
</head>
<body>
    <b>Spring Rest Demo</b>
    <hr>
    <a href="${pageContext.request.contextPath}/test/hello">Hello</a>
    <br><br>
    <a href="${pageContext.request.contextPath}/api/students">Get all students</a>
</body>
</html>
