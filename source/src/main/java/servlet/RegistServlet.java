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
import dto.Result;
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
		String priceStr = request.getParameter("price");
		int price =0;
		if (priceStr != null && !priceStr.isEmpty()) {
		    try {
		        price = Integer.parseInt(priceStr);
		    } catch (NumberFormatException e) {
		        System.out.println("価格が不正です：" + priceStr);
		        price = 0;
		    }
		}

		String day = request.getParameter("purchased_date");
		

//		String perfume_img = this.getFileName(part);
//		request.setAttribute("image", perfume_img);
//		part.write(perfume_img);
		
		
		
		
		
		
		
		boolean favourite = Boolean.parseBoolean(request.getParameter("favourite"));
		String color = request.getParameter("color");
		
		String strengthStr = request.getParameter("strength");
		int strength = 0;
		if (strengthStr != null && !strengthStr.isEmpty()) {
		    try {
		        strength = Integer.parseInt(strengthStr);
		    } catch (NumberFormatException e) {
		        strength = 0;
		    }
		}

		String complexStr = request.getParameter("complex");
		int complex = 0;
		if (complexStr != null && !complexStr.isEmpty()) {
		    try {
		        complex = Integer.parseInt(complexStr);
		    } catch (NumberFormatException e) {
		        complex = 0;
		    }
		}

		String sweetStr = request.getParameter("sweet");
		int sweet = 0;
		if (sweetStr != null && !sweetStr.isEmpty()) {
		    try {
		        sweet = Integer.parseInt(sweetStr);
		    } catch (NumberFormatException e) {
		        sweet = 0;
		    }
		}

		String heavyStr = request.getParameter("heavy");
		int heavy = 0;
		if (heavyStr != null && !heavyStr.isEmpty()) {
		    try {
		        heavy = Integer.parseInt(heavyStr);
		    } catch (NumberFormatException e) {
		        heavy = 0;
		    }
		}

		String womenStr = request.getParameter("women");
		int women = 0;
		if (womenStr != null && !womenStr.isEmpty()) {
		    try {
		        women = Integer.parseInt(womenStr);
		    } catch (NumberFormatException e) {
		        women = 0;
		    }
		}

		String spicyStr = request.getParameter("spicy");
		int spicy = 0;
		if (spicyStr != null && !spicyStr.isEmpty()) {
		    try {
		        spicy = Integer.parseInt(spicyStr);
		    } catch (NumberFormatException e) {
		        spicy = 0;
		    }
		}


		
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
		     response.sendRedirect(request.getContextPath() + "/RegistImageServletServlet");
			
		} else {
		    request.setAttribute("result", new Result("登録失敗！", "レコードを登録できませんでした。", "/b3/RegistImageServlet"));
		}	

	}
	


}

		
		
		
		
	
