package leetcode;

public class MaximumSubarray {

	public static int maxSubArray(int[] A){
		int sum = 0;
		int max = A[0];
		int len = A.length;
		for(int i = 0; i < len; ++i){
			if(sum + A[i] >= 0){
				sum += A[i];
				if(sum > max)
					max = sum;
			}else
				sum = 0;
		}
		if(max < 0){
			for(int j = 1; j < len;++j){
				if(max < A[j])
					max = A[j];
			}
		}
		return max;
	}
	public static int maxSubArray2(int[] A){
		int sum = 0;
		int max = A[0];
		int len = A.length;
		for(int i = 0; i < len; i++){
			sum = sum < 0 ? A[i] : sum + A[i];
			max = sum > max ? sum : max;
		}
		return max;
	}
	
	public static void main(String[] args) {
		int[] A = {-2,1,-3,4,-1,2,1,-5,4};
		int[] a = {-2,-1};
		int[] b = {-1};
		System.out.println(maxSubArray(A));
		System.out.println(maxSubArray(a));
		System.out.println(maxSubArray(b));
		System.out.println(maxSubArray2(A));
		System.out.println(maxSubArray2(a));
		System.out.println(maxSubArray2(b));
	}

}
