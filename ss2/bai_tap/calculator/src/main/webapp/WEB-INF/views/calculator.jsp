<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<h2>Simple Calculator</h2>
<form action="calculate" method="post">
    <label for="num1">Number 1:</label>
    <input type="number" name="num1" id="num1" required><br><br>

    <label for="num2">Number 2:</label>
    <input type="number" name="num2" id="num2" required><br><br>

    <label for="operation">Operation:</label>
    <select name="operation" id="operation">
        <option value="add">Add</option>
        <option value="subtract">Subtract</option>
        <option value="multiply">Multiply</option>
        <option value="divide">Divide</option>
    </select><br><br>

    <button type="submit">Calculate</button>
</form>

<c:if test="${not empty result}">
    <h3>Result: ${result}</h3>
</c:if>

<c:if test="${not empty error}">
    <h3 style="color: red;">${error}</h3>
</c:if>
</body>
</html>
