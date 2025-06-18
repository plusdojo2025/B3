package dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class Big_category implements Serializable {

    private int id;              
    private String sweet;           
    private String fresh;           
    private String spicyt;          
    private String relax;           
    private Timestamp created_at;   
    private Timestamp cupdated_at;  
    
    // 各フィールドのgetterとsetter
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

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getCupdated_at() {
        return cupdated_at;
    }

    public void setCupdated_at(Timestamp cupdated_at) {
        this.cupdated_at = cupdated_at;
    }

    // 引数ありコンストラクタ
    public Big_category(int id, String sweet, String fresh, String spicyt, String relax, Timestamp created_at, Timestamp cupdated_at) {
        super();
    	this.id = id;
        this.sweet = sweet;
        this.fresh = fresh;
        this.spicyt = spicyt;
        this.relax = relax;
        this.created_at = created_at;
        this.cupdated_at = cupdated_at;
    }

    public Big_category() {
    	super();
    }
}

