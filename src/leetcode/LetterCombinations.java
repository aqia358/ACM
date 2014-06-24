package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {

	public static List<String> letterCombinations(String digits){
		List<String> re = new ArrayList<String>();
		String[] strs = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		combinations(strs, 0, digits, "", re);
		return re;
	}
	
	public static void combinations(String[] strs, int n, String digits, String temp, List<String> re){
		if(n == digits.length()){
			re.add(temp);
			return ;
		}
		String t = strs[Integer.parseInt(digits.charAt(n)+"")];
		for(int i = 0; i < t.length(); i++){
			combinations(strs, n + 1, digits, temp + t.charAt(i), re);
		}
	}
	public static void main(String[] args) {
		letterCombinations("23");
		System.out.println();
	}

}
