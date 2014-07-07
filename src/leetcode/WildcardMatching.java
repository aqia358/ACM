package leetcode;

public class WildcardMatching {

	public static boolean isMatch(String s, String p) {
		int sLen = s.length();
		int pLen = p.length();
		if(pLen == 0) return sLen == 0;
		boolean[] res = new boolean[sLen + 1];
		res[0] = true;
		for(int j = 0; j < pLen; j++){
			if(p.charAt(j) != '*'){
				for(int i = s.length() - 1; i >= 0; i--){
					res[i + 1] = res[i] && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i));
				}
			}else {
				int i = 0;
				while(i < sLen && !res[i])
					i++;
				for(;i <= sLen; i++)
					res[i] = true;
			}
			res[0] = res[0] && p.charAt(j) == '*';
		}
		return res[s.length()];
	}
	public static boolean isMatch2(String s, String p) {
		int sLen = s.length();
		int pLen = p.length();
		if(pLen == 0) return sLen == 0;
		if(p.charAt(0) == '*'){
			int i = 0;
			while(i <= sLen){
				if(isMatch(s.substring(i), p.substring(1)))
					return true;
				i++;
			}
		}else if(sLen > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?'))
			return isMatch(s.substring(1), p.substring(1));
		return false;
	}
	public static boolean isMathc2(String s, String p) {
		int sLen = s.length();
		int pLen = p.length();
		if(sLen == 0 && pLen == 0) return true;
		if(sLen != 0 && pLen == 0) return false;
		boolean[][] f = new boolean[sLen + 1][Math.max(pLen, sLen) + 1];
		f[0][0] = true;
		for(int i = 1; i <= sLen; i++){
			for(int j = 1; j <= pLen; j++){
				if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
					f[i][j] = f[i - 1][j - 1];
				} else if(p.charAt(j - 1) == '*'){
					f[i][j] = f[i - 1][j] || f[i][j - 1] || f[i - 1][j - 1];
					for(int m = j + 1; m <= Math.max(pLen, sLen); m++) f[i][m] = f[i][j];
					for(int m = j + 1; m <= sLen; m++) f[m][j] = f[i][j];
				} else
					f[i][j] = false;
				if(f[sLen][sLen]) return true;
			}
		}
		return f[sLen][sLen];
	}
	public static boolean isMathc3(String s, String p) {
		int sLen = s.length();
		int pLen = p.length();
		if(pLen == 0) return sLen == 0;
		if(sLen == 0){
			for(int i = 0; i < pLen; i++){
				if(p.charAt(i) != '*') return false;
			}
			return true;
		}
        int count = 0;
        for(int i = 0;i< pLen;i++){
            if(p.charAt(i) != '*') count++;
        }
        if(count > pLen) return false;
		boolean[][] f = new boolean[sLen + 1][pLen + 1];
		f[0][0] = true;
        for (int i = 0; i < pLen; i++) {
            if(p.charAt(i) == '*'){
                f[0][i+1] = true;
            }else{
                break;
            }
        }
		for(int i = 1; i <= sLen; i++){
			for(int j = 1; j <= pLen; j++){
				if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
					f[i][j] = f[i - 1][j - 1];
				} else if(p.charAt(j - 1) == '*'){
					f[i][j] = f[i - 1][j] || f[i][j - 1] || f[i - 1][j - 1];
				} else
					f[i][j] = false;
				if(f[sLen][pLen]) return true;
			}
		}
		return f[sLen][pLen];
	}
	public static boolean isMathc4(String s, String p) {
		int sLen = s.length();
		int pLen = p.length();
		if(pLen == 0) return sLen == 0;
		if(sLen == 0){
			for(int i = 0; i < pLen; i++){
				if(p.charAt(i) != '*') return false;
			}
			return true;
		}
		int count = 0;
		for(int i = 0;i< pLen;i++){
			if(p.charAt(i) != '*') count++;
		}
		if(count > pLen) return false;
		boolean[] f = new boolean[pLen + 1];
		f[0] = true;
		for (int i = 0; i < pLen; i++) {
			if(p.charAt(i) == '*'){
				f[i+1] = true;
			}else{
				break;
			}
		}
		for(int i = 1; i <= sLen; i++){
			for(int j = 1; j <= pLen; j++){
				if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
					f[j] = f[j - 1];
				} else if(p.charAt(j - 1) == '*'){
					f[j] = f[j] || f[j - 1];
				} else
					f[j] = false;
				if(f[pLen]) return true;
			}
		}
		return f[pLen];
	}
	
	public static void test(){
		String s = "**dfdf*fdf*";
		for(int i = 0; i < s.length(); i++){
			System.out.println("fsd");
			if(s.charAt(i) == '*'){
				
			}else{
				break;
			}
		}
	}
	public static void main(String[] args) {
		test();
		System.out.println(isMathc4("c", "*?*"));
		System.out.println(isMathc4("", "?"));
		System.out.println(isMathc4("a", "aa"));
		System.out.println(isMathc4("aa", "a"));
		System.out.println(isMathc4("aa", "aa"));
		System.out.println(isMathc4("aaa", "aa"));
		System.out.println(isMathc4("aa", "*"));
		System.out.println(isMathc4("aa", "a*"));
		System.out.println(isMathc4("ab", "?*"));
		System.out.println(isMathc4("aab", "c*a*b"));
	}

}
