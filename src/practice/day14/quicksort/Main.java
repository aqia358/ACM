package practice.day14.quicksort;

/**
 * 2014年4月1日 20:01:05
 * 2014年4月1日 20:06:50
 * @author aqia358
 *
 */
public class Main {

	public static void quickSort(int[] a, int begin, int end){
		int left = begin;
		int right = end;
		int key = a[left];
		while(left < right){
			while(left < right && a[right] >= key)
				right--;
			if(left < right)
				a[left] = a[right];
			while(left < right && a[left] < key)
				left++;
			if(left < right)
				a[right] = a[left];
		}
		a[right] = key;
		if(left - begin > 1)
			quickSort(a, begin, left - 1);
		if(end - right > 1)
			quickSort(a, right + 1, end);
	}
	
	public static void print(int[] temp){
		for(int i = 0; i < temp.length; ++i){
			System.out.print(temp[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] a = {9,8,7,6,5,4,3,2,1};
		int[] b = {1};
		int[] c = {1,2,3,4,5,6,7,9,8,9};
		quickSort(a, 0, a.length - 1);
		quickSort(b, 0, b.length - 1);
		quickSort(c, 0, c.length - 1);
		print(a);
		print(b);
		print(c);
	}

}
