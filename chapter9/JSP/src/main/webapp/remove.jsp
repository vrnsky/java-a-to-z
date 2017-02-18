<%@ page import="dao.Repository" %>
<%@ page import="models.User" %><%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 18.02.2017
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Remove user</title>
</head>
<body>
<% Repository repo = Repository.getInstance();
    User user = repo.getUserById(Integer.valueOf(request.getParameter("id")));
%>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Email</th>
    </tr>
    <tr>
        <td><%=user.getId()%></td>
        <td><%=user.getFirstName()%></td>
        <td><%=user.getSurname()%></td>
        <td><%=user.getEmail()%></td>
    </tr>
</table>
<p>Do you want to remove this user? If yes push the remove button. Otherwise return back.</p>
<form action="<%=request.getContextPath()%>/remove" method="post">
    <input type="hidden" name="id" value="<%=user.getId()%>" />
    <input type="submit" value="Remove" />
</form>
</body>
</html>
