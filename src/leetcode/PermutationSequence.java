package leetcode;

import java.util.Arrays;

public class PermutationSequence {

	public static String getPermutation(int n, int k){
		int[] a = new int[n + 1];
		for(int i = 1; i <= n; i++)
			a[i] = i;
		for(int i = 1; i < k; i++){
			int left = a.length - 1;
			while(left > 1 && a[left] <= a[left - 1])
				left--;
			if(left > 1)
				left--;
			int right = a.length - 1;
			while(right > left && a[right] <= a[left])
				right--;
			int temp = a[right];
			a[right] = a[left];
			a[left] = temp;
			Arrays.sort(a, left + 1, a.length);			
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= n; i++)
			sb.append(a[i]);
		return sb.toString();
	}
	
	public static void nextPermutation(int a[], int num, int k){
		int left = a.length - 1;
		while(left > 1 && a[left] <= a[left - 1])
			left--;
		if(left > 1)
			left--;
		int right = a.length - 1;
		while(right > left && a[right] <= a[left])
			right--;
		int temp = a[right];
		a[right] = a[left];
		a[left] = temp;
		Arrays.sort(a, left + 1, a.length);
		num++;
		if(num >= k)
			return ;
		else
			nextPermutation(a, num, k);
	}
	public static String nextPermutation(int start, int end, int num, int k, String temp){
		if(start == end){
			num++;
			if(num == k) return temp;
		}
		for(int i = start; i <= end; i++){
			String next = nextPermutation(start + 1, end, num, k, temp + i);
			if(next != null)
				return next;
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(8 * 7*6*5*4*3*2*1);
		System.out.println(getPermutation(1, 1));
		System.out.println(getPermutation(3, 1));
		System.out.println(getPermutation(3, 2));
		System.out.println(getPermutation(3, 3));
		System.out.println(getPermutation(3, 4));
		System.out.println(getPermutation(3, 5));
		System.out.println(getPermutation(3, 6));
		System.out.println(getPermutation(3, 7));
//		int[] a = {5,4,3,2,1};
//		Arrays.sort(a, 1, a.length);
//		for(Integer t: a){
//			System.out.print(t);
//		}
	}

}
