package oj.q1371q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 最小的K个数 
 * 堆排序取最小的k个 时间复杂度O（k+（n-k）*logk）
 * @author aqia358
 *
 */
public class Heap_Main {
	
	public static void BuildHeap(int[] a, int n){
		for(int i = a.length/2 - 1; i >= 0; i--){
			HeapAdjust(a, i, n);
		}
	}
	
	public static void HeapAdjust(int[] a, int i, int n){
		int  j = 2 * i + 1;
		if(j < n){
			if(j+1 < n && a[j] > a[j+1]){
				int t = a[j];
				a[j] = a[j+1];
				a[j+1] = t;
			}
			int temp = a[i];
			if(a[j] < temp){
				a[i] = a[j];
				a[j] = temp;
			}
		}
	}

	public static void MinHeapFixDown(int[] a, int i, int n){
		int j = 2 * i + 1;
		while(i >= 0){
			int temp = a[i];
			if(j+1 < n-1 && a[j] > a[j+1]){
				int t = a[j];
				a[j] = a[j+1];
				a[j+1] = t;
			}
			if(a[j] < temp){
				a[i] = a[j];
				a[j] = temp;
			}
			i = i/2 - 1;	
		}
	}
	public static void MinHeap(int[]a, int k){
		for(int i = a.length-1; i >= a.length - k; i--){
			BuildHeap(a,i);
			System.out.print(a[0]+" ");
			a[0] = a[i];
		}
	}
	public static void MyHeap(int[] a){
		for(int i = a.length/2 - 1; i >= 0; i--){
			MinHeapFixDown(a, i, a.length);
		}
	}
	public static void print(int[] a){
		int count = 0;
		int s = 0;
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i]+" ");
			if(i == 2*count+s){
				s = 2*count+s;
				if(i == 0)
					count = 1;
				else
					count = 2*count;
				System.out.println();
			}
		}
	}
	public static void main(String[] args) throws IOException {
		int[] a = {9,12,17,30,50,20,60,65,4,19};
//		MyHeap(a);
		BuildHeap(a,a.length);
		print(a);
		System.out.println();
		MinHeap(a, 4);
//		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
//		while(st.nextToken() != StreamTokenizer.TT_EOF){
//			int n = (int)st.nval;
//			st.nextToken();
//			int k = (int)st.nval;
//			int count = 0;
//			long[] array = new long[n];
//			while(count < n){
//				st.nextToken();
//				array[count] = (long)st.nval;
//				count++;
//			}
//			quickSort(array,0,array.length - 1);
//			for(int i = 0; i < k - 1; i++){
//				System.out.print(array[i]+" ");
//			}
//			System.out.println(array[k - 1]);
//		}
		
	}

}
