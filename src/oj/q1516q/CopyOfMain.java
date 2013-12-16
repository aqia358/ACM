package oj.q1516q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 调整数组顺序使奇数位于偶数前面
 * @author aqia358
 * 
 */
public class CopyOfMain {

	public static void merge(int[] a1, int p1, int a2[], int p2){
		int m = 0;
		int n = 0;
		while(m < p1){
			System.out.print(a1[m++]+" ");
		}
		while(n < p2 - 1){
			System.out.print(a2[n++]+" ");
		}
		System.out.print(a2[n]);
	}
	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while(st.nextToken() != st.TT_EOF){
			int n = (int) st.nval;
			int[] a1 = new int[n];
			int[] a2 = new int[n];
			int p1 = 0;
			int p2 = 0;
			int count = 0;
			while(count < n){
				st.nextToken();
				int t = (int) st.nval;
				if(t%2 != 0){
					a1[p1++] = t;
				}else{
					a2[p2++] = t;
				}
				count++;
			}
			merge(a1,p1,a2,p2);
		}
	}
}
