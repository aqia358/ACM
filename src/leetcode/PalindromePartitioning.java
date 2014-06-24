package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	public static List<List<String>> partition(String s){
		List<List<String>> re = new ArrayList<List<String>>();
		ArrayList<String> l = new ArrayList<String>();
		dfs(s, l, re, 0);
		return re;
	}
	
	public static void dfs(String s, ArrayList<String> l, List<List<String>> re, int start){
		if(start == s.length()){
			re.add(l);
		}
		for(int i = start; i < s.length(); i++){
			if(isPalindrome(s, start, i)){
				ArrayList<String> c = (ArrayList<String>) l.clone();
				c.add(s.substring(start, i + 1));
				dfs(s, c, re, i + 1);
			}
		}
	}

	public static boolean isPalindrome(String s, int start, int end){
		while(start < end && s.charAt(start) == s.charAt(end)){
			start++;
			end--;
		}
		return start >= end;
	}
	
	public static void main(String[] args) {
		partition("aab");
	}

}
