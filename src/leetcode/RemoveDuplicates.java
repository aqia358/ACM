package leetcode;

public class RemoveDuplicates {

	public static int removeDuplicates(int[] A){
		int len = A.length;
		int index = 0;
		for(int i = 1; i < len; ++i){
			if(A[i] != A[index])
				A[++index] = A[i];
		}
		return index + 1;
	}
	public static int removeDuplicates2(int[] A){
		int count = 0;
		int start = 0;
		int len = A.length;
		for(int i = 1; i < len; ++i){
			if(A[start] == A[i]){
				count++;
			}else{
				A[i - count] = A[i];
				start++;
			}
		}
		return len - count;
	}
	
	public static void main(String[] args) {
		int[] a = {1,1,1,2,2,3};
		System.out.println(removeDuplicates(a));
	}

}
