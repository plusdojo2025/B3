package dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class Detail_category implements Serializable {
	private int id;
	private int big_id;
	private String genre;
	private  String detail;
    private Timestamp created_at;
    private Timestamp updated_at;
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getBig_id() {
		return big_id;
	}
	public void setBig_id(int big_id) {
		this.big_id = big_id;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}
	public Timestamp getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}
	public Detail_category(int id, int big_id, String genre, String detail, Timestamp created_at,
			Timestamp updated_at) {
		super();
		this.id = id;
		this.big_id = big_id;
		this.genre = genre;
		this.detail = detail;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
   
}
