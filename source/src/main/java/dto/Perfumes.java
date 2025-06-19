package dto;

import java.io.Serializable;

public class Perfumes implements Serializable {

	//▶　フィールド
		private int id;
		private String perfume_name;
		private String brand_name;
		private int price;
		private String perfume_img;
		private String day;
		private Boolean favourite;
		private String color;
		private int strength;
		private String created_at;
		private String updated_at;
		private int simple_complex;
		private int fresh_sweet;
		private int light_heavy;
		private int male_women;
		private int mild_spicy;
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
		public String getDay() {
			return day;
		}
		public void setDay(String day) {
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
		public Perfumes(int id, String perfume_name, String brand_name, int price, String perfume_img, String day,
				Boolean favourite, String color, int strength, String created_at, String updated_at, int simple_complex,
				int fresh_sweet, int light_heavy, int male_women, int mild_spicy) {
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
			this.created_at = created_at;
			this.updated_at = updated_at;
			this.simple_complex = simple_complex;
			this.fresh_sweet = fresh_sweet;
			this.light_heavy = light_heavy;
			this.male_women = male_women;
			this.mild_spicy = mild_spicy;
		}
		
		
}