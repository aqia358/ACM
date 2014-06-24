package leetcode;

import java.util.HashSet;

public class FirstMissingPositive {

	public static int firstMissingPositive(int[] A){
		int len = A.length;
		for(int i = 0; i < len; i++){
			while(A[i] != i + 1){
				if(A[i] > len || A[i] <= 0 || A[i] == A[A[i] - 1])
					break;
				swap(A, i, A[i] - 1);
			}
		}
		for(int i = 0; i < len; i++)
			if(A[i] != i + 1)
				return i + 1;
		return len + 1;
	}
	public static void swap(int[] a, int s, int e){
		int temp = a[s];
		a[s] = a[e];
		a[e] = temp;
	}
	public static int firstMissingPositive2(int[] A){
		if(A.length == 0) return 1;
		HashSet<Integer> l = new HashSet<Integer>();
		for(Integer i : A){
			if(i > 0)
				l.add(i);
		}
		int leftMis = 1;
		int rightMis = Integer.MAX_VALUE;
		while(!l.isEmpty()){
			Integer temp = l.iterator().next();
			l.remove(temp);
			int left = temp - 1;
			while(l.contains(left)){
				l.remove((Integer)left);
				left--;
			}
			int right = temp + 1;
			while(l.contains(right)){
				l.remove((Integer)right);
				right++;
			}
			if(leftMis > left)
				leftMis = left;
			if(rightMis > right)
				rightMis = right;
		}
		return leftMis == 0 ? rightMis : leftMis;
	}
	public static void main(String[] args) {
//		int[] a = {1};
//		int[] a = {1,2,0};
//		int[] a = {3,4,-1,1};
		int[] a = {1,2,2,1,3,1,0,4,0};
		System.out.println(firstMissingPositive(a));
	}

}
