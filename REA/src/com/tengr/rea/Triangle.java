package com.tengr.rea;

public class Triangle implements Shape {
	double baseline;
	double height;
	
	public Triangle(double baseline, double height) {
		this.baseline = baseline;
		this.height = height;
	}
	@Override
	public double getArea() {
		return 0.5 * baseline * height; 
	}

}
