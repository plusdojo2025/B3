<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Perfume</title>
    <link rel="stylesheet" href="<c:url value='/css/common.css'/>">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }

        .gallery {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            gap: 20px;
            max-width: 1000px;
            margin: 40px auto;
            padding: 0 20px;
        }

        .gallery-item {
            flex: 0 0 calc(33.33% - 20px);
            box-sizing: border-box;
            background-color: #ffffff;
            padding: 10px;
            border-radius: 12px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.05);
            transition: transform 0.3s ease;
        }

        .gallery-item:hover {
            transform: translateY(-5px);
        }

        .gallery-item img {
            width: 100%;
            height: 200px;
            object-fit: cover;
            border-radius: 8px;
        }

        @media (max-width: 768px) {
            .gallery-item {
                flex: 0 0 calc(50% - 20px);
            }
        }

        @media (max-width: 480px) {
            .gallery-item {
                flex: 0 0 100%;
            }
        }

        #andmore_button {
            display: block;
            margin: 30px auto;
            padding: 12px 25px;
            background-color: #ff7f50;
            border: none;
            border-radius: 6px;
            font-size: 16px;
            color: #fff;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        #andmore_button:hover {
            background-color: #ff6347;
        }

        .btn-container {
            text-align: center;
            margin: 30px 0;
        }

        .btn-container img {
            height: 60px;
            transition: transform 0.3s ease;
        }

        .btn-container img:hover {
            transform: scale(1.05);
        }

    </style>
</head>
<body>


<header>
		<jsp:include page="/WEB-INF/jsp/header.jsp" /> <!-- ヘッダー -->
	</header>

    
 

 


<div class="gallery">
    <c:forEach var="perfume" items="${imageList}" varStatus="status">
        <div class="gallery-item" <c:if test="${status.index >= 6}">style="display:none;" class="hidden-item"</c:if>>
            <img src="${pageContext.request.contextPath}/${perfume.perfume_img}" alt="">
        </div>
    </c:forEach>
</div>

<button id="andmore_button">さらに読み込む</button>
<div >
	<!--　<a href="RegistServlet"><img src="img/button.png" alt="Parfüm Note" height="60" alt="Parfüm Note"></a>　-->
  	  <a href="<c:url value='/RegistServlet'/>"><img src="<c:url value='/img/button.png'/>" alt="Parfüm Note" height="60"></a>
  </div>
  
  <script>
    document.getElementById('andmore_button').addEventListener('click', function () {
        const hiddenItems = document.querySelectorAll('.gallery-item[style*="display:none"]');
        hiddenItems.forEach(item => {
            item.style.display = 'block';
        });
        this.style.display = 'none'; // Hide the button after loading
    });
</script>
</body>
</html>