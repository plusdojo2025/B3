package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.Big_category;

public class Big_categoryDAO {
	
	public boolean insert(Big_category bcate) {
		Connection conn = null;
		boolean result = false;
		
		try{
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3303/b3?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			
			String sql = "INSERT INTO Big_category (id, scent_type, update_at, updated_at) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// SQL文を完成させる
			if (bcate.getScent_type() != null) {
				pStmt.setString(1, bcate.getScent_type());
			} else {
				pStmt.setString(1, "");
			}
			
			if (bcate.getCreated_at() != null) {
				pStmt.setTimestamp(2, bcate.getCreated_at());
			} else {
				pStmt.setNull(2, java.sql.Types.TIMESTAMP);
			}
			if (bcate.getUpdated_at() != null) {
				pStmt.setTimestamp(3, bcate.getUpdated_at());
			} else {
				pStmt.setNull(3, java.sql.Types.TIMESTAMP);
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