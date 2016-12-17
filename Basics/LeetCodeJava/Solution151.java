package LeetCodeJava;
public class Solution151 {
	public static void main(String[] args) {
		Solution151 ins = new Solution151();
		//char[] test = {'a','b','c',' ', 'd'};
		//ins.reverse(test,0,4);
		//System.out.println(new String(test));
		System.out.println(ins.reverseWords("a"));
		System.out.println(ins.reverseWords(" aa bde   cdf g "));
	}
    public String reverseWords(String s) {
        if(s == null) return null;
        if(s.length() == 0) return "";
        char[] data = s.toCharArray();
        reverse(data, 0, data.length - 1);
        int count = 0; 
        for(int i = 0, j = 0, start = -1; i <= data.length; i++) {
            if(i == data.length || data[i] == ' ') {
                if(start != -1) {                	
                    reverse(data, start, j-1);
                    count += j - start;
                    if(i != data.length){ 
                    		count++;
                    		data[j++] = ' ';
                    }
                    start = -1;
                }
            }
            else {
                if(start == -1) start = j;
                data[j++] = data[i];
            }
        }
        if(count == 0) return "";
        return new String(data, 0, count);
    }
    public void reverse(char[] data, int start, int end) {
        while(start < end) {
            char temp = data[start];
            data[start] = data[end];
            data[end] = temp;
            start++;
            end--;
        }
    }
}