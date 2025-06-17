<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Parfüm Note | Search</title>
<link rel="stylesheet" href="/B3/css/search.css">


<title>カスタム2つまみスライダー</title>
  <style>
    .slider-container {
      width: 300px;
      position: relative;
      height: 10px;
      margin: 50px 0;
    }
    .slider-track {
      position: absolute;
      width: 100%;
      height: 10px;
      background: #ccc; /* 薄い灰色 */
      border-radius: 5px;
      top:
    }
    .slider-range {
      position: absolute;
      height: 10px;
      background: #888; /* 中くらいの灰色 */
      border-radius: 5px;
      z-index: 2;
    }
    input[type=range] {
      position: absolute;
      width: 100%;
      pointer-events: none;
      -webkit-appearance: none;
      background: none;
      z-index: 3;
    }
    input[type=range]::-webkit-slider-thumb {
      pointer-events: all;
      -webkit-appearance: none;
      height: 20px;
      width: 20px;
      border-radius: 50%;
      background: transparent;
      border: none;
    }
    .values {
      margin-top: 20px;
    }
  </style>

</head>
<body>
	<header>
	<jsp:include page="/WEB-INF/jsp/header.jsp" />
	</header>
<!-- エラーメッセージ -->	
	<form id="search_form" method="POST" action="/webapp/SearchServlet">
		<table>
			
					<label for="name">商品名
					<input type="text" name="name" id="name">
					</label>
				
					<label for="brand_name">ブランド
					<input type="text" name="brand_name" id="brand_name">
					</label>
			
					<label>イメージタグ
					<input type="text" name="image_tag" id="image_tag">
					</label>
				
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

<script>
<!-- エラーメッセージ -->	
'use strict';
document.getElementById('login_form').onsubmit = function(event) {
    const searchNAME = document.getElementById('name').value;
    const searchBRAND_NAME = document.getElementById('brand_name').value;
    const errorMessage = document.getElementById('error_message');

    if (searchNAME === '' && searchBRAND_NAME === '') {
        event.preventDefault();
        window.alert('項目を入力してください。');
    }
};

<!-- スライダーバー -->	
function updateSlider() {
    const minSlider = document.getElementById('minRange');
    const maxSlider = document.getElementById('maxRange');
    const sliderRange = document.getElementById('sliderRange');
    const rangeValue = document.getElementById('rangeValue');
    let min = parseInt(minSlider.value);
    let max = parseInt(maxSlider.value);
    // 値の入れ替え防止
    if (min > max) {
      [min, max] = [max, min];
    }
    rangeValue.textContent = `${min} - ${max}`;
    const percentMin = (min / 100) * 100;
    const percentMax = (max / 100) * 100;
    sliderRange.style.left = percentMin + "%";
    sliderRange.style.width = (percentMax - percentMin) + "%";
  }
  updateSlider();


</script>
</html>