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
  <script>
    // 画像URLのダミーデータ
    const imageUrls = [
      'img1.jpg', 'img2.jpg', 'img3.jpg', 'img4.jpg', 'img5.jpg', 'img6.jpg',
      'img7.jpg', 'img8.jpg', 'img9.jpg', 'img10.jpg', 'img11.jpg', 'img12.jpg',
      'img13.jpg', 'img14.jpg', 'img15.jpg'
    ];

    const gallery = document.getElementById('perfume_id');
    const loadMoreBtn = document.getElementById('andmore_button');
    let currentIndex = 0;
    const imagesPerPage = 6;

    function loadImages() {
      const nextImages = imageUrls.slice(currentIndex, currentIndex + imagesPerPage);
      nextImages.forEach(url => {
        const img = document.createElement('img');
        img.src = url;
        gallery.appendChild(img);
      });
      currentIndex += imagesPerPage;

      if (currentIndex >= imageUrls.length) {
        loadMoreBtn.style.display = 'none';
      }
    }

    loadImages();
    
    loadMoreBtn.addEventListener('click', loadImages);
  </script>
<script src="<c:url value='/js/list.js'/>"></script>
</body>
</html>