package leetcode;

public class MedianofTwoSortedArrays {

	public static double findmedianSortedArrays(int A[], int B[]) {
		int lenA = A.length;
		int lenB = B.length;
		int len = lenA + lenB;
		if(len % 2 == 0)
			return (helper(A, 0, lenA - 1, B, 0, lenB - 1, len/2 + 1) 
					+ helper(A, 0, lenA - 1, B, 0, lenB - 1, len/2))/2.0;
		else
			return helper(A, 0, lenA - 1, B, 0, lenB - 1, len/2 + 1);
	}
	
	public static double helper(int[] A, int as, int ae, int[] B, int bs, int be, int k){
		int m = ae - as + 1;
		int n = be - bs + 1;
		if(m > n)
			return helper(B, bs, be, A, as, ae, k);
		if(m == 0) return B[bs + k - 1];
		if(k == 1) return Math.min(A[ae], B[be]);
		int posA = Math.min(m, k/2);
		int posB = k - posA;
		if(A[as + posA - 1] == B[bs + posB - 1])
			return A[as + posA - 1];
		else if(A[as + posA - 1] < B[bs + posB - 1])
			return helper(A, as + posA, ae, B, bs, bs + posB - 1, posB);
		else
			return helper(A, as, ae + posA - 1, B, bs + posB, be, posA);
	}
	
	public static double findmedianSortedArrays2(int A[], int B[]) {
		int lenA = A.length;
		int lenB = B.length;
		int len = lenA + lenB;
		int[] f = new int[len];
		int m = len/2;
		int i = 0;
		int ia = 0;
		int ib = 0;
		while(i <= m && ia < lenA && ib < lenB){
			while(i <= m && ia < lenA && ib < lenB && A[ia] >= B[ib])
				f[i++] = B[ib++];
			while(i <= m && ia < lenA && ib < lenB && A[ia] < B[ib])
				f[i++] = A[ia++];
		}
		while(i <= m && ia < lenA)
			f[i++] = A[ia++];
		while(i <= m && ib < lenB)
			f[i++] = B[ib++];
		if(len % 2 == 0){
			System.out.println(f[len/2]+" "+f[len/2 - 1]);
			return (f[len/2] + f[len/2 - 1])/2.0;
		}
		else
			return f[len/2];
	}
	
	public static void main(String[] args) {
		int[] a = {};
		int[] b = {2,3};
		System.out.println(findmedianSortedArrays(a, b));
	}

}
