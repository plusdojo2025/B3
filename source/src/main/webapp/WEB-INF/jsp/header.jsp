<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 <style>
 /* 全体のヘッダーラッパー */
.header-container {
    display: flex;
    flex-direction:column;
    align-items: center;
    gap: 20px;
    padding: 10px 20px;
    background-color: transparent; /* 透明でもいいけど色付けてもOK */
}

/* ロゴ画像 */
.header-logo {
    height: 60px;
    width: auto;
}
.header-nav {
	display: flex;
	flex-direction:row;
}
/* メニューリンク */
.header-nav a {
    text-decoration: none;
    color: #333;
    font-weight: bold;
    margin: 0 8px;
    transition: color 0.3s ease;
}

.header-nav a:hover {
    color: #2196F3; /* ホバーで青く */
}
 </style>
<div class="header-container">
	<img src="img/logo.png" alt="Parfüm Note" height="130">
	<nav class="header-nav">
		<a href="<c:url value='/ListServlet' />">Home</a>
		<a href="<c:url value='/CalenderServlet' />">Log</a>
		<a href="<c:url value='/SearchServlet' />">Search</a>
		<a href="<c:url value='/ChartServlet' />">MyType</a>
		<a href="<c:url value='/LoginServlet' />">Logout</a>
	</nav>
</div>