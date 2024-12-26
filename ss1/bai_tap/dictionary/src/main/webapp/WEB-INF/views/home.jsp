<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tra từ điển Anh - Việt</title>
</head>
<body>
<h1>Tra từ điển Anh - Việt</h1>
<form action="/translate" method="get">
    <label for="word">Nhập từ tiếng Anh:</label>
    <input type="text" id="word" name="word" required>
    <button type="submit">Tra cứu</button>
</form>

<h2>Thêm từ mới</h2>
<form action="/add-word" method="post">
    <label for="newWord">Từ tiếng Anh:</label>
    <input type="text" id="newWord" name="word" required>
    <br>
    <label for="newMeaning">Nghĩa tiếng Việt:</label>
    <input type="text" id="newMeaning" name="meaning" required>
    <br>
    <button type="submit">Thêm từ</button>
</form>
<h2>Xóa Từ</h2>
<form action="/remove-word" method="post">
    <input type="text" id="oldWord" name="word" required>
    <button type="submit">Xóa từ</button>
</form>
</body>
</html>
