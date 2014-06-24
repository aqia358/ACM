package leetcode;

public class KMP {

	public static String strStr(String haystack, String needle) {
		int hlen = haystack.length();
		int nlen = needle.length();
		if(hlen == 0 && nlen == 0) return "";
		if(nlen == 0) return haystack;
		int i = 0;
		int j = 0;
		int[] next = getNext(needle);
		while (i < haystack.length()) {
			if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
				j++;
				i++;
			} else {
				j = next[j];
			}
			if(j == needle.length()) return haystack.substring(i - needle.length());
		}
		return null;
	}

	public static int[] getNext(String s) {
		int len = s.length();
		int[] next = new int[len];
		int i = 0;
		int j = -1;
		next[0] = -1;
		while(i < len){
			if(j == -1 || s.charAt(i) == s.charAt(j)){
				i++;
				j++;
				if(i < len)
					next[i] = j;
			}else{
				j = next[j];
			}
		}
		return next;
	}

	public static void main(String[] args) {
//		int[] a = getNext("abcabcd");
//		for(Integer t: a)
//			System.out.print(t);
		System.out.println(strStr("a","a"));
		System.out.println(strStr("asdfasdfasaabcabbcdsfa","abcab"));
		System.out.println(strStr("","abcab"));
		System.out.println(strStr("asdfasdfasaabcabbcdsfa",""));
	}

}
