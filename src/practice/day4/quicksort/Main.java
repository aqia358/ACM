package practice.day4.quicksort;

/**
 * 2014年3月20日 16:45:43
 * 2014年3月20日 16:53:44
 * @author aqia358
 *
 */
public class Main {

	public static void quicksort(int[] a, int left, int right){
		int key = a[left];
		int begin = left;
		int end = right;
		while(begin < end){
			while(begin < end && a[end] > key)
				end--;
			if(begin < end)
				a[begin] = a[end];
			while(begin < end && a[begin] < key)
				begin++;
			if(begin < end)
				a[end] = a[begin];
		}
		a[begin] = key;
		if(begin > left)
			quicksort(a, left, begin);
		if(right > begin)
			quicksort(a, end + 1, right);
		
	}
	
	public static void main(String[] args) {
//		int[] a = {9,8,7,6,5,4,3,2,1};
		int[] a = {1,2,3,4,5,6,7,8,9};
		Main.quicksort(a, 0, a.length - 1);
		for(int i = 0; i < a.length; i ++){
			System.out.print(a[i]+" ");
		}
	}

}
