
package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PerfumesDAO;
import dto.PerfumeWithScrollbar;
import dto.Perfumes;
import dto.Scrollbar_search;

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
	 * @param sb 
	 * @param p 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search.jsp");
        dispatcher.forward(request, response);
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		// データの入力後にもしもログインしていない場合ログインサーブレットにリダイレクト

		// データの入力後にもしもログインしていない場合ログインサーブレットにリダイレクト

//				HttpSession session = request.getSession();
//				if (session.getAttribute("id") == null) {
//					response.sendRedirect("/B3/LoginServlet");
//					return;
//				}

//		
//		// TODO Auto-generated method stub
//		doGet(request, response);
//		
//		/*こっから下編集*/
//		
//	
//	
//	//リクエストパラメータを取得する
//	request.setCharacterEncoding("UTF-8");
//	String perfume_name = request.getParameter("perfume_name");
//	String brand_name = request.getParameter("brand_name");
//	String detail = request.getParameter("detail");
//	int complex = Integer.parseInt(request.getParameter("complex"));
//	int sweet = Integer.parseInt(request.getParameter("sweet"));
//	int heavy = Integer.parseInt(request.getParameter("heavy"));
//	int women = Integer.parseInt(request.getParameter("women"));
//	int spicy = Integer.parseInt(request.getParameter("spicy"));
//	
//	// Create objects
//		Perfumes perfume = new Perfumes(perfume_name, brand_name);
//		Small_category  scategory = new Small_category(detail);
//		Scrollbar scrollbar = new Scrollbar(complex, sweet, heavy, women,spicy);
//	
//	//検索処理を行う　赤線のところ変える
//	PerfumesDAO pDao = new PerfumesDAO();
//	List<Perfumes> perfumesList = pDao.select(new Perfumes(perfume_name, brand_name));
//	
//	Small_categoryDAO sDao = new Small_categoryDAO();
//	List<Small_category> small_categoryList =sDao.select(new Small_category(detail));
//	
//	ScrollbarDAO bDao = new ScrollbarDAO();
//	//List<Scrollbar> scrollbarList = bDao.select(new Scrollbar(simple_complex,fresh_sweet, light_heavy, male_women, mild_spicy));
//	
//	// 検索結果をリクエストスコープに格納する  （これいるのかわからない）
//			request.setAttribute("perfumesList", perfumesList);
//
//	// 結果ページにフォワードする　　（かっこの中書き換える）
//	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search_result.jsp");
//	dispatcher.forward(request, response);
//	
//	}


		
		// パラメータを受け取る（例: クエリ文字列などから）
        String perfumeName = request.getParameter("perfume_name");
        String brandName = request.getParameter("brand_name");
        
        //simple_complex min max value
        int simpleMin = Integer.parseInt(request.getParameter("simple_minRange"));
        int simpleMax = Integer.parseInt(request.getParameter("simple_maxRange"));
               
        //fresh
        int freshMin = Integer.parseInt(request.getParameter("fresh_minRange"));
        int freshMax = Integer.parseInt(request.getParameter("fresh_maxRange"));
        
        int lightMin = Integer.parseInt(request.getParameter("light_minRange"));
        int lightMax = Integer.parseInt(request.getParameter("light_maxRange"));
        
        int menMin = Integer.parseInt(request.getParameter("men_minRange"));
        int menMax = Integer.parseInt(request.getParameter("men_maxRange"));
      
        int mildMin = Integer.parseInt(request.getParameter("mild_minRange"));
        int mildMax = Integer.parseInt(request.getParameter("mild_maxRange"));
        //sql
        //select * from scrollbar WHERE perfume_name = ? or brand_name = ? or
        // simple_complex between ? and ? or
        //simple_complex between simpleMin and simpleMax
        
        
        
//        
//        int simpleComplex = Integer.parseInt(request.getParameter("simple_complex"));
//        int freshSweet = Integer.parseInt(request.getParameter("fresh_sweet"));
//        int lightHeavy = Integer.parseInt(request.getParameter("light_heavy"));
//        int maleWomen = Integer.parseInt(request.getParameter("male_women"));
//        int mildSpicy = Integer.parseInt(request.getParameter("mild_spicy"));

        // オブジェクトに格納
        Perfumes p = new Perfumes(perfumeName, brandName);
       // Scrollbar sb = new Scrollbar(simpleComplex, freshSweet, lightHeavy, maleWomen, mildSpicy);

        Scrollbar_search sb = new Scrollbar_search(simpleMin,simpleMax,
        		freshMin,freshMax,
        		lightMin,lightMax,
        		menMin,menMax,
        		mildMin,mildMax);
        
        
        // DAO呼び出し
        PerfumesDAO pDAO = new PerfumesDAO();
        List<PerfumeWithScrollbar> dataList = pDAO.selectdata(p, sb);

        // JSPに渡す
        request.setAttribute("dataList", dataList);

        // 転送
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/searchdataList.jsp");
        dispatcher.forward(request, response);
}
}
