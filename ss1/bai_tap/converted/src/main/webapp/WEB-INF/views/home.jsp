<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Currency Converter</title>
</head>
<body>
<h1>Currency Converter: USD to VND</h1>
<form action="convert" method="post">
    <label for="rate">Exchange Rate (VND per USD):</label>
    <input type="number" id="rate" name="rate" step="0.01" required>
    <br>
    <label for="usdAmount">Amount in USD:</label>
    <input type="number" id="usdAmount" name="usdAmount" step="0.01" required>
    <br><br>
    <button type="submit">Convert</button>
</form>
</body>
</html>
