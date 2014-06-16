package leetcode;

public class RemoveDuplicates2 {

	public static int removeDuplicates(int[] A){
		int len = A.length;
		if(len <= 2) return len;
		int index = 1;
		for(int i = 2; i < len; ++i){
			if(A[i] != A[index - 1])
				A[++index] = A[i];
		}
		return index + 1;
	}
	public static int removeDuplicates2(int[] A){
		int count = 0;
		int start = 0;
		int len = A.length;
		boolean flag = false;
		for(int i = 1; i < len; ++i){
			if(A[start] == A[i]){
				if(flag){
					count++;
				} else{
					flag = true;
					A[i - count] = A[i];
					start++;
				}
			}else{
				A[i - count] = A[i];
				start++;
				flag = false;
			}
		}
		return len - count;
	}
	
	public static void main(String[] args) {
		int[] a = {0,0,0,0,0,2,2,2,3,3};
		System.out.println(removeDuplicates(a));
	}

}
