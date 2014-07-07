package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/***
 * BFS 怎样记录数据 DFS 怎样记录数据
 * 
 * @author aqia358
 * 
 */
public class WordLadder2 {

	public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
		List<List<String>> res = new ArrayList<List<String>>();
		dfs(start, end, dict, new ArrayList<String>(), res);
		return res;
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
						ArrayList<String> clone = (ArrayList<String>) l.clone();
						res.add(clone);
					}
					if (dict.contains(sb.toString()) && !l.contains(sb.toString())) {
						l.add(sb.toString());
						dfs(sb.toString(), end, dict, l, res);
					}
					sb.setCharAt(i, t);
				}
			}
		}
	}

	public static void bfs(String start, String end, Set<String> dict) {
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
		String start = "hit";
		String end = "cog";
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		findLadders(start, end, dict);
	}

}
