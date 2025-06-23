package servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.PerfumesDAO;
import dto.Perfumes;
import dto.Scrollbar;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/regist.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//リクエストパラメータを受け取る
		request.setCharacterEncoding("UTF-8");

		String perfume_name = request.getParameter("name");
		String brand_name = request.getParameter("brand");
		int price = Integer.parseInt(request.getParameter("price"));
		//String perfume_img = request.getParameter("image");
		Part imagePart= request.getPart("image");
		String perfume_img = imagePart.getSubmittedFileName();
		InputStream fileContent = imagePart.getInputStream();

		
		String day = request.getParameter("purchased_date");
		boolean favourite = Boolean.parseBoolean(request.getParameter("favourite"));
		String color = request.getParameter("color");
		int strength = Integer.parseInt(request.getParameter("strength"));
		
	
		
		
		int complex = Integer.parseInt(request.getParameter("complex"));
		int sweet = Integer.parseInt(request.getParameter("sweet"));
		int heavy = Integer.parseInt(request.getParameter("heavy"));
		int women = Integer.parseInt(request.getParameter("women"));
		int spicy = Integer.parseInt(request.getParameter("spicy"));

		// Create objects
		Perfumes perfume = new Perfumes(perfume_name, brand_name, price, perfume_img, day, favourite, color, strength);
		Scrollbar scrollbar = new Scrollbar(complex, sweet, heavy, women, spicy);

		// Insert into DB
		PerfumesDAO pDAO = new PerfumesDAO();
		if (pDAO.insert(perfume, scrollbar)) {
		    doGet(request,response);
		    // response.sendRedirect(request.getContextPath() + "/HomeServlet");
			
		} else {
//		    request.setAttribute("result", new Result("登録失敗！", "レコードを登録できませんでした。", "/b3/RegistServlet"));
		}	
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/result.jsp");
//		dispatcher.forward(request, response);
	}

}
		//PefumesDAOを実体化して、その中の香水を追加するメソッドを実行する
		//insert into perfumes (name,brand....) valeues (?,?,,,);
		
		
		//引数としてdaoにデートを渡したい。
		//そのままでもいいけど、出来たらまとめた形で渡したい
		//その時に使うのがdto（javabeans）になる
		//「Perfumes」型を実体化する。コンストラクターでデータを入れた形で実体化する
//		Perfumes pf = new Perfumes(name,brand);
//		PerfumesDAO pDao = new PerfumesDAO();
//		boolean result = pDao.insert(pf);
//		
		
		
		
		
	
