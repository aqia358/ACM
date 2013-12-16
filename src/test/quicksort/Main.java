package test.quicksort;

/**
 * 20时15分59秒
 * @author aqia358
 * 20时46分25秒
 */
public class Main {

	public void qSort(int[] array, int begin, int end){
//		if(begin == end)return;
		int temp = array[begin];
		int left = begin;
		int right = end;
		while(left < right){
			while(left < right && temp <= array[right])
				right--;
			if(left < right)
				array[left] = array[right];
			while(left < right && array[left] < temp)
				left++;
			if(left < right)
				array[right] = array[left];
		}
		array[left] = temp;
		if(left - begin > 1)
			qSort(array, begin, left - 1);
		if(end - left > 1)
			qSort(array, left + 1, end);
	}
	public static void main(String[] args) {
		int[] a = {2,1,4,3,6,5,8,7,0,9};
		Main m = new Main();
		m.qSort(a, 0, a.length - 1);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i]+" ");
		}
	}

}
