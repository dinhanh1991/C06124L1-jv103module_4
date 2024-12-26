<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Customer Details</title>
</head>
<body>
<h2>Customer Details</h2>
<table border="1">
  <tr>
    <th>ID</th>
    <td>${customer.id}</td>
  </tr>
  <tr>
    <th>Name</th>
    <td>${customer.name}</td>
  </tr>
  <tr>
    <th>Email</th>
    <td>${customer.email}</td>
  </tr>
  <tr>
    <th>Address</th>
    <td>${customer.address}</td>
  </tr>
</table>
<br>
<a href="/views/list.jsp">Back to Customer List</a>
</body>
</html>