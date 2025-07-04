<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Parfüm Note | Regist image</title>
<link rel="stylesheet" href="<c:url value='/css/common.css'/>">
<link rel="stylesheet" href="<c:url value='/css/registimage.css'/>">
</head>
<body>
<p> *イメージタグ </p>


<form id="myForm" method="POST" action="/B3/RegistImageServlet">
<div  class="section" data-section="甘さ">
<p class ="group-label">甘さ</p>
      		<label for="genre">ジャンル</label>
			<select name="genre" id="genre">
    			<option data-display="選択して下さい" value="">選択して下さい</option>
    			<option value="スイーツ">スイーツ</option>
    			<option value="果物">果物</option>
    			<option value="飲み物">飲み物</option>
    			<option value="スパイス">スパイス</option>
    			<option value="シーン">シーン</option>
    			<option value="植物">植物</option>
			</select>
			
			<div id="sweets-options" class="section" data-section="甘さ" style="display: none;">
    			<p>スイーツの種類を選んでください:</p>
					<label><input type="checkbox" name="sweets[]" value="無し"> 無し</label>
					<label><input type="checkbox" name="sweets[]" value="あんこ"> あんこ</label>
					<label><input type="checkbox" name="sweets[]" value="カスタード"> カスタード</label>
					<label><input type="checkbox" name="sweets[]" value="カラメル"> カラメル</label>
					<label><input type="checkbox" name="sweets[]" value="キャラメル"> キャラメル</label>
					<label><input type="checkbox" name="sweets[]" value="キャンディ"> キャンディ</label>
					<label><input type="checkbox" name="sweets[]" value="ケーキ"> ケーキ</label>
					<label><input type="checkbox" name="sweets[]" value="チョコレート"> チョコレート</label>
					<label><input type="checkbox" name="sweets[]" value="生クリーム"> 生クリーム</label>
					<label><input type="checkbox" name="sweets[]" value="はちみつ"> はちみつ</label>
					<label><input type="checkbox" name="sweets[]" value="バニラ"> バニラ</label>
					<label><input type="checkbox" name="sweets[]" value="プリン"> プリン</label>
					<label><input type="checkbox" name="sweets[]" value="マシュマロ"> マシュマロ</label>
					<label><input type="checkbox" name="sweets[]" value="メープルシロップ"> メープルシロップ</label>
					<label><input type="checkbox" name="sweets[]" value="モンブラン"> モンブラン</label>
					<label><input type="checkbox" name="sweets[]" value="わたあめ"> わたあめ</label>    				
			</div>
			
			<div id="fruit-options"class="section" data-section="甘さ" style="display: none;">
    			<p>フルーツの種類を選んでください:</p>
  <label><input type="checkbox" name="fruit[]" value="あんず"> あんず</label>
  <label><input type="checkbox" name="fruit[]" value="イチゴ"> イチゴ</label>
  <label><input type="checkbox" name="fruit[]" value="イチジク"> イチジク</label>
  <label><input type="checkbox" name="fruit[]" value="オレンジ"> オレンジ</label>
  <label><input type="checkbox" name="fruit[]" value="カシス"> カシス</label>
  <label><input type="checkbox" name="fruit[]" value="グレープフルーツ"> グレープフルーツ</label>
  <label><input type="checkbox" name="fruit[]" value="ココナッツ"> ココナッツ</label>
  <label><input type="checkbox" name="fruit[]" value="サクランボ"> サクランボ</label>
  <label><input type="checkbox" name="fruit[]" value="サツマイモ"> サツマイモ</label>
  <label><input type="checkbox" name="fruit[]" value="シトラス"> シトラス</label>
  <label><input type="checkbox" name="fruit[]" value="スイカ"> スイカ</label>
  <label><input type="checkbox" name="fruit[]" value="パイナップル"> パイナップル</label>
  <label><input type="checkbox" name="fruit[]" value="ブドウ"> ブドウ</label>
  <label><input type="checkbox" name="fruit[]" value="プラム"> プラム</label>
  <label><input type="checkbox" name="fruit[]" value="ベルガモット"> ベルガモット</label>
  <label><input type="checkbox" name="fruit[]" value="マスカット"> マスカット</label>
  <label><input type="checkbox" name="fruit[]" value="マンゴー"> マンゴー</label>
  <label><input type="checkbox" name="fruit[]" value="マンダリン"> マンダリン</label>
  <label><input type="checkbox" name="fruit[]" value="メロン"> メロン</label>
  <label><input type="checkbox" name="fruit[]" value="モモ"> モモ</label>
  <label><input type="checkbox" name="fruit[]" value="柚子"> 柚子</label>
  <label><input type="checkbox" name="fruit[]" value="ライム"> ライム</label>
  <label><input type="checkbox" name="fruit[]" value="ラズベリー"> ラズベリー</label>
  <label><input type="checkbox" name="fruit[]" value="ラフランス"> ラフランス</label>
  <label><input type="checkbox" name="fruit[]" value="リンゴ"> リンゴ</label>
  <label><input type="checkbox" name="fruit[]" value="レモン"> レモン</label>
			</div>
				
			<div id="drink-options" class="section" data-section="甘さ" style="display: none;">
    			<p>飲み物の種類を選んでください:</p>
					  <label><input type="checkbox" name="drink[]" value="無し"> 無し</label>
					  <label><input type="checkbox" name="drink[]" value="アールグレイ"> アールグレイ</label>
					  <label><input type="checkbox" name="drink[]" value="グリーンティー"> グリーンティー</label>
					  <label><input type="checkbox" name="drink[]" value="コーヒー"> コーヒー</label>
					  <label><input type="checkbox" name="drink[]" value="ブラックティー"> ブラックティー</label>
					  <label><input type="checkbox" name="drink[]" value="ほうじ茶"> ほうじ茶</label>
					  <label><input type="checkbox" name="drink[]" value="ミルク"> ミルク</label>
					  <label><input type="checkbox" name="drink[]" value="ミルクティー"> ミルクティー</label>
			</div>
			
			<div id="spices-options" class="section" data-section="甘さ" style="display: none;">
    			<p>スパイスの種類を選んでください:</p>
  <label><input type="checkbox" name="spices[]" value="無し"> 無し</label>
  <label><input type="checkbox" name="spices[]" value="クローブ"> クローブ</label>
  <label><input type="checkbox" name="spices[]" value="シナモン"> シナモン</label>
  <label><input type="checkbox" name="spices[]" value="ショウガ"> ショウガ</label>
  <label><input type="checkbox" name="spices[]" value="唐辛子"> 唐辛子</label>
  <label><input type="checkbox" name="spices[]" value="ペッパー"> ペッパー</label>
  <label><input type="checkbox" name="spices[]" value="ワサビ"> ワサビ</label>   				
			</div>
			
			<div id="scene-options" class="section" data-section="甘さ" style="display: none;">
    			<p>シーンの種類を選んでください:</p>
  <label><input type="checkbox" name="scene[]" value="無し"> 無し</label>
  <label><input type="checkbox" name="scene[]" value="オゾンノート"> オゾンノート</label>
  <label><input type="checkbox" name="scene[]" value="シーソルト"> シーソルト</label>
  <label><input type="checkbox" name="scene[]" value="石鹸"> 石鹸</label>
  <label><input type="checkbox" name="scene[]" value="ソファ"> ソファ</label>
  <label><input type="checkbox" name="scene[]" value="太陽"> 太陽</label>
  <label><input type="checkbox" name="scene[]" value="畳"> 畳</label>
  <label><input type="checkbox" name="scene[]" value="ムスク"> ムスク</label>
  <label><input type="checkbox" name="scene[]" value="海"> 海</label>
  <label><input type="checkbox" name="scene[]" value="映画館"> 映画館</label>
  <label><input type="checkbox" name="scene[]" value="カフェ"> カフェ</label>
  <label><input type="checkbox" name="scene[]" value="サウナ"> サウナ</label>
  <label><input type="checkbox" name="scene[]" value="森林"> 森林</label>
  <label><input type="checkbox" name="scene[]" value="茶室"> 茶室</label>
  <label><input type="checkbox" name="scene[]" value="ディズニー"> ディズニー</label>
  <label><input type="checkbox" name="scene[]" value="寺"> 寺</label>
  <label><input type="checkbox" name="scene[]" value="庭"> 庭</label>
  <label><input type="checkbox" name="scene[]" value="ビーチ"> ビーチ</label>
  <label><input type="checkbox" name="scene[]" value="美容室"> 美容室</label>
  <label><input type="checkbox" name="scene[]" value="プール"> プール</label>
  <label><input type="checkbox" name="scene[]" value="風呂"> 風呂</label>
  <label><input type="checkbox" name="scene[]" value="ベッドルーム"> ベッドルーム</label>
  <label><input type="checkbox" name="scene[]" value="ホテル"> ホテル</label>
  <label><input type="checkbox" name="scene[]" value="山"> 山</label>
  <label><input type="checkbox" name="scene[]" value="旅館"> 旅館</label>
  <label><input type="checkbox" name="scene[]" value="春"> 春</label>
  <label><input type="checkbox" name="scene[]" value="夏"> 夏</label>
  <label><input type="checkbox" name="scene[]" value="秋"> 秋</label>
  <label><input type="checkbox" name="scene[]" value="冬"> 冬</label>
			</div>
			
			<div id="plant-options" class="section" data-section="甘さ" style="display: none;">
    			<p>植物の種類を選んでください:</p>
  <label><input type="checkbox" name="plant[]" value="無し"> 無し</label>
  <label><input type="checkbox" name="plant[]" value="アーモンド"> アーモンド</label>
  <label><input type="checkbox" name="plant[]" value="イランイラン"> イランイラン</label>
  <label><input type="checkbox" name="plant[]" value="ウッド"> ウッド</label>
  <label><input type="checkbox" name="plant[]" value="カモミール"> カモミール</label>
  <label><input type="checkbox" name="plant[]" value="キンモクセイ"> キンモクセイ</label>
  <label><input type="checkbox" name="plant[]" value="ジャスミン"> ジャスミン</label>
  <label><input type="checkbox" name="plant[]" value="スズラン"> スズラン</label>
  <label><input type="checkbox" name="plant[]" value="ネロリ"> ネロリ</label>
  <label><input type="checkbox" name="plant[]" value="バジル"> バジル</label>
  <label><input type="checkbox" name="plant[]" value="ヒノキ"> ヒノキ</label>
  <label><input type="checkbox" name="plant[]" value="白檀(サンダルウッド)"> 白檀(サンダルウッド)</label>
  <label><input type="checkbox" name="plant[]" value="マリーゴールド"> マリーゴールド</label>
  <label><input type="checkbox" name="plant[]" value="ミモザ"> ミモザ</label>
  <label><input type="checkbox" name="plant[]" value="ミント"> ミント</label>
  <label><input type="checkbox" name="plant[]" value="ユーカリ"> ユーカリ</label>
  <label><input type="checkbox" name="plant[]" value="ラベンダー"> ラベンダー</label>
  <label><input type="checkbox" name="plant[]" value="ローズ"> ローズ</label>
  <label><input type="checkbox" name="plant[]" value="ローズマリー"> ローズマリー</label>
			</div>

      	<br>
      	<input type="submit" name="decision" value="決定">
      	<input type="reset" name="reset" value="リセット">
      	<hr>
      	</div>
      	</form>

