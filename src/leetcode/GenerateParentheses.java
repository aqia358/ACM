package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses. For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 * @author aqia358
 * 
 */
public class GenerateParentheses {

	public static List<String> list = new ArrayList<String>();
	
	public static List<String> generateParenthesis2(int n){
		List<String> result = new ArrayList<String>();
		generate(0, 0, "", result, n);
		return result;
	}
	
	public static void generate(int pos, int neg, String temp, List<String> result, int n){
		if(pos < neg)return;
		if(pos + neg == 2 * n){
			if(pos == neg){
				result.add(temp);
			}
			return;
		}
		generate(pos + 1, neg, temp + "(", result, n);
		generate(pos, neg + 1, temp + ")", result, n);
	}
	
	
	
	public static List<String> generateParenthesis(int n) {
		generate(n - 2, n - 1, "(", new Stack<String>());
		return list;
	}

	public static void generate(int left, int right, String s, Stack<String> stack) {
		stack.push(s);
		if(right < left){
			return;
		}
		if (left == -1 && right == -1){
			list.add(stackToString(stack));
			return;
		}
		if(left >= 0){
			generate(left - 1, right, "(", stack);
			stack.pop();
		}
		if(right >= 0){
			generate(left, right - 1, ")", stack);
			stack.pop();
		}
	}
	
	public static String stackToString(Stack<String> s){
		StringBuilder sb = new StringBuilder();
		Stack<String> s1 = (Stack<String>) s.clone();
		print(s1,sb);
		return sb.toString();		
	}
	public static void print(Stack<String> s,StringBuilder sb){
		if(!s.isEmpty()){
			String str = (String) s.pop();
			print(s, sb);
			sb.append(str);
		}else{
			return;
		}
			
	}

	public static void main(String[] args) {
		List<String> s = generateParenthesis(3);
		for(String str : s){
			System.out.println(str);
		}
		System.out.println("-----------");
		s = generateParenthesis2(3);
		for(String str : s){
			System.out.println(str);
		}
	}

}
