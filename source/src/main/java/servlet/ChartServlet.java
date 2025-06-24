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

@WebServlet("/ChartServlet")
public class ChartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        // ログインチェック（テスト時無効化OK）
//        HttpSession session = request.getSession(false);
//        if (session == null || session.getAttribute("id") == null) {
//            response.sendRedirect(request.getContextPath() + "/LoginServlet");
//            return;
//        }

        List<String> labels = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();
        Map<String, Double> radarData = new LinkedHashMap<>();

        String url = "jdbc:mysql://localhost:3306/b3?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9";
        String user = "root";
        String password = "password";

        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement usageStmt = conn.prepareStatement(
                "SELECT p.name AS perfume_name, COUNT(*) AS count " +
                "FROM perfume_log pl JOIN perfumes p ON pl.perfume_id = p.id " +
                "GROUP BY p.name"
            );
            ResultSet usageRs = usageStmt.executeQuery()
        ) {
            while (usageRs.next()) {
                labels.add(usageRs.getString("perfume_name"));
                counts.add(usageRs.getInt("count"));
            }

            // 平均値の取得
            try (
                PreparedStatement avgStmt = conn.prepareStatement(
                    "SELECT " +
                    "AVG(simple_complex) AS simple_complex_avg, " +
                    "AVG(fresh_sweet) AS fresh_sweet_avg, " +
                    "AVG(light_heavy) AS light_heavy_avg, " +
                    "AVG(male_women) AS male_women_avg, " +
                    "AVG(mild_spicy) AS mild_spicy_avg " +
                    "FROM perfumes"
                );
                ResultSet avgRs = avgStmt.executeQuery()
            ) {
                if (avgRs.next()) {
                    radarData.put("Simple-Complex", avgRs.getDouble("simple_complex_avg"));
                    radarData.put("Fresh-Sweet", avgRs.getDouble("fresh_sweet_avg"));
                    radarData.put("Light-Heavy", avgRs.getDouble("light_heavy_avg"));
                    radarData.put("Male-Women", avgRs.getDouble("male_women_avg"));
                    radarData.put("Mild-Spicy", avgRs.getDouble("mild_spicy_avg"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("labels", labels);
        request.setAttribute("counts", counts);
        request.setAttribute("radarData", radarData);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/chart.jsp");
        dispatcher.forward(request, response);
    }
}