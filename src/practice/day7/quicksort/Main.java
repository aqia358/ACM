package practice.day7.quicksort;

/**
 * 2014年3月24日 13:22:56
 * 2014年3月24日 13:29:20
 * @author aqia358
 * 
 */
public class Main {

	public static void quicksort(int[] a, int left, int right) {
		int key = a[left];
		int leftBegin = left;
		int rightBegin = right;
		while (leftBegin < rightBegin) {
			while (leftBegin < rightBegin && key < a[rightBegin])
				rightBegin--;
			if (leftBegin < rightBegin)
				a[leftBegin] = a[rightBegin];
			while (leftBegin < rightBegin && key > a[leftBegin])
				leftBegin++;
			if (leftBegin < rightBegin)
				a[rightBegin] = a[leftBegin];
		}
		a[leftBegin] = key;
		if(leftBegin - left > 1)
			quicksort(a, left, leftBegin);
		if(right - rightBegin > 1)
			quicksort(a, leftBegin+1, right);
	}

	public static void main(String[] args) {
		int[] a = {9,8,7,6,5,4,3,2,1};
		Main.quicksort(a, 0, a.length - 1);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i]+" ");
		}
	}

}
