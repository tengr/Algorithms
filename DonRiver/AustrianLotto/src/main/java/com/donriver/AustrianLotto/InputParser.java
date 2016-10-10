package com.donriver.AustrianLotto;
import java.util.ArrayList;
/**
 * This class is designed for processing input       
 */
public class InputParser {
	public static final int NUM_DRAWS = 6;
	public static final int MIN = 1, MAX = 45;
	private static final String DELIMITER = "\\s+";
	
	
	/**
	 * Returns a Data from parsing input
	 * @see com.donriver.AustrianLotto.Data
	 * When calling this method, all the input is assumed to be concatenated in a string in the order drawing, picks and (optional) eval
	 * The evaluation result field is optional, it will be populated in mode TEST, not in mode MAIN
	 * 
	 * @throws IllegalArgumentException  if drawing or any pick is invalid 
	 * @param  s                         input
	 * @param  parseMode                 parsing mode
	 * @return                           parsing result          
	 */
	public static Data parse(String s, ParseMode parseMode) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		addNumberFromString(s, numbers);
		
		String drawing = subListToString(numbers,0, AustrianLotto.NUM_DRAWS);
		
		if(parseMode == ParseMode.TEST) {
			int[] eval = new int[AustrianLotto.NUM_DRAWS + 1];
			//the last part of the input string would represent evaluation result
			for(int i = 0; i < eval.length; i++) eval[eval.length - 1 - i] = numbers.get(numbers.size() - 1 - i);
			
			String[] picks = subListToStringArray(numbers, AustrianLotto.NUM_DRAWS, numbers.size() - eval.length);
			return new Data(drawing, picks, eval);
		}
		else if(parseMode == ParseMode.MAIN) {
			String[] picks = subListToStringArray(numbers, AustrianLotto.NUM_DRAWS, numbers.size());
			return new Data(drawing, picks);
		}
		return null;
	}
	
	/**
	 * count the numbers contained in a string
	 * 
	 * @param  s                      String containing numbers
	 * @return                        count of total numbers in string
	 */
	public static int countNumberFromString(String s){
		ArrayList<Integer> temp = new ArrayList<Integer>();
		addNumberFromString(s, temp);
		return temp.size();
	}
	
	
	/**
	 * Returns an array of integers from a string representing a pick or a drawing
	 * if the string is valid, i.e. 
	 * 1. it contains the correct number of numbers, 
	 * 2. it contains all distinct numbers, 
	 * 3. all the numbers are within the correct range
	 * 
	 * @throws IllegalArgumentException  if string is invalid or having problem converting a substring to integer
	 * @param  s                         string consists of numbers in a pick or a drawing, separated by DELIMITER
	 * @return                           numbers in the string
	 */
	public static int[] parseNumberString(String s) throws IllegalArgumentException{
		String[] strArr = s.split(DELIMITER);
		if(strArr.length != NUM_DRAWS){
			throw new IllegalArgumentException(s + " should contain " + NUM_DRAWS + " numbers instead of " + strArr.length);
		} 
		
		int[] intArr = new int[NUM_DRAWS]; //integer array to return
		int idx = 0;
		int[] freq = new int[MAX + 1]; //frequency count for numbers in in the string
		for(String ss : strArr) {
			int num = Integer.parseInt(ss);
			//validate
			if(num < MIN || num > MAX) throw new IllegalArgumentException(num + " is out of range in " + s);
			if(freq[num] > 0) throw new IllegalArgumentException(s + " has a duplicate " + num);
			
			freq[num]++; //increase frequency count
			intArr[idx++] = num; //add number to result
		}

		return intArr;
	}
	
	/**
	 * Add all the numbers in String to an ArrayList
	 * Negative signs are ignored
	 * 
	 * @param  s                      String containing numbers
	 * @param  numbers                ArrayList to be modified in place
	 * @return                        an ArrayList containing all numbers in string
	 */
	private static ArrayList<Integer> addNumberFromString(String s) throws {
		int num = -1;
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(char c : s.toCharArray()){
			if(c <= '9' && c >= '0') {
				if(num == -1) num = c - '0';
				else num = num * 10 + (c - '0');
			}
			else {
				if(num != -1) {
					if(num < MIN || num > MAX) throw new IllegalArgumentException(num + " is out of range in " + s);
					nums.add(num);
				}
				num = -1;
			}
		}
		return nums;
	}
	
	/**
	 * Returns a String as a result of concatenating some numbers in an ArrayList, delimited by space
	 * 
	 * @throws IllegalArgumentException      if range is not specified correctly
	 * @param  start                         start index of the numbers (inclusive)
	 * @param  end                           end index the numbers (exclusive)
	 * @param  numbers                       ArrayList of numbers
	 */
	private static String subListToString(ArrayList<Integer> numbers, int start, int end) throws IllegalArgumentException{
		assert end - start == AustrianLotto.NUM_DRAWS : "invalid sublist range for a draw or pick";
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
	
	private static String[] subListToStringArray(ArrayList<Integer> numbers, int start, int end) {
		assert end - start > 0 && (end - start) % AustrianLotto.NUM_DRAWS == 0: "incorrect range specified for picks";
		String[] picks = new String[(end - start) / AustrianLotto.NUM_DRAWS];
		for(int i = 0; i < picks.length; i++) {
			picks[i] = subListToString(numbers, start+i*AustrianLotto.NUM_DRAWS,start+(i+1)*AustrianLotto.NUM_DRAWS);
		}
		return picks;
	}

}