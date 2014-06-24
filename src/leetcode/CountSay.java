package leetcode;

public class CountSay {

	public static String countAndSay(int n) {
		String s = "1";
		while (n > 1) {
			n--;
			StringBuffer sb = new StringBuffer();
			int len = s.length();
			for (int i = 0; i < len; i++) {
				int num = 1;
				while (i + 1 < len && s.charAt(i + 1) == s.charAt(i)) {
					num++;
					i++;
				}
				sb.append(num).append(s.charAt(i));
			}
			s = sb.toString();
		}
		return s;
	}

	public static void main(String[] args) {
		System.out.println(countAndSay(2));
		System.out.println(countAndSay(3));
		System.out.println(countAndSay(4));
		System.out.println(countAndSay(5));
		System.out.println(countAndSay(6));
	}

}
