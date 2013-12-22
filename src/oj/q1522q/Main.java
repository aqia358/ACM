package oj.q1522q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
	
	public int index = -1;
	public int[] a;
	
	public Main(int size){
		this.a = new int[size];
	}

	public void buildMinTree() {
		int l = (int) Math.ceil(index / 2.0) - 1;
		for (int i = l; i >= 0; i--) {
			int temp;
			if (2 * i + 2 == index) {
				if (a[2 * i + 1] > a[2 * i + 2]) {
					temp = a[2 * i + 1];
					a[2 * i + 1] = a[2 * i + 2];
					a[2 * i + 2] = temp;
				}
			}
			if (a[2 * i + 1] < a[i]) {
				temp = a[i];
				a[i] = a[2 * i + 1];
				a[2 * i + 1] = temp;
			}
		}
	}
	public void remove(){
		if(index >= 0){
			a[0] = a[index];
			index--;
			buildMinTree();
			System.out.println(a[0]);
		}else{
			System.out.println("NULL");
		}
	}
	public void add(int data){
		index++;
		a[index] = data;
		buildMinTree();
		System.out.println(a[0]);
	}

	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while(st.nextToken() != StreamTokenizer.TT_EOF){
			int n = (int)st.nval;
			Main m = new Main(n);
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
