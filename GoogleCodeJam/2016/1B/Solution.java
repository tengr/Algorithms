import java.util.Scanner;

public class Remove {
    public static void main(String[] args) {
        Remove ins = new Remove();
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        for(int i = 1; i <= testCase; i++) System.out.println("Case #" + i + ": " + ins.solve(sc.next()));
        sc.close();
    }
    public String solve(String s){
        int[] freq = new int[26];
        int[] count = new int[10];
        for(int i = 0; i < s.length(); i++) freq[s.charAt(i) - 'A']++;
        count[2] = removeTwo(freq, count);
        count[6] = removeSix(freq, count);
        count[7] = removeSeven(freq, count);
        count[5] = removeFive(freq, count);
        count[4] = removeFour(freq, count);
        count[3] = removeThree(freq, count);
        count[1] = removeOne(freq, count);
        count[9] = removeNine(freq, count);
        count[8] = removeEight(freq, count);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= 9; i++) if(count[i] > 0) {
            for(int j = 0; j < count[i]; j++) sb.append(i);
        }
        return sb.toString();
    }
    
    public int removeTwo(int[] freq, int[] count){
        int wCount = freq['W' - 'A'];
        if(wCount == 0) return 0;
        freq['T'-'A'] -= wCount;
        freq['W'-'A'] -= wCount;
        freq['O'-'A'] -= wCount;
        return wCount;
    }
    
    public int removeSix(int[] freq, int[] count){
        int xCount = freq['X' - 'A'];
        if(xCount == 0) return 0;
        freq['S'-'A'] -= xCount;
        freq['I'-'A'] -= xCount;
        freq['X'-'A'] -= xCount;
        return xCount;
    }
    
    public int removeSeven(int[] freq, int[] count){
        int sCount = freq['S' - 'A'];
        if(sCount == 0) return 0;
        freq['S'-'A'] -= sCount;
        freq['E'-'A'] -= sCount;
        freq['V'-'A'] -= sCount;
        freq['E'-'A'] -= sCount;
        freq['N'-'A'] -= sCount;
        return sCount;
    }
    
    public int removeFive(int[] freq, int[] count){
        int vCount = freq['V' - 'A'];
        if(vCount == 0) return 0;
        freq['F'-'A'] -= vCount;
        freq['I'-'A'] -= vCount;
        freq['V'-'A'] -= vCount;
        freq['E'-'A'] -= vCount;
        return vCount;
    }
    
    public int removeFour(int[] freq, int[] count){
        int fCount = freq['F' - 'A'];
        if(fCount == 0) return 0;
        freq['F'-'A'] -= fCount;
        freq['O'-'A'] -= fCount;
        freq['U'-'A'] -= fCount;
        freq['R'-'A'] -= fCount;
        return fCount;
    }
    public int removeThree(int[] freq, int[] count){
        int rCount = freq['R' - 'A'];
        if(rCount == 0) return 0;
        freq['T'-'A'] -= rCount;
        freq['H'-'A'] -= rCount;
        freq['R'-'A'] -= rCount;
        freq['E'-'A'] -= rCount;
        freq['E'-'A'] -= rCount;
        return rCount;
    }
    public int removeOne(int[] freq, int[] count){
        int oCount = freq['O' - 'A'];
        if (oCount == 0) return 0;
        freq['O'-'A'] -= oCount;
        freq['N'-'A'] -= oCount;
        freq['E'-'A'] -= oCount;
        return oCount;
    }
    public int removeNine(int[] freq, int[] count){
        int nCount = freq['N' - 'A'];
        if (nCount == 0) return 0;
        freq['N'-'A'] -= nCount;
        freq['I'-'A'] -= nCount;
        freq['N'-'A'] -= nCount;
        freq['E'-'A'] -= nCount;
        return nCount;
    }
    public int removeEight(int freq[], int[] count){
        return freq['T' - 'A'];
    }
    
    
    
}
