package SortHashMap;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class SortHashMap {
	
	public static void main(String[] args) {
		HashMap<String, Integer> aMap = new HashMap<>();
		aMap.put("8", 234);
		aMap.put("4", 5656);
		aMap.put("1", 5656);
		aMap.put("3",1);
		aMap.put("2",1);
		System.out.println(aMap);
		System.out.println(sort(aMap));
	}
	
	private static TreeMap<String, Integer> sort(HashMap<String, Integer> map) {
		Comparator<String> comp = (Comparator<String>) new ValueComparator(map);
		TreeMap<String, Integer> ret = new TreeMap<>(comp);
		ret.putAll(map);
		return ret;
	}
	
}