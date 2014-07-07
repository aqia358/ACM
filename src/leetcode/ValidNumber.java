package leetcode;

public class ValidNumber {

	public static boolean isNumber(String s) {
		s = s.trim();
		if(s.startsWith("-") || s.startsWith("+"))
			s = s.substring(1);
		return slove(s);
	}
	public static boolean slove(String s) {
		if(s.length() == 0) return false;
		if(s.contains(".")) {
			if(s.lastIndexOf(".") != s.indexOf(".")) return false;
			String[] t = s.split("\\.");
			if(t.length == 1) return slove(t[0]);
			else if(t.length == 2)	return t[0].length() == 0 ? slove(t[1]) : slove(t[0]) && slove(t[1]);
			else return false;
		} else if(s.contains("e")) {
			if(s.lastIndexOf("e") != s.indexOf("e")) return false;
			String[] t = s.split("e");
			if(t.length != 2) return false;
			else return t[0].length() == 0 ? slove(t[1]) : slove(t[0]) && slove(t[1]);
		} else {
			for(int i = 0; i < s.length(); i++)
				if(s.charAt(i) < '0' || s.charAt(i) > '9') return false;
			return true;
		}
	}
	
	public static void main(String[] args) {
//		String t = "0..";
//		System.out.println(t.indexOf(".")+" "+t.lastIndexOf("."));
//		String[] a = t.split("\\.");
		System.out.println(isNumber("46.e3"));
		System.out.println(isNumber(" -1. "));
		System.out.println(isNumber(" 0.1 "));
		System.out.println(isNumber("0"));
		System.out.println(isNumber("asdf"));
		System.out.println(isNumber("1 a"));
		System.out.println(isNumber("2e11"));
	}

}
