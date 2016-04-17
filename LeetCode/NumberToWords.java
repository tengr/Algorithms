// //273. Integer to English Words
// 123 -> "One Hundred Twenty Three"
// 12345 -> "Twelve Thousand Three Hundred Forty Five"
// 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
public class NumberToWords{
	public static void main(String[] args){
		//System.out.println(numberToWords(12));
  //       String ones[] = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", 
  //       				"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
  //       				"Eighteen", "Nineteen"};
  //       String tens[] = {"", "", "Twenty", "thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Nighty"};

		// String commas[] = {"", "Thousand", "Millon", "Trillon"};
		// for(int i = 0; i < 999; i++) System.out.println(getSeg(i, ones, tens));
		System.out.println(numberToWords(123456789));
	}

	//IT audit //controls processing improvement
	//forensic team //data discovery
	//technolgial adviosry // technical consulting //ea strategic
	public static String getSeg(int num, String [] ones, String [] tens) {
		String hundred = getHundred(num, ones);		
		num %= 100;
		if (num == 0) return hundred.trim();
		else if (num < 20) return hundred + ones[num];
		else if (num % 10 == 0) return hundred + tens[num / 10];
		else return hundred + tens[num / 10] + " " + ones[num % 10];
	}

	public static String getHundred(int num, String[] ones) {
		if (num < 100) return "";
		return ones[num / 100] + " Hundred ";
	}

    public static String numberToWords(int num) {
    	if (num == 0) return "Zero";
        String ones[] = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", 
        				"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
        				"Eighteen", "Nineteen"};
        String tens[] = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Nighty"};

		String commas[] = {"", " Thousand ", " Millon ", " Trillon "}; int count = 0;

		String res = "";

		while(num > 0) {
			 int seg = num % 1000;
			 if (seg != 0) res = getSeg(seg, ones, tens) + commas[count] + res;
			 num /= 1000;
			 count++;
		}
        return res;
    }
}