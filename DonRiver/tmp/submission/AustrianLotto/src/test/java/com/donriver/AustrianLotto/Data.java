package com.donriver.AustrianLotto;

/**
 * This class is designed for ease of processing input from file containing test cases
 * It bundles all input and output parameters of concern together.          
 */
public class Data{
	public String drawing;
	public String[] picks;
	public int[] eval;
	
	public Data(String drawing, String[] picks) {
		this.drawing = drawing;
		this.picks = picks;
	}
	public Data(String drawing, String[] picks, int[] eval) {
		this(drawing, picks);
		this.eval = eval;
	}
}