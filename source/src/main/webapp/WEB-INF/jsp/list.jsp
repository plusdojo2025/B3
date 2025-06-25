<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Perfume</title>
</head>
<body>
    <h2>香水を検索</h2>

    <form method="POST" action="<c:url value='/ListServlet' />">
        <label>画像名またはキーワード: </label>
        <input type="text" name="perfume_imag" required />
        <button type="submit">検索</button>
    </form>
</body>
</html>
