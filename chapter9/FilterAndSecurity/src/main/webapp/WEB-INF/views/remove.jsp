<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Remove</title>
</head>
<body>
<p>Push the button to remove user.</p>
<form action="${pageContext.servletContext.contextPath}/remove" method="post">
    <input type="hidden" name="id" value="${id}" />
    <input type="submit" value="Remove" />
</form>
</body>
</html>
