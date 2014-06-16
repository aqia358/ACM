package leetcode;

public class SortColors {

	public static void sortColors(int[] A){
		int len = A.length;
		int left = 0;
		int right = len - 1;
		for(int i = 0; i < 2; ++i){
			while(left < right){
				while(left < right && A[left] == i)
					left++;
				while(left < right && A[right] != i)
					right--;
				if(left < right){
					A[right] = A[left];
					A[left] = i;
				}
			}
			right = len - 1;
		}
	}
	
	public static void main(String[] args) {
		int[] A = {0,1,2,2,1,2,1,2,1,0};
		sortColors(A);
	}	
}
