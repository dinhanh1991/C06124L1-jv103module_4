<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Edit Customer</title>
</head>
<body>
<h1>Edit Customer</h1>
<form action="/customers/update" method="post">
  <input type="hidden" id="id" name="id" value="${customer.id}">
  <label for="name">Name:</label>
  <input type="text" id="name" name="name" value="${customer.name}" required><br><br>
  <label for="address">Address:</label>
  <input type="text" id="address" name="address" value="${customer.address}" required><br><br>
  <label for="email">Email:</label>
  <input type="email" id="email" name="email" value="${customer.email}" required><br><br>
  <button type="submit">Update Customer</button>
</form>
<br>
<a href="/customers">Back to List</a>
</body>
</html>
