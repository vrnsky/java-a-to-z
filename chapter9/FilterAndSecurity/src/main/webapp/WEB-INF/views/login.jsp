<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<c:if test="${error != ''}">
    <div style="background-color:red">
        <c:out value="${error}" />
    </div>
</c:if>
<form action="${pageContext.servletContext.contextPath}/login" method="post">
    Login: <input type="text" name="login" /><br />
    Password: <input type="password" name="password" /><br />
    <input type="submit" value="Log in" />
</form>
</body>
</html>
