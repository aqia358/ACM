package leetcode;

import java.util.Stack;

public class EvaluateReversePolishNotation {

	public static int evalRPN(String[] tokens) {
		Stack<Integer> s = new Stack<Integer>();
		for(int i = 0; i < tokens.length; i++){
			calc(tokens[i], s);
		}
		return s.pop();
	}
	
	public static void calc(String op, Stack<Integer> s){
		if("+".equals(op)){
			s.push(s.pop() + s.pop());
		}else if("-".equals(op)){
			s.push(-(s.pop() - s.pop()));
		}else if("*".equals(op)){
			s.push(s.pop() * s.pop());
		}else if("/".equals(op)){
			int a = s.pop();
			s.push(s.pop()/a);
		}else{
			s.push(Integer.parseInt(op));
		}
	}
	
	public static void main(String[] args) {
		String[] a = {"2", "1", "+", "3", "*"};
		String[] b = {"4", "13", "5", "/", "+"};
		System.out.println(evalRPN(a));
		System.out.println(evalRPN(b));
	}

}
