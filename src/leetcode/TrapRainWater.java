package leetcode;

public class TrapRainWater {

	public static int trap(int[] A){
		int len = A.length;
		if(len < 3)return 0;
		int sum = 0;
		int left = 0;
		int lheight = A[left];
		int right = len - 1;
		int rheight = A[right];
		while(left < right){
			while(left < right && lheight <= rheight){
				left++;
				if(A[left] < lheight){
					sum += lheight - A[left];
				}else
					lheight = A[left];
			}
			while(left < right && lheight > rheight){
				right--;
				if(A[right] < rheight){
					sum += rheight - A[right];
				}else
					rheight = A[right];
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
//		int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
		int[] A = {3,2,1,3};
		System.out.println(trap(A));
	}

}