<form id="myFormFresh" method="POST" action="/B3/RegistImageServlet">
<div  class="section" data-section="さわやかさ">
<p class ="group-label">さわやかさ</p>
				<label for="genre_fresh">ジャンル</label>
				<select name="genre" id="genre_fresh">
    				<option data-display="選択して下さい" value="">選択して下さい</option>
    				<option value="スイーツ1">スイーツ</option>
    				<option value="果物1">果物</option>
    				<option value="飲み物1">飲み物</option>
    				<option value="スパイス1">スパイス</option>
    				<option value="シーン1">シーン</option>
    				<option value="植物1">植物</option>
				</select>
			
			<div id="sweets-options1" class="section" data-section="さわやかさ" style="display: none;">
    			<p>スイーツの種類を選んでください:</p>
    				<label><input type="checkbox" name="sweets[]" value="無し"> 無し</label>
<label><input type="checkbox" name="sweets[]" value="あんこ"> あんこ</label>
<label><input type="checkbox" name="sweets[]" value="カスタード"> カスタード</label>
<label><input type="checkbox" name="sweets[]" value="カラメル"> カラメル</label>
<label><input type="checkbox" name="sweets[]" value="キャラメル"> キャラメル</label>
<label><input type="checkbox" name="sweets[]" value="キャンディ"> キャンディ</label>
<label><input type="checkbox" name="sweets[]" value="ケーキ"> ケーキ</label>
<label><input type="checkbox" name="sweets[]" value="チョコレート"> チョコレート</label>
<label><input type="checkbox" name="sweets[]" value="生クリーム"> 生クリーム</label>
<label><input type="checkbox" name="sweets[]" value="はちみつ"> はちみつ</label>
<label><input type="checkbox" name="sweets[]" value="バニラ"> バニラ</label>
<label><input type="checkbox" name="sweets[]" value="プリン"> プリン</label>
<label><input type="checkbox" name="sweets[]" value="マシュマロ"> マシュマロ</label>
<label><input type="checkbox" name="sweets[]" value="メープルシロップ"> メープルシロップ</label>
<label><input type="checkbox" name="sweets[]" value="モンブラン"> モンブラン</label>
<label><input type="checkbox" name="sweets[]" value="わたあめ"> わたあめ</label>    				
			</div>
			
			<div id="fruit-options1" class="section" data-section="さわやかさ" style="display: none;">
    			<p>フルーツの種類を選んでください:</p>
    		<label><input type="checkbox" name="fruit[]" value="無し"> 無し</label>
  <label><input type="checkbox" name="fruit[]" value="あんず"> あんず</label>
  <label><input type="checkbox" name="fruit[]" value="イチゴ"> イチゴ</label>
  <label><input type="checkbox" name="fruit[]" value="イチジク"> イチジク</label>
  <label><input type="checkbox" name="fruit[]" value="オレンジ"> オレンジ</label>
  <label><input type="checkbox" name="fruit[]" value="カシス"> カシス</label>
  <label><input type="checkbox" name="fruit[]" value="グレープフルーツ"> グレープフルーツ</label>
  <label><input type="checkbox" name="fruit[]" value="ココナッツ"> ココナッツ</label>
  <label><input type="checkbox" name="fruit[]" value="サクランボ"> サクランボ</label>
  <label><input type="checkbox" name="fruit[]" value="サツマイモ"> サツマイモ</label>
  <label><input type="checkbox" name="fruit[]" value="シトラス"> シトラス</label>
  <label><input type="checkbox" name="fruit[]" value="スイカ"> スイカ</label>
  <label><input type="checkbox" name="fruit[]" value="パイナップル"> パイナップル</label>
  <label><input type="checkbox" name="fruit[]" value="ブドウ"> ブドウ</label>
  <label><input type="checkbox" name="fruit[]" value="プラム"> プラム</label>
  <label><input type="checkbox" name="fruit[]" value="ベルガモット"> ベルガモット</label>
  <label><input type="checkbox" name="fruit[]" value="マスカット"> マスカット</label>
  <label><input type="checkbox" name="fruit[]" value="マンゴー"> マンゴー</label>
  <label><input type="checkbox" name="fruit[]" value="マンダリン"> マンダリン</label>
  <label><input type="checkbox" name="fruit[]" value="メロン"> メロン</label>
  <label><input type="checkbox" name="fruit[]" value="モモ"> モモ</label>
  <label><input type="checkbox" name="fruit[]" value="柚子"> 柚子</label>
  <label><input type="checkbox" name="fruit[]" value="ライム"> ライム</label>
  <label><input type="checkbox" name="fruit[]" value="ラズベリー"> ラズベリー</label>
  <label><input type="checkbox" name="fruit[]" value="ラフランス"> ラフランス</label>
  <label><input type="checkbox" name="fruit[]" value="リンゴ"> リンゴ</label>
  <label><input type="checkbox" name="fruit[]" value="レモン"> レモン</label>
			</div>
				
			<div id="drink-options1" class="section" data-section="さわやかさ" style="display: none;">
    			<p>飲み物の種類を選んでください:</p>
    				<label><input type="checkbox" name="drink[]" value="無し"> 無し</label>
					  <label><input type="checkbox" name="drink[]" value="アールグレイ"> アールグレイ</label>
					  <label><input type="checkbox" name="drink[]" value="グリーンティー"> グリーンティー</label>
					  <label><input type="checkbox" name="drink[]" value="コーヒー"> コーヒー</label>
					  <label><input type="checkbox" name="drink[]" value="ブラックティー"> ブラックティー</label>
					  <label><input type="checkbox" name="drink[]" value="ほうじ茶"> ほうじ茶</label>
					  <label><input type="checkbox" name="drink[]" value="ミルク"> ミルク</label>
					  <label><input type="checkbox" name="drink[]" value="ミルクティー"> ミルクティー</label>
			</div>
			
			<div id="spices-options1" class="section" data-section="さわやかさ" style="display: none;">
    			<p>スパイスの種類を選んでください:</p>
  <label><input type="checkbox" name="spices[]" value="無し"> 無し</label>
  <label><input type="checkbox" name="spices[]" value="クローブ"> クローブ</label>
  <label><input type="checkbox" name="spices[]" value="シナモン"> シナモン</label>
  <label><input type="checkbox" name="spices[]" value="ショウガ"> ショウガ</label>
  <label><input type="checkbox" name="spices[]" value="唐辛子"> 唐辛子</label>
  <label><input type="checkbox" name="spices[]" value="ペッパー"> ペッパー</label>
  <label><input type="checkbox" name="spices[]" value="ワサビ"> ワサビ</label>
			</div>
			
			<div id="scene-options1" class="section" data-section="さわやかさ" style="display: none;">
    			<p>シーンの種類を選んでください:</p>
  <label><input type="checkbox" name="scene[]" value="無し"> 無し</label>
  <label><input type="checkbox" name="scene[]" value="オゾンノート"> オゾンノート</label>
  <label><input type="checkbox" name="scene[]" value="シーソルト"> シーソルト</label>
  <label><input type="checkbox" name="scene[]" value="石鹸"> 石鹸</label>
  <label><input type="checkbox" name="scene[]" value="ソファ"> ソファ</label>
  <label><input type="checkbox" name="scene[]" value="太陽"> 太陽</label>
  <label><input type="checkbox" name="scene[]" value="畳"> 畳</label>
  <label><input type="checkbox" name="scene[]" value="ムスク"> ムスク</label>
  <label><input type="checkbox" name="scene[]" value="海"> 海</label>
  <label><input type="checkbox" name="scene[]" value="映画館"> 映画館</label>
  <label><input type="checkbox" name="scene[]" value="カフェ"> カフェ</label>
  <label><input type="checkbox" name="scene[]" value="サウナ"> サウナ</label>
  <label><input type="checkbox" name="scene[]" value="森林"> 森林</label>
  <label><input type="checkbox" name="scene[]" value="茶室"> 茶室</label>
  <label><input type="checkbox" name="scene[]" value="ディズニー"> ディズニー</label>
  <label><input type="checkbox" name="scene[]" value="寺"> 寺</label>
  <label><input type="checkbox" name="scene[]" value="庭"> 庭</label>
  <label><input type="checkbox" name="scene[]" value="ビーチ"> ビーチ</label>
  <label><input type="checkbox" name="scene[]" value="美容室"> 美容室</label>
  <label><input type="checkbox" name="scene[]" value="プール"> プール</label>
  <label><input type="checkbox" name="scene[]" value="風呂"> 風呂</label>
  <label><input type="checkbox" name="scene[]" value="ベッドルーム"> ベッドルーム</label>
  <label><input type="checkbox" name="scene[]" value="ホテル"> ホテル</label>
  <label><input type="checkbox" name="scene[]" value="山"> 山</label>
  <label><input type="checkbox" name="scene[]" value="旅館"> 旅館</label>
  <label><input type="checkbox" name="scene[]" value="春"> 春</label>
  <label><input type="checkbox" name="scene[]" value="夏"> 夏</label>
  <label><input type="checkbox" name="scene[]" value="秋"> 秋</label>
  <label><input type="checkbox" name="scene[]" value="冬"> 冬</label>    				
			</div>
			
			<div id="plant-options1" class="section" data-section="さわやかさ" style="display: none;">
    			<p>植物の種類を選んでください:</p>
  <label><input type="checkbox" name="plant[]" value="無し"> 無し</label>
  <label><input type="checkbox" name="plant[]" value="アーモンド"> アーモンド</label>
  <label><input type="checkbox" name="plant[]" value="イランイラン"> イランイラン</label>
  <label><input type="checkbox" name="plant[]" value="ウッド"> ウッド</label>
  <label><input type="checkbox" name="plant[]" value="カモミール"> カモミール</label>
  <label><input type="checkbox" name="plant[]" value="キンモクセイ"> キンモクセイ</label>
  <label><input type="checkbox" name="plant[]" value="ジャスミン"> ジャスミン</label>
  <label><input type="checkbox" name="plant[]" value="スズラン"> スズラン</label>
  <label><input type="checkbox" name="plant[]" value="ネロリ"> ネロリ</label>
  <label><input type="checkbox" name="plant[]" value="バジル"> バジル</label>
  <label><input type="checkbox" name="plant[]" value="ヒノキ"> ヒノキ</label>
  <label><input type="checkbox" name="plant[]" value="白檀(サンダルウッド)"> 白檀(サンダルウッド)</label>
  <label><input type="checkbox" name="plant[]" value="マリーゴールド"> マリーゴールド</label>
  <label><input type="checkbox" name="plant[]" value="ミモザ"> ミモザ</label>
  <label><input type="checkbox" name="plant[]" value="ミント"> ミント</label>
  <label><input type="checkbox" name="plant[]" value="ユーカリ"> ユーカリ</label>
  <label><input type="checkbox" name="plant[]" value="ラベンダー"> ラベンダー</label>
  <label><input type="checkbox" name="plant[]" value="ローズ"> ローズ</label>
  <label><input type="checkbox" name="plant[]" value="ローズマリー"> ローズマリー</label>
			</div>
      	<br>
      	<input type="submit" name="decision" value="決定">
      	<input type="reset" name="reset" value="リセット">
		<hr>
		</div>
		</form>
		
      	<form id="myFormSpicy" method="POST" action="/B3/RegistImageServlet">
      	<div  class="section" data-section="スパイシー">
      	<p class="group-label">スパイシー</p>
      			<label for="genre_spicy">ジャンル</label>
				<select name="genre" id="genre_spicy">
    				<option data-display="選択して下さい" value="">選択して下さい</option>
    				<option value="スイーツ2">スイーツ</option>
    				<option value="果物2">果物</option>
    				<option value="飲み物2">飲み物</option>
    				<option value="スパイス2">スパイス</option>
    				<option value="シーン2">シーン</option>
    				<option value="植物2">植物</option>
				</select>
			
			<div id="sweets-options2" class="section" data-section="スパイシー" style="display: none;">
    			<p>スイーツの種類を選んでください:</p>
    				<label><input type="checkbox" name="sweets[]" value="無し"> 無し</label>
