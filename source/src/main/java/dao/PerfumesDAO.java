package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


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
			String sql = "INSERT INTO Perfumes VALUES ( 0, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる
			if (pf.getPerfume_name() != null) {
				pStmt.setString(1, pf.getPerfume_name());
			} else {
				pStmt.setString(1, "");
			}
			if (pf.getBrand_name() != null) {
				pStmt.setString(2, pf.getBrand_name());
			} else {
				pStmt.setString(2, "");
			}
			if (pf.getPrice() != 0) {
				pStmt.setInt(3, pf.getPrice());
			} else {
				pStmt.setString(3, "");
			}
			if (pf.getPerfume_img() != null) {
				pStmt.setString(4, pf.getPerfume_img());
			} else {
				pStmt.setString(4, "");
			}
			if (pf.getDay() != null) {
				pStmt.setString(5, pf.getDay());
			} else {
				pStmt.setString(5, "");
			}
			if (pf.getFavourite() != null) {
				pStmt.setBoolean(6, result);
			} else {
				pStmt.setString(6, "");
			}
			if (pf.getColor() != null) {
				pStmt.setString(7, pf.getColor());
			} else {
				pStmt.setString(7, "");
			}
			if (pf.getStrength() != 0) {
				pStmt.setInt(8, pf.getStrength());
			} else {
				pStmt.setString(8, "");
			}
			if (sb.getSimple_complex() != 0) {
				pStmt.setInt(9, sb.getSimple_complex());
			} else {
				pStmt.setString(9, "");
			}
			if (sb.getFresh_sweet() != 0) {
				pStmt.setInt(10, sb.getFresh_sweet());
			} else {
				pStmt.setString(10, "");
			}
			if (sb.getLight_heavy() != 0) {
				pStmt.setInt(11, sb.getLight_heavy());
			} else {
				pStmt.setString(11, "");
			}
			if (sb.getMale_women() != 0) {
				pStmt.setInt(12, sb.getMale_women());
			} else {
				pStmt.setString(12, "");
			}
			if (sb.getMild_spicy() != 0) {
				pStmt.setInt(13, sb.getMild_spicy());
			} else {
				pStmt.setString(13, "");
			}
			
			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		 catch (SQLException e) {
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
	public boolean update(Perfumes pf) {
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
				String sql = "UPDATE Bc SET company=?, department=?, position=?, "
						+ "name=?, zipcode=?, address=?, phone=?, fax=?, email=?, remarks=? "
						+ "WHERE number=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
			
				// SQL文を完成させる
				if (pf.getPerfume_name() != null) {
					pStmt.setString(1, pf.getPerfume_name());
				} else {
					pStmt.setString(1, "");
				}
				if (pf.getBrand_name() != null) {
					pStmt.setString(2, pf.getBrand_name());
				} else {
					pStmt.setString(2, "");
				}	
				if (pf.getPrice() != 0) {
					pStmt.setInt(3, pf.getPrice());
				} else {
					pStmt.setString(3, "");
				}
				if (pf.getPerfume_img() != null) {
					pStmt.setString(4, pf.getPerfume_img());
				} else {
					pStmt.setString(4, "");
				}
				if (pf.getDay() != null) {
					pStmt.setString(5, pf.getDay());
				} else {
					pStmt.setString(5, "");
				}
				if (pf.getFavourite() != null) {
					pStmt.setBoolean(6, result);
				} else {
					pStmt.setString(6, "");
				}
				if (pf.getColor() != null) {
					pStmt.setString(7, pf.getColor());
				} else {
					pStmt.setString(7, "");
				}
				if (pf.getStrength() != 0) {
					pStmt.setInt(8, pf.getStrength());
				} else {
					pStmt.setString(8, "");
				}
				if (pf.getSimple_complex() != 0) {
					pStmt.setInt(9, pf.Simple_complex());
				} else {
					pStmt.setString(9, "");
				}
				if (pf.getFresh_sweet() != 0) {
					pStmt.setInt(10, pf.Fresh_sweet());
				} else {
					pStmt.setString(10, "");
				}
				if (pf.getLight_heavy() != 0) {
					pStmt.setInt(11, pf.Light_heavy());
				} else {
					pStmt.setString(11, "");
				}
				if (pf.getMale_women() != 0) {
					pStmt.setInt(12, pf.Male_women());
				} else {
					pStmt.setString(12, "");
				}
				if (pf.getMild_spicy() != 0) {
					pStmt.setInt(13, pf.Mild_spicy());
				} else {
					pStmt.setString(13, "");
				}
			}
			return false;
	}
}
