package leetcode;

import java.util.Stack;

public class ValidParentheses {

	public static boolean isValid(String s){
		String left = "([{";
		String right = ")]}";
		Stack<Character> stack = new Stack<Character>();
		for(char c : s.toCharArray()){
			if(left.indexOf(c) != -1){
				stack.push(c);
			}else{
				if(stack.isEmpty() || right.indexOf(c) != left.indexOf((Character)stack.pop())){
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
	public static boolean isValid2(String s){
		char[] a = s.toCharArray();
		int len = a.length;
		if(len % 2 != 0)
			return false;
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < a.length; i++){
			if(a[i] == '(' || a[i] == '{' || a[i] == '['){
				stack.push(a[i]);
			}else{
				if(stack.isEmpty() || !vaild(stack.pop(),a[i]))
					return false;
			}
		}
		if(stack.isEmpty())
			return true;
		else
			return false;
	}
	
	public static boolean vaild(Object a, char b){
		if(a.equals('(') && b == ')')
			return true;
		if(a.equals('{') && b == '}')
			return true;
		if(a.equals('[') && b == ']')
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isValid("{([])}"));
	}

}
