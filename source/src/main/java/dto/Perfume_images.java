package dto;

import java.io.Serializable;

public class Perfume_images implements Serializable {
		//フィールド
	public class DetailCategoryDto {
	    private String genre;      
	    private Integer big_id; 
	    private String detail;
	    
	  //ゲッターセッター
		public String getGenre() {
			return genre;
		}
		public void setGenre(String genre) {
			this.genre = genre;
		}
		public Integer getBig_id() {
			return big_id;
		}
		public void setBig_id(Integer big_id) {
			this.big_id = big_id;
		}
		public String getDetail() {
			return detail;
		}
		public void setDetail(String detail) {
			this.detail = detail;
		}
		
		//コンストラクター
		public DetailCategoryDto(String genre, Integer big_id, String detail) {
			super();
			this.genre = genre;
			this.big_id = big_id;
			this.detail = detail;
		}
		public DetailCategoryDto() {
			super();
			// TODO 自動生成されたコンストラクター・スタブ
		}     
		
	}
}
		

