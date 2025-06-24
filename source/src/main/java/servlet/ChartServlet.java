package servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
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

        // ログインチェック（単体テスト時は無効化）
//        HttpSession session = request.getSession(false);
//        if (session == null || session.getAttribute("id") == null) {
//            response.sendRedirect(request.getContextPath() + "/LoginServlet");
//            return;
//        }

        // データを格納するリスト
        List<Map<String, Object>> perfumeList = new ArrayList<>();

        // DB接続
        String url = "jdbc:mysql://localhost:3306/b3?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9";
        String user = "root";
        String password = "password";

        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement(
                "SELECT p.name AS perfume_name, COUNT(*) AS count " +
                "FROM perfume_log pl JOIN perfumes p ON pl.perfume_id = p.id " +
                "GROUP BY p.name"
            );
            ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("name", rs.getString("perfume_name"));
                map.put("count", rs.getInt("count"));
                perfumeList.add(map);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // JSPにデータを渡す
        request.setAttribute("perfumeList", perfumeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/chart.jsp");
        dispatcher.forward(request, response);
    }
}