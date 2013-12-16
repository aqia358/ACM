package oj.q1398q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 移动次数 19时52分50秒
 * 
 * @author aqia358
 * 
 * 20时06分27秒
 */
public class Main {

	public void move(int[] a) {
		int minPos = 0;
		int maxPos = a.length - 1;
		int min = a[minPos];
		int max = a[maxPos];
		for (int i = 0; i < a.length; i++) {
			if (min > a[i]) {
				min = a[i];
				minPos = i;
			}
			if (max <= a[i]) {
				max = a[i];
				maxPos = i;
			}
		}
		if (minPos < maxPos) {
			System.out.println(minPos + a.length - 1 - maxPos);
		} else {
			System.out.println(minPos + a.length - 1 - maxPos - 1);
		}
	}

	public static void main(String[] args) throws IOException {
		Main m = new Main();
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while(st.nextToken() != StreamTokenizer.TT_EOF){
			int n = (int)st.nval;
			int[] array = new int[n];
			for(int i = 0; i < n; i++){
				st.nextToken();
				array[i] = (int) st.nval;
			}
			m.move(array);
		}
	}

}
