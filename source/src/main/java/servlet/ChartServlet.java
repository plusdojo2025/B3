package servlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ChartServlet")
public class ChartServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

//        // ログインチェック
//        HttpSession session = request.getSession(false);
//        if (session == null || session.getAttribute("id") == null) {
//            response.sendRedirect(request.getContextPath() + "/LoginServlet");
//            return;
//        }

        List<String> labels = new ArrayList<>();
        List<Integer> counts = new ArrayList<>();

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
                labels.add(rs.getString("perfume_name"));
                counts.add(rs.getInt("count"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Chart.jsで利用する形式で渡す
        request.setAttribute("labels", labels);
        request.setAttribute("counts", counts);
        request.getRequestDispatcher("/WEB-INF/jsp/chart.jsp").forward(request, response);
    }
}