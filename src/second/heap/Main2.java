package second.heap;

/**
 * max heap
 * 
 * @author aqia358
 * 
 */
public class Main2 {

	public void heap(int[] a) {
		for (int i = a.length - 1; i >= 0; i--) {
			buildHeap(a, i);
			System.out.print(a[0] + " ");
			a[0] = a[i];
		}
	}

	public void buildHeap(int[] a, int size) {
		for (int i = size / 2 - 1; i >= 0; i--) {
			if (2 * i + 2 < size && a[2 * i + 1] > a[2 * i + 2]) {
				int temp = a[2 * i + 1];
				a[2 * i + 1] = a[2 * i + 2];
				a[2 * i + 2] = temp;
			}
			if (a[2 * i + 1] < a[i]) {
				int temp2 = a[2 * i + 1];
				a[2 * i + 1] = a[i];
				a[i] = temp2;
			}
		}
	}

	public static void main(String[] args) {
		int[] a = { 2, 1, 4, 3, 6, 5, 8, 7, 9 };
		Main2 m = new Main2();
		m.heap(a);
	}

}
