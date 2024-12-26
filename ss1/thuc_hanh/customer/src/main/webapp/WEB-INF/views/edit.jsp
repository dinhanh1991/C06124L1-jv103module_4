<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 21/12/2024
  Time: 10:47 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Edit Customer</h2>

<!-- Hiển thị thông báo nếu có -->
<c:if test="${not empty messenger}">
    <p style="color:green">${messenger}</p>
</c:if>

<form action="<%= request.getContextPath() %>/customer?action=edit" method="post">
    <input type="hidden" name="action" value="edit">
    <input type="hidden" name="id" value="${param.id}">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="${customer.name}" required><br><br>

    <label for="email">Email:</label>
    <input type="text" id="email" name="email" value="${customer.email}" required><br><br>

    <label for="address">Address:</label>
    <input type="text" id="address" name="address" value="${customer.address}" required><br><br>

    <button type="submit">Update</button>
</form>

<br>

<a href="/views/list.jsp">Back to Customer List</a>
</body>
</html>
