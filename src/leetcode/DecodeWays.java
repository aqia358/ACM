package leetcode;

public class DecodeWays {

	public static int numDecodings(String s) {
		int len = s.length();
		if (len == 0 || s.charAt(0) == 0)
			return 0;
		int p = 1;
		int p1 = 1;
		int p2 = 1;
		for (int i = 1; i < len; ++i) {
			if (s.charAt(i) == '0') {
				if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2')
					p = p2;
				else
					return 0;
			} else {
				if(s.charAt(i - 1) == '0' || s.charAt(i - 1) >= '3')
					p = p1;
				else{
					if(s.charAt(i - 1) == '2' && s.charAt(i) >= '7' && s.charAt(i) <= '9')
						p = p1;
					else
						p = p1 + p2;
				}
			}
			p2 = p1;
			p1 = p;
		}
		return p;
	}

	public static int numDecodings2(String s) {
		return dfs(s, 0);
	}

	public static int dfs(String s, int p) {
		if (p == s.length())
			return 1;
		while (p < s.length() && (s.charAt(p) < '0' || s.charAt(p) > '9')) {
			p++;
		}
		int sum = dfs(s, p + 1);
		if (p + 1 < s.length()) {
			if (s.charAt(p) == '1' && s.charAt(p + 1) >= '0'
					&& s.charAt(p + 1) <= '9')
				sum += dfs(s, p + 2);
			if (s.charAt(p) == '2' && s.charAt(p + 1) >= '0'
					&& s.charAt(p + 1) <= '6')
				sum += dfs(s, p + 2);
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(numDecodings("27"));
	}

}
