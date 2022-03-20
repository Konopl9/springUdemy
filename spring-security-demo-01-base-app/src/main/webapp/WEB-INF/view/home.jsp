<%--
  Created by IntelliJ IDEA.
  User: mishcma
  Date: 3/15/2022
  Time: 2:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Mishcma Company Home Page</title>
</head>
<body>
    <h2>Mishcma Company Home Page</h2>
    <p>
        Welcome to the home page !!!
    </p>
    <form:form action="${pageContext.request.contextPath}/logout" method="POST">
        <input type="submit" value="Logout"/>
    </form:form>

</body>
</html>
