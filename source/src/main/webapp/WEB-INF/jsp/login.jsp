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
		<form>
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
</body>
</html>