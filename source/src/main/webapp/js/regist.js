/**
 * 
 */
  function previewImage(obj){

		var fileReader = new FileReader();

		// 読み込み後に実行する処理
		fileReader.onload = (function() {

			// canvas にプレビュー画像を表示
			var canvas = document.getElementById('preview');
			var ctx = canvas.getContext('2d');
			var image = new Image();
			image.src = fileReader.result;
			console.log(fileReader.result) // ← (確認用)

			image.onload = (function () {
				canvas.width = image.width;
				canvas.height = image.height;
				ctx.drawImage(image, 0, 0);
			});
		});
		// 画像読み込み
		fileReader.readAsDataURL(obj.files[0]);
		console.log(fileReader.result) // ← (確認用)null
	}
  
  
    const heart = document.getElementById("heart");
    heart.addEventListener("click", () => {
      heart.classList.toggle("active");
      
      const submitBtn = document.querySelector('input[type="submit"]'); // 登録ボタン
  const productNameInput = document.getElementById('productName');  // 香水名入力欄
  const productNameError = document.getElementById('productNameError'); // エラー表示欄

  submitBtn.addEventListener('click', function (e) {
    productNameError.textContent = ''; // 前のエラーを消す

    if (!productNameInput.value.trim()) {
      e.preventDefault(); // 登録中止
      productNameError.textContent = '香水名を入力してください';
    }
  });


document.getElementById('registerForm').addEventListener('submit', function(event) {
      event.preventDefault(); // ページの再読み込みを防ぐ

      // 登録処理（ここに本来のAPI呼び出しなどを追加）
      alert('登録が成功しました');

      // ホーム画面に遷移（例えば home.html に移動）
      window.location.href = 'home.html';
    });
});
    
    