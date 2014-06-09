package leetcode;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 */
public class InsertPosition {

	public static int searchInsert(int[] A, int target){
		int len = A.length;
		int start = 0;
		int end = len - 1;
		int pos = len/2;
		while(start <= end){
			if(A[pos] == target){
				return pos;
			}else{
				if(A[pos] > target){
					end = pos - 1;
				}else if(A[pos] < target){
					start = pos + 1;
				}
				pos = (start + end)/2;
			}
		}
		return end + 1;
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,5,6};
		int[] b = {1,3};
		int[] c = {1};
//		System.out.println("pre"+searchInsert(a, 0));
//		System.out.println("has"+searchInsert(a, 3));
//		System.out.println("not has"+searchInsert(a, 4));
//		System.out.println("end"+searchInsert(a, 7));
//		System.out.println("end"+searchInsert(b, 7));
		System.out.println("end"+searchInsert(b, 2));
		System.out.println("end"+searchInsert(c, 0));
//		System.out.println("end"+searchInsert(b, 8));
	}

}
