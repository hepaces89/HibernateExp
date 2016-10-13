package com.gmail.hubert.hibernateExp.data;

public class Square implements StorableShape {
	private String id;
	private double area;
	private int sideLength;
	
	public Square(int sideLength){
		this.setSideLength(sideLength);
		this.id = "sq"+System.currentTimeMillis();
	}
	
	public String getId() {
		return id;
	}
	public double getArea() {
		return area;
	}
	public int getSideLength() {
		return sideLength;
	}
	public void setSideLength(int sideLength) {
		this.sideLength = sideLength;
		this.area = this.sideLength * this.sideLength;
	}
}
