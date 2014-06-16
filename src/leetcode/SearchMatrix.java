package leetcode;

public class SearchMatrix {

	public static boolean searchMatrix(int[][] matrix, int target) {
		int row = matrix.length;
		if(row == 0)return false;
		int col = matrix[0].length;
		if(col == 0)return false;
		int e = row * col - 1;
		int s = 0;
		while(s <= e){
			int m = (s + e)/2;
			int value = matrix[m/col][m%col];
			if(value == target)
				return true;
			else if(value < target)
				s = m + 1;
			else
				e = m - 1;
		}
		return false;
	}
	
	public static boolean searchMatrix(int[][] matrix, int target, int row){
		if(row == matrix.length) return false;
		int pos = binarySearch(matrix[row], target);
		if(matrix[row][pos] == target)
			return true;
		else
			return searchMatrix(matrix, target, row + 1);
	}
	public static int binarySearch(int[] a, int target){
		int len = a.length;
		int left = 0;
		int right = len - 1;
		int center = (left + right)/2;
		while(left <= right){
			if(a[center] == target)
				return center;
			else if(a[center] > target){
				right = center - 1;
			}else{
				left = center + 1;
			}
			center = (left + right)/2;
		}
		return center;
	}
	
	public static void main(String[] args) {
		int[][] a = {{1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};
		System.out.println(searchMatrix(a, 3));
		System.out.println(searchMatrix(a, 11));
		System.out.println(searchMatrix(a, 12));
		System.out.println(binarySearch(a[1], 11));
		
	}

}
