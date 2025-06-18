package dto;

import java.io.Serializable;
import java.time.LocalTime;

public class Perfume_log implements Serializable {
	
	//▶　フィールド
    private int perfume_id;
    private float temperature;
    private String weather;
    private LocalTime applied_time;
    private int push_count;
    private String applied_area;
    private String top_note;
    
    //▶使用後記録
    private String middle_note;
    private String last_note;
    private String thoughts;
    
    
	//▶　ゲッターとセッター
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
	
	//▶　コンストラクタ（使用前）
	public Perfume_log(int perfume_id, float temperature, String weather,
			LocalTime applied_time, int push_count, String applied_area,
			String top_note) {
		this.perfume_id = perfume_id;
		this.temperature = temperature;
		this.weather = weather;
		this.applied_time = applied_time;
		this.push_count = push_count;
		this.applied_area = applied_area;
		this.top_note = top_note;		
	}
	
	//▶　コンストラクタ（使用後）
	public Perfume_log(int perfume_id, String middle_note, String last_note,
			String thoughts) {
		this.perfume_id = perfume_id;
		this.middle_note = middle_note;
		this.last_note = last_note;
		this.thoughts = thoughts;	
	}

	public Perfume_log() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}
    
	
	
    
}
