package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Detail_category;

public class Detail_categoryDAO {

	// 引数detc指定された項目で検索して、取得されたデータのリストを返す
	public List<Detail_category> select(Detail_category detc) {
		Connection conn = null;
		List<Detail_category> detcList = new ArrayList<Detail_category>();

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b3?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "SELECT id, big_id, genre, detail, created_at, updated_at FROM Detail_category "
					+ "WHERE genre LIKE ? AND detail LIKE ? ORDER BY id";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (detc.getGenre() != null) {
				pStmt.setString(1, "%" + detc.getGenre() + "%");
			} else {
				pStmt.setString(1, "%");
			}
			if (detc.getDetail() != null) {
				pStmt.setString(2, "%" + detc.getDetail() + "%");
			} else {
				pStmt.setString(2, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Detail_category dc = new Detail_category(
					rs.getInt("id"),
					rs.getInt("big_id"),
					rs.getString("genre"),
					rs.getString("detail"),
					rs.getTimestamp("created_at"),
					rs.getTimestamp("updated_at")
				);
				detcList.add(dc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			detcList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			detcList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					detcList = null;
				}
			}
		}

		// 結果を返す
		return detcList;
	}

	// 引数detcで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Detail_category detc) {
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
			String sql = "INSERT INTO Detail_category (big_id, genre, detail, created_at, updated_at) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, detc.getBig_id());
			pStmt.setString(2, detc.getGenre());
			pStmt.setString(3, detc.getDetail());
			pStmt.setTimestamp(4, detc.getCreated_at());
			pStmt.setTimestamp(5, detc.getUpdated_at());

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

	// 引数detcで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(Detail_category detc) {
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
			String sql = "UPDATE Detail_category SET big_id=?, genre=?, detail=?, created_at=?, updated_at=? WHERE id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, detc.getBig_id());
			pStmt.setString(2, detc.getGenre());
			pStmt.setString(3, detc.getDetail());
			pStmt.setTimestamp(4, detc.getCreated_at());
			pStmt.setTimestamp(5, detc.getUpdated_at());
			pStmt.setInt(6, detc.getId());

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

	// 引数detcで指定されたIDのレコードを削除し、成功したらtrueを返す
	public boolean delete(Detail_category detc) {
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
			String sql = "DELETE FROM Detail_category WHERE id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, detc.getId());

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