package com.donriver.AustrianLotto;
import java.util.ArrayList;
/**
 * This class is designed for processing input in test case file   
 */
public class InputParser {
	/**
	 * Returns a Data from parsing a test case in test case file
	 * @see com.donriver.AustrianLotto.Data
	 * All the input is assumed to be concatenated in a string in the order drawing, picks and eval
	 * 
	 * @throws IllegalArgumentException  if drawing or any pick is invalid 
	 * @param  s                         input
	 * @return                           parsing result          
	 */
	public static Data parse(String s) throws IllegalArgumentException{
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		addAllNumbers(s, numbers);
		
		String drawing = subListToString(numbers,0, AustrianLotto.NUM_DRAWS);
		int[] eval = new int[AustrianLotto.NUM_DRAWS + 1];
		//the last part of the input string would represent evaluation result
		for(int i = 0; i < eval.length; i++) eval[eval.length - 1 - i] = numbers.get(numbers.size() - 1 - i);
		String[] picks = subListToStringArray(numbers, AustrianLotto.NUM_DRAWS, numbers.size() - eval.length);
		return new Data(drawing, picks, eval);
	}
	/**
	 * Add all the numbers in String to an ArrayList
	 * 
	 * @param  s                      String containing numbers
	 * @param  numbers                ArrayList to be modified in place
	 */
	private static void addAllNumbers(String s, ArrayList<Integer> numbers) {
		int num = -1;
		for(char c : s.toCharArray()){
			if(c <= '9' && c >= '0') {
				if(num == -1) num = c - '0';
				else num = num * 10 + (c - '0');
			}
			else {
				if(num != -1) numbers.add(num);
				num = -1;
			}
		}
	}
	
	/**
	 * Returns a String as a result of concatenating some numbers in an ArrayList, delimited by space
	 * 
	 * @throws IllegalArgumentException  if range is not specified correctly
	 * @param  start                         start index of the numbers (inclusive)
	 * @param  end                           end index the numbers (exclusive)
	 * @param  numbers                       ArrayList of numbers
	 */
	private static String subListToString(ArrayList<Integer> numbers, int start, int end) throws IllegalArgumentException{
		if((end - start) % AustrianLotto.NUM_DRAWS != 0) throw new IllegalArgumentException("incorrect range specified, invalid input");
		StringBuilder sb = new StringBuilder();
		for(int i = start; i < end; i++) {
			sb.append(numbers.get(i) + " ");
		}
		return sb.toString().trim();
	}
	
	/**
	 * Returns an array of Strings, each of which a result of concatenating some numbers in an ArrayList, delimited by space
	 * 
	 * @param  start                  start index (inclusive)
	 * @param  end                    end index (exclusive)
	 * @param  numbers                ArrayList of numbers
	 */
	
	private static String[] subListToStringArray(ArrayList<Integer> numbers, int start, int end) throws IllegalArgumentException{
		String[] picks = new String[(end - start) / AustrianLotto.NUM_DRAWS];
		for(int i = 0; i < picks.length; i++) {
			picks[i] = subListToString(numbers, start+i*AustrianLotto.NUM_DRAWS,start+(i+1)*AustrianLotto.NUM_DRAWS);
		}
		return picks;
	}

}