<label><input type="checkbox" name="sweets[]" value="あんこ"> あんこ</label>
<label><input type="checkbox" name="sweets[]" value="カスタード"> カスタード</label>
<label><input type="checkbox" name="sweets[]" value="カラメル"> カラメル</label>
<label><input type="checkbox" name="sweets[]" value="キャラメル"> キャラメル</label>
<label><input type="checkbox" name="sweets[]" value="キャンディ"> キャンディ</label>
<label><input type="checkbox" name="sweets[]" value="ケーキ"> ケーキ</label>
<label><input type="checkbox" name="sweets[]" value="チョコレート"> チョコレート</label>
<label><input type="checkbox" name="sweets[]" value="生クリーム"> 生クリーム</label>
<label><input type="checkbox" name="sweets[]" value="はちみつ"> はちみつ</label>
<label><input type="checkbox" name="sweets[]" value="バニラ"> バニラ</label>
<label><input type="checkbox" name="sweets[]" value="プリン"> プリン</label>
<label><input type="checkbox" name="sweets[]" value="マシュマロ"> マシュマロ</label>
<label><input type="checkbox" name="sweets[]" value="メープルシロップ"> メープルシロップ</label>
<label><input type="checkbox" name="sweets[]" value="モンブラン"> モンブラン</label>
<label><input type="checkbox" name="sweets[]" value="わたあめ"> わたあめ</label>
			</div>
			
			<div id="fruit-options2" class="section" data-section="スパイシー" style="display: none;">
    			<p>フルーツの種類を選んでください:</p>
    				<label><input type="checkbox" name="fruit[]" value="無し"> 無し</label>
  <label><input type="checkbox" name="fruit[]" value="あんず"> あんず</label>
  <label><input type="checkbox" name="fruit[]" value="イチゴ"> イチゴ</label>
  <label><input type="checkbox" name="fruit[]" value="イチジク"> イチジク</label>
  <label><input type="checkbox" name="fruit[]" value="オレンジ"> オレンジ</label>
  <label><input type="checkbox" name="fruit[]" value="カシス"> カシス</label>
  <label><input type="checkbox" name="fruit[]" value="グレープフルーツ"> グレープフルーツ</label>
  <label><input type="checkbox" name="fruit[]" value="ココナッツ"> ココナッツ</label>
  <label><input type="checkbox" name="fruit[]" value="サクランボ"> サクランボ</label>
  <label><input type="checkbox" name="fruit[]" value="サツマイモ"> サツマイモ</label>
  <label><input type="checkbox" name="fruit[]" value="シトラス"> シトラス</label>
  <label><input type="checkbox" name="fruit[]" value="スイカ"> スイカ</label>
  <label><input type="checkbox" name="fruit[]" value="パイナップル"> パイナップル</label>
  <label><input type="checkbox" name="fruit[]" value="ブドウ"> ブドウ</label>
  <label><input type="checkbox" name="fruit[]" value="プラム"> プラム</label>
  <label><input type="checkbox" name="fruit[]" value="ベルガモット"> ベルガモット</label>
  <label><input type="checkbox" name="fruit[]" value="マスカット"> マスカット</label>
  <label><input type="checkbox" name="fruit[]" value="マンゴー"> マンゴー</label>
  <label><input type="checkbox" name="fruit[]" value="マンダリン"> マンダリン</label>
  <label><input type="checkbox" name="fruit[]" value="メロン"> メロン</label>
  <label><input type="checkbox" name="fruit[]" value="モモ"> モモ</label>
  <label><input type="checkbox" name="fruit[]" value="柚子"> 柚子</label>
  <label><input type="checkbox" name="fruit[]" value="ライム"> ライム</label>
  <label><input type="checkbox" name="fruit[]" value="ラズベリー"> ラズベリー</label>
  <label><input type="checkbox" name="fruit[]" value="ラフランス"> ラフランス</label>
  <label><input type="checkbox" name="fruit[]" value="リンゴ"> リンゴ</label>
  <label><input type="checkbox" name="fruit[]" value="レモン"> レモン</label>
			</div>
				
			<div id="drink-options2"  class="section" data-section="スパイシー" style="display: none;">
    			<p>飲み物の種類を選んでください:</p>
