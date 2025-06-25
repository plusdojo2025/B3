<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 
<div class="header">
	<img src="img/logo.png" alt="Parfüm Note" height="130">
	<nav class="nav">
		<a href="<c:url value='/ListServlet' />">Home</a>
		<a href="<c:url value='/CalenderServlet' />">Log</a>
		<a href="<c:url value='/SearcherServlet' />">Search</a>
		<a href="<c:url value='/ChartServlet' />">MyType</a>
		<a href="<c:url value='/LoginServlet' />">Logout</a>
	</nav>
</div>