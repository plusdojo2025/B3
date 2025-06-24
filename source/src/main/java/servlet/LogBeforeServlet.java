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
import dao.PerfumesDAO;
import dto.Perfume_log;
import dto.Perfumes;

/**
 * Servlet implementation class LogBeforeServlet
 */
@WebServlet("/LogBeforeServlet")
public class LogBeforeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogBeforeServlet() {
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
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/logbefore.jsp");
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
		// 登録した香水のデータを引き継ぐために
		request.setAttribute("perfume_id", perfume_id);
		
		String temperature = request.getParameter("temperature");
		
		String weather = request.getParameter("weather");

		String applied_time = request.getParameter("applied_time");
		
		String push_count = request.getParameter("push_count");
		
		String usage_scene = request.getParameter("usage_scene");
		
		String[] applied_areas = request.getParameterValues("applied_area");

		String top_note = request.getParameter("top_note");
		
		String applied_area = "";
		if (applied_areas != null) {
		    applied_area = String.join(",", applied_areas);  // カンマ区切りで1つの文字列にまとめる
		}
		
		// どのボタンが押下されたかを取得
		String action = request.getParameter("action");
		
		//香水情報呼び出し
		PerfumesDAO pDao = new PerfumesDAO();
		List<Perfumes> perfumesList = pDao.select(new Perfumes(perfume_name, brand_name));
		// シンプルに登録処理を行う
		Perfume_logDAO plog = new Perfume_logDAO();
		plog.insert(new Perfume_log(id, perfume_id, temperature, weather, applied_time, 
		push_count, usage_scene, applied_area, top_note));
		// ボタンによってフォワード先を変える
		if("記録".equals(action)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/calendar.jsp");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/logafter.jsp");
			dispatcher.forward(request, response);
		}
		
//		// 登録処理を行う（名刺管理ver）
//		Perfume_logDAO plog = new Perfume_logDAO();
//		if (plog.insert(new Perfume_log(id, perfume_id, temperature, weather, applied_time, 
//			push_count, usage_scene, applied_area, top_note))) { 
//			
//			// 🍥🍚🍛🍜要検討！！！！！！！！！！！！！！！！！
//			// 登録成功↓ここから下は必要なのか
//			request.setAttribute("result", new Result("登録成功！", "レコードを登録しました。", "/webapp/MenuServlet"));
//		}
//		else { 
//			// 登録失敗
//			request.setAttribute("result", new Result("登録失敗！", "レコードを登録できませんでした。", "/webapp/MenuServlet"));
//		}
	}

}
