<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<% int i = 1;%>
<form action="${pageContext.servletContext.contextPath}/create" method="post">
    Login: <input type="text" name="login" /><br />
    Password: <input type="password" name="password" /><br />
    <c:if test="${user.role == 'admin'}">
        <select name="role">
            <c:forEach items="${roles}" var="role">
                <option value="<%=i++%>"><c:out value="${role}" /></option>
            </c:forEach>
        </select>
    </c:if>
    <input type="submit" value="Add" />
</form>
</body>
</html>
