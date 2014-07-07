package leetcode;

public class StringToInteger {

	public static int atoi(String str) {
		if (str.equals(String.valueOf(Integer.MIN_VALUE)))
			return Integer.MIN_VALUE;
		boolean flag = false;
		while (str.startsWith(" "))
			str = str.substring(1);
		if (str.startsWith("-")) {
			flag = true;
			str = str.substring(1);
		} else if (str.startsWith("+"))
			str = str.substring(1);
		int re = 0;
		for (Character c : str.toCharArray()) {
			if (c >= '0' && c <= '9') {
				if (Integer.MAX_VALUE - re * 10 == c - '0') {
					re = Integer.MAX_VALUE;
					break;
				} else if(Integer.MAX_VALUE/10 < re || Integer.MAX_VALUE - re * 10 < c - '0'){
					return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
				} else
					re = re * 10 + c - '0';
			} else
				break;
		}
		return flag ? -re : re;
	}

	public static void main(String[] args) {
		System.out.println(atoi("10522545459"));
		System.out.println(atoi("-2147483648"));
		System.out.println(atoi("2147483648"));
		System.out.println(atoi("-2147483649"));
	}

}
