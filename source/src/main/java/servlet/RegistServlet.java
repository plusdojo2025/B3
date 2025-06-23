package servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
@MultipartConfig
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

		String perfume_name = request.getParameter("perfume_name");
		String brand_name = request.getParameter("brand");
		int price = Integer.parseInt(request.getParameter("price"));
		String day = request.getParameter("purchased_date");
		

//		String perfume_img = this.getFileName(part);
//		request.setAttribute("image", perfume_img);
//		part.write(perfume_img);
		
		
		
		
		
		
		
		boolean favourite = Boolean.parseBoolean(request.getParameter("favourite"));
		String color = request.getParameter("color");
		int strength = Integer.parseInt(request.getParameter("strength"));
		
	
		
		
		int complex = Integer.parseInt(request.getParameter("complex"));
		int sweet = Integer.parseInt(request.getParameter("sweet"));
		int heavy = Integer.parseInt(request.getParameter("heavy"));
		int women = Integer.parseInt(request.getParameter("women"));
		int spicy = Integer.parseInt(request.getParameter("spicy"));

		
		//image
		Part imagePart =request.getPart("image");
		String fileName = Paths.get(imagePart.getSubmittedFileName()).getFileName().toString();

        // Webアプリ内の upload フォルダの絶対パスを取得
        String uploadDir = getServletContext().getRealPath("/upload/");
        System.out.println("upload先: " + uploadDir); // ← デバッグ確認用

        // フォルダが存在しなければ作成
        File uploadFolder = new File(uploadDir);
        if (!uploadFolder.exists()) uploadFolder.mkdirs();

        // 保存ファイル名を一意にする
        String newFileName = UUID.randomUUID() + "_" + fileName;

        // 保存先のフルパス
        String fullPath = uploadDir + File.separator + newFileName;
        System.out.println("fullpath先: " + fullPath); // ← デバッグ確認用
        
        // ファイル保存（Files.copy）
        try (InputStream input = imagePart.getInputStream()) {
            Files.copy(input, Paths.get(fullPath), StandardCopyOption.REPLACE_EXISTING);
        }

        // DB保存用の相対パス（Webからアクセス可能なパス）
        String relativePath = "upload/" + newFileName;

        // DBに保存


     // Create objects
     		Perfumes perfume = new Perfumes(perfume_name, brand_name, price, relativePath, day, favourite, color, strength);
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
	
//	private String getFileName(Part part) {
//		String name = null;
//		for(String dispotion : part.getHeader
//				("Content-Disposition").split(";")) {
//			if(dispotion.trim().startsWith("filename")) {
//				name = dispotion.substring(dispotion.indexOf
//						("=")+1).replace("\"", "").trim();
//				name = name.substring(name.lastIndexOf("\\")+
//						1);
//				break;
//			}
//		}
//		return name;
//		
//	}

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
		
		
		
		
	
