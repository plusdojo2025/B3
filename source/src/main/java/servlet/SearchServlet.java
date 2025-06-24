
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
import dao.Small_categoryDAO;
import dto.Perfumes;
import dto.Scrollbar;
import dto.Small_category;

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
		
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		/*HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect(request.getContextPath()+"/LoginServlet");
			return;
		}*/
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search.jsp");
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
		
		// TODO Auto-generated method stub
		doGet(request, response);
		
		/*こっから下編集*/
		
	
	
	//リクエストパラメータを取得する
	request.setCharacterEncoding("UTF-8");
	String perfume_name = request.getParameter("perfume_name");
	String brand_name = request.getParameter("brand_name");
	String detail = request.getParameter("detail");
	int complex = Integer.parseInt(request.getParameter("complex"));
	int sweet = Integer.parseInt(request.getParameter("sweet"));
	int heavy = Integer.parseInt(request.getParameter("heavy"));
	int women = Integer.parseInt(request.getParameter("women"));
	int spicy = Integer.parseInt(request.getParameter("spicy"));
	
	// Create objects
		Perfumes perfume = new Perfumes(perfume_name, brand_name);
		Small_category  scategory = new Small_category(detail);
		Scrollbar scrollbar = new Scrollbar(complex, sweet, heavy, women,spicy);
	
	//検索処理を行う　赤線のところ変える
	PerfumesDAO pDao = new PerfumesDAO();
	List<Perfumes> perfumesList = pDao.select(new Perfumes(perfume_name, brand_name));
	
	Small_categoryDAO sDao = new Small_categoryDAO();
	List<Small_category> small_categoryList =sDao.select(new Small_category(image_tag));
	
	ScrollbarDAO bDao = new ScrollbarDAO();
	List<Scrollbar> scrollbarList = bDao.select(new Scrollbar(simple_complex,fresh_sweet, light_heavy, male_women, mild_spicy));
	
	// 検索結果をリクエストスコープに格納する  （これいるのかわからない）
			request.setAttribute("perfumesList", perfumesList);

	// 結果ページにフォワードする　　（かっこの中書き換える）
	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search_result.jsp");
	dispatcher.forward(request, response);
	
	}
}
