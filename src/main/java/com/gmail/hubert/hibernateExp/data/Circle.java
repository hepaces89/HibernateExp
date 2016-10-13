package com.gmail.hubert.hibernateExp.data;

public class Circle implements StorableShape{
	private String id;
	private double area;
	private int radius;
	
	public Circle(int radius){
		this.setRadius(radius);
		this.id = "circle"+System.currentTimeMillis();
	}
	
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
		this.area = Math.PI * Math.pow(radius, 2);
	}
	public String getId() {
		return id;
	}
	public double getArea() {
		return area;
	}
}
