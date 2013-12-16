package oj.q1511q;

import java.util.Scanner;
import java.util.Stack;

/**
 * 到序输出输入的数
 * @author aqia358
 *
 */
public class Main {

	public static void main(String[] args) {
		Stack stack = new Stack();
		int value = 0;
		Scanner s = new Scanner(System.in);
		while((value = s.nextInt()) != -1){
			stack.push(value);
		}
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}

}
