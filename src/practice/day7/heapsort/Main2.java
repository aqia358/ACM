package practice.day7.heapsort;

/**
 * 2014年3月25日 11:30:51
 * @author aqia358
 *
 */
public class Main2 {

	public static void heap(int[] a){
		for(int i = (a.length - 1)/2; i >= 0; i--)
			buildHeap(a, a.length, i);
		for(int j = a.length; j > 0; j--){
			swap(a, j, 0);
			buildHeap(a, j, 0);
		}
	}
	public static void buildHeap(int[] a, int size , int pos){
		int largest = pos;
		if(2*pos+2 < size && pos < a[2*pos+2]){
			largest = 2*pos+2;
		}
		if(2*pos+1 < size && a[largest] < a[2*pos+1]){
			largest = 2*pos+1;
		}
		if(largest != pos){
			swap(a, pos, largest);
			buildHeap(a, size , largest);
		}
	}
	
	public static void swap(int[] a, int left, int right){
		int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}
	
	public static void main(String[] args) {
		int[] a = {9,8,7,6,3,5,4,3,2,1,1};
		Main.heap(a);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i]+" ");
		}
		
	}

}
