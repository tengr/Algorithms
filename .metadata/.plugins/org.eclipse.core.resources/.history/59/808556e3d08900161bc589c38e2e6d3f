package SortHashMap;

import java.util.Comparator;
import java.util.HashMap;

class ValueComparator implements Comparator<String> {
	HashMap<String, Integer> map;
	public ValueComparator(HashMap<String, Integer> map) {
		this.map = map;
	}
	@Override
	public int compare(String o1, String o2) {
		if(map.get(o1) != map.get(o2)) return -map.get(o1).compareTo(map.get(o2));
		return Integer.parseInt(o1) - Integer.parseInt(o2);
	}
	
}
