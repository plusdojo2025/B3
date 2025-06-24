<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Parfüm Note | List</title>
<link rel="stylesheet" href="<c:url value='/css/common.css'/>">
</head>
<body>

	<header>
		<jsp:include page="/WEB-INF/jsp/header.jsp" /> <!-- ヘッダー -->
	</header>
	<p id="deletemessage"></p>  <!-- メッセージエリア -->


  <div class="perfume_id" id="perfume_id"></div>
  <button id="andmore_button">さらに読み込む</button>

  <div>
  	<a href="<c:url value='/RegistServlet'/>"><img src="<c:url value='/images/button.png'/>"></a>
  </div>

  <div class="gallery">
    <c:forEach var="perfume" items="${perfumeList}">
      <div class="gallery-item">
      
        <img src="${pageContext.request.contextPath}/images/${perfume.perfume_img}" alt="画像">
        <p>${perfume.name}</p>
      </div>
    </c:forEach>
  </div>
</body>
</html>
