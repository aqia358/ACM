package oj.q1512q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Stack;

/**
 * 用两个栈实现一个队列
 * s1一直入队
 * s2一直出队当s2为空时把s1全部倒入s2
 * @author aqia358
 *
 */
public class Main {
	
	public static void POP(Stack s){
		if(s.isEmpty())
			System.out.println(-1);
		else
			System.out.println(s.pop());
	}
	
	public static void swap(Stack source, Stack target){
		while(!source.isEmpty())
			target.push(source.pop());
	}
	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		Stack s1 = new Stack();
		Stack s2 = new Stack();
		st.nextToken();
		int n = (int) st.nval;
		while(n > 0){
			n--;
			int value = 0;
			st.nextToken();
			String str = st.sval;
			if(str.equals("PUSH")){
				st.nextToken();
				value = (int)st.nval;
				s1.push(value);
			}else{
				if(s2.isEmpty())
					swap(s1,s2);
				POP(s2);
			}
		}
	}
}
