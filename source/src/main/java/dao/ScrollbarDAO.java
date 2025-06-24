package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import dto.Scrollbar;

public class ScrollbarDAO {

	public List<Scrollbar> select(Scrollbar sb){
		Connection conn = null;
		List<Scrollbar> sbar = new ArrayList<Scrollbar>();
		
		try {
			// JDBCドライバを読み込む
						Class.forName("com.mysql.cj.jdbc.Driver");

						// データベースに接続する
						conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b3?"
								+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
								"root", "password");
						
						// SQL文を準備する
						String sql = "SELECT id, genre, detail, created_at, updated_at FROM Small_category "
								+ "WHERE genre LIKE ? AND detail LIKE ? ORDER BY id";
						
						PreparedStatement pStmt = conn.prepareStatement(sql);

		}
		
		
		
		return null;
		
	}
}
