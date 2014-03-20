package practice.day2.quicksort;

/**
 * 2014年3月18日 11:15:01
 * 2014年3月18日 11:20:46
 * @author aqia358
 *
 */
public class Main {

	public static void quick(int[] a, int begin, int end){
		int left = begin;
		int right = end;
		int key = a[begin];
		while(left < right){
			while(left < right && key < a[right])
				right--;
			if(left < right)
				a[left] = a[right];
			while(left < right && key > a[left])
				left++;
			if(left < right)
				a[right] = a[left];
		}
		a[left] = key;
		if(left - begin > 1)
			quick(a, begin, left);
		if(end - right > 1)
			quick(a, right + 1, end);
	}
	
	public static void main(String[] args) {
		int[] a = {9,8,7,6,5,4,3,2,1};
		Main.quick(a, 0, a.length - 1);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
	}

}
