package dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class Big_category implements Serializable {

    private int id;              
    private String scent_type;                   
    private Timestamp created_at;   
    private Timestamp updated_at;
	public int getId() {
		return id;
	}
	public Big_category(int id, String scent_type, Timestamp created_at, Timestamp updated_at) {
		super();
		this.id = id;
		this.scent_type = scent_type;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getScent_type() {
		return scent_type;
	}
	public void setScent_type(String scent_type) {
		this.scent_type = scent_type;
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
    
    
}