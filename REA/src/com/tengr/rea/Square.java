package com.tengr.rea;

public class Square implements Shape{
	double size;
	public Square(double size) {
		this.size = size;
	}
	@Override
	public double getArea() {
		return size * size;
	}
	
}
