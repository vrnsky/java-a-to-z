<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add role</title>
</head>
<body>
<form method="post" action="${pageContext.servletContext.contextPath}/add_role">
    Name: <input type="text" name="role" />
    <input type="submit" value="Add" />
</form>
</body>
</html>
