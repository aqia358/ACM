package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongextSubstringWithoutRepeating {

	public static int lengthOfLongestSubstring(String s) {
		int max = 0;
		int sum = 0;
		int left = 0;
		Map<Character, Integer> m = new HashMap<Character, Integer>();
		for(int i = 0; i < s.length();){
			if(m.containsKey(s.charAt(i))){
				int p = m.get(s.charAt(i));
				sum += left - p - 1;
				while(left <= p){
					m.remove(s.charAt(left));
					left++;
				}
			}else{
				m.put(s.charAt(i), i);
				i++;
				sum++;
				if(sum > max){
					max = sum;
				}
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcdebtyu"));
		System.out.println(lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco"));
	}

}
