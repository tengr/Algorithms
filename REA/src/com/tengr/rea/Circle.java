package com.tengr.rea;

public class Circle implements Shape{
	double R;
	public Circle(double R) {
		this.R = R;
	}
	@Override
	public double getArea() {
		return Math.PI * R * R;
	}

}
