package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Perfume_logDAO;
import dto.Big_category;
import dto.Perfume_log;
import dto.Perfumes;
import dto.Small_category;

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
		
		int perfume_id= Integer.parseInt(request.getParameter("perfume_id"));
		
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
		if("香水情報呼び出し".equals(action)) {
			// 香水情報呼び出し
			List<Perfumes> pimgList = plog.selectImg(perfume_id);
			List<Big_category> pbigList = plog.selectBig(perfume_id);
			List<Small_category> psmlList = plog.selectSml(perfume_id);
			// 検索結果をリクエストスコープに格納する
			request.setAttribute("pimgList", pimgList);
			request.setAttribute("pbigList", pbigList);
			request.setAttribute("psmlList", psmlList);
			// 使用前画面へ戻る
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/modlog.jsp");
			dispatcher.forward(request, response);
			
		}else if("記録".equals(action)) {
		plog.update(new Perfume_log(perfume_id, temperature, weather, applied_time, 
			push_count, usage_scene, applied_area, top_note, middle_note, last_note, thoughts));
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/calendar.jsp");
		dispatcher.forward(request, response);	
		} else {
			//　更新処理をせずに戻る
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/calendar.js");
			dispatcher.forward(request, response);
		}

	}

	
}
