<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Parfüm Note | Chart</title>
<link rel="stylesheet" href="<c:url value='/css/common.css'/>">
<script src="http://cdn/jsdelivr.net/npm/chart.js"></script>
</head>
<body>
<h3> chart</h3>
<h2>香水の使用割合</h2>
<canvas id="pieChart" width="400" height="400"></canvas>
<script src="<c:url value='/js/chart.js'/>"></script>
</body>
</html>