package dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Perfumes implements Serializable {

	//▶　フィールド
		private int id;
		private String perfume_name;
		private String brand_name;
		private int price;
		private String perfume_img;
		private LocalDate day;
		private Boolean favourite;
		private String color;
		private int strength;
		private String memo;
		private LocalDateTime created_at;
		private LocalDateTime updated_at;
		
		public Perfumes() {
			super();
			// TODO 自動生成されたコンストラクター・スタブ
		}
		public Perfumes(int id, String perfume_name, String brand_name, int price, String perfume_img, LocalDate day,
				Boolean favourite, String color, int strength, String memo, LocalDateTime created_at,
				LocalDateTime updated_at) {
			super();
			this.id = id;
			this.perfume_name = perfume_name;
			this.brand_name = brand_name;
			this.price = price;
			this.perfume_img = perfume_img;
			this.day = day;
			this.favourite = favourite;
			this.color = color;
			this.strength = strength;
			this.memo = memo;
			this.created_at = created_at;
			this.updated_at = updated_at;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getPerfume_name() {
			return perfume_name;
		}
		public void setPerfume_name(String perfume_name) {
			this.perfume_name = perfume_name;
		}
		public String getBrand_name() {
			return brand_name;
		}
		public void setBrand_name(String brand_name) {
			this.brand_name = brand_name;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public String getPerfume_img() {
			return perfume_img;
		}
		public void setPerfume_img(String perfume_img) {
			this.perfume_img = perfume_img;
		}
		public LocalDate getDay() {
			return day;
		}
		public void setDay(LocalDate day) {
			this.day = day;
		}
		public Boolean getFavourite() {
			return favourite;
		}
		public void setFavourite(Boolean favourite) {
			this.favourite = favourite;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public int getStrength() {
			return strength;
		}
		public void setStrength(int strength) {
			this.strength = strength;
		}
		public String getMemo() {
			return memo;
		}
		public void setMemo(String memo) {
			this.memo = memo;
		}
		public LocalDateTime getCreated_at() {
			return created_at;
		}
		public void setCreated_at(LocalDateTime created_at) {
			this.created_at = created_at;
		}
		public LocalDateTime getUpdated_at() {
			return updated_at;
		}
		public void setUpdated_at(LocalDateTime updated_at) {
			this.updated_at = updated_at;
		}
	



}
