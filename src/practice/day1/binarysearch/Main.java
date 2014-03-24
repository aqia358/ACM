package practice.day1.binarysearch;

/**
 * 2014年3月21日 16:31:27
 * 2014年3月21日 16:37:14
 * @author aqia358
 * 
 */
public class Main {

	public static void binarySearch(int[] a, int key) {
		int begin = 0;
		int end = a.length - 1;
		while (begin <= end) {
			int center = (begin + end) / 2;
			if(a[center] == key){
				System.out.println(center);
				break;
			} if (a[center] > key) {
				end = center - 1;
			} else {
				begin = center + 1;
			}
		}
	}

	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9};
		Main.binarySearch(a, 5);
		Main.binarySearch(a, 3);
	}

}
