package leetcode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {

	public static List<String> restoreIpAddresses(String s) {
		List<String> re = new ArrayList<String>();
		dfs(s, "", 0, 1, re);
		return re;
	}

	public static void dfs(String s, String temp, int start, int pos,
			List<String> re) {
		if (pos == 4) {
			String t1 = s.substring(start);
			if(t1.length() > 1 && t1.startsWith("0")) return;
			if (valid(t1)) {
				re.add(temp + "." + s.substring(start));
			}
			return;
		}
		for (int i = 1; i <= 4; i++) {
			if (start + i < s.length()){
				String t = s.substring(start, start + i);
				if(valid(t)){
					if(temp == "")
						dfs(s, t, start + i, pos + 1, re);
					else
						dfs(s, temp + "." + t, start + i, pos + 1, re);
				}
				if(t.startsWith("0")) return;
			}
		}
	}

	public static boolean valid(String s) {
		if(s.length() > 3) return false;
		int t = Integer.parseInt(s);
		return t >= 0 && t <= 255;
	}

	public static void main(String[] args) {
		String s = "010010";
		restoreIpAddresses(s);
	}

}
