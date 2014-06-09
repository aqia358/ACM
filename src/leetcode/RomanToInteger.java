package leetcode;


/**
 * I（1）V（5）X（10）L（50）C（100）D（500）M（1000）
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * @author aqia358
 * 
 */
public class RomanToInteger {

	public static int romanToInt2(String s) {
		char[] roman = { 'M', 'D', 'C', 'L', 'X', 'V', 'I' };
		int[] integer = { 1000, 500, 100, 50, 10, 5, 1 };
		int sum = 0;
		for (int i = 0; i < 7; ++i) {
			int m = s.indexOf(roman[i]);
			while (m >= 0) {
				if (m > 0) {
					int num = 0;
					if(i < 2)
						num = integer[2];
					else if(i < 4)
						num = integer[4];
					else if(i < 6)
						num = integer[6];
					sum += integer[i] - num;
				}
				else if (m == 0)
					sum += integer[i];
				s = s.substring(m + 1);
				m = s.indexOf(roman[i]);
			}
		}
		return sum;
	}

	public static int romanToInt(String s) {
		int sum = 0;
		int m = s.indexOf('M');
		while (m >= 0) {
			if (m > 0)
				sum += 1000 - getNum(s.charAt(0));
			else if (m == 0)
				sum += 1000;
			s = s.substring(m + 1);
			m = s.indexOf('M');
		}
		m = s.indexOf('D');
		while (m >= 0) {
			if (m > 0)
				sum += 500 - getNum(s.charAt(0));
			else if (m == 0)
				sum += 500;
			s = s.substring(m + 1);
			m = s.indexOf('D');
		}
		m = s.indexOf('C');
		while (m >= 0) {
			if (m > 0)
				sum += 100 - getNum(s.charAt(0));
			else if (m == 0)
				sum += 100;
			s = s.substring(m + 1);
			m = s.indexOf('C');
		}
		m = s.indexOf('L');
		while (m >= 0) {
			if (m > 0)
				sum += 50 - getNum(s.charAt(0));
			else if (m == 0)
				sum += 50;
			s = s.substring(m + 1);
			m = s.indexOf('L');
		}
		m = s.indexOf('X');
		while (m >= 0) {
			if (m > 0)
				sum += 10 - getNum(s.charAt(0));
			else if (m == 0)
				sum += 10;
			s = s.substring(m + 1);
			m = s.indexOf('X');
		}
		m = s.indexOf('V');
		while (m >= 0) {
			if (m > 0)
				sum += 5 - getNum(s.charAt(0));
			else if (m == 0)
				sum += 5;
			s = s.substring(m + 1);
			m = s.indexOf('V');
		}
		m = s.indexOf('I');
		while (m == 0) {
			sum += 1;
			s = s.substring(m + 1);
			m = s.indexOf('I');
		}
		return sum;
	}

	public static int getNum(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			return 0;
		}
	}

	public static void main(String[] args) {
		System.out.println(romanToInt("XVIII"));
		System.out.println(romanToInt2("XVIII"));
		System.out.println(romanToInt("XCVIII"));
		System.out.println(romanToInt2("XCVIII"));
		System.out.println(romanToInt("DCCC"));
		System.out.println(romanToInt2("DCCC"));
		System.out.println(romanToInt("MDCCCLXXXVIII"));
		System.out.println(romanToInt2("MDCCCLXXXVIII"));
	}

}
