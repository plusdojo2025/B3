package dto;

import java.io.Serializable;

public class Big_category implements Serializable {

    private int id;              
    private String sweet;           
    private String fresh;           
    private String spicyt;             
	private String relax;           

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
	public String getSpicyt() {
		return spicyt;
	}
	public void setSpicyt(String spicyt) {
		this.spicyt = spicyt;
	}
	public String getRelax() {
		return relax;
	}
	public void setRelax(String relax) {
		this.relax = relax;
	}
	
	
	public Big_category(int id, String sweet, String fresh, String spicyt, String relax) {
		super();
		this.id = id;
		this.sweet = sweet;
		this.fresh = fresh;
		this.spicyt = spicyt;
		this.relax = relax;
		
	}
}