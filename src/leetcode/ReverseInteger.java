package leetcode;

public class ReverseInteger {

	public static int reverse(int x){
		if(x > 0)
			return doReverse(x);
		else
			return -1*doReverse(-1*x);
	}
	
	public static int doReverse(int x){
		String s = x+"";
		char[] array = s.toCharArray();
		StringBuffer sb = new StringBuffer();
		for(int i = array.length - 1; i >= 0; --i)
			sb.append(array[i]);
		return Integer.parseInt(sb.toString());
	}
	
	public static void main(String[] args) {
		System.out.println(reverse(123));
		System.out.println(reverse(-1123));
	}

}
