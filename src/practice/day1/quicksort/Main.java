package practice.day1.quicksort;

/**
 * 2014年3月17日 21:18:14
 * 2014年3月17日 21:47:12
 * @author aqia358
 * 
 */
public class Main {

	public static void quick(int[] a, int left, int right) {
		int temp = a[left];
		int begin = left;
		int end = right;
		while (begin < end) {
			while (begin < end && temp < a[end])
				end--;
			if (begin < end)
				a[begin] = a[end];
			while (begin < end && temp > a[begin])
				begin++;
			if (begin < end)
				a[end] = a[begin];
		}
		a[begin] = temp;
		if (begin - left > 1)
			quick(a, left, begin);
		if (right - end > 1)
			quick(a, begin + 1, right);
	}

	public static void main(String[] args) {
		int[] a = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		Main.quick(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
