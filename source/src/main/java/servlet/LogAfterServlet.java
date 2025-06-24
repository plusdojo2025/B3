package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Perfume_logDAO;
import dto.Perfume_log;
import dto.Result;

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
		
//		// ログインしていない場合
//		HttpSession session = request.getSession();
//		if (session.getAttribute("id") == null) {
//			response.sendRedirect(request.getContextPath() + "/LoginServlet");
//			return;
//		}
				
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/logafter.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// データの入力後にもしもログインしていない場合ログインサーブレットにリダイレクト
//		HttpSession session = request.getSession();
//		if (session.getAttribute("id") == null) {
//			response.sendRedirect("/B3/LoginServlet");
//			return;
//		}
		
		// リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		
		int id= Integer.parseInt(request.getParameter("id"));
		
		int perfume_id= Integer.parseInt(request.getParameter("perfume_id"));
		
		String middle_note = request.getParameter("middle_note");
		
		String last_note = request.getParameter("last_note");
		
		String thoughts = request.getParameter("thoughts");
		
		// 更新または削除を行う	
		Perfume_logDAO plog = new Perfume_logDAO();
		if (request.getParameter("submit").equals("更新")) {
			if (plog.update(new Perfume_log(id, perfume_id, middle_note, last_note, thoughts))) { // 更新成功
				request.setAttribute("result", new Result("更新成功", "住民のデータを更新しました", "/webapp/MenuServlet"));
			} else { // 更新失敗
				request.setAttribute("result", new Result("更新失敗", "住民のデータを更新できませんでした", "/webapp/MenuServlet"));
			}
		} else {
			if (plog.delete(new Perfume_log(id, perfume_id, middle_note, last_note, thoughts))) { // 削除成功
				request.setAttribute("result", new Result("削除成功", "住民のデータを削除しました。", "/webapp/MenuServlet"));
			} else { // 削除失敗
				request.setAttribute("result", new Result("削除失敗", "住民のデータを削除できませんでした。", "/webapp/MenuServlet"));
			}
		}
		
	}
}
