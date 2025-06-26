package dto;

import java.io.Serializable;

public class Scrollbar_search implements Serializable {

	//▶　フィールド
	private int simpleMin;
	private int simpleMax;
	private int freshMin;
	private int freshMax;
	private int lightMin;
	private int lightMax;
	private int menMin;
	private int menMax;
	private int mildMin;
	private int mildMax;
	
	
	public Scrollbar_search() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}


	public Scrollbar_search(int simpleMin, int simpleMax, int freshMin, int freshMax, int lightMin, int lightMax, int menMin,
			int menMax, int mildMin, int mildMax) {
		super();
		this.simpleMin = simpleMin;
		this.simpleMax = simpleMax;
		this.freshMin = freshMin;
		this.freshMax = freshMax;
		this.lightMin = lightMin;
		this.lightMax = lightMax;
		this.menMin = menMin;
		this.menMax = menMax;
		this.mildMin = mildMin;
		this.mildMax = mildMax;
	}


	public int getSimpleMin() {
		return simpleMin;
	}


	public void setSimpleMin(int simpleMin) {
		this.simpleMin = simpleMin;
	}


	public int getSimpleMax() {
		return simpleMax;
	}


	public void setSimpleMax(int simpleMax) {
		this.simpleMax = simpleMax;
	}


	public int getFreshMin() {
		return freshMin;
	}


	public void setFreshMin(int freshMin) {
		this.freshMin = freshMin;
	}


	public int getFreshMax() {
		return freshMax;
	}


	public void setFreshMax(int freshMax) {
		this.freshMax = freshMax;
	}


	public int getLightMin() {
		return lightMin;
	}


	public void setLightMin(int lightMin) {
		this.lightMin = lightMin;
	}


	public int getLightMax() {
		return lightMax;
	}


	public void setLightMax(int lightMax) {
		this.lightMax = lightMax;
	}


	public int getMenMin() {
		return menMin;
	}


	public void setMenMin(int menMin) {
		this.menMin = menMin;
	}


	public int getMenMax() {
		return menMax;
	}


	public void setMenMax(int menMax) {
		this.menMax = menMax;
	}


	public int getMildMin() {
		return mildMin;
	}


	public void setMildMin(int mildMin) {
		this.mildMin = mildMin;
	}


	public int getMildMax() {
		return mildMax;
	}


	public void setMildMax(int mildMax) {
		this.mildMax = mildMax;
	}
	
}
