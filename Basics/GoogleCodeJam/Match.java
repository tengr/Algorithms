package GoogleCodeJam;

import java.util.Scanner;

//Problem 2016 1B Problem B
public class Match {
	public static void main(String[] args) {
        Match ins = new Match();
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for(int i = 1; i <= testCase; i++) {
        	String[] res = ins.solve(sc.next(), sc.next());
        	System.out.println("Case #" + i + ": " + res[0] + " " + res[1]);
        }
        sc.close();
    }
	public long compare(String a, String b) {
		long compare = 0;
		for(int i = 0; i < a.length(); i++) {
			if(a.charAt(i) == b.charAt(i)) continue; //same, ? or digit
			else if(a.charAt(i) != '?' && b.charAt(i) != '?') compare = compare * 10  + a.charAt(i) - b.charAt(i);
		}
		return 0;
	}
	
	public String[] solveEqual(String a, String b){
		char[] coder = a.toCharArray();
		char[] jammer = b.toCharArray();
		for(int i = 0; i < coder.length; i++){
			if(coder[i] == '?' && jammer[i] == '?') coder[i] = jammer[i] = '0';
			else if(coder[i] == '?') coder[i] = jammer[i];
			else if(jammer[i] == '?') jammer[i] = coder[i];
		}
		String ret[] = new String[2];
		ret[0] = String.valueOf(coder);
		ret[1] = String.valueOf(jammer);
		return ret;
	}
	
	public boolean examineCompare(long compare) {
		if(compare < 0) compare = -compare;
		char[] compareChar = String.valueOf(compare).toCharArray();
		if(compareChar[0] <= '4') return true;
		else if(compareChar[0] >= '6') return false;
		for(int i = 1; i < compareChar.length; i++) {
			if(compareChar[i] != '0') return false;
		}
		return true;
	}
	
	public String[] solve(String a, String b){
		char[] coder = a.toCharArray();
		char[] jammer = b.toCharArray();
		long compare = compare(a,b);
		if(compare == 0) return solveEqual(a,b);
		else if(!examineCompare(compare)) compare = -compare;
		//equal is one way
		for(int i = 0; i < coder.length; i++) {
			if(coder[i] != '?' && jammer[i] != '?') continue;
			else if(coder[i] == '?' && jammer[i] == '?'){
				coder[i] = jammer[i] = '0';
			}
			else {
				if(compare < 0) {
					
				}
			}
		}
		
		
	}
		
}
