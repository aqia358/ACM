package leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class WordBreak {
	
	public static boolean wordBreak(String s, Set<String> dict){
		boolean[] f = new boolean[s.length() + 1];
		f[0] = true;
		for(int i = 1; i <= s.length(); i++){
			for(int j = i - 1; j >= 0; j--){
				if(f[j] && dict.contains(s.substring(j, i)))
					f[i] = true;
			}
		}
		return f[s.length()];
	}
	public static boolean wordBreak2(String s, Set<String> dict){
		return dfs(s, 0, 1, dict);
	}

	public static boolean dfs(String s, int begin, int cur, Set<String> dict){
		if(cur == s.length())
			return dict.contains(s.substring(begin, cur));
		if(dfs(s, begin, cur + 1, dict)) return true;
		if(dict.contains(s.substring(begin, cur)))
			if(dfs(s, begin + 1, cur + 1, dict)) return true;
		return false;
	}
	public static boolean dfs(String s, int index, Set<String> dict){
		if(index == s.length()) return true;
		Iterator<String> iter = dict.iterator();
		while(iter.hasNext()){
			String temp =iter.next();
			int p = s.indexOf(temp, index);
			if(p == -1) return false;
			if(dfs(s, p + temp.length(), dict)){
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		String s = "abcd";
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("b");
		dict.add("cd");
		dict.add("abc");
		System.out.print(wordBreak(s, dict));
//		
	}

}
