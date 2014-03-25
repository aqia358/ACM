package practice.day7.heapsort;

/**
 * 2014年3月25日 11:22:41
 * 2014年3月25日 11:28:28
 * @author aqia358
 *
 */
public class Main {

	public static void heap(int[] a){
		for(int i = a.length - 1; i > 0; i--){
			buildHeap(a, i);
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
		}
	}

	public static void buildHeap(int[] a, int size){
		for(int i = (size - 1)/2; i >= 0; i--){
			if(2*i+2 <= size && a[2*i+1] < a[2*i+2]){
				int temp = a[2*i+2];
				a[2*i+2] = a[2*i+1];
				a[2*i+1] = temp;
			}
			if(a[i] < a[2*i+1]){
				int temp = a[i];
				a[i] = a[2*i+1];
				a[2*i+1] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = {9,8,7,6,5,4,3,2,1,1};
		Main.heap(a);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i]+" ");
		}
	}

}
