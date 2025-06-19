package servlet;

import java.io.IOException;
import java.time.LocalTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
			response.sendRedirect("/B3/LoginServlet");
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
		String id_s = request.getParameter("id");
		int id = Integer.parseInt(id_s);
		
		String user_id_s = request.getParameter("user_id");
		int user_id = Integer.parseInt(user_id_s);
		
		String perfume_id_s = request.getParameter("perfume_id");
		int perfume_id = Integer.parseInt(perfume_id_s);
		
		String float_s = request.getParameter("temperature");
		float temperature = Float.parseFloat(float_s);
		
		String weather = request.getParameter("weather");

		String time_s = request.getParameter("applied_time");
		LocalTime applied_time = LocalTime.parse(time_s);
		
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
		
		
	}

	
}
