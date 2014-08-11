package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class test {

	public static List<List<Integer>> combine(int n, int k){
		List<List<Integer>> re = new ArrayList<List<Integer>>();
		combine(n, k, 1, re, new ArrayList<Integer>());
		return re;
	}
	
	public static void combine(int n, int num, int start, List<List<Integer>> re, ArrayList<Integer> l){
		if(num == 0){
			re.add(l);
			return;
		}
		for(int i = start; i <= n; i++){
			ArrayList<Integer> c = (ArrayList<Integer>) l.clone();
			c.add(i);
			combine(n, num - 1, i + 1, re, c);
		}
	}
	
	public static int findLadders(String start, String end, Set<String> dict){
		Queue<String> q = new LinkedList<String>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		q.add(start);
		map.put(start, 1);
		while(!q.isEmpty()) {
			String temp = q.poll();
			int step = map.get(temp);
			StringBuilder sb = new StringBuilder(temp);
			for(int i = 0; i < sb.length(); i++){
				char c = sb.charAt(i);
				for(char j = 'a'; j <= 'z'; j++){
					if(sb.charAt(i) != j){
						sb.setCharAt(i, j);
						String t = sb.toString();
						if(t.equals(end)){
							return step + 1;
						}
						if(dict.contains(t) && !q.contains(t)){
							q.add(t);
							map.put(t, step + 1);
						}
						sb.setCharAt(i, c);
					}
				}
			}
		
		}
		return 0;
	}
	
	public static void ipConver(String ip) {
		String[] strs = ip.split("\\.");
		for(String t : strs){
			System.out.println(Integer.parseInt(t));
		}
	}
	
	public static void main(String[] args) {
		combine(4, 2);
		ipConver("192.168.2.22");
	}

}
