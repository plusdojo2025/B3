package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

@WebServlet("/ChartServlet")
public class ChartServlet extends HttpServlet {
	// ページロード時、doメッソドで処理
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        // ログインチェック（テスト時コメントアウト。直すときは19行目のコメントアウトを同時に解除）
//    		HttpSession session = request.getSession(false);
//      	if (session == null || session.getAttribute("id") == null) {
//          response.sendRedirect(request.getContextPath() + "/LoginServlet");
//          return;
//      	}

        // グラフ用のデータ構造
        List<String> labels = new ArrayList<>();          // 円グラフ用（香水名と使用回数）
        List<Integer> counts = new ArrayList<>();

        Map<String, Double> radarData = new LinkedHashMap<>(); // レーダーチャート用（項目ごとの平均）

        List<String> barLabels = new ArrayList<>();       // 棒グラフ用（香りカテゴリーと詳細）
        List<Integer> barCounts = new ArrayList<>();

        // DB接続
        String url = "jdbc:mysql://localhost:3306/b3?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Tokyo";
        String user = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            // 円グラフ：香水使用回数
        	// perfumesとperfume_logテーブルをjoin
        	// 一時的に Map に詰めてからソート
        	Map<String, Integer> pieMap = new LinkedHashMap<>();
        	try (
        	    PreparedStatement stmt = conn.prepareStatement(
        	        "SELECT p.perfume_name, COUNT(*) AS count " +
        	        "FROM perfume_log pl " +
        	        "JOIN perfumes p ON pl.perfume_id = p.id " +
        	        "GROUP BY p.perfume_name"
        	    );
        	    ResultSet rs = stmt.executeQuery()
        	) {
        	    while (rs.next()) {
        	        pieMap.put(rs.getString("perfume_name"), rs.getInt("count"));
        	    }
        	}

        	// Map を使用回数の降順でソートして labels/counts に入れ直す
        	//　結果をlabelとcountに保存
        	pieMap.entrySet().stream()
        	    .sorted((a, b) -> b.getValue().compareTo(a.getValue())) // 降順ソート
        	    .forEach(entry -> {
        	        labels.add(entry.getKey());
        	        counts.add(entry.getValue());
        	    });

            
            // レーダーチャート：scrollbarから取得
            // scroolbarテーブルから５つの要素の平均値を取得
            //　結果をradarDataに保存
            try (
                PreparedStatement stmt = conn.prepareStatement(
                    "SELECT " +
                    "AVG(simple_complex) AS simple_complex_avg, " +
                    "AVG(fresh_sweet) AS fresh_sweet_avg, " +
                    "AVG(light_heavy) AS light_heavy_avg, " +
                    "AVG(male_women) AS male_women_avg, " +
                    "AVG(mild_spicy) AS mild_spicy_avg " +
                    "FROM scrollbar"
                );
                ResultSet rs = stmt.executeQuery()
            ) {
                if (rs.next()) {
                    radarData.put("Simple-Complex", rs.getDouble("simple_complex_avg"));
                    radarData.put("Fresh-Sweet", rs.getDouble("fresh_sweet_avg"));
                    radarData.put("Light-Heavy", rs.getDouble("light_heavy_avg"));
                    radarData.put("Male-Women", rs.getDouble("male_women_avg"));
                    radarData.put("Mild-Spicy", rs.getDouble("mild_spicy_avg"));
                }
            }

            // 棒グラフ：香りの種類×詳細のTOP5
            // perfume_imagesに関連づいているbig_categoryとsmall_catrgoryをjoinして組み合わせる
            //　組み合わせた香りの種類×詳細のperfume_logの使用回数を取得
            //　使用回数上位5つを取得し、barlabels,barCountsに保存
            try (
	    		PreparedStatement stmt = conn.prepareStatement(
	    			    "SELECT b.scent_type, s.detail, COUNT(pl.id) AS cnt " +
	    			    "FROM perfume_log pl " +
	    			    "JOIN perfumes p ON pl.perfume_id = p.id " +
	    			    "JOIN perfume_images pi ON p.id = pi.perfume_id " +
	    			    "JOIN big_category b ON pi.big_id = b.id " +
	    			    "JOIN small_category s ON pi.small_id = s.id " +
	    			    "GROUP BY b.scent_type, s.detail " +
	    			    "ORDER BY cnt DESC " +
	    			    "LIMIT 5"
	    			);
                ResultSet rs = stmt.executeQuery()
            ) {
                while (rs.next()) {
                    String label = rs.getString("scent_type") + " × " + rs.getString("detail");
                    int count = rs.getInt("cnt");
                    barLabels.add(label);
                    barCounts.add(count);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // データをリクエストスコープを用いて、JSPへ渡す
        request.setAttribute("labels", labels);
        request.setAttribute("counts", counts);
        request.setAttribute("radarData", radarData);
        request.setAttribute("barLabels", barLabels);
        request.setAttribute("barCounts", barCounts);
        
        //　chart.jspにフォワードしてグラフを描画。
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/chart.jsp");
        dispatcher.forward(request, response);
    }
}