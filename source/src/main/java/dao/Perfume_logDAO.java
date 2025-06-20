package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.Perfume_log;

public class Perfume_logDAO {
	// ▶　記録｜ 引数で指定されたレコードを登録し、成功したらtrueを返す
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

			// SQL文を準備する
			String sql = "INSERT INTO perfume_log VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (plog.getId() != 0) {
				pStmt.setInt(1, plog.getId());
			} else {
				pStmt.setInt(1, 0);
			}
			if (plog.getPerfume_id() != 0) {
				pStmt.setInt(2, plog.getPerfume_id());
			} else {
				pStmt.setInt(2, 0);
			}
			if (plog.getTemperature() != 0) {
				pStmt.setFloat(3, plog.getTemperature());
			} else {
				pStmt.setFloat(3, 0);
			}
			if (plog.getWeather() != null) {
				pStmt.setString(4, plog.getWeather());
			} else {
				pStmt.setString(4, "");
			}
			if (plog.getApplied_time() != null) {
				pStmt.setString(5, plog.getApplied_time());
			} else {
				pStmt.setString(5, "");
			}
			
			if (plog.getPush_count() != 0) {
				pStmt.setInt(6, plog.getPush_count());
			} else {
				pStmt.setInt(6, 0);
			}
			if (plog.getUsage_scene() != 0) {
				pStmt.setInt(7, plog.getUsage_scene());
			} else {
				pStmt.setInt(7, 0);
			}
			if (plog.getApplied_area() != null) {
				pStmt.setString(8, plog.getApplied_area());
			} else {
				pStmt.setString(8, "");
			}
			if (plog.getTop_note() != null) {
				pStmt.setString(9, plog.getTop_note());
			} else {
				pStmt.setString(9, "");
			}
			if (plog.getMiddle_note() != null) {
				pStmt.setString(10, plog.getMiddle_note());
			} else {
				pStmt.setString(10, "");
			}
			if (plog.getLast_note() != null) {
				pStmt.setString(11, plog.getLast_note());
			} else {
				pStmt.setString(11, "");
			}
			if (plog.getThoughts() != null) {
				pStmt.setString(12, plog.getThoughts());
			} else {
				pStmt.setString(12, "");
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
	
	
	//  ▶　更新｜ 引数で指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(Perfume_log plog) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// ▶▶▶データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b3?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone"
					+ "=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "UPDATE perfume_log SET perfume_id=?, temperature=?, weather=?, applied_time=?, push_count=?,"
					+ "applied_area=?, top_note=?, middle_note=?, last_note=? WHERE id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (plog.getId() != 0) {
				pStmt.setInt(1, plog.getId());
			} else {
				pStmt.setInt(1, 0);
			}
			if (plog.getPerfume_id() != 0) {
				pStmt.setInt(2, plog.getPerfume_id());
			} else {
				pStmt.setInt(2, 0);
			}
			if (plog.getTemperature() != 0) {
				pStmt.setFloat(3, plog.getTemperature());
			} else {
				pStmt.setFloat(3, 0);
			}
			if (plog.getWeather() != null) {
				pStmt.setString(4, plog.getWeather());
			} else {
				pStmt.setString(4, "");
			}
			if (plog.getApplied_time() != null) {
				pStmt.setString(5, plog.getApplied_time());
			} else {
				pStmt.setString(5, "");
			}
			
			if (plog.getPush_count() != 0) {
				pStmt.setInt(6, plog.getPush_count());
			} else {
				pStmt.setInt(6, 0);
			}
			if (plog.getUsage_scene() != 0) {
				pStmt.setInt(7, plog.getUsage_scene());
			} else {
				pStmt.setInt(7, 0);
			}
			if (plog.getApplied_area() != null) {
				pStmt.setString(8, plog.getApplied_area());
			} else {
				pStmt.setString(8, "");
			}
			if (plog.getTop_note() != null) {
				pStmt.setString(9, plog.getTop_note());
			} else {
				pStmt.setString(9, "");
			}
			if (plog.getMiddle_note() != null) {
				pStmt.setString(10, plog.getMiddle_note());
			} else {
				pStmt.setString(10, "");
			}
			if (plog.getLast_note() != null) {
				pStmt.setString(11, plog.getLast_note());
			} else {
				pStmt.setString(11, "");
			}
			if (plog.getThoughts() != null) {
				pStmt.setString(12, plog.getThoughts());
			} else {
				pStmt.setString(12, "");
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
	
	// ▶メソッド３　｜引数で指定された番号のレコードを削除し、成功したらtrueを返す
	public boolean delete(Perfume_log plog) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// ▶▶▶データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b3?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "DELETE FROM perfume_log WHERE id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, plog.getId());

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
