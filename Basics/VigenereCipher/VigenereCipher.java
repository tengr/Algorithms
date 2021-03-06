package VigenereCipher;

public class VigenereCipher {
	public static void main(String[] args){
		System.out.println(decipher("LXFOPVEFRNHa", "LEMON"));
	}
	
	public static boolean isUpper(String s) {
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) > 'Z' || s.charAt(i) < 'A') return false;
		}
		return true;
	}
	
	public static String decipher(String cipherText, String key) {
		if(!isUpper(cipherText) || !isUpper(key)) return null;
		StringBuilder realKey = new StringBuilder(key);
		int pos = 0;
		while(realKey.length() < cipherText.length()) {
			realKey.append(key.charAt(pos));
			pos = (pos + 1) % key.length();
		}
		System.out.println(realKey.toString());
		StringBuilder ret = new StringBuilder();
		for(int i = 0; i < cipherText.length(); i++) {
			ret.append( (char) (((cipherText.charAt(i) - realKey.charAt(i) + 26)) % 26 + 'A'));
		}
		return ret.toString();
	}
}
