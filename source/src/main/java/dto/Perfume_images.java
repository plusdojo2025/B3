package dto;

import java.io.Serializable;

public class Perfume_images implements Serializable {
		//フィールド
		private Integer perfume_id;       
	    private Integer big_id;
	    private Integer small_id; 
	    private String created_at;
	    private String updated_at;
	    
	  //ゲッターセッター
		public Integer getPerfume_id() {
			return perfume_id;
		}
		public void setPerfume_id(Integer perfume_id) {
			this.perfume_id = perfume_id;
		}
		public Integer getBig_id() {
			return big_id;
		}
		public void setBig_id(Integer big_id) {
			this.big_id = big_id;
		}
		public Integer getSmall_id() {
			return small_id;
		}
		public void setSmall_id(Integer small_id) {
			this.small_id = small_id;
		}
		public String getCreated_at() {
			return created_at;
		}
		public void setCreated_at(String created_at) {
			this.created_at = created_at;
		}
		public String getUpdated_at() {
			return updated_at;
		}
		public Perfume_images(Integer perfume_id, Integer big_id, Integer small_id) {
			super();
			this.perfume_id = perfume_id;
			this.big_id = big_id;
			this.small_id = small_id;
		}
		public Perfume_images(Integer perfume_id, Integer big_id, Integer small_id, String created_at,
				String updated_at) {
			super();
			this.perfume_id = perfume_id;
			this.big_id = big_id;
			this.small_id = small_id;
			this.created_at = created_at;
			this.updated_at = updated_at;
		}
		public Perfume_images() {
			super();
			// TODO 自動生成されたコンストラクター・スタブ
		}
		
		
		
	}	
		

		

