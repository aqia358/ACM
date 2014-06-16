package leetcode;

public class RemoveElement {

	public static int removeElement(int[] A, int elem){
		int len = A.length;
		int count = 0;
		for(int i = 0; i < len; ++i){
			if(A[i] == elem)
				count++;
			else
				A[i - count] = A[i];
		}
		return len - count;
	}
	
	public static void main(String[] args) {
		int[] a = {4,5};
		System.out.println(removeElement(a, 4));
	}

}
