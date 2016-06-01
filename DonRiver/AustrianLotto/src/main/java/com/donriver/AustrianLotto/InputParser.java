package com.donriver.AustrianLotto;
import java.util.ArrayList;
//this is a utility class for parsing input
public class InputParser {
	public static Data parse(String s, ParseMode parseMode) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		addAllNumbers(s, numbers);
		String drawing = subListToString(numbers,0, AustrianLotto.NUM_DRAWS);
		if(parseMode == ParseMode.TEST) { //no result array present
			int[] ret = new int[AustrianLotto.NUM_DRAWS + 1];
			for(int i = 0; i < ret.length; i++) ret[ret.length - 1 - i] = numbers.get(numbers.size() - 1 - i);
			String[] picks = subListToStringArray(numbers, AustrianLotto.NUM_DRAWS, numbers.size() - ret.length);
			return new Data(drawing, picks, ret);
		}
		else if(parseMode == ParseMode.MAIN) {
			String[] picks = subListToStringArray(numbers, AustrianLotto.NUM_DRAWS, numbers.size());
			return new Data(drawing, picks);
		}
		return null;
	}
	
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

	private static String subListToString(ArrayList<Integer> numbers, int start, int end) {
		StringBuilder sb = new StringBuilder();
		for(int i = start; i < end; i++) {
			sb.append(numbers.get(i) + " ");
		}
		return sb.toString().trim();
	}
	private static String[] subListToStringArray(ArrayList<Integer> numbers, int start, int end) {
		String[] picks = new String[(end - start) / AustrianLotto.NUM_DRAWS];
		for(int i = 0; i < picks.length; i++) {
			picks[i] = subListToString(numbers, start+i*AustrianLotto.NUM_DRAWS,start+(i+1)*AustrianLotto.NUM_DRAWS);
		}
		return picks;
	}

}