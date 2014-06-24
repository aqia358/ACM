package leetcode;


public class BSearch {

	public static int[] searchRange(int[] A, int target){
		int[] re = {-1, -1};
		int len = A.length;
		int index = bSearch(A, target, 0, len - 1);
		if(index != -1){
			int left = index;
			int right = index;
			re[0] = left;
			re[1] = right;
			while((left = bSearch(A, target, 0, left - 1)) != -1)
				re[0] = left;
			while((right = bSearch(A, target, right + 1, len - 1)) != -1)
				re[1] = right;
		}
		return re;
	}
	
	public static int bSearch(int[] A, int target, int s, int e){
		while(s <= e) {
			int m = (s + e)/2;
			if(A[m] == target)
				return m;
			else if(A[m] < target)
				s = m + 1;
			else
				e = m -1;
		}
		return  -1;
	}
	public static int bSearchLeft(int[] A, double target, int s, int e){
		while(s <= e){
			int m = (s + e)/2;
			if(A[m] >= target){
				e = m - 1;
			}else
				s = m + 1;
		}
		return s;
	}
	public static int bSearchRight(int[] A, double target, int s, int e){
		while(s <= e){
			int m = (s + e)/2;
			if(A[m] <= target){
				s = m + 1;
			}else
				e = m - 1;
		}
		return s - 1;
	}
	public static void main(String[] args) {
		int[] A = {1};
//		int[] A = {5, 7, 7, 8, 8, 10};
//		System.out.println(bSearchLeft(A, 2, 0, A.length - 1));
//		System.out.println(bSearchRight(A, 2, 0, A.length - 1));
		int[] b = searchRange(A, 1);
		System.out.println(b[0]+" "+b[1]);
	}

}
