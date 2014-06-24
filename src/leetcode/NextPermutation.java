package leetcode;

import java.util.Arrays;

public class NextPermutation {

	public static void nextPermutation(int[] num){
		int len = num.length - 1;
		int p = len;
		while(p > 0 && num[p] <= num[p - 1]){
			p--;
		}
		if(p == 0)
			Arrays.sort(num);
		else{
			int e = len;
			while(num[e] <= num[p - 1])
				e--;
			swap(num, p - 1, e);
			Arrays.sort(num, p, len + 1);
		}
	}
	
	public static void swap(int[] a, int l, int r){
		int temp = a[l];
		a[l] = a[r];
		a[r] = temp;
	}
	
	public static void main(String[] args) {
		int[] a = {1,5,1};
//		int[] a = {1,2,7,6,5,4,3};
		nextPermutation(a);
		nextPermutation(a);
		nextPermutation(a);
		nextPermutation(a);
		nextPermutation(a);
		nextPermutation(a);
		nextPermutation(a);
		nextPermutation(a);
		nextPermutation(a);
		nextPermutation(a);
		nextPermutation(a);
		nextPermutation(a);
		nextPermutation(a);
		nextPermutation(a);
		System.out.println();
	}

}
