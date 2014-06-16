package leetcode;

/**
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 * @author aqia358
 *
 */
public class IntegerToRoman {

	public static String intToRoman(int num){
		StringBuilder result = new StringBuilder();
		int[] integer = { 1000, 100, 10, 1};
		char[] roman = { 'M', 'C', 'X', 'I' };
		char[] roman5 = { 'D', 'L', 'V'};
		int m = num/1000;
		for(int i = 0; i < integer.length; i++){
			while(m > 0){
				if(m < 4){
					result.append(roman[i]);
					m--;
				}else if(m == 4){
					result.append(roman[i]);
					result.append(roman5[i - 1]);
					m = 0;
				}else if(m == 5){
					result.append(roman5[i - 1]);
					m = 0;
				}else if(m < 9){
					result.append(roman5[i - 1]);
					m -= 5;
				}else if(m == 9){
					result.append(roman[i]);
					result.append(roman[i - 1]);
					m = 0;
				}
			}		
			num %= integer[i];
			if(i + 1 < integer.length)
				 m = num/integer[i + 1];
		}
		return result.toString();
	}
	public static String intToRoman2(int num){
		StringBuilder result = new StringBuilder();
		char[] roman = { 'M', 'D', 'C', 'L', 'X', 'V', 'I' };
		int[] integer = { 1000, 500, 100, 50, 10, 5, 1 };
		int m;
		m = num/1000;
		while(m > 0){
			result.append("M");
			m--;
		}
		num %= 1000;
		m = num/100;
		while(m > 0){
			if(m < 4){
				result.append("C");
				m--;
			}else if(m == 5){
				
			}else if(m < 9){
				result.append("D");
				m -= 5;
			}else if(m == 9){
				result.append("CM");
				m = 0;
			}
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(intToRoman(1984));
		System.out.println(intToRoman(5));
		System.out.println(intToRoman(39));
		System.out.println(intToRoman(900));
		System.out.println(intToRoman(3999));
	}

}
