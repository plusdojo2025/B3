<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Parfüm Note | Regist</title>
<link rel="stylesheet" href="/B3/css/list.css">
</head>
<body>
<<<<<<< HEAD
	<header>
		<jsp:include page="/WEB-INF/jsp/header.jsp" />
	</header>
	<main>
		<form>
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
      	
      	<p> *イメージタグ </p>
      	<p id="errormessage"></p>
      	<hr>
      	<br>
      	<p>甘さ</p>
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
			
			<div id="sweets-options" style="display: none;">
    			<p>フルーツの種類を選んでください:</p>
    				<label><input type="checkbox" name="sweets[]" value="無し"> 無し</label><br>
    				<label><input type="checkbox" name="sweets[]" value="あんこ"> あんこ</label><br>
    				<label><input type="checkbox" name="sweets[]" value="カスタード"> カスタード</label><br>
    				<label><input type="checkbox" name="sweets[]" value="カラメル"> カラメル</label><br>
    				<label><input type="checkbox" name="sweets[]" value="キャラメル"> キャラメル</label><br>
    				<label><input type="checkbox" name="sweets[]" value="キャンディ"> キャンディ</label><br>
    				<label><input type="checkbox" name="sweets[]" value="ケーキ"> ケーキ</label><br>
    				<label><input type="checkbox" name="sweets[]" value="チョコレート"> チョコレート</label><br>
    				<label><input type="checkbox" name="sweets[]" value="生クリーム"> 生クリーム</label><br>
    				<label><input type="checkbox" name="sweets[]" value="はちみつ"> はちみつ</label><br>
    				<label><input type="checkbox" name="sweets[]" value="バニラ"> バニラ</label><br>
    				<label><input type="checkbox" name="sweets[]" value="プリン"> プリン</label><br>
    				<label><input type="checkbox" name="sweets[]" value="マシュマロ"> マシュマロル</label><br>
    				<label><input type="checkbox" name="sweets[]" value="メープルシロップ"> メープルシロップ</label><br>
    				<label><input type="checkbox" name="sweets[]" value="モンブラン"> モンブラン</label><br>
    				<label><input type="checkbox" name="sweets[]" value="わたあめ"> わたあめ</label><br>    				
			</div>
			
			<div id="fruit-options" style="display: none;">
    			<p>フルーツの種類を選んでください:</p>
    				<label><input type="checkbox" name="fruit[]" value="無し"> 無し</label><br>
    				<label><input type="checkbox" name="fruit[]" value="あんず"> あんず</label><br>
    				<label><input type="checkbox" name="fruit[]" value="イチゴ"> イチゴ</label><br>
    				<label><input type="checkbox" name="fruit[]" value="イチジク"> イチジク</label><br>
    				<label><input type="checkbox" name="fruit[]" value="オレンジ"> オレンジ</label><br>
    				<label><input type="checkbox" name="fruit[]" value="カシス"> カシス</label><br>
    				<label><input type="checkbox" name="fruit[]" value="グレープフルーツ"> グレープフルーツ</label><br>
    				<label><input type="checkbox" name="fruit[]" value="ココナッツ"> ココナッツ</label><br>
    				<label><input type="checkbox" name="fruit[]" value="サクランボ"> サクランボ</label><br>
    				<label><input type="checkbox" name="fruit[]" value="サツマイモ"> サツマイモ</label><br>
    				<label><input type="checkbox" name="fruit[]" value="シトラス"> シトラス</label><br>
    				<label><input type="checkbox" name="fruit[]" value="スイカ"> スイカ</label><br>
    				<label><input type="checkbox" name="fruit[]" value="パイナップル"> パイナップル</label><br>
    				<label><input type="checkbox" name="fruit[]" value="ブドウ"> ブドウ</label><br>
    				<label><input type="checkbox" name="fruit[]" value="プラム"> プラム</label><br>
    				<label><input type="checkbox" name="fruit[]" value="ベルガモット"> ベルガモット</label><br>
    				<label><input type="checkbox" name="fruit[]" value="マスカット"> マスカット</label><br>
    				<label><input type="checkbox" name="fruit[]" value="マンゴー"> マンゴー</label><br>
    				<label><input type="checkbox" name="fruit[]" value="マンダリン"> マンダリン</label><br>
    				<label><input type="checkbox" name="fruit[]" value="メロン"> メロン</label><br>
    				<label><input type="checkbox" name="fruit[]" value="モモ"> モモ</label><br>
    				<label><input type="checkbox" name="fruit[]" value="柚子"> 柚子</label><br>
    				<label><input type="checkbox" name="fruit[]" value="ライム"> ライム</label><br>
    				<label><input type="checkbox" name="fruit[]" value="ラズベリー"> ラズベリー</label><br>
    				<label><input type="checkbox" name="fruit[]" value="ラフランス"> ラフランス</label><br>
    				<label><input type="checkbox" name="fruit[]" value="リンゴ"> リンゴ</label><br>
    				<label><input type="checkbox" name="fruit[]" value="レモン"> レモン</label><br>
			</div>
				
			<div id="drink-options" style="display: none;">
    			<p>飲み物の種類を選んでください:</p>
    				<label><input type="checkbox" name="drink[]" value="無し"> 無し</label><br>
    				<label><input type="checkbox" name="drink[]" value="アールグレイ"> アールグレイ</label><br>
    				<label><input type="checkbox" name="drink[]" value="グリーンティー"> グリーンティー</label><br>
    				<label><input type="checkbox" name="drink[]" value="コーヒー"> コーヒー</label><br>
    				<label><input type="checkbox" name="drink[]" value="ブラックティー"> ブラックティー</label><br>
    				<label><input type="checkbox" name="drink[]" value="ほうじ茶"> ほうじ茶</label><br>
    				<label><input type="checkbox" name="drink[]" value="ミルク"> ミルク</label><br>
    				<label><input type="checkbox" name="drink[]" value="ミルクティー"> ミルクティー</label><br>
			</div>
			
			<div id="spices-options" style="display: none;">
    			<p>スパイスの種類を選んでください:</p>
    				<label><input type="checkbox" name="spices[]" value="無し"> 無し</label><br>
    				<label><input type="checkbox" name="spices[]" value="クローブ"> クローブ</label><br>
    				<label><input type="checkbox" name="spices[]" value="シナモン"> シナモン</label><br>
    				<label><input type="checkbox" name="spices[]" value="ショウガ"> ショウガ</label><br>
    				<label><input type="checkbox" name="spices[]" value="唐辛子"> 唐辛子</label><br>
    				<label><input type="checkbox" name="spices[]" value="ペッパー"> ペッパー</label><br>
    				<label><input type="checkbox" name="spices[]" value="ワサビ"> ワサビ</label><br>
			</div>
			
			<div id="scene-options" style="display: none;">
    			<p>シーンの種類を選んでください:</p>
    				<label><input type="checkbox" name="scene[]" value="無し"> 無し</label><br>
    				<label><input type="checkbox" name="scene[]" value="オゾンノート"> オゾンノート</label><br>
    				<label><input type="checkbox" name="scene[]" value="シーソルト"> シーソルト</label><br>
    				<label><input type="checkbox" name="scene[]" value="石鹸"> 石鹸</label><br>
    				<label><input type="checkbox" name="scene[]" value="ソファ"> ソファ</label><br>
    				<label><input type="checkbox" name="scene[]" value="太陽"> 太陽</label><br>
    				<label><input type="checkbox" name="scene[]" value="畳"> 畳</label><br>
    				<label><input type="checkbox" name="scene[]" value="ムスク"> ムスク</label><br>
    				<label><input type="checkbox" name="scene[]" value="海"> 海</label><br>
    				<label><input type="checkbox" name="scene[]" value="映画館"> 映画館</label><br>
    				<label><input type="checkbox" name="scene[]" value="カフェ"> カフェ</label><br>
    				<label><input type="checkbox" name="scene[]" value="サウナ"> サウナ</label><br>
    				<label><input type="checkbox" name="scene[]" value="森林"> 森林</label><br>
    				<label><input type="checkbox" name="scene[]" value="茶室"> 茶室</label><br>
    				<label><input type="checkbox" name="scene[]" value="ディズニー"> ディズニー</label><br>
    				<label><input type="checkbox" name="scene[]" value="寺"> 寺</label><br>
    				<label><input type="checkbox" name="scene[]" value="庭"> 庭</label><br>
    				<label><input type="checkbox" name="scene[]" value="ビーチ"> ビーチ</label><br>
    				<label><input type="checkbox" name="scene[]" value="美容室"> 美容室</label><br>
    				<label><input type="checkbox" name="scene[]" value="プール"> プール</label><br>
    				<label><input type="checkbox" name="scene[]" value="風呂"> 風呂</label><br>
    				<label><input type="checkbox" name="scene[]" value="ベッドルーム"> ベッドルーム</label><br>
    				<label><input type="checkbox" name="scene[]" value="ホテル"> ホテル</label><br>
    				<label><input type="checkbox" name="scene[]" value="山"> 山</label><br>
    				<label><input type="checkbox" name="scene[]" value="旅館"> 旅館</label><br>
    				<label><input type="checkbox" name="scene[]" value="春"> 春</label><br>
    				<label><input type="checkbox" name="scene[]" value="夏"> 夏</label><br>
    				<label><input type="checkbox" name="scene[]" value="秋"> 秋</label><br>
    				<label><input type="checkbox" name="scene[]" value="冬"> 冬</label><br>
			</div>
			
			<div id="plant-options" style="display: none;">
    			<p>植物の種類を選んでください:</p>
    				<label><input type="checkbox" name="plant[]" value="無し"> 無し</label><br>
    				<label><input type="checkbox" name="plant[]" value="アーモンド"> アーモンド</label><br>
    				<label><input type="checkbox" name="plant[]" value="イランイラン"> イランイラン</label><br>
    				<label><input type="checkbox" name="plant[]" value="ウッド"> ウッド</label><br>
    				<label><input type="checkbox" name="plant[]" value="カモミール"> カモミール</label><br>
    				<label><input type="checkbox" name="plant[]" value="キンモクセイ"> キンモクセイ</label><br>
    				<label><input type="checkbox" name="plant[]" value="ジャスミン"> ジャスミン</label><br>
    				<label><input type="checkbox" name="plant[]" value="スズラン"> スズラン</label><br>
    				<label><input type="checkbox" name="plant[]" value="ネロリ"> ネロリ</label><br>
    				<label><input type="checkbox" name="plant[]" value="バジル"> バジル</label><br>
    				<label><input type="checkbox" name="plant[]" value="ヒノキ"> ヒノキ</label><br>
    				<label><input type="checkbox" name="plant[]" value="白檀(サンダルウッド)"> 白檀(サンダルウッド)</label><br>
    				<label><input type="checkbox" name="plant[]" value="マリーゴールド"> マリーゴールド</label><br>
    				<label><input type="checkbox" name="plant[]" value="ミモザ"> ミモザ</label><br>
    				<label><input type="checkbox" name="plant[]" value="ミント"> ミント</label><br>
    				<label><input type="checkbox" name="plant[]" value="ユーカリ"> ユーカリ</label><br>
    				<label><input type="checkbox" name="plant[]" value="ラベンダー"> ラベンダー</label><br>
    				<label><input type="checkbox" name="plant[]" value="ローズ"> ローズ</label><br>
    				<label><input type="checkbox" name="plant[]" value="ローズマリー"> ローズマリー</label><br>
			</div>

      	<br>
      	<input type="submit" name="decision" value="決定">
      	<input type="reset" name="reset" value="リセット">
      	<hr>
      	
      	<br>
      	<p>さわやかさ</p>
      	<hr>
      	
      	<br>
      	<p>スパイシー</p>
      	<hr>
      	
      	<br>
      	<p>リラックス</p>
      	<hr>
      	
      	<p>登録済みのタグ</p>
      	<br>
      	<br>
      	
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

<script>
document.addEventListener('DOMContentLoaded', function () {
    const genreSelect = document.getElementById('genre');
    
    const genreMap = {
    	'スイーツ': 'sweets-options',
        '果物': 'fruit-options',
        '飲み物': 'drink-options',
        'スパイス': 'spices-options',
        'シーン': 'scene-options',
        '植物': 'plant-options'
    };
    

    genreSelect.addEventListener('change', function () {
        const selectedGenre = genreSelect.value;

        // すべてのオプションブロックを一旦非表示にする
        Object.values(genreMap).forEach(function (id) {
            document.getElementById(id).style.display = 'none';
        });

        // 選択されたジャンルに対応するブロックだけ表示する
        if (genreMap[selectedGenre]) {
            document.getElementById(genreMap[selectedGenre]).style.display = 'block';
        }
    });
});
</script>
=======
 
>>>>>>> 2441448cdb044ec1722fd7b29ddef4407981674c
</body>
</html>

<style>
.slider-row {
    display: flex;
    align-items: center;
    gap: 10px;
    margin-bottom: 10px; /* スライダーごとの間隔 */
}
</style>
