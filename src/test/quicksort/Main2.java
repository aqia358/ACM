package test.quicksort;

/**
 * 11时21分14秒
 * @author aqia358
 * 11时29分52秒
 */
public class Main2 {

	public void quickSort(int[] array, int begin, int end){
		int left = begin;
		int right = end;
		int t = array[left];
//		int temp[] = new int[array.length];
		while(left < right){
			while(left < right && t <= array[right])
				right--;
			if(left < right)
				array[left] = array[right];
			while(left < right && t > array[left])
				left++;
			if(left < right)
				array[right] = array[left];
		}
		array[left] = t;
		if(left - begin > 1)
			quickSort(array,begin,left-1);
		if(end - left > 1)
			quickSort(array,left+1,end);
	}
	public static void main(String[] args) {
		int[] a = {2,1,3,4,6,5,8,7,0,9};
		Main2 m = new Main2();
		m.quickSort(a, 0, a.length - 1);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i]+" ");
		}
		
	}

}
