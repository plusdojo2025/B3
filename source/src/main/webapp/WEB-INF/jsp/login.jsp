<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Parfüm Note | Login</title>
<link rel="stylesheet" href="<c:url value='/css/common.css'/>">
<link rel="stylesheet" href="<c:url value='/css/login.css'/>">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<header>
		<img src="img/logo.png" alt="Parfüm Note" height="130">
	</header>
	<main>
	<h2>Login</h2>
		<form id = "login"  action="<c:url value='LoginServlet' />" method="POST" >
			<div class="form-row">
				<label for="id">ID</label>
        		<input type="text" id="id" name="id">
      		</div>
      		<div class="form-row">
    			<label for="pw">Password</label>
    			<input type="password" id="pw" name="pw">
  			</div>
      <br>
      <input type="submit" name="submit" value="ログイン">
      <input type="reset" name="reset" value="リセット">
      <p id="errormessage"></p>
  </form>
  <p>ID dojouser1
  <p>PW #SEplus2025SEplus
</main>
<footer>
</footer>    
<script>
	'use strict';
	const form = document.getElementById('login');
	const error = document.getElementById('errormessage');
	const idInput = form.id;
	const pwInput = form.pw;

	form.onsubmit = function() {
  	if (!idInput.value || !pwInput.value) {
	    error.textContent = "※ユーザーIDとパスワードを入力してください";
	    return false; 
	 }
 	 error.textContent = null;
	};  
</script>
</body>

</html>