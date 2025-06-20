package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Perfume_images;

public class Perfume_imagesDAO {
	// 引数card指定された項目で検索して、取得されたデータのリストを返す
		public List<Perfume_images> select(Perfume_images pfi) {
			Connection conn = null;
			List<Perfume_images> imgList = new ArrayList<>();
			try {
				// JDBCドライバを読み込む
				Class.forName("com.mysql.cj.jdbc.Driver");
				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b3?"
						+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
						"root", "password");

				// SQL文を準備する
				String sql = "SELECT perfume_id, big_id, small_id"
						+ "FROM perfume_images"
						+ "WHERE perfume_id LIKE ? AND big_id LIKE ? AND small_id LIKE ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				
				if (pfi.getPerfume_id() != 0) {
					pStmt.setInt(1, pfi.getPerfume_id());
				} else {
					pStmt.setNull(1,java.sql.Types.INTEGER );
				}
				if (pfi.getBig_id() != 0) {
					pStmt.setInt(2, pfi.getBig_id());
				} else {
					pStmt.setNull(2,java.sql.Types.INTEGER );
				}
				if (pfi.getSmall_id() != 0) {
					pStmt.setInt(3, pfi.getSmall_id());
				} else {
					pStmt.setNull(3,java.sql.Types.INTEGER );
				}
				

				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Perfume_images image = new Perfume_images(
							rs.getInt("perfume_id"),
							rs.getInt("big_id"),
							rs.getInt("small_id")
							);
					imgList.add(image);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				imgList = null;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				imgList = null;
			} finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
						imgList = null;
					}
				}
			}

			// 結果を返す
			return imgList;
		}

	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
		public boolean insert(Perfume_images pfi) {
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
				String sql = "INSERT INTO Perfume_images VALUES (?, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (pfi.getPerfume_id() != 0) {
					pStmt.setInt(1, pfi.getPerfume_id());
				} else {
					pStmt.setInt(1, 0);
				}
				if (pfi.getBig_id() != 0) {
					pStmt.setInt(2, pfi.getBig_id());
				} else {
					pStmt.setInt(2, 0);
				}
				if (pfi.getSmall_id() != 0) {
					pStmt.setInt(3, pfi.getSmall_id());
				} else {
					pStmt.setInt(3, 0);
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
	
	
	// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(Perfume_images pfi) {
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
			String sql = "UPDATE Perfume_images SET perfume_id=?, big_id=?, small_id=?"
					+ "WHERE Perfume_id=?";
			
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (pfi.getPerfume_id() != 0) {
				pStmt.setInt(1, pfi.getPerfume_id());
			} else {
				pStmt.setInt(1, 0);
			}
			if (pfi.getBig_id() != 0) {
				pStmt.setInt(2, pfi.getBig_id());
			} else {
				pStmt.setInt(2, 0);
			}
			if (pfi.getSmall_id() != 0) {
				pStmt.setInt(3, pfi.getSmall_id());
			} else {
				pStmt.setInt(3, 0);
			}
			pStmt.setInt(3, pfi.getPerfume_id());

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

	// 引数cardで指定された番号のレコードを削除し、成功したらtrueを返す
	public boolean delete(Perfume_images pfi) {
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
			String sql = "DELETE FROM Perfume_images WHERE Perfume_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, pfi.getPerfume_id());

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
