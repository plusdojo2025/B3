package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Perfume_log;

public class Perfume_logDAO {
	// ▶　画像とイメージタグを引っ張ってくる｜引数指定された項目で検索して、取得されたデータのリストを返す
	    public Perfume_log selectImagesByPerfumeId(int p_id) {
	        Connection conn = null;
	        Perfume_log pinfo = null;

	        try {
	        	// JDBCドライバを読み込む
	            Class.forName("com.mysql.cj.jdbc.Driver");
				// データベースに接続する
	            conn = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/b3?characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9",
	                "root", "password"
	            );

				// SQL文を準備する
	            String sql = "SELECT p.perfume_img " +
	                         "FROM perfumes p " +
	            		//テーブル名を返還したのを書く
	                         "LEFT JOIN perfume_images pi ON p.ID = pi.perfume_id " +
	                         "WHERE p.ID = ?";

	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setInt(1, p_id);
	            
	         // SQL文を実行し、結果表を取得する
	            
	            ResultSet rs = ps.executeQuery();
	            
	            
	            if (rs.next()) {
	                pinfo = new Perfume_log();

	                pinfo.setPerfume_img(rs.getString("perfume_img"));
	                pinfo.setBig_id(rs.getInt("big_id"));
	                pinfo.setSmall_id(rs.getInt("small_id"));
	            }

	            rs.close();
	            ps.close();

	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	            pinfo = null;
	        } finally {
	            if (conn != null) {
	                try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
	            }
	        }

	        return pinfo;
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
					+ "push_count, usage_scene, applied_area, top_note) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
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
			pStmt.setInt(1, plog.getId());
			
			pStmt.setInt(2, plog.getPerfume_id());

			if (plog.getTemperature() != null) {
				pStmt.setString(3, plog.getTemperature());
			} else {
				pStmt.setString(3, "");
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
			
			if (plog.getPush_count() != null) {
				pStmt.setString(6, plog.getPush_count());
			} else {
				pStmt.setString(6, "");
			}
			if (plog.getUsage_scene() != null) {
				pStmt.setString(7, plog.getUsage_scene());
			} else {
				pStmt.setString(7, "");
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
