package dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalTime;

public class Perfume_log implements Serializable {
	
	//▶　フィールド
	//▶　基本情報
	private int id;
	private int user_id;
	//▶　使用前記録
    private int perfume_id;
    private float temperature;
    private String weather;
    private LocalTime applied_time;
    private int push_count;
    private int usage_scene;    
    private String applied_area;
    private String top_note;
    
    //▶使用後記録
    private String middle_note;
    private String last_note;
    private String thoughts;
    
    //▶日時
    private Timestamp created_at;
    private Timestamp updated_at;
    
    
	//▶　ゲッターとセッター
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public int getPerfume_id() {
		return perfume_id;
	}
	public void setPerfume_id(int perfume_id) {
		this.perfume_id = perfume_id;
	}

	public float getTemperature() {
		return temperature;
	}
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}

	public LocalTime getApplied_time() {
		return applied_time;
	}
	public void setApplied_time(LocalTime applied_time) {
		this.applied_time = applied_time;
	}
	
	public int getPush_count() {
		return push_count;
	}
	public void setPush_count(int push_count) {
		this.push_count = push_count;
	}

	public int getUsage_scene() {
		return usage_scene;
	}
	public void setUsage_scene(int usage_scene) {
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
	
	//▶　コンストラクタ（使用前）
	public Perfume_log(int id, int user_id, int perfume_id, float temperature, String weather, LocalTime applied_time,
			int push_count, int usage_scene, String applied_area, String top_note, Timestamp created_at,
			Timestamp updated_at) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.perfume_id = perfume_id;
		this.temperature = temperature;
		this.weather = weather;
		this.applied_time = applied_time;
		this.push_count = push_count;
		this.usage_scene = usage_scene;
		this.applied_area = applied_area;
		this.top_note = top_note;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	//▶　コンストラクタ（使用後）
	public Perfume_log(int id, int user_id, int perfume_id, String middle_note, String last_note, String thoughts,
			Timestamp created_at, Timestamp updated_at) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.perfume_id = perfume_id;
		this.middle_note = middle_note;
		this.last_note = last_note;
		this.thoughts = thoughts;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	//▶　引数のないコンストラクタ
    public Perfume_log() {
		super();
	}
	

    
	
	
    
}
