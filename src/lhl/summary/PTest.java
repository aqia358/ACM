package lhl.summary;

import java.util.Arrays;

public class PTest {

	public static int aSearch(int[] A, int target){
		int left = 0;
		int right = A.length - 1;
		while(left <= right) {
			int center = (left + right)/2;
			if(A[center] == target){
				return center;
			} 
			if(A[center] < A[right]){
				if(target > A[center] && target <= A[right]){
					left = center + 1;
				} else 
					right = center - 1;
			} else if(A[center] > A[right]){
				if(target >= A[left] && target < A[center]){
					right = center - 1;
				} else
					left = center + 1;
			} else
				right--;
		}
		return  -1;
	}
	
	public static void next(int[] a) {
		int len = a.length;
		int p = len - 1;
		while(p > 0 && a[p - 1] >= a[p])
			--p;
		if(p == 0)
			Arrays.sort(a);
		else {
			int r = len - 1;
			while(a[r] <= a[p - 1])
				r--;
			swap(a, r, p - 1);
			Arrays.sort(a, p, len);
		}
	}
	
	public static void swap(int[] a, int l, int r){
		int temp = a[l];
		a[l] = a[r];
		a[r] = temp;
	}
	
	public static void climbStairs(int n){
		int p1 = 1;
		int p2 = 1;
		int cur = 1;
		for(int i = 2; i <= n; i++){
			cur = p1 + p2;
			p1 = p2;
			p2 = cur;
		}
		System.out.println(cur);
	}
	
	public static void main(String[] args) {
		int[] a = {4,5,6,7,8,1,2,3};
		System.out.println(aSearch(a, 8));
		Arrays.sort(a);
		for(int i = 0; i < 10; i++){
			climbStairs(i);
			next(a);
		}
	}

}
