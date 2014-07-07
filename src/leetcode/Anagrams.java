package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {

	public static List<String> anagrams(String[] strs) {
		List<String> re = new ArrayList<String>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i = 0; i < strs.length; i++){
			String temp = sort(strs[i]);
			if(map.containsKey(temp)){
				if(map.get(temp) >= 0){
					re.add(strs[map.get(temp)]);
					map.put(temp, -1);
				}
				re.add(strs[i]);
			} else
				map.put(temp, i);
		}
		return re;
	}
	
	public static String sort(String s){
		char[] t = s.toCharArray();
		Arrays.sort(t);
		StringBuilder sb = new StringBuilder();
		for(Character c : t)
			sb.append(c);
		return sb.toString();
	}
	
	public static boolean isAnagrams(String str){
		int len = str.length();
		int s = 0;
		int e = len - 1;
		while(s <= e){
			if(str.charAt(s++) != str.charAt(e--))
				return false;
		}
		return true;
	}
	public static void main(String[] args) {

	}

}
