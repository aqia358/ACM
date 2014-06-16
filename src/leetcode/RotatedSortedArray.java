package leetcode;

public class RotatedSortedArray {

	public static int search(int[] A, int target){
		int len = A.length;
		int pos = -1;
		for(int i = 0; i < len - 1; ++i){
			if(A[i] > A[i+1])
				pos = i;
		}
		int s = 0;
		int e = len - 1;
		int center = 0;
		if(pos != -1){
			s = pos + 1;
			e = pos;
			if(A[center] == target){
				return center;
			}else if(A[center] > target){
				e = len - 1;
			}else{
				s = center + 1;
			}
		}
		while(s <= e){
			center = (s + e)/2;
			if(A[center] == target){
				return center;
			}else if(A[center] > target){
				e = center - 1;
			}else{
				s = center + 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] a = {4, 5, 6, 7, 7};
//		int[] a = {4, 5, 6, 7, 0, 1, 2};
		System.out.println(search(a, 5));
		System.out.println(search(a, 1));
		System.out.println(search(a, 11));
	}

}
