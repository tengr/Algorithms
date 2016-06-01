package com.donriver.AustrianLotto;

/*this class is designed for ease of parsing input from files or stdin
*/
public class Data{
	public String drawing;
	public String[] picks;
	public int[] ret;
	public Data(String drawing, String[] picks) {
		this.drawing = drawing;
		this.picks = picks;
	}
	public Data(String drawing, String[] picks, int[] ret) {
		this(drawing, picks);
		this.ret = ret;
	}
}