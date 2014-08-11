package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/***
 * BFS 怎样记录数据 DFS 怎样记录数据
 * 
 * @author aqia358
 * 
 */
public class WordLadder2 {

	public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
//		List<List<String>> res = new ArrayList<List<String>>();
//		dfs(start, end, dict, new ArrayList<String>(), res);
//		return res;
		return bfs(start, end, dict);
	}

	public static void dfs(String start, String end, Set<String> dict, ArrayList<String> l, List<List<String>> res) {
		StringBuilder sb = new StringBuilder(start);
		for (int i = 0; i < sb.length(); i++) {
			char t = sb.charAt(i);
			for (char c = 'a'; c <= 'z'; c++) {
				if (t != c) {
					sb.setCharAt(i, c);
					if (sb.toString().equals(end)){
						l.add(end);
						res.add(l);
					}
					if (dict.contains(sb.toString()) && !l.contains(sb.toString())) {
						ArrayList<String> clone = (ArrayList<String>) l.clone();
						clone.add(sb.toString());
						dfs(sb.toString(), end, dict, clone, res);
					}
					sb.setCharAt(i, t);
				}
			}
		}
	}

	public static List<List<String>> bfs(String start, String end, Set<String> dict) {
		List<List<String>> res = new ArrayList<List<String>>();
		LinkedList<String> q = new LinkedList<String>();
		HashSet<String> hash = new HashSet<String>();
		Map<String, String> path = new HashMap<String, String>();
		q.add(start);
		while (!q.isEmpty()) {
			String src = q.poll();
			StringBuilder sb = new StringBuilder(src);
			for (int i = 0; i < sb.length(); i++) {
				char c = sb.charAt(i);
				for (char j = 'a'; j <= 'z'; j++) {
					if (c != j) {
						sb.setCharAt(i, j);
						String temp = sb.toString();
						if (temp.equals(end)){
							res.add(buildPath(path,src, start, end));
							j += 'z';
						} else
							if (dict.contains(temp) && !hash.contains(temp)) {
								q.add(temp);
								hash.add(temp);
								path.put(temp, src);
							}
						sb.setCharAt(i, c);
					}
				}
			}
		}
		return res;
	}
	
	public static List<String> buildPath(Map<String, String> path, String s, String start, String end) {
		ArrayList<String> l = new ArrayList<String>();
		l.add(end);
		while(path.containsKey(s) && s != start){
			l.add(s);
			s = path.get(s);
		}
		l.add(start);
		return l;
	}
	public static void bfs2(String start, String end, Set<String> dict) {
		LinkedList<String> q = new LinkedList<String>();
		List<String> l = new ArrayList<String>();
		q.add(start);
		while (!q.isEmpty()) {
			StringBuilder sb = new StringBuilder(q.pop());
			l.add(sb.toString());
			for (int i = 0; i < sb.length(); i++) {
				char t = sb.charAt(i);
				for (char c = 'a'; c <= 'z'; c++) {
					if (t != c) {
						sb.setCharAt(i, c);
						if (sb.toString().equals(end))
							System.out.println("find");
						if (dict.contains(sb.toString())
								&& !l.contains(sb.toString())
								&& !q.contains(sb.toString())) {
							q.add(sb.toString());
						}
						sb.setCharAt(i, t);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		String start = "a";
		String end = "c";
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("b");
		dict.add("c");
//		String start = "hit";
//		String end = "cog";
//		Set<String> dict = new HashSet<String>();
//		dict.add("hot");
//		dict.add("dot");
//		dict.add("dog");
//		dict.add("lot");
//		dict.add("log");
		findLadders(start, end, dict);
	}

}
