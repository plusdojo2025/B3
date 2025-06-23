package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.Perfume_images;
import dto.Perfumes;
import dto.Scrollbar;

public class PerfumesDAO {

	// ▶ メソッド２｜ 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Perfumes pf,Scrollbar sb) {
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
			String sql_perfume = "INSERT INTO perfumes " +
	                "(perfume_name, brand_name, price, perfume_img, day, favourite, color, strength, created_at, updated_at) " +
	                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";
	        PreparedStatement pStmt = conn.prepareStatement(sql_perfume, Statement.RETURN_GENERATED_KEYS);

	        pStmt.setString(1, pf.getPerfume_name() != null ? pf.getPerfume_name() : "");
	        pStmt.setString(2, pf.getBrand_name() != null ? pf.getBrand_name() : "");
	        pStmt.setInt(3, pf.getPrice()); // Assuming price is never null
	        pStmt.setString(4, pf.getPerfume_img() != null ? pf.getPerfume_img() : "");
	        pStmt.setDate(5, pf.getDay() != null ? java.sql.Date.valueOf(pf.getDay()) : null);
	        pStmt.setBoolean(6, pf.getFavourite() != null && pf.getFavourite());
	        pStmt.setString(7, pf.getColor() != null ? pf.getColor() : "");
	        pStmt.setInt(8, pf.getStrength());

	        int affectedRows = pStmt.executeUpdate();
	        if (affectedRows == 0) {
	            throw new SQLException("Creating perfume failed, no rows affected.");
	        }

	        // Get generated perfume_id
	        int perfumeId = 0;
	        try (ResultSet generatedKeys = pStmt.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                perfumeId = generatedKeys.getInt(1);
	            } else {
	                throw new SQLException("Creating perfume failed, no ID obtained.");
	            }
	        }

	        // 2. Insert into scrollbar using perfume_id
	        String sql_scrollbar = "INSERT INTO scrollbar " +
	                "(perfume_id, simple_complex, fresh_sweet, light_heavy, male_women, mild_spicy, created_at, updated_at) " +
	                "VALUES (?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";
	        PreparedStatement pStmt2 = conn.prepareStatement(sql_scrollbar);
	        pStmt2.setInt(1, perfumeId);
	        pStmt2.setInt(2, sb.getSimple_complex());
	        pStmt2.setInt(3, sb.getFresh_sweet());
	        pStmt2.setInt(4, sb.getLight_heavy());
	        pStmt2.setInt(5, sb.getMale_women());
	        pStmt2.setInt(6, sb.getMild_spicy());

	        pStmt2.executeUpdate();
	        result = true;

	    } catch (SQLException | ClassNotFoundException e) {
	        e.printStackTrace();
	    } finally {
	        // Close DB connection
	        if (conn != null) {
	            try {
	                conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    return result;
	}

	public List<Perfumes> perfume_img() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	
	// 引数card指定された項目で検索して、取得されたデータのリストを返す     書き換え
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

	

//	// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
//	public boolean update(Perfumes pf) {
//			Connection conn = null;
//			boolean result = false;
//
//			try {
//				// JDBCドライバを読み込む
//				Class.forName("com.mysql.cj.jdbc.Driver");
//
//				// データベースに接続する
//				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b3?"
//						+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
//						"root", "password");
//
//				// SQL文を準備する
//				String sql = "UPDATE Bc SET company=?, department=?, position=?, "
//						+ "name=?, zipcode=?, address=?, phone=?, fax=?, email=?, remarks=? "
//						+ "WHERE number=?";
//				PreparedStatement pStmt = conn.prepareStatement(sql);
//			
//				// SQL文を完成させる
//				if (pf.getPerfume_name() != null) {
//					pStmt.setString(1, pf.getPerfume_name());
//				} else {
//					pStmt.setString(1, "");
//				}
//				if (pf.getBrand_name() != null) {
//					pStmt.setString(2, pf.getBrand_name());
//				} else {
//					pStmt.setString(2, "");
//				}	
//				if (pf.getPrice() != 0) {
//					pStmt.setInt(3, pf.getPrice());
//				} else {
//					pStmt.setString(3, "");
//				}
//				if (pf.getPerfume_img() != null) {
//					pStmt.setString(4, pf.getPerfume_img());
//				} else {
//					pStmt.setString(4, "");
//				}
//				if (pf.getDay() != null) {
//					pStmt.setString(5, pf.getDay());
//				} else {
//					pStmt.setString(5, "");
//				}
//				if (pf.getFavourite() != null) {
//					pStmt.setBoolean(6, result);
//				} else {
//					pStmt.setString(6, "");
//				}
//				if (pf.getColor() != null) {
//					pStmt.setString(7, pf.getColor());
//				} else {
//					pStmt.setString(7, "");
//				}
//				if (pf.getStrength() != 0) {
//					pStmt.setInt(8, pf.getStrength());
//				} else {
//					pStmt.setString(8, "");
//				}
//				if (pf.getSimple_complex() != 0) {
//					pStmt.setInt(9, pf.Simple_complex());
//				} else {
//					pStmt.setString(9, "");
//				}
//				if (pf.getFresh_sweet() != 0) {
//					pStmt.setInt(10, pf.Fresh_sweet());
//				} else {
//					pStmt.setString(10, "");
//				}
//				if (pf.getLight_heavy() != 0) {
//					pStmt.setInt(11, pf.Light_heavy());
//				} else {
//					pStmt.setString(11, "");
//				}
//				if (pf.getMale_women() != 0) {
//					pStmt.setInt(12, pf.Male_women());
//				} else {
//					pStmt.setString(12, "");
//				}
//				if (pf.getMild_spicy() != 0) {
//					pStmt.setInt(13, pf.Mild_spicy());
//				} else {
//					pStmt.setString(13, "");
//				}
//			}
//			return false;
//	}
}
