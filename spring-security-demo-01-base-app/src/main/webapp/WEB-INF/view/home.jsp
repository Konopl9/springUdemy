<%--
  Created by IntelliJ IDEA.
  User: mishcma
  Date: 3/15/2022
  Time: 2:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Mishcma Company Home Page</title>
</head>
<body>
    <h2>Mishcma Company Home Page</h2>
    <p>
        Welcome to the home page !!!
    </p>

    <hr>

    <security:authorize access="hasRole('MANAGER')">
        <!-- A link to point to /leaders ... for MANAGERS -->
        <p>
            <a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
            (Only for Manager peeps)
        </p>
    </security:authorize>

    <security:authorize access="hasRole('ADMIN')">
        <!-- A link to point to /systems ... for MANAGERS -->
    <p>
        <a href="${pageContext.request.contextPath}/systems">IT systems meeting</a>
        (Only for Admin peeps)
    </p>
    <hr>
    </security:authorize>

    <%--    display user name and role--%>
    <p>
        User: <security:authentication property="principal.username" />
        <br><br>
        Role (s): <security:authentication property="principal.authorities" />
    </p>
    <hr>
    <form:form action="${pageContext.request.contextPath}/logout" method="POST">
        <input type="submit" value="Logout"/>
    </form:form>

</body>
</html>
