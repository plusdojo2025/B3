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
import dto.Result;

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

		// ログインしていない場合
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect(request.getContextPath() + "/LoginServlet");
			return;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/modlog.jsp");
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
		int id = Integer.parseInt(request.getParameter("id"));
		
		String perfume_id_s = request.getParameter("perfume_id");
		int perfume_id = Integer.parseInt(perfume_id_s);
		
		String float_s = request.getParameter("temperature");
		float temperature = Float.parseFloat(float_s);
		
		String weather = request.getParameter("weather");

		String applied_time = request.getParameter("applied_time");
		
		String push_count_s = request.getParameter("push_count");
		int push_count = Integer.parseInt(push_count_s);
		
		String usage_scene_s = request.getParameter("usage_scene");
		int usage_scene = Integer.parseInt(usage_scene_s);
		
		String[] applied_areas = request.getParameterValues("applied_area");

		String top_note = request.getParameter("top_note");
		
		String middle_note = request.getParameter("middle_note");
		
		String last_note = request.getParameter("last_note");
		
		String thoughts = request.getParameter("thoughts");	
		
		String applied_area = "";
		if (applied_areas != null) {
		    applied_area = String.join(",", applied_areas);  // カンマ区切りで1つの文字列にまとめる
		}
		
		
		// 更新または削除を行う	
		Perfume_logDAO plog = new Perfume_logDAO();
		if (request.getParameter("submit").equals("更新")) {
			if (plog.update(new Perfume_log(id, perfume_id, temperature, weather, applied_time, 
					push_count, usage_scene, applied_area, top_note, middle_note, last_note, thoughts))) { // 更新成功
				request.setAttribute("result", new Result("更新成功", "住民のデータを更新しました", "/webapp/MenuServlet"));
			} else { // 更新失敗
				request.setAttribute("result", new Result("更新失敗", "住民のデータを更新できませんでした", "/webapp/MenuServlet"));
			}
			
		} else {
			if (plog.delete(new Perfume_log(id, perfume_id, temperature, weather, applied_time, 
				push_count, usage_scene, applied_area, top_note, middle_note, last_note, thoughts))) { // 削除成功
				request.setAttribute("result", new Result("削除成功", "住民のデータを削除しました。", "/webapp/MenuServlet"));
			} else { // 削除失敗
				request.setAttribute("result", new Result("削除失敗", "住民のデータを削除できませんでした。", "/webapp/MenuServlet"));
			}
		}
		
		//ボツだと思うけど一応残しておく先生スタイル
//		Perfume_log plog = new Perfume_log(id, user_id, perfume_id, temperature, weather, applied_time, 
//				push_count, usage_scene, applied_area, top_note, middle_note, last_note, thoughts, created_at, updated_at);
//		
//		Perfume_logDAO logDao = new Perfume_logDAO();
//		boolean result = logDao.update(plog);
//		doGet(request, response);
//	}

	}

	
}
