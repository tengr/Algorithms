package com.tengr.rea;

import java.util.Comparator;

public class ShapeComparator implements Comparator<Shape>{
	
	@Override
	public int compare(Shape shape1, Shape shape2) {
		return (int) (shape1.getArea() - shape2.getArea());
	}

}
