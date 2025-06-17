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

  <form id="search_form" method="POST" action="/B5/SearchServlet">
    <label for="name">商品名
      <input type="text" name="name" id="name">
    </label>
    <label for="brand_name">ブランド
      <input type="text" name="brand_name" id="brand_name">
    </label>
    <label for="image_tag">イメージタグ
      <input type="text" name="image_tag" id="image_tag">
    </label>

    <!-- シンプル -->
    <div class="slider-group">
      <label>シンプル:</label>
      <div id="simple_slider"></div>
      <input type="hidden" name="simple_min" id="simple_min">
      <input type="hidden" name="simple_max" id="simple_max">
    </div>

    <!-- フレッシュ -->
    <div class="slider-group">
      <label>フレッシュ:</label>
      <div id="fresh_slider"></div>
      <input type="hidden" name="fresh_min" id="fresh_min">
      <input type="hidden" name="fresh_max" id="fresh_max">
    </div>

    <!-- ライト -->
    <div class="slider-group">
      <label>ライト:</label>
      <div id="light_slider"></div>
      <input type="hidden" name="light_min" id="light_min">
      <input type="hidden" name="light_max" id="light_max">
    </div>

    <!-- メンズ -->
    <div class="slider-group">
      <label>メンズ:</label>
      <div id="mens_slider"></div>
      <input type="hidden" name="mens_min" id="mens_min">
      <input type="hidden" name="mens_max" id="mens_max">
    </div>

    <!-- マイルド -->
    <div class="slider-group">
      <label>マイルド:</label>
      <div id="mild_slider"></div>
      <input type="hidden" name="mild_min" id="mild_min">
      <input type="hidden" name="mild_max" id="mild_max">
    </div>

    <input type="submit" value="検索">
  </form>

  <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.min.js"></script>
  <script>
    function setupSlider(sliderId, minId, maxId, defaultMin, defaultMax) {
      $("#" + sliderId).slider({
        range: true,
        min: 0,
        max: 10,
        values: [defaultMin, defaultMax],
        slide: function (event, ui) {
          $("#" + minId).val(ui.values[0]);
          $("#" + maxId).val(ui.values[1]);
        },
        create: function () {
          $("#" + minId).val($("#" + sliderId).slider("values", 0));
          $("#" + maxId).val($("#" + sliderId).slider("values", 1));
        }
      });
    }

    $(function () {
      setupSlider("simple_slider", "simple_min", "simple_max", 2, 8);
      setupSlider("fresh_slider", "fresh_min", "fresh_max", 3, 9);
      setupSlider("light_slider", "light_min", "light_max", 1, 7);
      setupSlider("mens_slider", "mens_min", "mens_max", 4, 10);
      setupSlider("mild_slider", "mild_min", "mild_max", 0, 6);
    });
  </script>
</body>
</html>