package practice.day2.binarysearch;

public class Main {

	public static int binarySearch(int[] A, int elm){
		int len = A.length;
		int begin = 0;
		int center;
		int end = len - 1;
		while(begin < end){
			center = (begin + end)/2;
			if(A[center] > elm){
				end = center - 1;
			}else if(A[center] < elm){
				begin = center + 1;
			}else
				return center;
		}
		return end + 1;
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,5,6};
		System.out.println(binarySearch(a, 0));
		System.out.println(binarySearch(a, 3));
		System.out.println(binarySearch(a, 4));
		System.out.println(binarySearch(a, 7));
	}

}
