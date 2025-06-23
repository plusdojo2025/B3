package dto;

import java.io.Serializable;

public class Scrollbar implements Serializable {

	//▶　フィールド
	private int id;
	private int perfume_id;
	private int simple_complex;
	private int fresh_sweet;
	private int light_heavy;
	private int male_women;
	private int mild_spicy;
	private String created_at;
	private String updated_at;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPerfume_id() {
		return perfume_id;
	}
	public void setPerfume_id(int perfume_id) {
		this.perfume_id = perfume_id;
	}
	public int getSimple_complex() {
		return simple_complex;
	}
	public void setSimple_complex(int simple_complex) {
		this.simple_complex = simple_complex;
	}
	public int getFresh_sweet() {
		return fresh_sweet;
	}
	public void setFresh_sweet(int fresh_sweet) {
		this.fresh_sweet = fresh_sweet;
	}
	public int getLight_heavy() {
		return light_heavy;
	}
	public void setLight_heavy(int light_heavy) {
		this.light_heavy = light_heavy;
	}
	public int getMale_women() {
		return male_women;
	}
	public void setMale_women(int male_women) {
		this.male_women = male_women;
	}
	public int getMild_spicy() {
		return mild_spicy;
	}
	public void setMild_spicy(int mild_spicy) {
		this.mild_spicy = mild_spicy;
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
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	public Scrollbar(int id, int perfume_id, int simple_complex, int fresh_sweet, int light_heavy, int male_women,
			int mild_spicy, String created_at, String updated_at) {
		super();
		this.id = id;
		this.perfume_id = perfume_id;
		this.simple_complex = simple_complex;
		this.fresh_sweet = fresh_sweet;
		this.light_heavy = light_heavy;
		this.male_women = male_women;
		this.mild_spicy = mild_spicy;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	public Scrollbar() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public Scrollbar(int simple_complex, int fresh_sweet, int light_heavy, int male_women, int mild_spicy) {
		super();
		this.simple_complex = simple_complex;
		this.fresh_sweet = fresh_sweet;
		this.light_heavy = light_heavy;
		this.male_women = male_women;
		this.mild_spicy = mild_spicy;
	}

	
}
