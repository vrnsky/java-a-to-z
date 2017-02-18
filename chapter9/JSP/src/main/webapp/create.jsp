<%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 18.02.2017
  Time: 13:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new user</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/create" method="post">
    Name: <input type="text" name="name" /><br />
    Surname: <input type="text" name="surname"/><br />
    Email: <input type="text" name="email" /><br />
    <input type="submit" value="Add" />
</form>
</body>
</html>
