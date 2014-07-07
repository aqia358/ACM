package leetcode;

public class MultiplyStrings {

	public static String multiply(String num1, String num2) {
		int len1 = num1.length() - 1;
		char[] array1 = num1.toCharArray();
		int len2 = num2.length() - 1;
		char[] array2 = num2.toCharArray();
		char[] result = new char[len1 + len2 + 4];
		for(int i = 0; i < result.length; i++)result[i] = '0';
		int n = 0;
		int temp = 0;
		int c = 0;
		for(int i = len1; i >= 0; i--){
			int count = 0;
			int j = len2;
			while(c != 0 || j >= 0){
				if(j >= 0)
					temp = result[n + count] + (array1[i] - '0')*(array2[j] - '0') + c - '0';
				else
					temp = result[n + count] + c - '0';
				result[n + count] = (char) (temp%10 + '0');
				c = temp/10;
				count++;
				j--;
			}
			n++;
		}
		StringBuilder sb = new StringBuilder();
		int len = result.length - 1;
		while(len > 0 && result[len] == '0')
			len--;
		for(int i = len; i >= 0; i-- ){
			sb.append(result[i]);
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
//		char a = '2';
//		char b = '3';
//		System.out.println((a - '0')*(b - '0'));
		String a = "0";
		String b = "0";
		System.out.println(multiply(a, b));
	}

}
