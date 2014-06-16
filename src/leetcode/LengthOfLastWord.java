package leetcode;

public class LengthOfLastWord {

	public static int lengthOflastWord(String s){
		s = s.trim();
		int p = s.lastIndexOf(" ");
		int len = s.length();
		if(p == -1 && len > 0)
			return len;
		if(len - 1 == p)
		    return 0;
		return s.length() - p - 1;
	}
	
	public static void main(String[] args) {
		System.out.println(lengthOflastWord("sdfsdf"));
	}

}
