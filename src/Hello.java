import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import test.queen.Queen;

public class Hello {
	public static int a,b;

	public static void fortest(){
		for(int i = 0; i < 10; ++i){
			System.out.println(i+" "+ a++);
		}
		System.out.println();
		for(int i = 0; i < 10; i++){
			System.out.println(i+" "+ ++b);
		}
	}
	
	public static void stackTest(){
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		while(!s.isEmpty()){
			System.out.println(s.pop());
		}
	}
	
	public static void queueTest(){
		LinkedList<String> q = new LinkedList<String>();
		q.add("hello");
		q.add("word");
		int count = 0;
		while(!q.isEmpty()){
			System.out.println(q.poll());
			if(count < 10)
				q.add(count++ +"");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Hello");
		fortest();
		stackTest();
		queueTest();
	}
}
