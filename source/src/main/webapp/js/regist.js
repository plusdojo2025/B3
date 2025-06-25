// 画像プレビュー関数
function previewImage(obj) {
  const fileReader = new FileReader();

  fileReader.onload = function () {
    const canvas = document.getElementById('preview');
    const ctx = canvas.getContext('2d');
    const image = new Image();
    image.src = fileReader.result;

    image.onload = function () {
      canvas.width = image.width;
      canvas.height = image.height;
      ctx.drawImage(image, 0, 0);
    };
  };

  if (obj.files && obj.files[0]) {
    fileReader.readAsDataURL(obj.files[0]);
  }
}

// お気に入りハートのクリック処理
document.addEventListener('DOMContentLoaded', function () {
  const heart = document.getElementById("heart");
  const favouriteInput = document.createElement("input");
  favouriteInput.type = "hidden";
  favouriteInput.name = "favourite";
  favouriteInput.value = "false";
  heart.parentNode.appendChild(favouriteInput);

  heart.addEventListener("click", () => {
    heart.classList.toggle("active");
    favouriteInput.value = heart.classList.contains("active") ? "true" : "false";
  });

  // 登録バリデーション関連のコードは削除しました
});