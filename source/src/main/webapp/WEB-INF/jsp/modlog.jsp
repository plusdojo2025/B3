<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Parfüm Note | Log</title>
<link rel="stylesheet" href="/B3/css/common.css">
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/header.jsp" />
	</header>
	
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
	
	<p>・使用記録</p>
	<hr>
	
	<label>気温
		<input type="number" name="temperature" step="0.1">
	</label>
	
	<label for="weather">天気</label>
	<select name="weather">
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
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
	</select>

	<label for="usage_scene">場面</label>
	<select name="usage_scene">
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
	<textarea name="top_note"></textarea><br>
	
	<label for="middle_note">ミドルノート</label>
	<textarea name="middle_note"></textarea><br>
	
	<label for="last_note">ラストノート</label>
	<textarea name="last_note"></textarea><br>
	
	<label for="thoughts">感想</label>
	<textarea name="thoughts"></textarea>
	
	<p>更新すると自動的にカレンダーに戻ります</p>
	
	<input type="submit" value="更新">
	<input type="submit" value="戻る">
</body>
</html>