<label><input type="checkbox" name="drink[]" value="無し"> 無し</label>
  <label><input type="checkbox" name="drink[]" value="アールグレイ"> アールグレイ</label>
  <label><input type="checkbox" name="drink[]" value="グリーンティー"> グリーンティー</label>
  <label><input type="checkbox" name="drink[]" value="コーヒー"> コーヒー</label>
  <label><input type="checkbox" name="drink[]" value="ブラックティー"> ブラックティー</label>
  <label><input type="checkbox" name="drink[]" value="ほうじ茶"> ほうじ茶</label>
  <label><input type="checkbox" name="drink[]" value="ミルク"> ミルク</label>
  <label><input type="checkbox" name="drink[]" value="ミルクティー"> ミルクティー</label>    				
			</div>
			
			<div id="spices-options2"  class="section" data-section="スパイシー" style="display: none;">
    			<p>スパイスの種類を選んでください:</p>
  <label><input type="checkbox" name="spices[]" value="無し"> 無し</label>
  <label><input type="checkbox" name="spices[]" value="クローブ"> クローブ</label>
  <label><input type="checkbox" name="spices[]" value="シナモン"> シナモン</label>
  <label><input type="checkbox" name="spices[]" value="ショウガ"> ショウガ</label>
  <label><input type="checkbox" name="spices[]" value="唐辛子"> 唐辛子</label>
  <label><input type="checkbox" name="spices[]" value="ペッパー"> ペッパー</label>
  <label><input type="checkbox" name="spices[]" value="ワサビ"> ワサビ</label>    				
			</div>
			
			<div id="scene-options2"  class="section" data-section="スパイシー" style="display: none;">
    			<p>シーンの種類を選んでください:</p>
  <label><input type="checkbox" name="scene[]" value="無し"> 無し</label>
  <label><input type="checkbox" name="scene[]" value="オゾンノート"> オゾンノート</label>
  <label><input type="checkbox" name="scene[]" value="シーソルト"> シーソルト</label>
  <label><input type="checkbox" name="scene[]" value="石鹸"> 石鹸</label>
  <label><input type="checkbox" name="scene[]" value="ソファ"> ソファ</label>
  <label><input type="checkbox" name="scene[]" value="太陽"> 太陽</label>
  <label><input type="checkbox" name="scene[]" value="畳"> 畳</label>
  <label><input type="checkbox" name="scene[]" value="ムスク"> ムスク</label>
  <label><input type="checkbox" name="scene[]" value="海"> 海</label>
  <label><input type="checkbox" name="scene[]" value="映画館"> 映画館</label>
  <label><input type="checkbox" name="scene[]" value="カフェ"> カフェ</label>
  <label><input type="checkbox" name="scene[]" value="サウナ"> サウナ</label>
  <label><input type="checkbox" name="scene[]" value="森林"> 森林</label>
  <label><input type="checkbox" name="scene[]" value="茶室"> 茶室</label>
  <label><input type="checkbox" name="scene[]" value="ディズニー"> ディズニー</label>
  <label><input type="checkbox" name="scene[]" value="寺"> 寺</label>
  <label><input type="checkbox" name="scene[]" value="庭"> 庭</label>
  <label><input type="checkbox" name="scene[]" value="ビーチ"> ビーチ</label>
  <label><input type="checkbox" name="scene[]" value="美容室"> 美容室</label>
  <label><input type="checkbox" name="scene[]" value="プール"> プール</label>
  <label><input type="checkbox" name="scene[]" value="風呂"> 風呂</label>
  <label><input type="checkbox" name="scene[]" value="ベッドルーム"> ベッドルーム</label>
  <label><input type="checkbox" name="scene[]" value="ホテル"> ホテル</label>
  <label><input type="checkbox" name="scene[]" value="山"> 山</label>
  <label><input type="checkbox" name="scene[]" value="旅館"> 旅館</label>
  <label><input type="checkbox" name="scene[]" value="春"> 春</label>
  <label><input type="checkbox" name="scene[]" value="夏"> 夏</label>
  <label><input type="checkbox" name="scene[]" value="秋"> 秋</label>
  <label><input type="checkbox" name="scene[]" value="冬"> 冬</label>    				
			</div>
			
			<div id="plant-options2"  class="section" data-section="スパイシー" style="display: none;">
    			<p>植物の種類を選んでください:</p>
  <label><input type="checkbox" name="plant[]" value="無し"> 無し</label>
  <label><input type="checkbox" name="plant[]" value="アーモンド"> アーモンド</label>
  <label><input type="checkbox" name="plant[]" value="イランイラン"> イランイラン</label>
  <label><input type="checkbox" name="plant[]" value="ウッド"> ウッド</label>
  <label><input type="checkbox" name="plant[]" value="カモミール"> カモミール</label>
  <label><input type="checkbox" name="plant[]" value="キンモクセイ"> キンモクセイ</label>
  <label><input type="checkbox" name="plant[]" value="ジャスミン"> ジャスミン</label>
  <label><input type="checkbox" name="plant[]" value="スズラン"> スズラン</label>
  <label><input type="checkbox" name="plant[]" value="ネロリ"> ネロリ</label>
  <label><input type="checkbox" name="plant[]" value="バジル"> バジル</label>
  <label><input type="checkbox" name="plant[]" value="ヒノキ"> ヒノキ</label>
  <label><input type="checkbox" name="plant[]" value="白檀(サンダルウッド)"> 白檀(サンダルウッド)</label>
  <label><input type="checkbox" name="plant[]" value="マリーゴールド"> マリーゴールド</label>
  <label><input type="checkbox" name="plant[]" value="ミモザ"> ミモザ</label>
  <label><input type="checkbox" name="plant[]" value="ミント"> ミント</label>
  <label><input type="checkbox" name="plant[]" value="ユーカリ"> ユーカリ</label>
  <label><input type="checkbox" name="plant[]" value="ラベンダー"> ラベンダー</label>
  <label><input type="checkbox" name="plant[]" value="ローズ"> ローズ</label>
  <label><input type="checkbox" name="plant[]" value="ローズマリー"> ローズマリー</label>
			</div>
      	<br>
      	<input type="submit" name="decision" value="決定">
      	<input type="reset" name="reset" value="リセット">
		<hr>
		</div>
		</form>
      	
      	
