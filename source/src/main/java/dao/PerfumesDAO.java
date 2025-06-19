package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


import java.sql.SQLException;


import dto.Perfumes;

public class PerfumesDAO {

	// ▶　メソッド２｜ 引数cardで指定されたレコードを登録し、成功したらtrueを返す
		public boolean insert(Perfumes plog) {
			Connection conn = null;
			boolean result = false;
			
			try {
				// JDBCドライバを読み込む（いじってない）
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				// ▶▶▶データベースに接続する(いじってない)
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b3?"
						+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
						"root", "password");
				
				// SQL文を準備する
				String sql = "INSERT INTO perfumes VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				//
				if (plog.getId() != 0) {
					pStmt.setInt(1, plog.getId());
				} else {
					pStmt.setInt(1, 0);
				}
				if (plog.getBrand_name() != null) {
					pStmt.setString(2, plog.getBrand_name());
				} else {
					pStmt.setFloat(2, 0);
				}
			}
				
				
		
			

		
/*間違えて作ったやつ使わなかったら消して		
		if (plog.getPerfume_name() != 0) {
			pStmt.setInt(1, plog.getPerfume_name());
		} else {
			pStmt.setInt(1, 0);
		}
		if (plog.getBrand_name() != 0) {
			pStmt.setFloat(2, plog.getBrand_name());
		} else {
			pStmt.setFloat(2, 0);
		}
		if (plog.getPrice() != null) {
			pStmt.setString(3, plog.getPrice());
		} else {
			pStmt.setString(3, "");
		}
		if (plog.getPerfume_img() != null) {
			pStmt.setTime(4, plog.getPerfume_img());
		} else {
		    pStmt.setTime(4, null);
		}
		// nullと""の部分の書き方がわからない
		
		if (plog.getDay() != 0) {
			pStmt.setInt(5, plog.getDay());
		} else {
			pStmt.setInt(5, 0);
		}
		if (plog.getFavourite() != null) {
			pStmt.setString(6, plog.getFavourite());
		} 
		*/
		
		
		
=======

	public boolean insert(Perfumes pf) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b3?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "INSERT INTO Perfumes (name, brand) VALUES ( ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (pf.getName() != null) {
				pStmt.setString(1, pf.getName());
			} else {
				pStmt.setString(1, "");
			}
			if (pf.getBrand() != null) {
				pStmt.setString(2, pf.getBrand());
			} else {
				pStmt.setString(2, "");
			}
				
			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
		
	}
}
>>>>>>> fe859fc12a5c9328458436ca166c1eb5b8b45ce5
