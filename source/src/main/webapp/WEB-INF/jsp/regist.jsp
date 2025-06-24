<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Parfüm Note | Regist detail</title>
<link rel="stylesheet" href="<c:url value='/css/common.css'/>">
<link rel="stylesheet" href="<c:url value='/css/regist.css'/>">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/header.jsp" />
	</header>
	
	<main>
  <form method="POST" action="<c:url value='/RegistServlet' />" enctype="multipart/form-data">

    <!-- 上段：左 = 入力欄, 右 = 画像 -->
    <div class="form-top">
      <!-- 左上：基本情報 -->
      <div class="form-left">
        <div class="form-row">
          <label>商品名</label>
          <input type="text" name="perfume_name">
        </div>
        <div class="form-row">
          <label>ブランド</label>
          <input type="text" name="brand">
        </div>
        <div class="form-row">
          <label>値段</label>
          <input type="number" name="price" min="0">
        </div>
        <div class="form-row">
          <label>購入日</label>
          <input type="date" name="purchased_date">
        </div>
        <div class="form-row">
          <label for="strength">強さ</label>
          <select name="strength" id="strength">
            <option value="">選択して下さい</option>
            <option value="1">パルファム</option>
            <option value="2">オードパルファム</option>
    		<option value="3">オードトワレ</option>
    		<option value="4">オーデコロン</option>
    		<option value="5">オーデサントゥール</option>
          </select>
        </div>
        <div class="form-row">
          <label for="color">色</label>
          <input type="color"　id="color" name="color" value="#ffffff"　class="color-input">
        </div>
      </div>

      <!-- 右上：画像 -->
      <div class="form-right">
        <label>画像</label><br>
        <input type="file" name="image" accept="image/*" onchange="previewImage(this);">
        <canvas id="preview" style="max-width: 200px;"></canvas>
      </div>
    </div>

    <!-- 下段：中央に香りの印象とボタン -->
    <div class="form-bottom">
      <p>*香りの印象</p>
      <hr>
      <div class="slider-row">
        <span>シンプル</span>
        <input type="range" id="complex" name="complex" min="0" max="100" value="50">
        <span>コンプレックス</span>
      </div>
      
      <div class="slider-row">
        <span>フレッシュ</span>
        <input type="range" id="complex" name="complex" min="0" max="100" value="50">
        <span>スイート</span>
      </div>
      
      <div class="slider-row">
        <span>ライト</span>
        <input type="range" id="complex" name="complex" min="0" max="100" value="50">
        <span>ヘビー</span>
      </div>
      
      <div class="slider-row">
        <span>メンズ</span>
        <input type="range" id="complex" name="complex" min="0" max="100" value="50">
        <span>レディース</span>
      </div>
      
      <div class="slider-row">
        <span>マイルド</span>
        <input type="range" id="complex" name="complex" min="0" max="100" value="50">
        <span>スパイシー</span>
      </div>

      <div class="button-row">
        <input type="submit" value="登録" name="regist">
        <input type="reset" value="リセット">
        <input type="submit" name="delete" value="削除">
      </div>
    </div>

  </form>
</main>

<script src="<c:url value='/js/regist.js'/>"></script>
</body>

</html>
