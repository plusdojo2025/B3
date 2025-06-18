<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

  <meta charset="UTF-8">
  <title>Parfüm Note | Search</title>
  <link rel="stylesheet" href="https://code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/B3/css/search.css">

  <style>
    .slider-group {
      margin-bottom: 20px;
    }
    label {
      display: block;
      margin-bottom: 5px;
    }
  </style>
</head>
<body>

	<header>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
	</header>
<!-- エラーメッセージ -->	
	<form id="search_form" method="POST" action="/B3/SearchServlet">
		<table>
			
		<label for="name">商品名
		<input type="text" name="name" id="name">
		</label>
				
		<br>
		<label for="brand_name">ブランド
		<input type="text" name="brand_name" id="brand_name">
		</label>
			
		<br>
		<label>イメージタグ
		<input type="text" name="image_tag" id="image_tag">
		</label>
			
		<br>	
		<label>シンプル	
		<div class="slider-container">
		<div class="slider-track"></div>
		<div class="slider-range" id="sliderRange"></div>
	  	<input type="range" id="minRange" min="0" max="100" value="20" oninput="updateSlider()">
		<input type="range" id="maxRange" min="0" max="100" value="80" oninput="updateSlider()">
		</div>
		<div class="values">
		  選択範囲: <span id="rangeValue">20 - 80</span>
		</div>
		</label>
				
					<label>フレッシュ	
						<div class="slider-container">
						  <div class="slider-track"></div>
						  <div class="slider-range" id="sliderRange"></div>
						  <input type="range" id="minRange" min="0" max="100" value="20" oninput="updateSlider()">
						  <input type="range" id="maxRange" min="0" max="100" value="80" oninput="updateSlider()">
						</div>
						<div class="values">
						  選択範囲: <span id="rangeValue">20 - 80</span>
						</div>
					</label>
				
					<label>ライト	
						<div class="slider-container">
						  <div class="slider-track"></div>
						  <div class="slider-range" id="sliderRange"></div>
						  <input type="range" id="minRange" min="0" max="100" value="20" oninput="updateSlider()">
						  <input type="range" id="maxRange" min="0" max="100" value="80" oninput="updateSlider()">
						</div>
						<div class="values">
						  選択範囲: <span id="rangeValue">20 - 80</span>
						</div>
					</label>
				
					<label>メンズ	
						<div class="slider-container">
						  <div class="slider-track"></div>
						  <div class="slider-range" id="sliderRange"></div>
						  <input type="range" id="minRange" min="0" max="100" value="20" oninput="updateSlider()">
						  <input type="range" id="maxRange" min="0" max="100" value="80" oninput="updateSlider()">
						</div>
						<div class="values">
						  選択範囲: <span id="rangeValue">20 - 80</span>
						</div>
					</label>
				
					<label>マイルド	
						<div class="slider-container">
						  <div class="slider-track"></div>
						  <div class="slider-range" id="sliderRange"></div>
						  <input type="range" id="minRange" min="0" max="100" value="20" oninput="updateSlider()">
						  <input type="range" id="maxRange" min="0" max="100" value="80" oninput="updateSlider()">
						</div>
						<div class="values">
						  選択範囲: <span id="rangeValue">20 - 80</span>
						</div>
					</label>
				
					<input type="submit" value="検索">
					<span id="error_message"></span>
				
		</table>
	</form>	
	

</body>
</html>