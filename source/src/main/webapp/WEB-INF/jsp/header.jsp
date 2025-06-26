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
    background-color: transparent; 
}

/* ロゴ画像 */
.header-logo {
    display: block;
    width: 150px;
    height: 150px;
    margin: 0 auto;
}
.header-nav {
	display: flex;
	flex-direction:row;
    padding: 10px; 
    /* border: 1px solid #000; */
    box-shadow: 2px 2px 10px rgba(0, 0, 0, 0.15);
    /*ドロップシャドウは勝手に足した*/
    background-color: #c5c5c5;
}
/* メニューリンク */
.header-nav a {
    text-decoration: none;
    font-weight: bold;
    margin: 0 8px;
    transition: color 0.3s ease;
    margin: 0 15px;
    color: #ffffff;
}

.header-nav a:hover {
    color: #000000;
}
 </style>
 
<div class="header-container">
	<img src="img/logo.png" alt="Parfüm Note" height="130">
	<nav class="header-nav">
		<a href="<c:url value='/ListServlet' />">Home</a>

		<a href="<c:url value='/CalendarServlet' />">Log</a>

		

		<a href="<c:url value='/SearchServlet' />">Search</a>
		<a href="<c:url value='/ChartServlet' />">MyType</a>
		<a href="<c:url value='/LoginServlet' />">Logout</a>
	</nav>
</div>