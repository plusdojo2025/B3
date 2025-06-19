package dto;

import java.io.Serializable;

public class Detail_category implements Serializable {
	private int id;
	private int big_id;
	private String genre;
	private  String detail;
	
    // 各フィールドのgetterとsetter
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
	public Detail_category(int id, int big_id, String genre, String detail) {
		super();
		this.id = id;
		this.big_id = big_id;
		this.genre = genre;
		this.detail = detail;
	}
	
}
