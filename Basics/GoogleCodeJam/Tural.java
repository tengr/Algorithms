package GoogleCodeJam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
public class Tural{
	boolean isSorted(char[] ch){
		for(int i=0;i<ch.length-1;i++){
			if(ch[i]>ch[i+1])
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		Tural p = new Tural();
		String [] output = new String[T]; 
		for(int i=0;i<T;i++){
			String re  = p.getResString(sc.nextLine());
			char[] ca = re.toCharArray();
			if(!p.isSorted(ca)){
				System.out.println("False");
			}
			output[i] = String.format("Case #%d: %s",i+1 , re);
		}
		for(String s : output){
			System.out.println(s);
		}
	}
	String gNum = "";
	public boolean dfsutil(String str, String[] nums){
		if(str.equals("")) return true;
		for(String num: nums){
			if(lettersCon(str,num)){
				gNum += (num+"#");
				str = remove(str,num);
				boolean res = dfsutil(str,nums);
				if(res) return true;
				else{
					gNum = gNum.substring(0, gNum.length()-(num.length()+1));
					str = add(str,num);
				}
			}
			
		}
		return false;
	}
	
	
	public String getResString(String str){
		this.gNum = "";
		String[] nums = new String[]{"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};
		dfsutil(str, nums);
		String [] res =  this.gNum.split("#");
		HashMap<String,Integer> hm  = new HashMap<String,Integer>();
		hm.put("ZERO", 0);
		hm.put("ONE", 1);
		hm.put("TWO", 2);
		hm.put("THREE", 3);
		hm.put("FOUR", 4);
		hm.put("FIVE", 5);
		hm.put("SIX", 6);
		hm.put("SEVEN", 7);
		hm.put("EIGHT", 8);
		hm.put("NINE", 9);
		String resNum = "";
		for(String s: res){
			if(s.equals("")) continue;
			resNum += hm.get(s);
		}
		
		return resNum;
		
	}
	
	
	boolean lettersCon(String str, String num){
		char[] c = str.toCharArray();
		int [] sa = new int[26];
		char[] cc = num.toCharArray();
		
		for(char ch: cc )
			sa[ch-'A']++;
		
		for(char ch: c)
			sa[ch-'A']--;
		
		for(int i=0;i<sa.length;i++){
			if(sa[i]>0) return false;
		}
		
		return true;
		
		
		
	}
	
	String remove(String str, String num){
		char[] c = str.toCharArray();
		int [] sa = new int[26];
		for(char ch: c)
			sa[ch-'A']++;
		
		char[] cc = num.toCharArray();
		
		
		
		for(char ch: cc)
			sa[ch-'A']--;
		
		String res = "";
		for(int i=0;i<sa.length;i++){
			while(sa[i]>0){
				res+= String.valueOf((char)(i+'A'));
				sa[i]--;
			}
		}
		
		return res;
		
	}
	
	
	String add(String str, String num){
		char[] c = str.toCharArray();
		int [] sa = new int[26];
		for(char ch: c)
			sa[ch-'A']++;
		
		char[] cc = num.toCharArray();
		
		
		
		for(char ch: cc)
			sa[ch-'A']++;
		
		String res = "";
		for(int i=0;i<sa.length;i++){
			while(sa[i]>0){
				res+= String.valueOf((char)(i+'A'));
				sa[i]--;
			}
		}
		
		return res;
		
	}
	
	
	
}
