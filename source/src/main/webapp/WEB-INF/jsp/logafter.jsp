<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Parfüm Note | Log</title>
<link rel="stylesheet" href="<c:url value='/css/common.css'/>">
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/header.jsp" />
	</header>
	
	<form method="POST" action="<c:url value='/LogAfterServlet'/>">
		<label for="perfume_id">*商品名</label>
		<select name="perfume_id">
		<!-- perfume_nameかidかわからない -->
			<option value="1">香水A</option>
			<option value="2">香水B</option>
			<option value="3">香水C</option>
		</select>
		
		<p>*</p>
		<img src="わからない" alt="香水画像">
		<!-- 商品名に基づいた画像を表示させる方法が分からない -->
		
		<div>登録済みのタグ
			<!-- イメージタグを表示させる方法が分からない -->
		</div>
		
		<p>・使用後登録</p>
		<hr>
		
		<label for="middle_note">ミドルノート</label>
		<textarea name="middle_note"></textarea><br>
		
		<label for="last_note">ラストノート</label>
		<textarea name="last_note"></textarea><br>
		
		<label for="thoughts">感想</label>
		<textarea name="thoughts"></textarea>
		
		<p>記録すると自動的にカレンダーに戻ります</p>
		
		<input type="submit" value="記録">
		<input type="submit" value="使用前へ">
	</form>
	<script src="<c:url value='/js/logafter.js' />"></script>
</body>
</html>