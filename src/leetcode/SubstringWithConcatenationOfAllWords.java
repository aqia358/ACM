package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {

	public static List<Integer> findSubstring(String S, String[] L) {
		int sLen = S.length();
		int lLen = L.length;
		if(sLen == 0 || lLen == 0) return null;
		int step = L[0].length();
		List<Integer> re = new ArrayList<Integer>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(String t : L){
			if(map.containsKey(t))
				map.put(t, map.get(t) + 1);
			else
				map.put(t, 1);
		}
		for(int i = 0; i < step; i++){
			int begin = i;
			int count = 0;
			Map<String, Integer> curMap = new HashMap<String, Integer>();
			for(int j = i; j <= sLen - step; j += step){
				String t = S.substring(j, j + step);
				if(map.containsKey(t)){
					if(curMap.containsKey(t))
						curMap.put(t, curMap.get(t) + 1);
					else
						curMap.put(t, 1);
					if(curMap.get(t) <= map.get(t))
						count++;
					else{
						while(curMap.get(t) > map.get(t)){
							String temp = S.substring(begin, begin + step);
							begin += step;
							curMap.put(temp, curMap.get(temp) - 1);
							if(curMap.get(temp) < map.get(temp))  
								count--;
						}
					}
					if(count == lLen){
						re.add(begin);
						String temp = S.substring(begin, begin + step);
						begin += step;
						curMap.put(temp, curMap.get(temp) - 1);
						count--;
					}
				} else {
					begin = j + step;
					count = 0;
					curMap.clear();
				}
			}
		}
		return re;
	}
	
	public static void main(String[] args) {
		String s = "abababab";
		String[] l = {"a","b","a"};
		findSubstring(s, l);
	}

}
