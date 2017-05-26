package com.tengr.utils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	String[] nodes;
	public BinaryTree(String tree) {
		nodes = tree.split("\\W+");
		if (nodes.length == 0) {
			System.out.println("please input some nodes");
		}
		TreeNode root = new TreeNode(nodes[0]);
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		for(int i = 1; i < nodes.length;) {
			int size = q.size();
			for(int j = 0; j < size; j++) {
				TreeNode n = q.poll();
				if(!nodes[i].equals("null")) {
					n.left = new TreeNode(nodes[i]);
					q.offer(n.left);
				}
				i++;
				if(i == nodes.length) return;
				if(!nodes[i].equals("null")) {
					n.right = new TreeNode(nodes[i]);
					q.offer(n.right);
				}
				i++;
				if(i == nodes.length) return;
			}
			
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(String node : nodes) sb.append(node  + " ");
		return sb.toString();
	}

	class TreeNode{
		TreeNode left;
		TreeNode right;
		String o;
		TreeNode(String o) {this.o = o;}
	}
}