<form id="myFormRelax" method="POST" action="/B3/RegistImageServlet">
<div  class="section" data-section="リラックス">
<p class="group-label">リラックス</p>
				<label for="genre_relax">ジャンル</label>
				<select name="genre" id="genre_relax">
    				<option data-display="選択して下さい" value="">選択して下さい</option>
    				<option value="スイーツ3">スイーツ</option>
    				<option value="果物3">果物</option>
    				<option value="飲み物3">飲み物</option>
    				<option value="スパイス3">スパイス</option>
    				<option value="シーン3">シーン</option>
    				<option value="植物3">植物</option>
				</select>
			
			<div id="sweets-options3" class="section" data-section="リラックス" style="display: none;">
    			<p>スイーツの種類を選んでください:</p>
    				<label><input type="checkbox" name="sweets[]" value="無し"> 無し</label>
<label><input type="checkbox" name="sweets[]" value="あんこ"> あんこ</label>
<label><input type="checkbox" name="sweets[]" value="カスタード"> カスタード</label>
<label><input type="checkbox" name="sweets[]" value="カラメル"> カラメル</label>
<label><input type="checkbox" name="sweets[]" value="キャラメル"> キャラメル</label>
<label><input type="checkbox" name="sweets[]" value="キャンディ"> キャンディ</label>
<label><input type="checkbox" name="sweets[]" value="ケーキ"> ケーキ</label>
<label><input type="checkbox" name="sweets[]" value="チョコレート"> チョコレート</label>
<label><input type="checkbox" name="sweets[]" value="生クリーム"> 生クリーム</label>
<label><input type="checkbox" name="sweets[]" value="はちみつ"> はちみつ</label>
<label><input type="checkbox" name="sweets[]" value="バニラ"> バニラ</label>
<label><input type="checkbox" name="sweets[]" value="プリン"> プリン</label>
<label><input type="checkbox" name="sweets[]" value="マシュマロ"> マシュマロ</label>
<label><input type="checkbox" name="sweets[]" value="メープルシロップ"> メープルシロップ</label>
<label><input type="checkbox" name="sweets[]" value="モンブラン"> モンブラン</label>
<label><input type="checkbox" name="sweets[]" value="わたあめ"> わたあめ</label>
			</div>
			
			<div id="fruit-options3" class="section" data-section="リラックス" style="display: none;">
    			<p>フルーツの種類を選んでください:</p>
    				<label><input type="checkbox" name="fruit[]" value="無し"> 無し</label>
  <label><input type="checkbox" name="fruit[]" value="あんず"> あんず</label>
  <label><input type="checkbox" name="fruit[]" value="イチゴ"> イチゴ</label>
  <label><input type="checkbox" name="fruit[]" value="イチジク"> イチジク</label>
  <label><input type="checkbox" name="fruit[]" value="オレンジ"> オレンジ</label>
  <label><input type="checkbox" name="fruit[]" value="カシス"> カシス</label>
  <label><input type="checkbox" name="fruit[]" value="グレープフルーツ"> グレープフルーツ</label>
  <label><input type="checkbox" name="fruit[]" value="ココナッツ"> ココナッツ</label>
  <label><input type="checkbox" name="fruit[]" value="サクランボ"> サクランボ</label>
  <label><input type="checkbox" name="fruit[]" value="サツマイモ"> サツマイモ</label>
  <label><input type="checkbox" name="fruit[]" value="シトラス"> シトラス</label>
  <label><input type="checkbox" name="fruit[]" value="スイカ"> スイカ</label>
  <label><input type="checkbox" name="fruit[]" value="パイナップル"> パイナップル</label>
  <label><input type="checkbox" name="fruit[]" value="ブドウ"> ブドウ</label>
  <label><input type="checkbox" name="fruit[]" value="プラム"> プラム</label>
  <label><input type="checkbox" name="fruit[]" value="ベルガモット"> ベルガモット</label>
  <label><input type="checkbox" name="fruit[]" value="マスカット"> マスカット</label>
  <label><input type="checkbox" name="fruit[]" value="マンゴー"> マンゴー</label>
  <label><input type="checkbox" name="fruit[]" value="マンダリン"> マンダリン</label>
  <label><input type="checkbox" name="fruit[]" value="メロン"> メロン</label>
  <label><input type="checkbox" name="fruit[]" value="モモ"> モモ</label>
  <label><input type="checkbox" name="fruit[]" value="柚子"> 柚子</label>
  <label><input type="checkbox" name="fruit[]" value="ライム"> ライム</label>
  <label><input type="checkbox" name="fruit[]" value="ラズベリー"> ラズベリー</label>
  <label><input type="checkbox" name="fruit[]" value="ラフランス"> ラフランス</label>
  <label><input type="checkbox" name="fruit[]" value="リンゴ"> リンゴ</label>
  <label><input type="checkbox" name="fruit[]" value="レモン"> レモン</label>
			</div>
				
			<div id="drink-options3" class="section" data-section="リラックス" style="display: none;">
    			<p>飲み物の種類を選んでください:</p>
