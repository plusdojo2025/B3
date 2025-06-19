package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.Detail_category;

public class Detail_categoryDAO {
	
	public boolean insert(Detail_category detc) {
		Connection conn = null;
		boolean result = false;
		
		try{
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b3?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			
			String sql = "INSERT INTO Detail_category (id, big_id,  genre, detail, created_at, updated_at) VALUES ( ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			
			// SQL文を完成させる
			if (detc.getId() != 0) {
				pStmt.setInt(1, detc.getId());
			} else {
				pStmt.setInt(1, 0);
			}
		
			if (detc.getBig_id() != 0) {
				pStmt.setInt(2, detc.getBig_id());
			} else {
				pStmt.setInt(2, 0);
			}
			if (detc.getGenre() != null) {
				pStmt.setString(3, detc.getGenre());
			} else {
				pStmt.setString(3, "");
			}
			if (detc.getDetail() != null) {
				pStmt.setString(4, detc.getDetail());
			} else {
			    pStmt.setString(4, "");
			}
            if (detc.getCreated_at() != null) {
				pStmt.setTimestamp(5, detc.getCreated_at());
			} else {
				pStmt.setNull(5, java.sql.Types.TIMESTAMP);
			}
			if (detc.getUpdated_at() != null) {
				pStmt.setTimestamp(6, detc.getUpdated_at());
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
