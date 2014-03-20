package practice.day2.heapsort;

/**
 * 2014年3月19日 17:17:47
 * 2014年3月19日 17:29:08
 * @author aqia358
 *
 */
public class Main2 {

	public static void heapSort(int[] a){
		for(int i = a.length - 1; i > 0; i--){
			buildHeap(a, i);
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
		}
		
	}

	public static void buildHeap(int[] a, int size){
		for(int i = (size - 1)/2; i >= 0; i--){
			int min = a[i];
			if(2*i+2 <= size && a[2*i+2] > a[2*i+1]){
				min = a[2*i+2];
				a[2*i+2] = a[2*i+1];
				a[2*i+1] = min;
			}
			if(a[2*i+1] > a[i]){
				min = a[2*i+1];
				a[2*i+1] = a[i];
				a[i] = min;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = {9,8,7,6,5,4,3,2,1};
		Main2.heapSort(a);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i]+" ");
		}
		
	}

}
