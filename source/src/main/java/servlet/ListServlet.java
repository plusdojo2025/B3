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
import dto.Perfumes;

@WebServlet("/ListServlet")
public class ListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // GETリクエストで一覧表示
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // セッションからユーザー情報を確認（ログインしてなければリダイレクト）
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/B3/LoginServlet");
			return;
		}
//        HttpSession session = request.getSession(false); // セッションがなければnull
//        if (session == null || session.getAttribute("id") == null) {
////            response.sendRedirect(request.getContextPath() + "/LoginServlet");
//            response.sendRedirect("/b3/LoginServlet");
//            return;
//        }

//        HttpSession session = request.getSession(false); // セッションがなければnull
//        if (session == null || session.getAttribute("id") == null) {
//            response.sendRedirect(request.getContextPath() + "/LoginServlet");
//            return;
//        }

//        // 香水一覧を取得（PerfumesDAOを使用）
//        PerfumesDAO dao = new PerfumesDAO();
//        List<Perfumes> perfumeList = dao.perfume_img();
//
//        // JSPにデータを渡す
//        request.setAttribute("perfumeList", perfumeList);
//
//        // リスト表示用JSPにフォワード
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
//        dispatcher.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	
    	String perfume_img = request.getParameter("perfume_image");
    	
    	PerfumesDAO pDAO = new PerfumesDAO();
    	List<Perfumes> imageList = pDAO.selectImage(new Perfumes(perfume_img));
    	
    	request.setAttribute("imageList", imageList);
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/list.jsp");
		dispatcher.forward(request, response);
}
}