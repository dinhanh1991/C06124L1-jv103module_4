<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Kết quả tra cứu</title>
</head>
<body>
<h1>Kết quả</h1>


<c:if test="${not empty meaning}">
    <p>Từ: <strong>${word}</strong></p>
    <p>Nghĩa: <strong>${meaning}</strong></p>
</c:if>

<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>

<c:if test="${not empty successMessage}">
    <p style="color: green;">${successMessage}</p>
</c:if>

<c:if test="${not empty failureMessage}">
    <p style="color: red;">${failureMessage}</p>
</c:if>

<a href="/">Quay lại</a>
</body>
</html>
