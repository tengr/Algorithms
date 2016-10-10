package com.donriver.AustrianLotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class AustrianLotto
{
	//constants
	public static final int NUM_DRAWS = 6;
	public static final int MIN = 1, MAX = 45;
	private static final String DELIMITER = "\\s+";
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
			StringBuilder input = new StringBuilder();
			
			System.out.println("please input drawing (six distinct numbers between 1 and 45, inclusive), Enter \"Q\" to quit:");
			System.out.println("format: \"3 11 18 23 37 45\" (quotation marks are optional)");
			String line = sc.nextLine();
			if(line.equals("Q")) break;
			else if(InputParser.countNumberFromString(line) != NUM_DRAWS) {
				System.err.println("needed " + NUM_DRAWS + " numbers for drawing\n");
			    continue;
			}
			input.append(line);
			
			System.out.println("please input picks: (1 or more six number group), Enter \"Q\" to quit:");
			System.out.println("format: {\"4 7 14 30 33 35\", \"1 11 12 25 37 38\", \"11 18 19 20 21 22\"} (quotation marks, commas and brackets are optional)");
			line = sc.nextLine();
			if(line.equals("Q")) break;
			else if(InputParser.countNumberFromString(line) == 0 || InputParser.countNumberFromString(line) % NUM_DRAWS != 0) {
				System.err.println("each pick needed + " + NUM_DRAWS + " numbers\n" );
			    continue;
			}
			input.append(" " + line);
			
			System.out.println("Evaluation Result: ");
			try {
				Data inputData = InputParser.parse(input.toString(), ParseMode.MAIN);
				System.out.println(Arrays.toString(austrianLotto.evaluate(inputData.drawing, inputData.picks)));
			}
			catch (Exception e) {
				e.getMessage();
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
		HashSet<Integer> drawingSet = new HashSet<Integer>(); //set containing all numbers in drawing
		int[] eval = new int[NUM_DRAWS + 1]; //return value
		for(int num : InputParser.stringToIntArray(drawing)) {
			drawingSet.add(num);
		}
		for(String pick : picks) {
			evaluatePick(eval, drawingSet, pick);	
		} 
		return eval;
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
		for(int num : InputParser.stringToIntArray(pick)) {
			if(drawingSet.contains(num)) countCorrect++;
		}
		eval[countCorrect]++;
	}
}