<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Customer Information</title>
</head>
<body>
<h1>Customer Information</h1>
<p><strong>ID:</strong> ${customer.id}</p>
<p><strong>Name:</strong> ${customer.name}</p>
<p><strong>Address:</strong> ${customer.address}</p>
<p><strong>Email:</strong> ${customer.email}</p>
<br>
<a href="/customers">Back to List</a>
</body>
</html>
