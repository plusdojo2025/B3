
package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PerfumesDAO;
/*
import dao.BcDAO;
import dto.Bc;

編集
import dao.~~DAO;
import dto.~~;
*/
/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		/*こっから下編集*/
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
				HttpSession session = request.getSession();
				if (session.getAttribute("id") == null) {
					response.sendRedirect("/b3/LoginServlet");
					return;
				}
	
	
	//リクエストパラメータを取得する
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String brand_name = request.getParameter("brand_name");
	String image_tag = request.getParameter("image_tag");
	String simple_complex = request.getParameter("simple_complex");
	String fresh_sweet = request.getParameter("fresh_sweet");
	String light_heavy = request.getParameter("light_heavy");
	String male_women = request.getParameter("male_women");
	String mild_spicy = request.getParameter("mild_spicy");
	
	//検索処理を行う　赤線のところ変える
	PerfumesDAO pDao = new PerfumesDAO();
	List<Pf> perfumesList = pDao.select(new Pf(name, brand_name, image_tag, simple_complex,
			fresh_sweet, light_heavy, male_women, mild_spicy));
	
	// 検索結果をリクエストスコープに格納する  （これいるのかわからない）
			request.setAttribute("perfumesList", perfumesList);

	// 結果ページにフォワードする　　（かっこの中書き換える）
	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search_result.jsp");
	dispatcher.forward(request, response);
	
	}
}
