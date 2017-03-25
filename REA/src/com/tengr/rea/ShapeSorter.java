package com.tengr.rea;

import java.util.Arrays;

public class ShapeSorter {
	Shape[] shapes;
	public ShapeSorter() {
	}
	public ShapeSorter(Shape... shapes) {
		this.shapes = shapes;
	}
	
	public void sort(boolean verbose) {
		Arrays.sort(shapes, new ShapeComparator());
		if (verbose) System.out.println(this.toString());
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Shape shape: shapes) {
			sb.append(shape.getClass());
			sb.append(" ");
			sb.append(shape.getArea());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		ShapeSorter shapeSorter = new ShapeSorter(new Circle(3.0), 
					new Triangle(5.9, 2.89),
					new Square(6.21));
		shapeSorter.sort(true);
	}
	
	
	
}
