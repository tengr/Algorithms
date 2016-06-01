package com.donriver.AustrianLotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class AustrianLotto
{
	public static final int NUM_DRAWS = 6;
	public static final int MIN = 1, MAX = 45;
	private static final String WHITESPACE = "\\s+";

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
			input.append(line);
			System.out.println("please input picks: (1 or more six number group), Enter \"Q\" to quit:");
			System.out.println("format: {\"4 7 14 30 33 35\", \"1 11 12 25 37 38\", \"11 18 19 20 21 22\"} (quotation marks, commas and brackets are optional)");
			line = sc.nextLine();
			if(line.equals("Q")) break;
			input.append(" ");
			input.append(line);
			Data inputData = InputParser.parse(input.toString(), ParseMode.MAIN);
			System.out.println("Evaluation Result: ");
			try {
				System.out.println(Arrays.toString(austrianLotto.evaluate(inputData.drawing, inputData.picks)));
			}
			catch (InvalidInputException e){
				System.err.println(e.getMessage());
			}
			System.out.println("=========================================================================");
		}
		System.out.println("End of Austrian Lotto.");
		sc.close();
	}

	public int[] evaluate(String drawing, String[] picks) throws InvalidInputException{	
		HashSet<Integer> drawingSet = new HashSet<Integer>();
		int[] ret = new int[NUM_DRAWS + 1]; //return
		for(int num : stringToIntArray(drawing)) {
			drawingSet.add(num);
		}
		for(String pick : picks) {
			evaluatePick(ret, drawingSet, pick);	
		} 
		return ret;
	}
	/* split string by whitespace 
	@return int array with all the nubmers in the string
	*/
	private int[] stringToIntArray(String s) throws InvalidInputException{
		String[] strArr = s.split(WHITESPACE);
		if(strArr.length != NUM_DRAWS){
			throw new InvalidInputException(s + " should contain " + NUM_DRAWS + " numbers instead of " + strArr.length);
		} 
		
		int[] intArr = new int[NUM_DRAWS]; //integer array to return
		int idx = 0;
		int[] freq = new int[MAX + 1]; //frequency count for numbers in in the string
		for(String ss : strArr) {
			int num = 0;
			num = Integer.parseInt(ss);
			if(num < MIN || num > MAX) throw new InvalidInputException(num + " is out of range in " + s);
			if(freq[num] > 0) throw new InvalidInputException(s + " has a duplicate " + num);
			freq[num]++;
			intArr[idx++] = num;
		}

		return intArr;
	}

	private void evaluatePick(int ret[], HashSet<Integer> drawingSet, String pick) throws InvalidInputException{
		int countCorrect = 0;
		for(int num : stringToIntArray(pick)) {
			if(drawingSet.contains(num)) countCorrect++;
		}
		ret[countCorrect]++;
	}
}