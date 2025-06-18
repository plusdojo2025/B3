package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.Perfume_log;

public class Perfume_logDAO {
	// ▶　メソッド２｜ 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Perfume_log plog) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// ▶▶▶データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b3?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");
			// character~のところは変える必要あるのか

			// SQL文を準備する
			String sql = "INSERT INTO perfume_log VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (plog.getPerfume_id() != 0) {
				pStmt.setInt(1, plog.getPerfume_id());
			} else {
				pStmt.setInt(1, 0);
			}
			if (plog.getTemperature() != 0) {
				pStmt.setFloat(2, plog.getTemperature());
			} else {
				pStmt.setFloat(2, 0);
			}
			if (plog.getWeather() != null) {
				pStmt.setString(3, plog.getWeather());
			} else {
				pStmt.setString(3, "");
			}
			if (plog.getApplied_time() != null) {
				pStmt.setTime(4, java.sql.Time.valueOf(plog.getApplied_time()));
			} else {
			    pStmt.setTime(4, null);
			}
			// nullと""の部分の書き方がわからない
			
			if (plog.getPush_count() != 0) {
				pStmt.setInt(5, plog.getPush_count());
			} else {
				pStmt.setInt(5, 0);
			}
			if (plog.getApplied_area() != null) {
				pStmt.setString(6, plog.getApplied_area());
			} else {
				pStmt.setString(6, "");
			}
			if (plog.getTop_note() != null) {
				pStmt.setString(7, plog.getTop_note());
			} else {
				pStmt.setString(7, "");
			}
			if (plog.getMiddle_note() != null) {
				pStmt.setString(8, plog.getMiddle_note());
			} else {
				pStmt.setString(8, "");
			}
			if (plog.getLast_note() != null) {
				pStmt.setString(9, plog.getLast_note());
			} else {
				pStmt.setString(9, "");
			}
			if (plog.getThoughts() != null) {
				pStmt.setString(10, plog.getThoughts());
			} else {
				pStmt.setString(10, "");
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
