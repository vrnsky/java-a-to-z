<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index page</title>
</head>
<body>
<table border="1px">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Email</th>
        <th>Operations</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.id}"></c:out></td>
            <td><c:out value="${user.firstName}"></c:out></td>
            <td><c:out value="${user.surname}"></c:out></td>
            <td><c:out value="${user.email}"></c:out></td>
            <td><a href="${pageContext.servletContext.contextPath}/edit?id=${user.id}">Edit</a><br >
                <a href="${pageContext.servletContext.contextPath}/remove?id=${user.id}">Remove</a></td>
        </tr>
    </c:forEach>
</table>
<a href="${pageContext.servletContext.contextPath}/create">Add new user</a>
</body>
</html>