<label><input type="checkbox" name="drink[]" value="無し"> 無し</label>
  <label><input type="checkbox" name="drink[]" value="アールグレイ"> アールグレイ</label>
  <label><input type="checkbox" name="drink[]" value="グリーンティー"> グリーンティー</label>
  <label><input type="checkbox" name="drink[]" value="コーヒー"> コーヒー</label>
  <label><input type="checkbox" name="drink[]" value="ブラックティー"> ブラックティー</label>
  <label><input type="checkbox" name="drink[]" value="ほうじ茶"> ほうじ茶</label>
  <label><input type="checkbox" name="drink[]" value="ミルク"> ミルク</label>
  <label><input type="checkbox" name="drink[]" value="ミルクティー"> ミルクティー</label>   				
			</div>
			
			<div id="spices-options3" class="section" data-section="さわやかさ" style="display: none;">
    			<p>スパイスの種類を選んでください:</p>
  <label><input type="checkbox" name="spices[]" value="無し"> 無し</label>
  <label><input type="checkbox" name="spices[]" value="クローブ"> クローブ</label>
  <label><input type="checkbox" name="spices[]" value="シナモン"> シナモン</label>
  <label><input type="checkbox" name="spices[]" value="ショウガ"> ショウガ</label>
  <label><input type="checkbox" name="spices[]" value="唐辛子"> 唐辛子</label>
  <label><input type="checkbox" name="spices[]" value="ペッパー"> ペッパー</label>
  <label><input type="checkbox" name="spices[]" value="ワサビ"> ワサビ</label>    				
			</div>
			
			<div id="scene-options3" class="section" data-section="リラックス" style="display: none;">
    			<p>シーンの種類を選んでください:</p>
  <label><input type="checkbox" name="scene[]" value="無し"> 無し</label>
  <label><input type="checkbox" name="scene[]" value="オゾンノート"> オゾンノート</label>
  <label><input type="checkbox" name="scene[]" value="シーソルト"> シーソルト</label>
  <label><input type="checkbox" name="scene[]" value="石鹸"> 石鹸</label>
  <label><input type="checkbox" name="scene[]" value="ソファ"> ソファ</label>
  <label><input type="checkbox" name="scene[]" value="太陽"> 太陽</label>
  <label><input type="checkbox" name="scene[]" value="畳"> 畳</label>
  <label><input type="checkbox" name="scene[]" value="ムスク"> ムスク</label>
  <label><input type="checkbox" name="scene[]" value="海"> 海</label>
  <label><input type="checkbox" name="scene[]" value="映画館"> 映画館</label>
  <label><input type="checkbox" name="scene[]" value="カフェ"> カフェ</label>
  <label><input type="checkbox" name="scene[]" value="サウナ"> サウナ</label>
  <label><input type="checkbox" name="scene[]" value="森林"> 森林</label>
  <label><input type="checkbox" name="scene[]" value="茶室"> 茶室</label>
  <label><input type="checkbox" name="scene[]" value="ディズニー"> ディズニー</label>
  <label><input type="checkbox" name="scene[]" value="寺"> 寺</label>
  <label><input type="checkbox" name="scene[]" value="庭"> 庭</label>
  <label><input type="checkbox" name="scene[]" value="ビーチ"> ビーチ</label>
  <label><input type="checkbox" name="scene[]" value="美容室"> 美容室</label>
  <label><input type="checkbox" name="scene[]" value="プール"> プール</label>
  <label><input type="checkbox" name="scene[]" value="風呂"> 風呂</label>
  <label><input type="checkbox" name="scene[]" value="ベッドルーム"> ベッドルーム</label>
  <label><input type="checkbox" name="scene[]" value="ホテル"> ホテル</label>
  <label><input type="checkbox" name="scene[]" value="山"> 山</label>
  <label><input type="checkbox" name="scene[]" value="旅館"> 旅館</label>
  <label><input type="checkbox" name="scene[]" value="春"> 春</label>
  <label><input type="checkbox" name="scene[]" value="夏"> 夏</label>
  <label><input type="checkbox" name="scene[]" value="秋"> 秋</label>
  <label><input type="checkbox" name="scene[]" value="冬"> 冬</label>   				
			</div>
			
			<div id="plant-options3" class="section" data-section="リラックス" style="display: none;">
    			<p>植物の種類を選んでください:</p>
  <label><input type="checkbox" name="plant[]" value="無し"> 無し</label>
  <label><input type="checkbox" name="plant[]" value="アーモンド"> アーモンド</label>
  <label><input type="checkbox" name="plant[]" value="イランイラン"> イランイラン</label>
  <label><input type="checkbox" name="plant[]" value="ウッド"> ウッド</label>
  <label><input type="checkbox" name="plant[]" value="カモミール"> カモミール</label>
  <label><input type="checkbox" name="plant[]" value="キンモクセイ"> キンモクセイ</label>
  <label><input type="checkbox" name="plant[]" value="ジャスミン"> ジャスミン</label>
  <label><input type="checkbox" name="plant[]" value="スズラン"> スズラン</label>
  <label><input type="checkbox" name="plant[]" value="ネロリ"> ネロリ</label>
  <label><input type="checkbox" name="plant[]" value="バジル"> バジル</label>
  <label><input type="checkbox" name="plant[]" value="ヒノキ"> ヒノキ</label>
  <label><input type="checkbox" name="plant[]" value="白檀(サンダルウッド)"> 白檀(サンダルウッド)</label>
  <label><input type="checkbox" name="plant[]" value="マリーゴールド"> マリーゴールド</label>
  <label><input type="checkbox" name="plant[]" value="ミモザ"> ミモザ</label>
  <label><input type="checkbox" name="plant[]" value="ミント"> ミント</label>
  <label><input type="checkbox" name="plant[]" value="ユーカリ"> ユーカリ</label>
  <label><input type="checkbox" name="plant[]" value="ラベンダー"> ラベンダー</label>
  <label><input type="checkbox" name="plant[]" value="ローズ"> ローズ</label>
  <label><input type="checkbox" name="plant[]" value="ローズマリー"> ローズマリー</label>
			</div>
      	<br>
      	<input type="submit" name="decision" value="決定">
      	<input type="reset" name="reset" value="リセット">
      	<hr>
      	</div>
