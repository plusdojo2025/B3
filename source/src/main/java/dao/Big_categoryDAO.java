package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.Big_category;

public class Big_categoryDAO {
	
	public boolean insert(Big_category bigc) {
		Connection conn = null;
		boolean result = false;
		
		try{
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b3?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			
			String sql = "INSERT INTO Big_category (id, sweet, fresh, spicy, relax, update_at, updated_at) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// SQL文を完成させる
			if (bigc.getSweet() != null) {
				pStmt.setString(1, bigc.getSweet());
			} else {
				pStmt.setString(1, "");
			}
			if (bigc.getFresh() != null) {
				pStmt.setString(2, bigc.getFresh());
			} else {
				pStmt.setString(2, "");
			}
			if (bigc.getSpicy() != null) {
				pStmt.setString(3, bigc.getSpicy());
			} else {
			    pStmt.setString(3, "");
			}
			
			if (bigc.getRelax() != null) {
				pStmt.setString(4, bigc.getRelax());
			} else {
				pStmt.setString(4, "");
			}
			if (bigc.getCreated_at() != null) {
				pStmt.setTimestamp(5, bigc.getCreated_at());
			} else {
				pStmt.setNull(5, java.sql.Types.TIMESTAMP);
			}
			if (bigc.getUpdated_at() != null) {
				pStmt.setTimestamp(6, bigc.getUpdated_at());
			} else {
				pStmt.setNull(6, java.sql.Types.TIMESTAMP);
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