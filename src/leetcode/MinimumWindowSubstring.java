package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	public static String minWindow(String S, String T) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int sLen = S.length();
		for (Character t : T.toCharArray())
			if (map.containsKey(t))
				map.put(t, map.get(t) + 1);
			else
				map.put(t, 1);
		int[] f = new int[sLen];
		int p = 0;
		for (int i = 0; i < sLen; i++) {
			if (map.containsKey(S.charAt(i))) {
				f[p++] = i;
			}
		}
		int left = 0;
		int count = 0;
		String re = "";
		Map<Character, Integer> curMap = new HashMap<Character, Integer>();
		for (int i = 0; i < p; i++) {
			char t = S.charAt(f[i]);
			if (curMap.containsKey(t))
				curMap.put(t, curMap.get(t) + 1);
			else
				curMap.put(t, 1);
			if(curMap.get(t) <= map.get(t))
				count++;
			while (count == T.length()) {
				if (re == "" || re.length() > f[i] - f[left] + 1)
					re = S.substring(f[left], f[i] + 1);
				char temp = S.charAt(f[left]);
				if(curMap.get(temp) <= map.get(temp))
					count--;
				curMap.put(temp, curMap.get(temp) - 1);
				left++;
			}
		}
		return re;
	}

	public static void main(String[] args) {
		System.out.println(minWindow("bba", "ba"));
		System.out.println(minWindow("caae", "cae"));
	}

}
