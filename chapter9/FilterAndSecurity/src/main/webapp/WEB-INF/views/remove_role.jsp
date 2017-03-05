<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Remove role</title>
</head>
<body>
<% int i = 0; %>
<form action="${pageContext.servletContext.contextPath}/remove_role" method="post">
    <select name="role">
        <c:forEach items="${roles}" var="role">
            <option value="<%=i++%>"><c:out value="${role}"/></option>
        </c:forEach>
    </select>
    <input type="submit" value="Remove" />
</form>
</body>
</html>
