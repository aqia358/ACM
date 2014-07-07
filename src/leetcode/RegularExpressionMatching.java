package leetcode;

public class RegularExpressionMatching {

	public static boolean isMatch(String s, String p){
		int slen = s.length();
		int plen = p.length();
		if(plen== 0) return slen == 0;
		if(plen > 1 && p.charAt(1) == '*'){
			int i = 0;
			while(i < slen && (s.charAt(i) == p.charAt(0) || p.charAt(0) == '.')){
				if(isMatch(s.substring(i), p.substring(2)))
					return true;
				i++;
			}
			return isMatch(s.substring(i), p.substring(2));
		}else{
			if(slen > 0 && plen > 0){
				if(s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
					return isMatch(s.substring(1), p.substring(1));
			} else
				return false;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
//		System.out.println(isMatch("aa", "a"));
//		System.out.println(isMatch("aa", "aa"));
//		System.out.println(isMatch("aaa", "a"));
//		System.out.println(isMatch("aaa", "a*"));
//		System.out.println(isMatch("aa", ".*"));
//		System.out.println(isMatch("ab", ".*"));
//		System.out.println(isMatch("aa", ".*"));
		System.out.println(isMatch("aaa", "ab*a*c*a"));
		String s = "123456";
		System.out.println(s.substring(0));
		System.out.println(s.substring(1));
	}

}
