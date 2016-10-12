package SortHashMap;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

public class SortHashMap {
	static class ValueComparator implements Comparator<String> {
		HashMap<String, Integer> map;
		public ValueComparator(HashMap<String, Integer> map) {
			this.map = map;
		}
		@Override
		public int compare(String o1, String o2) {
			if(map.get(o1) != (map.get(o2))) return -map.get(o1).compareTo((map.get(o2)));
//			return Integer.parseInt(o1) - Integer.parseInt(o2);
			return o1.compareTo(o2);
		}
	}
	public static void main(String[] args) {
		HashMap<String, Integer> aMap = new HashMap<>();
		aMap.put("8", 233);
		aMap.put("4", 5);
		aMap.put("1", 233);
		aMap.put("32", 1000);
		aMap.put("22", 1000);
		aMap.put("5", 5);
		System.out.println(aMap);
		System.out.println(sort(aMap));
//		TreeMap<String, Integer> aTreeMap = new TreeMap<>();
//		aTreeMap.put("8", 234);
//		aTreeMap.put("4", 5656);
//		aTreeMap.put("1", 5656);
//		aTreeMap.put("3",1);
//		aTreeMap.put("2",1);
//		System.out.println(aTreeMap);
	}
	
	private static TreeMap<String, Integer> sort(HashMap<String, Integer> map) {
		Comparator<String> comp = (Comparator<String>) new ValueComparator(map);
		//TreeMap<String, Integer> ret = new TreeMap<>(comp);
		TreeMap<String, Integer> ret = new TreeMap<>(comp);
		for(String key: map.keySet()) {
			ret.put(key, map.get(key));
			System.out.print(key + "\t" + map.get(key));
			System.out.println(" size = " + ret.size());
		}
		//ret.putAll(map);
		return ret;
	}
	
}
