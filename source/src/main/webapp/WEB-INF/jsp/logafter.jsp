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
    		<option value="" ${empty perfume_id ? "selected" : ""}>---</option>
    		<option value="1" ${perfume_id == '1' ? "selected" : ""}>香水A</option>
    		<option value="2" ${perfume_id == '2' ? "selected" : ""}>香水B</option>
    		<option value="3" ${perfume_id == '3' ? "selected" : ""}>香水C</option>
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
<!-- 		削除ボタンを画像に -->
		<input type="submit" name="action" value="削除">
		
		<p>・使用後登録</p>
		<hr>
		
		<label for="middle_note">ミドルノート</label>
		<textarea name="middle_note"></textarea><br>
		
		<label for="last_note">ラストノート</label>
		<textarea name="last_note"></textarea><br>
		
		<label for="thoughts">感想</label>
		<textarea name="thoughts"></textarea>
		
		<p>記録すると自動的にカレンダーに戻ります</p>
		
		<input type="submit" name="action" value="記録">
		
	</form>
	<script src="<c:url value='/js/logafter.js' />"></script>
</body>
</html>