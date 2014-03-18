package practice.heapsort;

/**
 * 2014年3月18日 14:41:32
 * 2014年3月18日 15:23:23
 * @author aqia358
 * 
 */
public class Main {

	public static void heap(int[] a) {
		for (int i = a.length - 1; i >= 0; i--) {
			buildHeap(a, i);
			System.out.print(a[0] + " ");
			a[0] = a[i];
		}
	}

	public static void buildHeap(int[] a, int size) {
		for (int i = getParent(size); i >= 0; i--) {
			if (2 * i + 2 <= size && a[2 * i + 2] < a[2 * i + 1]) {
				int min = a[2 * i + 2];
				a[2 * i + 2] = a[2 * i + 1];
				a[2 * i + 1] = min;
			}
			if (a[i] > a[2 * i + 1]) {
				int temp = a[2 * i + 1];
				a[2 * i + 1] = a[i];
				a[i] = temp;
			}
		}
	}
	
	public static int getParent(int a){
		return (a - 1) >> 1;
	}

	public static void main(String[] args) {
//		int[] a = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int[] a = { 2, 1, 4, 3, 6, 5, 8, 7, 9 };
		Main.heap(a);
	}

}
