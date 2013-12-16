package oj.q1349q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 数字再排序数组中出现的次数
 * @author aqia358
 *
 */
public class Main {
	
	public static void count(int[] a, int num){
		int pos = 0;
		for(pos = 0; pos < a.length; pos++){
			if(a[pos] == num)
				break;
		}
		int count = 0;
		while(pos < a.length){
			if(a[pos++] == num)
				count++;
			else
				break;
		}
		System.out.println(count);
	}

	public static void main(String[] args) throws IOException {
//		int[] a = {1,2,2,3,3,4,4,5,6,7,8,9};
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while(st.nextToken() != st.TT_EOF){
			int n = (int)st.nval;
			int[] a = new int[n];
			int count = 0;
			while(count < n	){
				st.nextToken();
				a[count++] = (int) st.nval;
			}
			st.nextToken();
			int m = (int) st.nval;
			while(m > 0){
				m--;
				st.nextToken();
				count(a,(int)st.nval);
			}
		}
	}

}
