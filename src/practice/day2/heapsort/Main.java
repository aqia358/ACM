package practice.day2.heapsort;

/**
 * 2014年3月19日 11:10:35
 * 2014年3月19日 11:31:13
 * @author aqia358
 *
 */
public class Main {

	public static void heap(int[] a){
		for(int i = a.length-1; i > 0; i--){
			buildHeap(a, i);
//			System.out.print(a[0]+" ");
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
		}
	}

	public static void buildHeap(int[] a,int size){
		for(int i = getParent(size); i >= 0; i--){
			int min = a[i];
			if(2*i+2 <= size && a[2*i+2] < a[2*i+1]){
				min = a[2*i+2];
				a[2*i+2] = a[2*i+1];
				a[2*i+1] = min;
			}
			if(a[i] > a[2*i+1]){
				min = a[2*i+1];
				a[2*i+1] = a[i];
				a[i] = min;
			}
		}
	}
	
	public static int getParent(int node){
		return (node - 1)/2;
	}
	
	public static void main(String[] args) {
		int[] a = {9,8,7,6,5,4,3,2,1};
		Main.heap(a);
		for(int i = a.length - 1; i >= 0; i--){
			System.out.print(a[i]+" ");
		}
	}

}
