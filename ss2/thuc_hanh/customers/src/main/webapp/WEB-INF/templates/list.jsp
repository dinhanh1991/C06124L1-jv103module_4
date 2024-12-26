<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Customer List</title>
</head>
<body>
<h1>Customer List</h1>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Address</th>
        <th>Email</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.address}</td>
            <td>${customer.email}</td>
            <td>
                <a href="/customers/${customer.id}">View</a> |
                <a href="/customers/edit?id=${customer.id}">Edit</a> |
                <a href="/customers/delete?id=${customer.id}" onclick="return confirm('Are you sure?')">Delete</a>
            </td>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="/customers/add">Add New Customer</a>
</body>
</html>
