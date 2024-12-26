<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add New Customer</title>
</head>
<body>
<h1>Add New Customer</h1>
<form action="/customers/add" method="post">
    <label for="id">ID:</label>
    <input type="text" id="id" name="id" required><br><br>
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br><br>
    <label for="address">Address:</label>
    <input type="text" id="address" name="address" required><br><br>
    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required><br><br>
    <button type="submit">Add Customer</button>
</form>
<br>
<a href="/customers">Back to List</a>
</body>
</html>
