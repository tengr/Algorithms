package NestedDictionary;

import java.util.HashMap;

public class NestedDictionary {
	static HashMap<String, Object> map;
	static HashMap<String, String> res;
	public static void main(String[] args) {
		NestedDictionary ins = new NestedDictionary();
		System.out.println(map);
		ins.traverse("",  map);
		System.out.println(res);
	}
	
	public NestedDictionary() {
		map = new HashMap<String, Object>();
		map.put("key1", "s1");
		map.put("key2", new HashMap<String, Object>());

		((HashMap<String, Object>)map.get("key2")).put("a", "ValA");
		((HashMap<String, Object>)map.get("key2")).put("b", "ValB");
		((HashMap<String, Object>)map.get("key2")).put("a", "ValA");
		map.put("key2", map);
		res = new HashMap<String, String>();
	}
	
	public void traverse(String keyPrefix, Object node) {
		if(node instanceof String) res.put(keyPrefix, (String)node);
		else {
			for(String key : ((HashMap<String, Object>)node).keySet()) {
				traverse(keyPrefix.length() == 0 ? key : keyPrefix + "." + key
						, ((HashMap<String, Object>)node).get(key));
			}
		}
	}
}
