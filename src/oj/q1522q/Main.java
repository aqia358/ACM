package oj.q1522q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Stack;
/**
 * 两个栈方法
 * @author aqia358
 *
 */
public class Main {
	
	public Stack<Integer> data = new Stack<Integer>();
	public Stack<Integer> help = new Stack<Integer>();
	
	public void push(int value){
		data.push(value);
		if(help.isEmpty()){
			help.push(value);
			System.out.println(value);
		}else{
			int temp = help.peek();
			if(temp < value){
				help.push(temp);
				System.out.println(temp);
			}else{
				help.push(value);
				System.out.println(value);
			}
		}
	}
	public void pop(){
		if(help.isEmpty()){
			System.out.println("NULL");
		}else{
			data.pop();
			help.pop();
			if(help.isEmpty()){
				System.out.println("NULL");
			}else
				System.out.println(help.peek());
		}
	}

	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while(st.nextToken() != StreamTokenizer.TT_EOF){
			int n = (int)st.nval;
			Main m = new Main();
			for(int i = 0; i < n; i++){
				st.nextToken();
				String op = st.sval;
				if(op.equals("s")){
					st.nextToken();
					int data = (int)st.nval;
					m.push(data);
				}else if(op.equals("o")){
					m.pop();
				}
			}
		}
	}
}
