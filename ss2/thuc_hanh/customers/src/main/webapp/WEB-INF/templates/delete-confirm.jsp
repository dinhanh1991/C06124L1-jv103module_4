<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Delete Customer</title>
</head>
<body>
<h1>Are you sure you want to delete this customer?</h1>
<p><strong>ID:</strong> ${customer.id}</p>
<p><strong>Name:</strong> ${customer.name}</p>
<p><strong>Address:</strong> ${customer.address}</p>
<p><strong>Email:</strong> ${customer.email}</p>
<form action="/customers/delete" method="post">
  <input type="hidden" id="id" name="id" value="${customer.id}">
  <button type="submit">Yes, Delete</button>
  <a href="/customers">Cancel</a>
</form>
</body>
</html>
