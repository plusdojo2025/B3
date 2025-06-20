package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Big_category;

public class Big_categoryDAO {
	public List<Big_category> select(Big_category bcate) {
		Connection conn = null;
		List<Big_category> scateList = new ArrayList<Big_category>();

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b3?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "SELECT id, scent_type, created_at, updated_at FROM Big_category "
					+ "WHERE scent_type LIKE ?  ORDER BY id";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (bcate.getScent_type() != null) {
				pStmt.setString(1, "%" + bcate.getScent_type() + "%");
			} else {
				pStmt.setString(1, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Big_category dc = new Big_category(
					rs.getInt("id"),
					rs.getString("scent_type"),
					rs.getTimestamp("created_at"),
					rs.getTimestamp("updated_at")
				);
				scateList.add(dc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			scateList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			scateList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					scateList = null;
				}
			}
		}

		// 結果を返す
		return scateList;
	}


}