<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 21/12/2024
  Time: 10:46 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Create New Customer</h2>
<form action="<%= request.getContextPath() %>/customer?action=create" method="post">
  <input type="hidden" name="action" value="create">
  <label for="name">ID:</label>
  <input type="text" id="id" name="id" required><br><br>
  <label for="name">Name:</label>
  <input type="text" id="name" name="name" required><br><br>
  <label for="email">Email:</label>
  <input type="email" id="email" name="email" required><br><br>
  <label for="address">Address:</label>
  <input type="text" id="address" name="address" required><br><br>
  <button type="submit">Create</button>
</form>

<br>
<a href="/views/list.jsp">Back to Customer List</a>

<br>
<c:if test="${not empty messenger}">
  <p>${messenger}</p>
</c:if>
</body>
</html>
