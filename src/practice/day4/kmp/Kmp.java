package practice.day4.kmp;

public class Kmp {

	public static int[] next(String s) {
		int[] next = new int[s.length()];
		next[0] = -1;
		int i, j;
		i = j = 0;
		while (i < s.length() && j < s.length()) {
			if (i == -1 || s.charAt(j) == s.charAt(i)) {
				i++;
				j++;
				if(j < s.length())
					next[j] = i;
			} else {
				i = next[i];
			}
		}
		return next;
	}

	public static boolean kmp(String s1, String s2) {
		int i, j;
		i = j = 0;
		int[] next = next(s2);
		while (i < s1.length() && j < s2.length()) {
			if (j == -1 || s1.charAt(i) == s2.charAt(j)) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}
		return j == s2.length();
	}

	public static boolean compare(String s1, String s2) {
		int i, j;
		i = j = 0;
		while (i < s1.length() && j < s2.length()) {
			int next = i;
			while (next < s1.length() && j < s2.length()) {
				if (s1.charAt(next) == s2.charAt(j)) {
					next++;
					j++;
				} else {
					i++;
					j = 0;
					break;
				}
			}
		}
		return j == s2.length();
	}

	public static void main(String[] args) {
		System.out.println(kmp("asdfasdfasdf", "sdf"));
		next("abcabcda");
	}

}
