package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PerfumesDAO;
import dto.Perfumes;

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
		String name= request.getParameter("name");
		String brand = request.getParameter("brand");
		String price = request.getParameter("price");
		String purchased_date = request.getParameter("purchased_date");
		String image = request.getParameter("image");
		String strength = request.getParameter("strength");
		String color = request.getParameter("color");
		String favourite=request.getParameter("favourite");
		boolean fav = Boolean.parseBoolean(favourite);
		String complex=request.getParameter("complex");
		String sweet=request.getParameter("sweet");
		String heavy=request.getParameter("heavy");
		String women=request.getParameter("women");
		String spicy=request.getParameter("spicy");
		
		PerfumesDAO pDAO = new PerfumesDAO();
		if(pDAO.insert(new p(name, brand, price, purchased_date, image, strength, color, favourite),
				new s(complex, sweet, heavy, women, spicy))) {
			
		}else {
			
		}
		//PefumesDAOを実体化して、その中の香水を追加するメソッドを実行する
		//insert into perfumes (name,brand....) valeues (?,?,,,);
		
		
		//引数としてdaoにデートを渡したい。
		//そのままでもいいけど、出来たらまとめた形で渡したい
		//その時に使うのがdto（javabeans）になる
		//「Perfumes」型を実体化する。コンストラクターでデータを入れた形で実体化する
		Perfumes pf = new Perfumes(name,brand);
		PerfumesDAO pDao = new PerfumesDAO();
		boolean result = pDao.insert(pf);
		
		
		
		
		
		doGet(request, response);
	}

}
