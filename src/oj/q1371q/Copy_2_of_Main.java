package oj.q1371q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 最小的K个数 
 * 快速排序取最小的k个 时间复杂度O(n*log n)
 * @author aqia358
 *
 */
public class Copy_2_of_Main {
	
	public static void quickSort(long[] a,int begin, int end){
		int left = begin;
		int right = end;
		long key = a[left];
		while(left < right){
			while(left < right && a[right] >= key)
				right--;
			if(left < right)
				a[left] = a[right];
			while(left < right && a[left] < key)
				left++;
			if(left < right)
				a[right] = a[left];
		}
		a[left] = key;
		if(left - begin > 1)
			quickSort(a,begin,left - 1);
		if(end - right > 1)
			quickSort(a,right + 1,end);
	}
	public static void main(String[] args) throws IOException {
//		long[] a = {7,6,5,4,3,2,1,3};
//		quickSort(a,0,a.length - 1);
//		for(int i = 0; i < a.length; i++){
//			System.out.println(a[i]);
//		}
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
			quickSort(array,0,array.length - 1);
			for(int i = 0; i < k - 1; i++){
				System.out.print(array[i]+" ");
			}
			System.out.println(array[k - 1]);
		}
		
	}

}
