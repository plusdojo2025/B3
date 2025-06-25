<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Perfume</title>
    <link rel="stylesheet" href="<c:url value='/css/common.css'/>">
    
       <style>
        .gallery-item {
            display: inline-block;
            margin: 10px;
            text-align: center;
        }
        .gallery-item img {
            width: 200px;
            height: auto;
        }
    </style>
</head>
<body>


<header>

	

		<jsp:include page="/WEB-INF/jsp/header.jsp" /> <!-- ヘッダー -->
	</header>

    
 

 

<div class="gallery">
    <c:forEach var="perfume" items="${imageList}">
        <div class="gallery-item">
          <%--   <img src="${pageContext.request.contextPath}+'/'+{perfume.perfume_img}" alt="${perfume.name}"> --%>
          <img src='${pageContext.request.contextPath}/${perfume.perfume_img}' alt="">

     
            <%-- <p>${perfume.name}</p> --%>
            
        </div>
        
    </c:forEach>
    
     
</div>
<button id="andmore_button">さらに読み込む</button>

</body>
</html>