package leetcode;

public class BinaryAdd {

	public static String addbinary(String a, String b){
		int c = 0;
		int lenA = a.length() - 1;
		int lenB = b.length() - 1;
		if(lenA < lenB)
			return addbinary(b, a);
		int temp;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i <= lenA; i++){
			if(i <= lenB){
				temp = a.charAt(lenA - i) - '0' + b.charAt(lenB - i) - '0' + c;
				c = temp/2;
				sb.append(temp%2);
			}else{
				temp = a.charAt(lenA - i) - '0' + c;
				c = temp/2;
				sb.append(temp%2);
			}
		}
		if(c > 0) sb.append(c);
		return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		System.out.println(addbinary("11", "1"));
	}

}
