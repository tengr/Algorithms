package com.tengr.utils;

public class BinaryTreePrinter {
	BinaryTree tree;
	public BinaryTreePrinter(String tr) {
		this.tree = new BinaryTree(tr);
	}
	public void print() {
		System.out.println(this.tree.toString());
	}
	
	public static void main(String[] args) {
		BinaryTreePrinter printer = new BinaryTreePrinter("[1,2,4,7,8,9,10,6,3]");
		printer.print();
	}
}
