package leetcode;

public class JumpGame2 {

	public static int jump0(int[] A){
		
		return 0;
	}
	public static int jump(int[] A){
		int len = A.length;
		int last = 0;
		int step = 0;
		int max = 0;
		for(int i = 0; i <= max && i < len; i++){
			if(i > last){
				last = max;
				++step;
			}
			max = Math.max(max, i + A[i]);
		}
		return step;
	}
	
	public static int jump2(int[] A){
		int len = A.length;
		int[] f = new int[len];
		f[0] = 1;
		for(int i = 1; i < len; i++){
			f[i] = f[i - 1] + 1;
			for(int j = i - 1; j >= 0; j--){
				if(A[j] + j >= i)
					f[i] = Math.min(f[i], f[j]) + 1;
			}
		}
		return f[len - 1] - 1;
	}
	
	public static void main(String[] args) {
//		int[] a = {0};
		int[] a = {2,3,1,1,4};
		System.out.println(jump(a));
	}

}
