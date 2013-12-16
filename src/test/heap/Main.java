package test.heap;

/**
 * 15时21分40秒
 * 
 * @author aqia358
 * 
 */
public class Main {

	public void heapSort(int[] a){
		ad(a,a.length);
		for(int i = a.length - 1; i > 0; i--){
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			ad(a, i);
		}
//		adjustHeap(a,a.length);
//		for(int i = a.length - 1; i > 0; i--){
//			int temp = a[0];
//			a[0] = a[i];
//			a[i] = temp;
//			adjustHeap(a, i);
//		}
	}
	/**
	 * 维持size的小根堆
	 * @param a
	 * @param size
	 */
	public void adjustHeap(int[] a, int size) {
		int n = size;
		for (int i = n/2 - 1; i >= 0; i--) {
			for (int j = i; j >= 0; j--) {
				int left = a[2 * j + 1];
				if (n > 2 * j + 2) {
					if (left > a[2 * j + 2]) {
						a[2 * j + 1] = a[2 * j + 2];
						a[2 * j + 2] = left;
					}
				}
				if (a[j] > a[2 * j + 1]) {
					int temp = a[j];
					a[j] = a[2 * j + 1];
					a[2 * j + 1] = temp;
				}
			}
		}
	}
	
	public void ad(int[] a, int size){
		int n = size;
		for(int j = n/2 - 1; j >= 0; j--){
			int left = a[2 * j + 1];
			if (n > 2 * j + 2) {
				if (left > a[2 * j + 2]) {
					a[2 * j + 1] = a[2 * j + 2];
					a[2 * j + 2] = left;
				}
			}
			if (a[j] > a[2 * j + 1]) {
				int temp = a[j];
				a[j] = a[2 * j + 1];
				a[2 * j + 1] = temp;
			}
		}
	}
	public void maxHeapSort(int[] a){
		maxHeapAdjust(a, a.length);
		for(int i = a.length-1; i > 0; i--){
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			maxHeapAdjust(a, i);
		}
	}
	/**
	 * 维持size大小的大根堆
	 * @param a
	 * @param size
	 */
	public void maxHeapAdjust(int[] a, int size){
		for(int i = size/2 - 1; i >= 0; i--){
			int max;
			if(2*i+2 < size && a[2*i+1] < a[2*i+2]){
				max = a[2*i+1];
				a[2*i+1] = a[2*i+2];
				a[2*i+2] = max;
			}
			if(2*i+1 < size && a[i] < a[2*i+1]){
				max = a[2*i+1];
				a[2*i+1] = a[i];
				a[i] = max;
			}
		}
	}
	public void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static void main(String[] args) {
		int[] a = { 2, 1, 4, 3, 6, 5, 8, 7, 0, 9 };
		Main m = new Main();
//		m.heapSort(a);
		m.maxHeapSort(a);
		m.print(a);
//		System.out.println(9 / 2);
//		System.out.println(Math.round(7.1 / 2));
//		System.out.println(Math.round(8.1 / 2));

	}

}
