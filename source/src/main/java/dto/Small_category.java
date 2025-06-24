package dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class Small_category implements Serializable {
	private int id;
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
	
	
	public Small_category(int id, String genre, String detail, Timestamp created_at, Timestamp updated_at) {
		super();
		this.id = id;
		this.genre = genre;
		this.detail = detail;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public Small_category(String detail) {
		super();
		this.detail = detail;
	}
	
	
}
