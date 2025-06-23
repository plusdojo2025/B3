/* HTML要素をオブジェクトとして取得する */
let formObj = document.getElementById('logbefore_form');
let errorMessageObj = document.getElementById('error_message');
let perfumeSelectObj = document.getElementById('perfume_id');
	
	/* [記録]ボタンをクリックしたときの処理 */
	formObj.onsubmit = function() {
		if (perfumeSelectObj.value === "") {
    		errorMessageObj.textContent = '商品名を選択してください';
    		return false;
  		}
  		
  		errorMessageObj.textContent = null;
  	};
