<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sandwich Selector</title>
</head>
<body>
<h1>Select Condiments for Your Sandwich</h1>
<form action="save" method="post">
    <label>
        <input type="checkbox" name="condiment" value="Ketchup"> Ketchup
    </label><br>
    <label>
        <input type="checkbox" name="condiment" value="Mustard"> Mustard
    </label><br>
    <label>
        <input type="checkbox" name="condiment" value="Mayonnaise"> Mayonnaise
    </label><br>
    <label>
        <input type="checkbox" name="condiment" value="Pickles"> Pickles
    </label><br>
    <button type="submit">Save</button>
</form>

<c:if test="${not empty message}">
    <p>${message}</p>
</c:if>
</body>
</html>

