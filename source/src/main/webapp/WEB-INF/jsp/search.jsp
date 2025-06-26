<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

  <meta charset="UTF-8">
  <title>Parfüm Note | Search</title>
  <link rel="stylesheet" href="<c:url value='/css/common.css'/>">

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
	<form id="search_form" method="POST" action="<c:url value='/SearchServlet'/>">
		<table>
			
		<label for="name">商品名
		<input type="text" name="perfume_name" id="name">
		</label>
				
		<br>
		<label for="brand_name">ブランド
		<input type="text" name="brand_name" id="brand_name">
		</label>
			
		
<label>シンプル  
  <div class="slider-container">
    <div class="slider-track"></div>
    <div class="slider-range"></div>
    <input type="range" class="minRange" name="simple_minRange" min="0" max="100" value="0" oninput="updateSlider(this)">
    <input type="range" class="maxRange" name="simple_maxRange" min="0" max="100" value="100" oninput="updateSlider(this)">
  </div>
  <div class="values">
    選択範囲: <span class="rangeValue">0 - 100</span>
  </div>
</label>
				
<label>フレッシュ  
  <div class="slider-container">
    <div class="slider-track"></div>
    <div class="slider-range"></div>
    <input type="range" class="minRange" name="fresh_minRange" min="0" max="100" value="0" oninput="updateSlider(this)">
    <input type="range" class="maxRange" name="fresh_maxRange" min="0" max="100" value="100" oninput="updateSlider(this)">
  </div>
  <div class="values">
    選択範囲: <span class="rangeValue">0 - 100</span>
  </div>
</label>
				
					<label>ライト  
  <div class="slider-container">
    <div class="slider-track"></div>
    <div class="slider-range"></div>
    <input type="range" class="minRange" name="light_minRange" min="0" max="100" value="0" oninput="updateSlider(this)">
    <input type="range" class="maxRange" name="light_maxRange" min="0" max="100" value="100" oninput="updateSlider(this)">
  </div>
  <div class="values">
    選択範囲: <span class="rangeValue">0 - 100</span>
  </div>
</label>
				
					<label>メンズ  
  <div class="slider-container">
    <div class="slider-track"></div>
    <div class="slider-range"></div>
    <input type="range" class="minRange" name="men_minRange" min="0" max="100" value="0" oninput="updateSlider(this)">
    <input type="range" class="maxRange" name="men_maxRange" min="0" max="100" value="100" oninput="updateSlider(this)">
  </div>
  <div class="values">
    選択範囲: <span class="rangeValue">0 - 100</span>
  </div>
</label>
				
					<label>マイルド  
  <div class="slider-container">
    <div class="slider-track"></div>
    <div class="slider-range"></div>
    <input type="range" class="minRange" name="mild_minRange" min="0" max="100" value="0" oninput="updateSlider(this)">
    <input type="range" class="maxRange" name="mild_maxRange" min="0" max="100" value="100" oninput="updateSlider(this)">
  </div>
  <div class="values">
    選択範囲: <span class="rangeValue">0 - 100</span>
  </div>
</label>
				
					<input type="submit" value="検索">
					<span id="error_message"></span>
				
		</table>
	</form>	
	

<script>
function updateSlider(input) {
  const label = input.closest('label'); // Find the label around the input

  const minInput = label.querySelector('.minRange');
  const maxInput = label.querySelector('.maxRange');
  const display = label.querySelector('.rangeValue');

  const min = parseInt(minInput.value, 10);
  const max = parseInt(maxInput.value, 10);

  const minValue = Math.min(min, max);
  const maxValue = Math.max(min, max);

  display.textContent = minValue + " - " + maxValue;
}

'use strict';
const form = document.getElementById('search');
const error = document.getElementById('errormessage');
const perfume_nameInput = form.perfume_name;
const brand_nameInput = form.brand_name;
const detailInput = form.detail;
const complexInput = form.complex;
const sweetInput = form.sweet;
const heavyInput = form.heavy;
const womenInput = form.women;
const spicyInput = form.spicy;

form.onsubmit = function() {
	if (!perfume_nameInput.value || !brand_nameInput.value || !detailInput.value || !complexInput.value || !sweetInput.value || !heavyInput.value || !womenInput.value || !spicyInput.value) {
    error.textContent = "※項目を入力してください";
    return false; 
 }
	 error.textContent = null;
};  
</script>
  
</body>
</html>