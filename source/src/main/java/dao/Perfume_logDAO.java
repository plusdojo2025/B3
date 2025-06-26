package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Big_category;
import dto.Perfume_log;
import dto.Perfumes;
import dto.Small_category;

public class Perfume_logDAO {
	// ▶　画像を引っ張ってくる｜引数指定された項目で検索して、取得されたデータのリストを返す
	public List<Perfumes> selectImg(int perfume_id) {
		Connection conn = null;
		List<Perfumes> pimgList = new ArrayList<Perfumes>();

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b3?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "SELECT perfume_img FROM Perfumes WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (perfume_id != 0) {
				pStmt.setInt(1, perfume_id);
			} else {
				pStmt.setNull(1, java.sql.Types.INTEGER);
			}


			// SQL文を実行し、結果表を取得する
			ResultSet imgrs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (imgrs.next()) {
				Perfumes pimgrs = new Perfumes(
						imgrs.getString("perfume_img")
						);
				pimgList.add(pimgrs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			pimgList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			pimgList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					pimgList = null;
				}
			}
		}
		// 結果を返す
		return pimgList;
	}
	
			// ▶　大項目（甘さ等）を引っ張ってくる｜引数指定された項目で検索して、取得されたデータのリストを返す
		public List<Big_category> selectBig(int perfume_id) {
			Connection conn = null;
			List<Big_category> pbigList = new ArrayList<Big_category>();

			try {
				// JDBCドライバを読み込む
				Class.forName("com.mysql.cj.jdbc.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b3?"
						+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
						"root", "password");

				// SQL文を準備する
				String sql = "SELECT big.scent_type FROM perfume_images pi"
						+ " JOIN big_category big ON pi.big_id = big.id WHERE pi.perfume_id = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (perfume_id != 0) {
					pStmt.setInt(1, perfume_id);
				} else {
					pStmt.setNull(1, java.sql.Types.INTEGER);
				}


				// SQL文を実行し、結果表を取得する
				ResultSet bigrs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (bigrs.next()) {
					Big_category pbigrs = new Big_category(
							bigrs.getString("scent_type")
							);
					pbigList.add(pbigrs);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				pbigList = null;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				pbigList = null;
			} finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
						pbigList = null;
					}
				}
			}
			// 結果を返す
			return pbigList;
		}
		
		// ▶　小項目（いちご等）を引っ張ってくる｜引数指定された項目で検索して、取得されたデータのリストを返す
		public List<Small_category> selectSml(int perfume_id) {
			Connection conn = null;
			List<Small_category> psmlList = new ArrayList<Small_category>();

			try {
				// JDBCドライバを読み込む
				Class.forName("com.mysql.cj.jdbc.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b3?"
						+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
						"root", "password");

				// SQL文を準備する
				String sql = "SELECT sml.detail FROM perfume_images pi"
						+ " JOIN small_category sml ON pi.small_id = sml.id WHERE pi.perfume_id = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (perfume_id != 0) {
					pStmt.setInt(1, perfume_id);
				} else {
					pStmt.setNull(1, java.sql.Types.INTEGER);
				}


				// SQL文を実行し、結果表を取得する
				ResultSet smlrs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				while (smlrs.next()) {
					Small_category psmlrs = new Small_category(
							smlrs.getString("detail")
							);
					psmlList.add(psmlrs);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				psmlList = null;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				psmlList = null;
			} finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
						psmlList = null;
					}
				}
			}
			// 結果を返す
			return psmlList;
		}
		
		
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
			String sql = "INSERT INTO perfume_log (perfume_id, temperature, weather, applied_time,"
					+ "push_count, usage_scene, applied_area, top_note, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (plog.getPerfume_id() != 0) {
				pStmt.setInt(1,plog.getPerfume_id());
			} else {
				pStmt.setInt(1, 0);
			}
			if (plog.getTemperature() != null) {
				pStmt.setString(2, plog.getTemperature());
			} else {
				pStmt.setString(2, "");
			}
			if (plog.getWeather() != null) {
				pStmt.setString(3, plog.getWeather());
			} else {
				pStmt.setString(3, "");
			}
			if (plog.getApplied_time() != null) {
				pStmt.setString(4, plog.getApplied_time());
			} else {
				pStmt.setString(4, "");
			}
			if (plog.getPush_count() != null) {
				pStmt.setString(5, plog.getPush_count());
			} else {
				pStmt.setString(5, "");
			}
			if (plog.getUsage_scene() != null) {
				pStmt.setString(6, plog.getUsage_scene());
			} else {
				pStmt.setString(6,"");
			}
			if (plog.getApplied_area() != null) {
				pStmt.setString(7, plog.getApplied_area());
			} else {
				pStmt.setString(7, "");
			}
			if (plog.getTop_note() != null) {
				pStmt.setString(8, plog.getTop_note());
			} else {
				pStmt.setString(8, "");
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
	
	
	
	
//	//▶Maxid検索　｜　引数指定された項目で検索して、取得されたデータのリストを返す
//	public List<Perfume_log> selectId(Perfume_log lid) {
//		Connection conn = null;
//		List<Perfume_log> idList = new ArrayList<Perfume_log>();
//
//		try {
//			// JDBCドライバを読み込む
//			Class.forName("com.mysql.cj.jdbc.Driver");
//
//			// データベースに接続する
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b3?"
//					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
//					"root", "password");
//
//			// SQL文を準備する
//			String sql = "SELECT perfume_id" + "FROM Perfume_log"
//					+ "WHERE id = ?";
//			PreparedStatement pStmt = conn.prepareStatement(sql);
//
//			// SQL文を完成させる
//			if (lid.getId() != 0) {
//				pStmt.setInt(1, lid.getId());
//			} else {
//				pStmt.setNull(1, java.sql.Types.INTEGER);
//			}
//
//
//			// SQL文を実行し、結果表を取得する
//			ResultSet lidrs = pStmt.executeQuery();
//
//			// 結果表をコレクションにコピーする
//			while (lidrs.next()) {
//				Perfume_log idrs = new Perfume_log(
//						lidrs.getInt("perfume_id")
//						);
//				idList.add(idrs);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			idList = null;
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//			idList = null;
//		} finally {
//			// データベースを切断
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//					idList = null;
//				}
//			}
//		}
//		// 結果を返す
//		return idList;
//	}

	
//	//  ▶　更新（使用後記録）　｜
//	public boolean updateAdd(Perfume_log plog) {
//		Connection conn = null;
//		boolean result = false;
//
//		try {
//			// JDBCドライバを読み込む
//			Class.forName("com.mysql.cj.jdbc.Driver");
//
//			// ▶▶▶データベースに接続する
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b3?"
//					+ "characterEncoding=utf8&useSSL=false&serverTimezone"
//					+ "=GMT%2B9&rewriteBatchedStatements=true",
//					"root", "password");
//
//			// SQL文を準備する
//			String sql = "UPDATE perfume_log SET middle_note=?, last_note=? ,thoughts=? WHERE id=?";
//			PreparedStatement pStmt = conn.prepareStatement(sql);
//
//			// SQL文を完成させる
//
//			if (plog.getMiddle_note() != null) {
//				pStmt.setString(1, plog.getMiddle_note());
//			} else {
//				pStmt.setString(1, "");
//			}
//			if (plog.getLast_note() != null) {
//				pStmt.setString(2, plog.getLast_note());
//			} else {
//				pStmt.setString(2, "");
//			}
//			if (plog.getThoughts() != null) {
//				pStmt.setString(3, plog.getThoughts());
//			} else {
//				pStmt.setString(3, "");
//			}
//			if (plog.getId()!=0) {
//				pStmt.setInt(4, plog.getId());
//			} else {
//				pStmt.setInt(4, 0);
//			}
//			
//			// SQL文を実行する
//			if (pStmt.executeUpdate() == 1) {
//				result = true;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} finally {
//			// データベースを切断
//			if (conn != null) {
//				try {
//					conn.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//
//		// 結果を返す
//		return result;
//	}
	
	// ▶　更新（詳細編集）｜ 引数で指定されたレコードを更新し、成功したらtrueを返す
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
						+ "applied_area=?, top_note=?, middle_note=?, last_note=?, thoughts=? WHERE id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (plog.getPerfume_id() != 0) {
					pStmt.setInt(1, plog.getPerfume_id());
				} else {
					pStmt.setInt(1, 0);
				}

				if (plog.getTemperature() != null) {
					pStmt.setString(2, plog.getTemperature());
				} else {
					pStmt.setString(2, "");
				}
				if (plog.getWeather() != null) {
					pStmt.setString(3, plog.getWeather());
				} else {
					pStmt.setString(3, "");
				}
				if (plog.getApplied_time() != null) {
					pStmt.setString(4, plog.getApplied_time());
				} else {
					pStmt.setString(4, "");
				}
				
				if (plog.getPush_count() != null) {
					pStmt.setString(5, plog.getPush_count());
				} else {
					pStmt.setString(5, "");
				}
				if (plog.getUsage_scene() != null) {
					pStmt.setString(6, plog.getUsage_scene());
				} else {
					pStmt.setString(6, "");
				}
				if (plog.getApplied_area() != null) {
					pStmt.setString(7, plog.getApplied_area());
				} else {
					pStmt.setString(7, "");
				}
				if (plog.getTop_note() != null) {
					pStmt.setString(8, plog.getTop_note());
				} else {
					pStmt.setString(8, "");
				}
				if (plog.getMiddle_note() != null) {
					pStmt.setString(9, plog.getMiddle_note());
				} else {
					pStmt.setString(9, "");
				}
				if (plog.getLast_note() != null) {
					pStmt.setString(10, plog.getLast_note());
				} else {
					pStmt.setString(10, "");
				}
				if (plog.getThoughts() != null) {
					pStmt.setString(11, plog.getThoughts());
				} else {
					pStmt.setString(11, "");
				}
				if (plog.getId()!=0) {
					pStmt.setInt(12, plog.getId());
				} else {
					pStmt.setInt(12, 0);
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
	// ▶　削除｜引数で指定された番号のレコードを削除し、成功したらtrueを返す
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
	
	// ▶　検索（グラフ化）｜引数指定された項目で検索して、取得されたデータのリストを返す
	public List<Perfume_log> select(Perfume_log plog) {
		Connection conn = null;
		List<Perfume_log> plogList = new ArrayList<Perfume_log>();

		try {
			// JDBCドライバを読み込む
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b3?"
					+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
					"root", "password");

			// SQL文を準備する
			String sql = "SELECT id, perfume_id" + "FROM Perfume_log"
					+ "WHERE perfume_id = ?" + "ORDER BY id";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (plog.getPerfume_id() != 0) {
				pStmt.setInt(1, plog.getPerfume_id());
			} else {
				pStmt.setNull(1, java.sql.Types.INTEGER);
			}


			// SQL文を実行し、結果表を取得する
			ResultSet logrs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (logrs.next()) {
				Perfume_log plogrs = new Perfume_log(
						logrs.getInt("id"), 
						logrs.getInt("perfume_id")
						);
				plogList.add(plogrs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			plogList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			plogList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					plogList = null;
				}
			}
		}
		// 結果を返す
		return plogList;
	}
}
