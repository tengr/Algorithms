package LeetCodeJava;

import java.util.Arrays;

public class WallsandGates {
	public class Solution {
	    public void wallsAndGates(int[][] rooms) {
	        int rowCount = 0, colCount = 0;
	        if(rooms == null || (rowCount = rooms.length) == 0 || (colCount = rooms[0].length) == 0) return;
	        for(int i = 0; i < rowCount; i++)
	            for(int j = 0; j < colCount; j++)
	                if(rooms[i][j] == 0) {System.out.println("main");dfs(rooms, i, j, rowCount, colCount, -1);}
	    }
	    public void dfs(int[][] rooms, int row, int col, int rowCount, int colCount, int dist) {
	        if(row < 0 || col < 0 || row > rowCount-1 || col > colCount-1 || rooms[row][col] <= dist) return;
	        System.out.println("dfs start visiting " + row + " " + col);
	        for(int i = 0; i < rowCount; i++) System.out.println(Arrays.toString(rooms[i]));
	        System.out.println("===============================");
	        dist++;
	        rooms[row][col] = dist;
	        dfs(rooms, row+1, col, rowCount, colCount, dist);
	        dfs(rooms, row-1, col, rowCount, colCount, dist);
	        dfs(rooms, row, col+1, rowCount, colCount, dist);
	        dfs(rooms, row, col-1, rowCount, colCount, dist);
	        for(int i = 0; i < rowCount; i++) System.out.println(Arrays.toString(rooms[i]));
	        System.out.println("===============================");
	        System.out.println("dfs finish visiting " + row + " " + col);
	    }
	}
}
