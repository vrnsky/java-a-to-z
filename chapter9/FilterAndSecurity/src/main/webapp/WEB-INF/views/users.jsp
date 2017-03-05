<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users Table</title>
</head>
<body>
<table border="1px">
    <tr>
        <th>ID</th>
        <th>Login</th>
        <th>Password</th>
        <th>Role</th>
        <th>Operations</th>
    </tr>
    <c:forEach items="${users}" var="current">
        <tr>
            <td><c:out value="${current.id}"/></td>
            <td><c:out value="${current.login}"/></td>
            <td><c:out value="${current.password}"/></td>
            <td><c:out value="${current.role}"/></td>
            <c:if test="${user.role == 'admin'}">
                <td><a href="${pageContext.servletContext.contextPath}/edit?id=${current.id}">Edit</a><br/>
                    <a href="${pageContext.servletContext.contextPath}/remove?id=${current.id}">Remove</a>
                </td>
            </c:if>
            <c:if test="${user.role != 'admin'}">
                <c:if test="${current.id == user.id}">
                    <td><a href="${pageContext.servletContext.contextPath}/edit?id=${current.id}">Edit</a></td>
                </c:if>
                <c:if test="${current != user}">
                    <td>Edition is not allowed</td>
                </c:if>
            </c:if>
        </tr>
    </c:forEach>
</table>
<c:if test="${user.role == 'admin'}">
   <a href="${pageContext.servletContext.contextPath}/create">Create a new user</a><br/>
   <a href="${pageContext.servletContext.contextPath}/add_role">Add a new role</a><br />
   <a href="${pageContext.servletContext.contextPath}/remove_role">Remove role</a>
</c:if>
</body>
</html>
