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
import javax.servlet.http.HttpSession;

@WebServlet("/ChartServlet")
public class ChartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        // ログインチェック
//        HttpSession session = request.getSession(false);
//        if (session == null || session.getAttribute("id") == null) {
//            response.sendRedirect(request.getContextPath() + "/LoginServlet");
//            return;
//        }

        // データ格納リスト
        List<String> labels = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        Map<String, Double> radarData = new LinkedHashMap<>();
        List<String> barLabels = new ArrayList<>();
        List<Integer> barCounts = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/b3?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9";
        String user = "root";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            // 円グラフ：香水使用回数
            try (
                PreparedStatement stmt = conn.prepareStatement(
                    "SELECT p.name AS perfume_name, COUNT(*) AS count " +
                    "FROM perfume_log pl JOIN perfumes p ON pl.perfume_id = p.id " +
                    "GROUP BY p.name"
                );
                ResultSet rs = stmt.executeQuery()
            ) {
                while (rs.next()) {
                    labels.add(rs.getString("perfume_name"));
                    counts.add(rs.getInt("count"));
                }
            }

            // レーダーチャート：全体平均
            try (
                PreparedStatement stmt = conn.prepareStatement(
                    "SELECT " +
                    "AVG(simple_complex) AS simple_complex_avg, " +
                    "AVG(fresh_sweet) AS fresh_sweet_avg, " +
                    "AVG(light_heavy) AS light_heavy_avg, " +
                    "AVG(male_women) AS male_women_avg, " +
                    "AVG(mild_spicy) AS mild_spicy_avg " +
                    "FROM perfumes"
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

            // 棒グラフ：よくあるbig_id×small_idの組み合わせ
            try (
                PreparedStatement stmt = conn.prepareStatement(
                    "SELECT b.scent_type, s.detail, COUNT(*) AS cnt " +
                    "FROM perfume_images pi " +
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

        request.setAttribute("labels", labels);
        request.setAttribute("counts", counts);
        request.setAttribute("radarData", radarData);
        request.setAttribute("barLabels", barLabels);
        request.setAttribute("barCounts", barCounts);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/chart.jsp");
        dispatcher.forward(request, response);
    }
}