package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak2 {

	public static List<String> wordBreak(String s, Set<String> dict) {
		List<String> re = new ArrayList<String>();
		dfs(s, dict, "", re, 0);
		return re;
	}
	
	public static void dfs(String s, Set<String> dict, String temp, List<String> re, int index) {
		if(index == s.length()){
			re.add(temp);
			return;
		}
		for(int i = index; i < s.length(); i++){
			String t = s.substring(index, i + 1);
			if(dict.contains(t)){
				temp = temp == "" ? t : temp + " " + t;
				dfs(s, dict, temp, re, i + 1);
			}
		}
	}
	
	public static void main(String[] args) {
		String s = "a";
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		wordBreak(s, dict);
	}

}
