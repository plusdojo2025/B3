<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Parfüm Note | Search</title>
<link rel="stylesheet" href="/B3/css/search.css">
</head>
<body>
	<header>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
	</header>
		<table>
			<tr>
				<td>
					<label>商品名
					<input type="text" name="name">
					</label>
				</td>
			</tr>
			<tr>
				<td>
					<label>ブランド
					<input type="text" name="brand">
					</label>
				</td>
			</tr>
			<tr>
				<td>
					<label>イメージタブ
					<input type="text" name="">
					</label>
				</td>
			</tr>
			
			<tr>
				<td>
					<input type="submit" id="" name="" value="検索">
					<span id="error_message"></span>
				</td>
			</tr>
		</table>
		
	
</body>
</html>