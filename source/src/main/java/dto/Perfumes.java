package dto;

import java.io.Serializable;

public class Perfumes implements Serializable {
	//フィールド
	private String name;
	private String brand;
	private String price;
	private String purchased_date;
	private String image;
	private String strength;
	private String color;
	private String complex;
	private String sweet;
	private String heavy;
	private String women;
	private String spicy;
	
	
	//ゲッターセッター
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPurchased_date() {
		return purchased_date;
	}
	public void setPurchased_date(String purchased_date) {
		this.purchased_date = purchased_date;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getStrength() {
		return strength;
	}
	public void setStrength(String strength) {
		this.strength = strength;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getComplex() {
		return complex;
	}
	public void setComplex(String complex) {
		this.complex = complex;
	}
	public String getSweet() {
		return sweet;
	}
	public void setSweet(String sweet) {
		this.sweet = sweet;
	}
	public String getHeavy() {
		return heavy;
	}
	public void setHeavy(String heavy) {
		this.heavy = heavy;
	}
	public String getWomen() {
		return women;
	}
	public void setWomen(String women) {
		this.women = women;
	}
	public String getSpicy() {
		return spicy;
	}
	public void setSpicy(String spicy) {
		this.spicy = spicy;
	}
	
	
	//コンストラクター
	public Perfumes(String name, String brand, String price, String purchased_date, String image, String strength,
			String color, String complex, String sweet, String heavy, String women, String spicy) {
		super();
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.purchased_date = purchased_date;
		this.image = image;
		this.strength = strength;
		this.color = color;
		this.complex = complex;
		this.sweet = sweet;
		this.heavy = heavy;
		this.women = women;
		this.spicy = spicy;
	}
	public Perfumes() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
}
