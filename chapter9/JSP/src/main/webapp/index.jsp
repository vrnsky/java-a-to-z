<%@ page import="dao.Repository" %>
<%@ page import="models.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Egor
  Date: 18.02.2017
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Surname</th>
        <th>Email</th>
        <th>Operations</th>
    </tr>
    <% Repository repo = Repository.getInstance();
       List<User> users = repo.getAllUsers();
       for (User user : users) {
           String editUrl = String.format("%s/edit?id=%s", request.getContextPath(), user.getId());
           String removeUrl = String.format("%s/remove?id=%s", request.getContextPath(), user.getId());
    %>
       <tr>
           <td><%=user.getId()%></td>
           <td><%=user.getFirstName()%></td>
           <td><%=user.getSurname()%></td>
           <td><%=user.getEmail()%></td>
           <td><a href="<%=editUrl%>">Edit</a><br />
               <a href="<%=removeUrl%>">Remove</a></td>
       </tr>

    <% } %>
</table>

<a href="<%=request.getContextPath()%>/create.jsp">Add new user</a>
</body>
</html>
