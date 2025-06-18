package servlet;

import java.io.IOException;
import java.time.LocalTime;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		// ログインしていない場合
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/B3/LoginServlet");
			return;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/logbefore.jsp");
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
		
		String float_s = request.getParameter("temperature");
		float temperature = Float.parseFloat(float_s);
		
		String weather = request.getParameter("weather");

		String time_s = request.getParameter("applied_time");
		LocalTime applied_time = LocalTime.parse(time_s);
		
		String push_count_s = request.getParameter("push_count");
		int push_count = Integer.parseInt(push_count_s);
		
		String[] applied_areas = request.getParameterValues("applied_area");

		String top_note = request.getParameter("top_note");
		
		
		String applied_area = "";
		if (applied_areas != null) {
		    applied_area = String.join(",", applied_areas);  // カンマ区切りで1つの文字列にまとめる
		}
		
		
		// 登録処理を行う
		Perfume_logDao logDao = new Perfume_logDao();
		if (logDao.insert(new Log(perfume_id, temperature, weather, applied_time, 
			push_count, applied_area))) { 
			
			// 🍥🍚🍛🍜要検討！！！！！！！！！！！！！！！！！
//			// 登録成功↓ここから下は必要なのか
//			request.setAttribute("result", new Result("登録成功！", "レコードを登録しました。", "/webapp/MenuServlet"));
//		}
//		else { 
//			// 登録失敗
//			request.setAttribute("result", new Result("登録失敗！", "レコードを登録できませんでした。", "/webapp/MenuServlet"));
//		}
		
		// カレンダーにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/calendar.jsp");
		dispatcher.forward(request, response);
		
//		// 使用後にフォワードする
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/logafter.jsp");
//		dispatcher.forward(request, response);
//		// 「記録」と「使用後へ」のボタンで処理が違うと思うけど、わからない
	}

}