</form>
      
      	
      	<br>
      	<br>


<div id="summary-section">
  <h3>登録済みのタグ</h3>
  <ul id="summary-list"></ul>
</div>

<ul class="selected-list"></ul>
<input type="submit"  name="submit" value="登録">
<span id="error_message"></span>

<script>
document.addEventListener('DOMContentLoaded', function () {
	  // 共通の選択結果表示用リスト
	  let summaryList = document.createElement('ul');
	  summaryList.id = 'summary-list';
	  document.body.appendChild(summaryList); // 画面下部など適切な場所に配置

	  // 各フォームの設定
	  const formSettings = [
	    {
	      formId: 'myForm',
	      selectId: 'genre',
	      options: {
	        'スイーツ': 'sweets-options',
	        '果物': 'fruit-options',
	        '飲み物': 'drink-options',
	        'スパイス': 'spices-options',
	        'シーン': 'scene-options',
	        '植物': 'plant-options'
	      }
	    },
	    {
	      formId: 'myFormFresh',
	      selectId: 'genre_fresh',
	      options: {
	        'スイーツ1': 'sweets-options1',
	        '果物1': 'fruit-options1',
	        '飲み物1': 'drink-options1',
	        'スパイス1': 'spices-options1',
	        'シーン1': 'scene-options1',
	        '植物1': 'plant-options1'
	      }
	    },
	    {
	      formId: 'myFormSpicy',
	      selectId: 'genre_spicy',
	      options: {
	        'スイーツ2': 'sweets-options2',
	        '果物2': 'fruit-options2',
	        '飲み物2': 'drink-options2',
	        'スパイス2': 'spices-options2',
	        'シーン2': 'scene-options2',
	        '植物2': 'plant-options2'
	      }
	    },
	    {
	      formId: 'myFormRelax',
	      selectId: 'genre_relax',
	      options: {
	        'スイーツ3': 'sweets-options3',
	        '果物3': 'fruit-options3',
	        '飲み物3': 'drink-options3',
	        'スパイス3': 'spices-options3',
	        'シーン3': 'scene-options3',
	        '植物3': 'plant-options3'
	      }
	    }
	  ];

	  formSettings.forEach(({ formId, selectId, options }) => {
	    const form = document.getElementById(formId);
	    const genreSelect = document.getElementById(selectId);

	    // プルダウン変更時：該当カテゴリ表示
	    genreSelect.addEventListener('change', function () {
	      Object.values(options).forEach(id => {
	        const section = form.querySelector('#' + id);
	        if (section) section.style.display = 'none';
	      });

	      const selectedId = options[this.value];
	      if (selectedId) {
	        const section = form.querySelector('#' + selectedId);
	        if (section) section.style.display = 'block';
	      }
	    });

	    // 送信時：全体のリストに追加
	    form.addEventListener('submit', function (e) {
	      e.preventDefault();
	      let hasSelected = false;

	      Object.values(options).forEach(id => {
	        const section = form.querySelector('#' + id);
	        if (!section) return;

	        const label = section.getAttribute('data-section') || '';
	        const checkboxes = section.querySelectorAll('input[type="checkbox"]:checked');
	        checkboxes.forEach(cb => {
	          if (cb.value === '無し') return;
	          hasSelected = true;

	          const li = document.createElement('li');
	          //li.textContent = `${label} × ${cb.value}`;
	          li.textContent = label + "x" + cb.value;
	          summaryList.appendChild(li);
	        });
	      });

	      if (!hasSelected) {
	        const li = document.createElement('li');
	        li.textContent = '何も選択されていません。';
	        summaryList.appendChild(li);
	      }
	    });

	    // リセット時：選択肢非表示とセレクトボックス初期化
	    const resetBtn = form.querySelector('input[type="reset"]');
	    resetBtn.addEventListener('click', () => {
	      genreSelect.value = '';
	      Object.values(options).forEach(id => {
	        const section = form.querySelector('#' + id);
	        if (section) section.style.display = 'none';
	      });
	    });
	  });
	});
	
const resetBtn = document.getElementById('resetBtn');
const summaryList = document.getElementById('summary-list');

resetBtn.addEventListener('click', () => {
  // summary-listの中身を空にする
  summaryList.innerHTML = '';
});
</script>
</body>
</html>
