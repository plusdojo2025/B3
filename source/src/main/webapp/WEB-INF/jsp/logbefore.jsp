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
	
	<form method="POST" action="<c:url value='/LogBeforeServlet'/>">
		<label for="perfume_id">*商品名</label>
		<select name="perfume_id">
		<!-- perfume_nameかidかわからない -->
			<option value="">---</option>
			<option value="1">香水A</option>
			<option value="2">香水B</option>
			<option value="3">香水C</option>
		</select>
		<span id="error_message"></span>
		
		<c:forEach var="img" items="${pimgList}" >
			<img src='${pageContext.request.contextPath}/${img.perfume_img}' alt="香水画像">
		</c:forEach><br>
		
		<input type="submit" name="action" value="香水情報呼び出し"><br>
		

		<div>登録済みのタグ
			<table>
				<td>
					<c:forEach var="big" items="${pbigList}" >
						<p>${big.scent_type}　×</p>
					</c:forEach>
				</td>
				<td>
					<c:forEach var="sml" items="${psmlList}" >
						<p>${sml.detail}</p>
					</c:forEach>
				</td>
			</table>
		</div>
			
		<p>・使用前登録</p>
		<hr>

		<label>気温
			<input type="number" name="temperature" step="0.1">
		</label>
		
		<label for="weather">天気</label>
		<select name="weather">
				<option value="">---</option>
				<option value="sunny">晴れ</option>
				<option value="cloudy">くもり</option>
				<option value="rainy">雨</option>
				<option value="snowy">雪</option>
		</select><br>
		
		<label>つけた時間
			<input type="time" name="applied_time">
		</label>
		
		<label for="push_count">プッシュ数</label>
		<select name="push_count">
				<option value="">---</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
		</select>
		
		<label for="usage_scene">場面</label>
		<select name="usage_scene">
				<option value="">---</option>
				<option value="1">仕事</option>
				<option value="2">友人と遊ぶ</option>
				<option value="3">デート</option>
				<option value="4">ひとりで出かける</option>
		</select>
			
		<p>つけた箇所<br>
			<label><input type="checkbox" name="applied_area" value="head">頭</label>
			<label><input type="checkbox" name="applied_area" value="neck">首</label>
			<label><input type="checkbox" name="applied_area" value="armpit">脇</label>
			<label><input type="checkbox" name="applied_area" value="wrist">手首</label><br>
			<label><input type="checkbox" name="applied_area" value="back of the hand">手の甲</label>
			<label><input type="checkbox" name="applied_area" value="waist">腰</label>
			<label><input type="checkbox" name="applied_area" value="clothes">服</label>
			<label><input type="checkbox" name="applied_area" value="other parts">その他</label>
		</p>
		
		<label for="top_note">トップノート</label>
		<textarea name="top_note"></textarea>
		<hr>
		
		<p>記録すると自動的にカレンダーに戻ります</p>
		
		<input type="submit" name="action" value="記録">
		<input type="submit" name="action" value="使用後へ">
	</form>
	<script src="<c:url value='/js/logbefore.js' />"></script>
</body>
</html>