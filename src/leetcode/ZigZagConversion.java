package leetcode;

public class ZigZagConversion {

	public static String convert(String s, int nRows){
		if(nRows == 1) return s;
		StringBuilder sb = new StringBuilder();
		int len = s.length();
		for(int i = 0; i < nRows; i++){
			for(int j = i; j < len; j += 2*(nRows - 1)){
				sb.append(s.charAt(j));
				if(i != 0 && i != nRows - 1)
					if((j + 2*(nRows - i - 1)) < len)
						sb.append(s.charAt(j + 2*(nRows - i - 1)));
			}
		}
		return sb.toString();
	}
	public static String convert2(String s, int nRows){
		StringBuilder sb = new StringBuilder();
		if(nRows == 1) return s;
		int len = s.length();
		int t = 0;
		for(int i = 0; i < nRows; i++){
			for(int j = 0; j <= len/(nRows + 1); j++){
				t = j * (nRows + 1) + i;
				if(t < len)
					sb.append(s.charAt(t));
				if(i == (nRows - 1)/2){
					t += (nRows + 1)/2 + 1; 
					if(t < len)
						sb.append(s.charAt(t));
				}
			}
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		System.out.println(convert("ABCD", 1));
		System.out.println("PAHNAPLSIIGYIR");
	}

}
