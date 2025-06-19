package dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class Big_category implements Serializable {

    private int id;              
    private String sweet;           
    private String fresh;           
    private String spicy;             
	private String relax;           
    private Timestamp created_at;   
    private Timestamp updated_at;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSweet() {
		return sweet;
	}
	public void setSweet(String sweet) {
		this.sweet = sweet;
	}
	public String getFresh() {
		return fresh;
	}
	public void setFresh(String fresh) {
		this.fresh = fresh;
	}
	public String getSpicy() {
		return spicy;
	}
	public void setSpicy(String spicy) {
		this.spicy = spicy;
	}
	public String getRelax() {
		return relax;
	}
	public void setRelax(String relax) {
		this.relax = relax;
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
	
	public Big_category(int id, String sweet, String fresh, String spicy, String relax, Timestamp created_at,
			Timestamp updated_at) {
		super();
		this.id = id;
		this.sweet = sweet;
		this.fresh = fresh;
		this.spicy = spicy;
		this.relax = relax;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
    
}