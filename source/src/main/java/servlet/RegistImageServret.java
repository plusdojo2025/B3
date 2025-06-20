package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Perfume_imagesDAO;
import dto.Perfume_images;
import dto.Result;

/**
 * Servlet implementation class RegistImageServret
 */
@WebServlet("/RegistImageServret")
public class RegistImageServret extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistImageServret() {
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
				response.sendRedirect("/B3/RegistImageServlet");
				return;
			}
		
		// 登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/registimage.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// データの入力後にもしもログインしていない場合ログインサーブレットにリダイレクト
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/B3/RegistImageServlet");
			return;
			}
		
		// リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
				String perfume_id_s = request.getParameter("perfume_id");
				int perfume_id = Integer.parseInt(perfume_id_s);
				
				String big_id_s = request.getParameter("big_id");
				int big_id = Integer.parseInt(big_id_s);
				
				String small_id_s = request.getParameter("small_id");
				int small_id = Integer.parseInt(small_id_s);
				
				
				// 登録処理を行う
				Perfume_imagesDAO pfi = new Perfume_imagesDAO();
				if (pfi.insert(new Perfume_images(perfume_id, big_id,small_id))) { 
					
					// 🍥🍚🍛🍜要検討！！！！！！！！！！！！！！！！！
					// 登録成功↓ここから下は必要なのか
					request.setAttribute("result", new Result("登録成功！", "レコードを登録しました。", "/webapp/MenuServlet"));
				}
				else { 
					// 登録失敗
					request.setAttribute("result", new Result("登録失敗！", "レコードを登録できませんでした。", "/webapp/MenuServlet"));
				}
				
				// カレンダーにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/list/.jsp");
				dispatcher.forward(request, response);	
	}

}
