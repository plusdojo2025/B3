<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Perfume</title>
</head>
<body>
    <h2>香水を検索</h2>

<<<<<<< HEAD
    <form method="POST" action="<c:url value='/ListServlet' />">
        <label>画像名またはキーワード: </label>
        <input type="text" name="perfume_imag" required />
        <button type="submit">検索</button>
    </form>
=======
	<header>
		<jsp:include page="/WEB-INF/jsp/header.jsp" /> <!-- ヘッダー -->
	</header>
	<p id="deletemessage"></p>  <!-- メッセージエリア -->


  <div class="perfume_id" id="perfume_id"></div>
  <button id="andmore_button">さらに読み込む</button>

  <div>
  	<a href="<c:url value='/RegistServlet'/>"><img src="img/button.png" alt="Parfüm Note" height="130"></a>
  </div>

  <div class="gallery">
    <c:forEach var="perfume" items="${perfumeList}">
      <div class="gallery-item">
      
        <img src="${pageContext.request.contextPath}/images/${perfume.perfume_img}" alt="画像">
        <p>${perfume.name}</p>
      </div>
    </c:forEach>
  </div>
>>>>>>> 6f9f1d484d4fcaadf48498f6c820b99d2ed475aa
</body>
</html>