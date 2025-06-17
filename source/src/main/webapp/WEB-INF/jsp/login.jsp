<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Parfüm Note | Login</title>
<link rel="stylesheet" href="/B3/css/login.css">
</head>
<body>
	<header>
		<img src="/B3/img/logo.png">
	</header>
	<main>
	<h2>Login</h2>
		<form id = "login">
			<label>ID
        <input type="text" name="id">
      </label>
      <br>
      <label>Password
        <input type="password" name="pw">
      </label>
      <br>
      <input type="submit" name="submit" value="ログイン">
      <input type="reset" name="reset" value="リセット">
      <p id="errormessage"></p>
  </form>
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