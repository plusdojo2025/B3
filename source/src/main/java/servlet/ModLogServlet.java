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

/**
 * Servlet implementation class ModLogServlet
 */
@WebServlet("/ModLogServlet")
public class ModLogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

    public ModLogServlet() {
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
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/modlog.jsp");
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
		String id = request.getParameter("id");
				
		String perfume_id = request.getParameter("perfume_id");
		// 登録した香水のデータを引き継ぐために
		request.setAttribute("perfume_id", perfume_id);
		
		String temperature = request.getParameter("temperature");
		
		String weather = request.getParameter("weather");

		String applied_time = request.getParameter("applied_time");
		
		String push_count = request.getParameter("push_count");
		
		String usage_scene = request.getParameter("usage_scene");
		
		String[] applied_areas = request.getParameterValues("applied_area");

		String top_note = request.getParameter("top_note");
		
		String middle_note = request.getParameter("middle_note");
		
		String last_note = request.getParameter("last_note");
		
		String thoughts = request.getParameter("thoughts");	
		
		String applied_area = "";
		if (applied_areas != null) {
		    applied_area = String.join(",", applied_areas);  // カンマ区切りで1つの文字列にまとめる
		}
		
		// どっちのボタンが押下されたかを取得
		String action = request.getParameter("action");
				
				
		// シンプルに更新処理を行う
		Perfume_logDAO plog = new Perfume_logDAO();
		plog.update(new Perfume_log(id, perfume_id, temperature, weather, applied_time, 
			push_count, usage_scene, applied_area, top_note, middle_note, last_note, thoughts));
		
		// ボタンによってフォワード先を変える
		if("記録".equals(action)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/calendar.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/logafter.jsp");
			dispatcher.forward(request, response);
			//105,106変えてない(ボタンも消したのでjspのname="action"とかリクエストパラメータとかも全部いらなそう)
			
		}
		
//		// 更新または削除を行う	（名刺管理ver）
//		Perfume_logDAO plog = new Perfume_logDAO();
//		if (request.getParameter("submit").equals("更新")) {
//			if (plog.update(new Perfume_log(id, perfume_id, temperature, weather, applied_time, 
//					push_count, usage_scene, applied_area, top_note, middle_note, last_note, thoughts))) { // 更新成功
//				request.setAttribute("result", new Result("更新成功", "住民のデータを更新しました", "/webapp/MenuServlet"));
//			} else { // 更新失敗
//				request.setAttribute("result", new Result("更新失敗", "住民のデータを更新できませんでした", "/webapp/MenuServlet"));
//			}
//			
//		} else {
//			if (plog.delete(new Perfume_log(id, perfume_id, temperature, weather, applied_time, 
//				push_count, usage_scene, applied_area, top_note, middle_note, last_note, thoughts))) { // 削除成功
//				request.setAttribute("result", new Result("削除成功", "住民のデータを削除しました。", "/webapp/MenuServlet"));
//			} else { // 削除失敗
//				request.setAttribute("result", new Result("削除失敗", "住民のデータを削除できませんでした。", "/webapp/MenuServlet"));
//			}
//		}
	

	}

	
}
