package dto;

import java.io.Serializable;

public class Perfume_log implements Serializable {
	
	//▶　フィールド
	//▶　基本情報
	private int id;
	//▶　使用前記録
    private int perfume_id;
    private String temperature;
    private String weather;
    private String applied_time;
    private String push_count;
    private String usage_scene;    
    private String applied_area;
    private String top_note;
    
    //▶使用後記録
    private String middle_note;
    private String last_note;
    private String thoughts;
    
    //▶日時
    private String created_at;
    private String updated_at;
    
    //▶他のdtoとの関連付け
    private String perfume_img;
    private int big_id;
    private int small_id;
    
    
	//▶　ゲッターとセッター	
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
	
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getApplied_time() {
		return applied_time;
	}
	public void setApplied_time(String applied_time) {
		this.applied_time = applied_time;
	}

	public String getPush_count() {
		return push_count;
	}
	public void setPush_count(String push_count) {
		this.push_count = push_count;
	}

	public String getUsage_scene() {
		return usage_scene;
	}
	public void setUsage_scene(String usage_scene) {
		this.usage_scene = usage_scene;
	}

	public String getApplied_area() {
		return applied_area;
	}
	public void setApplied_area(String applied_area) {
		this.applied_area = applied_area;
	}

	public String getTop_note() {
		return top_note;
	}
	public void setTop_note(String top_note) {
		this.top_note = top_note;
	}

	public String getMiddle_note() {
		return middle_note;
	}
	public void setMiddle_note(String middle_note) {
		this.middle_note = middle_note;
	}

	public String getLast_note() {
		return last_note;
	}
	public void setLast_note(String last_note) {
		this.last_note = last_note;
	}

	public String getThoughts() {
		return thoughts;
	}
	public void setThoughts(String thoughts) {
		this.thoughts = thoughts;
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
		
	public String getPerfume_img() {
		return perfume_img;
	}
	public void setPerfume_img(String perfume_img) {
		this.perfume_img = perfume_img;
	}
	
	public int getBig_id() {
		return big_id;
	}
	public void setBig_id(int big_id) {
		this.big_id = big_id;
	}
	
	public int getSmall_id() {
		return small_id;
	}
	public void setSmall_id(int small_id) {
		this.small_id = small_id;
	}
	
	//▶　コンストラクタ（画像とタグを持ってくる）
	public Perfume_log(int perfume_id, String perfume_img, int big_id, int small_id) {
		super();
		this.perfume_id = perfume_id;
		this.perfume_img = perfume_img;
		this.big_id = big_id;
		this.small_id = small_id;
	}
	
	//▶　コンストラクタ（使用前）
	public Perfume_log(int perfume_id, String temperature, String weather, String applied_time,
			String push_count, String usage_scene, String applied_area, String top_note) {
		super();
		this.perfume_id = perfume_id;
		this.temperature = temperature;
		this.weather = weather;
		this.applied_time = applied_time;
		this.push_count = push_count;
		this.usage_scene = usage_scene;
		this.applied_area = applied_area;
		this.top_note = top_note;
	}
	
	//▶　コンストラクタ（使用後）
//	public Perfume_log(int id, int perfume_id, String middle_note, String last_note, String thoughts) {
	// ↑idを引き継いだ場合
	public Perfume_log(int perfume_id, String middle_note, String last_note, String thoughts) {
		super();
//		this.id = id;
		this.perfume_id = perfume_id;
		this.middle_note = middle_note;
		this.last_note = last_note;
		this.thoughts = thoughts;
	}
	
	//▶　コンストラクタ（更新）
	public Perfume_log(int id, int perfume_id, String temperature, String weather, String applied_time,
			String push_count, String usage_scene, String applied_area, String top_note, String middle_note,
			String last_note, String thoughts) {
		super();
		this.id = id;
		this.perfume_id = perfume_id;
		this.temperature = temperature;
		this.weather = weather;
		this.applied_time = applied_time;
		this.push_count = push_count;
		this.usage_scene = usage_scene;
		this.applied_area = applied_area;
		this.top_note = top_note;
		this.middle_note = middle_note;
		this.last_note = last_note;
		this.thoughts = thoughts;
	}

	//▶　コンストラクタ（グラフ化）
	public Perfume_log(int id, int perfume_id) {
		super();
		this.id = id;
		this.perfume_id = perfume_id;
	}
	
	
	//▶　引数のないコンストラクタ
    public Perfume_log() {
		super();
	}

	
	

    
	
	
    
}
