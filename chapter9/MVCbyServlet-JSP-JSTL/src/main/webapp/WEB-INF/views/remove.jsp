<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Remove user</title>
</head>
<body>
<p>For removing user tap on the remove button.</p>
<form action="${pageContext.servletContext.contextPath}/remove" method="post">
    <input type="hidden" name="id" value="${user.id}" />
    <input type="submit" value="Remove" />
</form>
</body>
</html>
