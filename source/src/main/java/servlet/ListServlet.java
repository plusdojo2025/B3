package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PerfumesDAO;
import dto.Perfumes;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/B3/LoginServlet");
			return;
		}
		PerfumesDAO dao = new PerfumesDAO();
		List<Perfumes> perfumeList = dao.perfume_img(); //perfumesのメッソド名で

		// 取得したリストをリクエストスコープに格納
		request.setAttribute("perfumeList", perfumeList);

		// リストページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
		dispatcher.forward(request, response);
	}
}