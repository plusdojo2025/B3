package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Small_category;

public class Small_categoryDAO {

	// 引数scate指定された項目で検索して、取得されたデータのリストを返す
	public List<Small_category> select(Small_category scate) {
		Connection conn = null;
		List<Small_category> scateList = new ArrayList<Small_category>();

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b3?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "SELECT id, genre, detail, created_at, updated_at FROM Detail_category "
					+ "WHERE genre LIKE ? AND detail LIKE ? ORDER BY id";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (scate.getGenre() != null) {
				pStmt.setString(1, "%" + scate.getGenre() + "%");
			} else {
				pStmt.setString(1, "%");
			}
			if (scate.getDetail() != null) {
				pStmt.setString(2, "%" + scate.getDetail() + "%");
			} else {
				pStmt.setString(2, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Small_category dc = new Small_category(
					rs.getInt("id"),
					rs.getString("genre"),
					rs.getString("detail"),
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