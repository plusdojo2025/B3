package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PerfumesDAO;
import dto.Result;

/**
 * Servlet implementation class ModServlet
 */
@WebServlet("/ModServlet")
public class ModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mod.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		/*ここから編集*/
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
				HttpSession session = request.getSession();
				if (session.getAttribute("id") == null) {
					response.sendRedirect("/b3/LoginServlet");
					return;
				}
		
		//リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String brand = request.getParameter("brand");
		String price = request.getParameter("price");
		String purchased_date = request.getParameter("purchased_date");
		String image = request.getParameter("image");
		String strength = request.getParameter("strength");
		String color = request.getParameter("color");
		String favorite = request.getParameter("favorite");
		String sweet = request.getParameter("sweet");
		String genre = request.getParameter("genre");
		String fresh = request.getParameter("fresh");
		String spicy = request.getParameter("spicy");
		String relax = request.getParameter("relax");
		String registered_tags = request.getParameter("registered_tags");
		String simple_complex = request.getParameter("simple_complex");
		String fresh_sweet = request.getParameter("fresh_sweet");
		String light_heavy = request.getParameter("light_heavy");
		String male_women = request.getParameter("male_women");
		String mild_spicy = request.getParameter("mild_spicy");
		String date = request.getParameter("date");
		String top_note = request.getParameter("top_note");
		String middle_note = request.getParameter("middle_note");
		String last_note = request.getParameter("last_note");
		String thoughts = request.getParameter("thoughts");
		
		// 更新または削除を行う
		PerfumesDAO pDao = new PerfumesDAO();
				if (request.getParameter("submit").equals("更新")) {
					if (pDao.update(new Pf(name, brand, price, purchased_date, image, strength, color, favorite, sweet, genre, 
							fresh, spicy, relax, registered_tags, simple_complex, fresh_sweet, light_heavy, male_women,
							mild_spicy, date, top_note, middle_note, last_note, thoughts))) { // 更新成功
						request.setAttribute("result", new Result("更新成功！", "レコードを更新しました。", "/b3/ModServlet"));
					} else { // 更新失敗
						request.setAttribute("result", new Result("更新失敗！", "レコードを更新できませんでした。", "/b3/ModServlet"));
					}
				} else {
					if (pDao.delete(new Pf(name, brand, price, purchased_date, image, strength, color, favorite, sweet, genre, 
							fresh, spicy, relax, registered_tags, simple_complex, fresh_sweet, light_heavy, male_women,
							mild_spicy, date, top_note, middle_note, last_note, thoughts))) { // 削除成功
						request.setAttribute("result", new Result("削除成功！", "レコードを削除しました。", "/b3/ModServlet"));
					} else { // 削除失敗
						request.setAttribute("result", new Result("削除失敗！", "レコードを削除できませんでした。", "/b3/ModServlet"));
					}
				}
				
				// 結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
				dispatcher.forward(request, response);
			}
}