package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	public static int ladderLength(String start, String end, Set<String> dict) {
		int sLen = start.length();
		int eLen = end.length();
		if (sLen == 0 || eLen == 0 || sLen != eLen || start.equals(end))
			return 0;
		Queue<String> q = new LinkedList<String>();
		Map<String, Integer> f = new HashMap<String, Integer>();
		q.add(start);
		f.put(start, 1);
		while (!q.isEmpty()) {
			String temp = q.poll();
			int step = f.get(temp);
			for (int i = 0; i < temp.length(); i++) {
				for (char j = 'a'; j <= 'z'; j++) {
					StringBuilder sb = new StringBuilder(temp);
					if(j == sb.charAt(i)) continue;
					sb.setCharAt(i, j);
					if(sb.toString().equals(end)) return step + 1;
					if(dict.contains(sb.toString()) && !f.containsKey(sb.toString())){
						q.add(sb.toString());
						f.put(sb.toString(), step + 1);
					}
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		String[] a = {"hot","dot","dog","lot","log"};
		Set<String> dict = new HashSet<String>();
		for(String t : a)
			dict.add(t);
		System.out.println(ladderLength("hit", "cog", dict));
	}

}
