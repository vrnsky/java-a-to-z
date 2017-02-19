<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit user</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/edit" method="post">
    <c:set var="user" value="${user}" />
    <input type="hidden" name="id" value="${user.id}" />
    Name: <input type="text" name="name" value="${user.firstName}" /><br />
    Surname: <input type="text" name="surname" value="${user.surname}" /><br />
    Email: <input type="text" name="email" value="${user.email}" /><br />
    <input type="submit" value="Edit" />
</form>
</body>
</html>
