<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Parfüm Note | Regist detail</title>
<link rel="stylesheet" href="/B3/css/list.css">
<style>
.slider-row {
    display: flex;
    align-items: center;
    gap: 10px;
    margin-bottom: 10px; /* スライダーごとの間隔 */
}
</style>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/header.jsp" />
	</header>
	<main>
		<form action="/b3/RegistServlet" method="POST">
			<label>*商品名
        		<input type="text" name="name">
      		</label>
      		<p id="errormessage"></p>
      	<br>
      		<label>ブランド
        		<input type="text" name="brand">
        	</label>
      	<br>
      		<label>値段
        		<input type="number" name="price" min="0">
      		</label>
      	<br>
      		<label>購入日
        		<input type="date" name="purchased_date">
        	</label>
      	<br>
      		<label>画像
        		<input type="file" name="image" accept="image/*">
      		</label>
      		<p id="errormessage"></p>
       	<br>
      		<label for="strength">強さ</label>
				<select name="strength" id="strength">
    				<option data-display="選択して下さい" value="">選択して下さい</option>
    				<option value="パルファム">パルファム</option>
    				<option value="オードパルファム">オードパルファム</option>
    				<option value="オードトワレ">オードトワレ</option>
    				<option value="オーデコロン">オーデコロン</option>
    				<option value="オーデサントゥール">オーデサントゥール</option>
				</select>
      	<br>
      		<label for="color">色を選んでください:</label>
				<input type="color" id="color" name="color" value="#FFFFFF">
      	<br>
      		//お気に入り
      	<br>
      	<input type="submit" name="delete" value="削除">
      	
      	<p>*香りの印象</p>
      	<p id="errormessage"></p>
      	<hr>
      		<div class="slider-row">
    			<span>シンプル</span>
    			<input type="range" id="complex" name="complex" min="0" max="100" value="50">
    			<span>コンプレックス</span>
			</div>
			<div class="slider-row">
    			<span>フレッシュ</span>
    				<input type="range" id="sweet" name="sweet" min="0" max="100" value="50">
    				<span>スイート</span>
			</div>
			<div class="slider-row">
    			<span>ライト</span>
    			<input type="range" id="heavy" name="heavy" min="0" max="100" value="50">
    			<span>ヘビー</span>
			</div>
			<div class="slider-row">
    			<span>メンズ</span>
    			<input type="range" id="women" name="women" min="0" max="100" value="50">
    			<span>レディース</span>
			</div>
			<div class="slider-row">
    			<span>マイルド</span>
    			<input type="range" id="spicy" name="spicy" min="0" max="100" value="50">
    			<span>スパイシー</span>
			</div>
			
			
      	<br>
      	<br>
      	<hr>     
      	<p>登録すると自動的にホームに戻ります</p>
      	
      	<br>
      	<input type="submit" name="regist" value="登録">
      	
      	
  </form>
</main>
</body>
</html>

