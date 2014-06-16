package leetcode;

/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * @author aqia358
 *
 */
public class MergeArray {

	public static void merge(int[] A, int m, int[] B, int n){
		int a = m - 1;
		int b = n - 1;
		int i = m + n - 1;
		while(a >= 0 && b >= 0){
			while(a >= 0 && b >= 0 && A[a] >= B[b])
				A[i--] = A[a--];
			while(a >= 0 && b >= 0 && A[a] < B[b])
				A[i--] = B[b--];
		}
		if(b >= 0)
			while(b >= 0)
				A[i--] = B[b--];
	}
	
	public static void merge2(int[] A, int m, int[] B, int n){
		int[] result = new int[m+n];
		int a = 0;
		int b = 0;
		int i = 0;
		while(a < m && b < n){
			while(a < m && b < n && A[a] <= B[b])
				result[i++] = A[a++];
			while(a < m && b < n && A[a] > B[b])
				result[i++] = B[b++];
			if(a < m)
				while(a < m)
					result[i++] = A[a++];
			if(b < n)
				while(b < n)
					result[i++] = B[b++];
		}
	}
	
	public static void main(String[] args) {
//		int[] a = new int[6];
//		int[] b = {-1,0};
//		a[0] = -1;
//		a[1] = -1;
//		a[2] = 0;
//		a[3] = 0;
//		merge(a, 6, b, 2);	
		int[] a = {4};
		int[] b = {1,2,3,5,6};
		merge(a, 1, b, 5);
	}

}
