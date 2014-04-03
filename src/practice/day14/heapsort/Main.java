package practice.day14.heapsort;

/**
 * 2014年4月2日 13:40:09
 * 
 * @author aqia358
 * 
 */
public class Main {

	public static void heapSort(int[] a) {
		if(a == null)return;
		for (int i = getParent(a.length - 1); i > 0; --i) {
			heapFix(a, i, a.length - 1);
		}
		for(int j = a.length - 1; j > 0; --j){
			int temp = a[0];
			a[0] = a[j];
			a[j] = temp;
			heapFix(a, 0, j);
		}
	}

	public static void heapFix(int[] a, int pos, int size) {
		int largest = pos;
		if (2 * pos + 2 <= size && a[2 * pos + 2] > a[pos]) {
			largest = 2 * pos + 2;
		}
		if (2 * pos + 1 < size && a[2 * pos + 1] > a[pos]) {
			largest = 2 * pos + 1;
		}
		if (largest != pos){
			int temp = a[pos];
			a[pos] = a[largest];
			a[largest] = temp;
			heapFix(a, largest, size);
		}
	}

	public static int getParent(int size) {
		return (size - 1) >> 1;
	}

	public static void print(int[] a){
		for(int i = 0; i < a.length; ++i){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] a = { 9, 8, 7, 6, 5, 4, 3, 3, 1 };
		heapSort(a);
		print(a);
		int[] b = { 1 };
		int[] c = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] d = null;
	}

}
