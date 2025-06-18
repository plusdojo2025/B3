package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Perfume_logDAO;
import dto.Perfume_log;

/**
 * Servlet implementation class LogAfterServlet
 */
@WebServlet("/LogAfterServlet")
public class LogAfterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogAfterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ログインしていない場合
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/B3/LoginServlet");
			return;
		}
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/logafter.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// データの入力後にもしもログインしていない場合ログインサーブレットにリダイレクト
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/B3/LoginServlet");
			return;
		}
		
		// リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		String perfume_id_s = request.getParameter("perfume_id");
		int perfume_id = Integer.parseInt(perfume_id_s);
		
		String middle_note = request.getParameter("middle_note");
		
		String last_note = request.getParameter("last_note");
		
		String thoughts = request.getParameter("thoughts");
		
		
		// 登録処理を行う
		Perfume_log plog = new Perfume_log(perfume_id, middle_note, last_note, thoughts);
		
		Perfume_logDAO logDao = new Perfume_logDAO();
				
		boolean result = logDao.insert(plog);
				
		doGet(request, response);
	}
}
