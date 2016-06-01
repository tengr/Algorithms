package com.donriver.AustrianLotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class AustrianLotto
{
	//constants
	public static final int NUM_DRAWS = 6;
	public static final int MIN = 1, MAX = 45;
	private static final String DELIMITER = " ";
	/**
	 * Process input from stdin
	 * Enter 'Q' any time to quit
	 * Can be further extended to process input from file        
	 */
	public static void main(String[] args){
		System.out.println("Welcome to Austrian Lotto.");
		Scanner sc = new Scanner(System.in);
		AustrianLotto austrianLotto = new AustrianLotto();
		while(true) {			
			System.out.println("please input drawing (six distinct numbers between 1 and 45, inclusive), Enter \"Q\" to quit:");
			System.out.println("format: 3 11 18 23 37 45");
			String line = sc.nextLine();
			if(line.equals("Q")) break;
			String drawing = line.trim();
			
			System.out.println("please input picks: (1 or more six number group separated by comma), Enter \"Q\" to quit:");
			System.out.println("format: 4 7 14 30 33 35, 1 11 12 25 37 38, 11 18 19 20 21 22");
			line = sc.nextLine();
			if(line.equals("Q")) break;
			String[] picks = line.trim().split(",");
			
			System.out.println("Evaluation Result: ");
			try {
				System.out.println(Arrays.toString(austrianLotto.evaluate(drawing, picks)));
			}
			catch (IllegalArgumentException iae){
				System.err.println(iae.getMessage());
			}
			catch (Exception e) {
				System.err.println("invalid input");
			}
			System.out.println("=========================================================================");
		}
		System.out.println("End of Austrian Lotto.");
		sc.close();
	}
	/**
	 * Returns an array of integers representing the evaluation result
	 * of a set of picks based on a particular drawing
	 * 
	 * @throws IllegalArgumentException  if drawing or any pick is invalid 
	 * @param  drawing                   string consists of numbers the drawing, separated by DELIMITER
	 * @param  picks                     an array of string, each representing a pick
	 * @return                           the evaluation result           
	 */
	public int[] evaluate(String drawing, String[] picks) throws IllegalArgumentException{	
		if(picks.length < 1 || picks.length > 50) throw new IllegalArgumentException("picks should contain between 1 and 50 elements, inclusive.");
		HashSet<Integer> drawingSet = new HashSet<Integer>(); //set containing all numbers in drawing
		int[] eval = new int[NUM_DRAWS + 1]; //return value
		for(int num : stringToIntArray(drawing)) {
			drawingSet.add(num);
		}
		for(String pick : picks) {
			evaluatePick(eval, drawingSet, pick.trim());	
		} 
		return eval;
	}
	
	/**
	 * Returns an array of integers from a string representing a pick or a drawing
	 * if the string is valid, i.e. 
	 * 1. it contains between 11 and 17 characters, inclusive
	 * 2  it contains no leading or trailing spaces
	 * 3. it contains the correct number of numbers, 
	 * 4. it contains all distinct numbers, 
	 * 5. all the numbers are within the correct range
	 * 
	 * @throws IllegalArgumentException  if string is invalid or having problem converting a substring to integer
	 * @param  s                         string consists of numbers in a pick or a drawing, separated by DELIMITER
	 * @return                           numbers in the string
	 */
	private int[] stringToIntArray(String s) throws IllegalArgumentException{
		if(s.length() < 11 || s.length() > 17 ) {
			throw new IllegalArgumentException(s + " should contain between 11 and 17 characters, inclusive");
		}
		if(s.startsWith(DELIMITER) || s.endsWith(DELIMITER)) {
			throw new IllegalArgumentException(s + " should contain no leading or trailing spaces");
		}
		String[] strArr = s.split(DELIMITER);
		if(strArr.length != NUM_DRAWS) {
			throw new IllegalArgumentException(s + " should contain " + NUM_DRAWS + " numbers instead of " + strArr.length);
		}
		
		int[] intArr = new int[NUM_DRAWS]; //integer array to return
		int idx = 0;
		int[] freq = new int[MAX + 1]; //frequency count for numbers in in the string
		for(String ss : strArr) {
			int num = Integer.parseInt(ss);
			//validate
			if(num < MIN || num > MAX) {
				throw new IllegalArgumentException(num + " is out of range in " + s);
			}
			if(freq[num] > 0) {
				throw new IllegalArgumentException(s + " has a duplicate " + num);
			}
			
			freq[num]++; //increase frequency count
			intArr[idx++] = num; //add number to result
		}

		return intArr;
	}

	/**
	 * Evaluate a pick, modify evaluation result in place
	 * @throws IllegalArgumentException  if pick is invalid
	 * @param  eval                      evaluation to be modified in place
	 * @param  drawingSet                set of drawings
	 * @param  pick                      a string consists of numbers in a pick
	 */
	private void evaluatePick(int eval[], HashSet<Integer> drawingSet, String pick) throws IllegalArgumentException{
		int countCorrect = 0;
		for(int num : stringToIntArray(pick)) {
			if(drawingSet.contains(num)) countCorrect++;
		}
		eval[countCorrect]++;
	}
}