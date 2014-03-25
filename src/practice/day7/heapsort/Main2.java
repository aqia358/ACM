package practice.day7.heapsort;

/**
 * 2014年3月25日 11:30:51
 * @author aqia358
 *
 */
public class Main2 {

	public static void heap(int[] a){
		for(int i = a.length - 1; i > 0; i--)
			buildHeap(a, 0, i);
		for(int j = a.length - 1; j > 0; j--){
			
			buildHeap(a, j, j);
		}
	}
	public static void buildHeap(int[] a, int pos, int size){
		if(2*pos+2 <= size && a[2*pos+1] < a[2*pos+2]){
			swap(a, 2*pos+1, 2*pos+2);
		}
		if(a[pos] < a[2*pos+1]){
			swap(a, pos, 2*pos+1);
			buildHeap(a, 2*pos+1, size);
		}
	}
	
	public static void swap(int[] a, int left, int right){
		int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}
	
	public static void main(String[] args) {
		
	}

}
