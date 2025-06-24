package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.Perfumes;
import dto.Scrollbar;
import dto.Small_category;

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
			public List<Perfumes> select(Perfumes pfi) {
				Connection conn = null;
				List<Perfumes> pfmList = new ArrayList<>();
				try {
					// JDBCドライバを読み込む
					Class.forName("com.mysql.cj.jdbc.Driver");
					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b3?"
							+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
							"root", "password");

					// SQL文を準備する
					String sql = "SELECT perfume_name, brand_name"
							+ "FROM perfumes"
							+ "WHERE perfume_name LIKE ? AND brand_name LIKE ?";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					
					

					// SQL文を完成させる
					
					if (pfi.getPerfume_name() != null) {
						pStmt.setString(1, pfi.getPerfume_name());
					} else {
						pStmt.setNull(1,java.sql.Types.INTEGER );
					}
					if (pfi.getBrand_name() != null) {
						pStmt.setString(2, pfi.getBrand_name());
					} else {
						pStmt.setNull(2,java.sql.Types.INTEGER );
					}
					

					// SQL文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// 結果表をコレクションにコピーする
					while (rs.next()) {
						Perfumes perfumesrs = new Perfumes(
								rs.getString("perfume_name"),
								rs.getString("brand_name")
								);
						pfmList.add(perfumesrs);
					}
				} catch (SQLException e) {
					e.printStackTrace();
					pfmList = null;
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					pfmList = null;
				} finally {
					// データベースを切断
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException e) {
							e.printStackTrace();
							pfmList = null;
						}
					}
				}

				// 結果を返す
				return pfmList;
			}

	
			// 引数card指定された項目で検索して、取得されたデータのリストを返す     書き換え
						public List<Small_category> select(Small_category pfi) {
							Connection conn = null;
							List<Small_category> scList = new ArrayList<>();
							try {
								// JDBCドライバを読み込む
								Class.forName("com.mysql.cj.jdbc.Driver");
								// データベースに接続する
								conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b3?"
										+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
										"root", "password");

								// SQL文を準備する
								String sql = "SELECT detail"
										+ "FROM small_category"
										+ "WHERE detail LIKE ?";
								PreparedStatement pStmt = conn.prepareStatement(sql);
								
								

								// SQL文を完成させる
								
								if (pfi.getDetail() != null) {
									pStmt.setString(1, pfi.getDetail());
								} else {
									pStmt.setNull(1,java.sql.Types.INTEGER );
								}
								

								// SQL文を実行し、結果表を取得する
								ResultSet rs = pStmt.executeQuery();

								// 結果表をコレクションにコピーする
								while (rs.next()) {
									Small_category small_categoryrs = new Small_category(
											rs.getString("Detail")
											
											);
									scList.add(small_categoryrs);
								}
							} catch (SQLException e) {
								e.printStackTrace();
								scList = null;
							} catch (ClassNotFoundException e) {
								e.printStackTrace();
								scList = null;
							} finally {
								// データベースを切断
								if (conn != null) {
									try {
										conn.close();
									} catch (SQLException e) {
										e.printStackTrace();
										scList = null;
									}
								}
							}

							// 結果を返す
							return scList;
						}
						
						
						// 引数card指定された項目で検索して、取得されたデータのリストを返す     書き換え
						public List<Scrollbar> select(Scrollbar pfi) {
							Connection conn = null;
							List<Scrollbar> sbList = new ArrayList<>();
							try {
								// JDBCドライバを読み込む
								Class.forName("com.mysql.cj.jdbc.Driver");
								// データベースに接続する
								conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/b3?"
										+ "characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B9&rewriteBatchedStatements=true",
										"root", "password");

								// SQL文を準備する
								String sql = "SELECT simple_complex, fresh_sweet, light_heavy, male_women, mild_spicy"
										+ "FROM scrollbar"
										+ "WHERE simple_complex LIKE ? AND fresh_sweet LIKE ? AND light_heavy LIKE ? AND male_women LIKE ? AND mild_spicy LIKE ?";
								PreparedStatement pStmt = conn.prepareStatement(sql);
								
								

								// SQL文を完成させる
								
								if (pfi.getSimple_complex() != 0) {
									pStmt.setInt(1, pfi.getSimple_complex());
								} else {
									pStmt.setNull(1,java.sql.Types.INTEGER );
								}
								if (pfi.getFresh_sweet() != 0) {
									pStmt.setInt(2, pfi.getFresh_sweet());
								} else {
									pStmt.setNull(2,java.sql.Types.INTEGER );
								}
								if (pfi.getLight_heavy() != 0) {
									pStmt.setInt(3, pfi.getLight_heavy());
								} else {
									pStmt.setNull(3,java.sql.Types.INTEGER );
								}
								if (pfi.getMale_women() != 0) {
									pStmt.setInt(4, pfi.getMale_women());
								} else {
									pStmt.setNull(4,java.sql.Types.INTEGER );
								}
								if (pfi.getMild_spicy() != 0) {
									pStmt.setInt(5, pfi.getMild_spicy());
								} else {
									pStmt.setNull(5,java.sql.Types.INTEGER );
								}
								

								// SQL文を実行し、結果表を取得する
								ResultSet rs = pStmt.executeQuery();

								// 結果表をコレクションにコピーする
								while (rs.next()) {
									Scrollbar scrollbarrs = new Scrollbar(
											rs.getInt("simple_complex"),
											rs.getInt("fresh_sweet"),
											rs.getInt("light_heavy"),
											rs.getInt("male_women"),
											rs.getInt("mild_spicy")
											);
									sbList.add(scrollbarrs);
								}
							} catch (SQLException e) {
								e.printStackTrace();
								sbList = null;
							} catch (ClassNotFoundException e) {
								e.printStackTrace();
								sbList = null;
							} finally {
								// データベースを切断
								if (conn != null) {
									try {
										conn.close();
									} catch (SQLException e) {
										e.printStackTrace();
										sbList = null;
									}
								}
							}

							// 結果を返す
							return sbList;
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
