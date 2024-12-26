<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 21/12/2024
  Time: 10:25 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<h1>Customer List</h1>
<table>
    <p>
        <a href="/views/create.jsp">Create new customer</a>
    </p>
    <table border="1">
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Email</td>
            <td>Address</td>
            <td>Views</td>
            <td>Edit</td>
            <td>Delete</td>
        </tr>
        <c:forEach items='${requestScope["customerList"]}' var="customer" varStatus="loop">
            <tr>
                <td>${loop.count}</td>
                <td>${customer.getName()}</td>
                <td>${customer.getEmail()}</td>
                <td>${customer.getAddress()}</td>
                <td><a href="<%= request.getContextPath() %>/customer?action=view&id=${customer.getId()}">View</a></td>
                <td><a href="<%= request.getContextPath() %>/views/edit.jsp?action=edit&id=${customer.getId()}">edit</a></td>
                <td><form action="${pageContext.request.contextPath}/customer" method="post">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="${customer.id}">
                    <button type="submit">Delete</button>
                </form></td>
            </tr>
        </c:forEach>
    </table>
</table>
</body>
</html>
