<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<% int i = 1;%>
<form action="${pageContext.servletContext.contextPath}/edit" method="post">
    <input type="hidden" name="id" value="${user.id}"/>
    Login: <input type="text" name="login"/><br />
    Password: <input type="password" name="password"/><br />
    <c:if test="${user.role == 'admin'}">
        <select name="role">
            <c:forEach items="${roles}" var="role">
                <option value="<%=i++%>"><c:out value="${role}" /></option>
            </c:forEach>
        </select>
    </c:if>
    <br />
    <input type="submit" value="Edit"/>
</form>
</body>
</html>
