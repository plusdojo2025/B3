<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Parfüm Note | Login</title>

</head>
<body>
	<header>
		<img src="/B3/img/logo.png">
	</header>
	<main>
	<h2>Login</h2>
		<form id = "login"  action="<c:url value='LoginServlet' />" method="POST" >
			<label>ID
        <input type="text" name="id">
      </label>
      <br>
      <label>Password
        <input type="password" name="pw">
      </label>
      <br>
      <input type="submit" name="subimt" value="ログイン">
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