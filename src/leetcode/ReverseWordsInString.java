package leetcode;

public class ReverseWordsInString {

	public static String reverseWords(String s) {
		s = s.trim();
		String[] a = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for(int i = a.length - 1; i > 0; i--){
			if(!a[i].equals(""))
				sb.append(a[i]).append(" ");
		}
		sb.append(a[0]);
		return sb.toString();
	}
		
	public static void main(String[] args) {
		String s = "a     b   c";
		System.out.println(reverseWords("   a   b "));
		System.out.println(reverseWords("the sky is blue"));
	}

}
