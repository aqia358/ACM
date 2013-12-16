package oj.q1371q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 最小的K个数 
 * 选择排序取最小的k个 时间复杂度O(n*k)
 * @author aqia358
 *
 */
public class CopyOfMain {
	
	public static void find(long[] a,int k){
		for(int i = 0;i < k; i++){
			for(int j = i+1; j < a.length; j++){
				if(a[i] > a[j]){
					long temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
			if(i < k-1)
				System.out.print(a[i]+" ");
		}
		System.out.println(a[k-1]);
	}
	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while(st.nextToken() != StreamTokenizer.TT_EOF){
			int n = (int)st.nval;
			st.nextToken();
			int k = (int)st.nval;
			int count = 0;
			long[] array = new long[n];
			while(count < n){
				st.nextToken();
				array[count] = (long)st.nval;
				count++;
			}
			find(array,k);
		}
	}

}
