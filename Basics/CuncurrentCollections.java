import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
public class CuncurrentCollections {
	public static void main(String[] args){
		HashSet<String> list = new HashSet<String>(3);
		CuncurrentCollections ins = new CuncurrentCollections();
		ins.dfs();
	}
	public void dfs(){
		Map<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();
		for(int i = 0; i < 10; i++) map.put(i,i);
		dfs(map);
	}
	public void dfs(Map<Integer, Integer> map) {
		if(map.isEmpty()) {
			System.out.println("finished");
			return;
		}
		for(Integer num : map.keySet()) {
			System.out.print(num + " ");
			map.remove(num);
			dfs(map);
			map.put(num,num);
		}
	}
	
	
	
}
