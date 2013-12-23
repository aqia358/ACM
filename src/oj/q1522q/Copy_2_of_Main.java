package oj.q1522q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
/**
 * 数组简单方法
 * @author aqia358
 *
 */
public class Copy_2_of_Main {
	
	public int index = -1;
	public int[] a;
	
	public Copy_2_of_Main(int size){
		this.a = new int[size];
	}

	public void min() {
		int min = a[0];
		for(int i = 0; i <= index; i++){
			if(min > a[i]){
				a[0] = a[i];
				a[i] = min;
				min = a[0];
			}
		}
	}
	public void remove(){
		if(index >= 0){
			a[0] = a[index];
			index--;
			min();
			System.out.println(a[0]);
		}else{
			System.out.println("NULL");
		}
	}
	public void add(int data){
		index++;
		a[index] = data;
		min();
		System.out.println(a[0]);
	}

	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while(st.nextToken() != StreamTokenizer.TT_EOF){
			int n = (int)st.nval;
			Copy_2_of_Main m = new Copy_2_of_Main(n);
			for(int i = 0; i < n; i++){
				st.nextToken();
				String op = st.sval;
				if(op.equals("s")){
					st.nextToken();
					int data = (int)st.nval;
					m.add(data);
				}else if(op.equals("o")){
					m.remove();
				}
			}
		}
	}
}
