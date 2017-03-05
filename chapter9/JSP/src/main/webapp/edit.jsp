<%@ page import="dao.Repository" %>
<%@ page import="models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit user</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/edit" method="post">
    <% int id = Integer.valueOf(request.getParameter("id"));
        Repository repo = Repository.getInstance();
        User user = repo.getUserById(id);
    %>
    <input type="hidden" name="id" value="<%=user.getId()%>" />
    Name: <input type="text" name="name" value="<%=user.getFirstName()%>" /><br />
    Surname: <input type="text" name="surname" value="<%=user.getSurname()%>" /><br />
    Email: <input type="text" name="email" value="<%=user.getEmail()%>" /> <br />
    <input type="submit" value="Edit" />
</form>
</body>
</html>
