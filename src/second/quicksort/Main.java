package second.quicksort;

/**
 * 2014年3月12日 16:35:53
 * @author aqia358
 *
 */
public class Main {
	
	public void quickSort(int left, int right, int[] a) {
		int begin = left;
		int end = right;
		int temp = a[left];
		while(begin < end){
			while(begin < end && temp < a[end]){
				end--;
			}
			a[begin] = a[end];
			while(begin < end && temp > a[begin]){
				begin++;
			}
			a[end] = a[begin];
		}
		a[begin] = temp;
		if(begin - left > 1)
			quickSort(left, begin - 1, a);
		if(right - end > 1)
			quickSort(begin + 1, right, a);
	}
	
	public static void main(String[] args) {
		int[] a = {2,1,4,3,6,5,8,7,9};
		Main m = new Main();
		m.quickSort(0, a.length - 1, a);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i]+" ");
		}
	}

}
