package practice.day14.mergesort;

/**
 * 2014年4月2日 11:12:47
 * 2014年4月2日 11:24:27
 * @author aqia358
 *
 */
public class Main {

	public static int[] temp;
	
	public static void merge(int[] a, int begin, int end){
		if(begin >= end)return;
		int center = (begin + end)/2;
		merge(a, begin, center);
		merge(a, center + 1, end);
		int left = begin;
		int i = begin;
		int right = center + 1;
		while(left <= center && right <= end){
			if(a[left] < a[right])
				temp[i++] = a[left++];
			else
				temp[i++] = a[right++];
		}
		while(left <= center)
			temp[i++] = a[left++];
		while(right <= end)
			temp[i++] = a[right++];
		for(int j = begin; j <= end; ++j){
			a[j] = temp[j];
		}
	}
	public static void print(int[] a){
		for(int i = 0; i < a.length; ++i){
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9};
		Main.temp = new int[a.length];
		Main.merge(a, 0, a.length - 1);
		Main.print(a);
		int[] b = {1};
		Main.temp = new int[b.length];
		Main.merge(b, 0, b.length - 1);
		Main.print(b);
		int[] c = {9,8,7,6,6,5,4,3,2,};
		Main.temp = new int[c.length];
		Main.merge(c, 0, c.length - 1);
		Main.print(c);
	}

}
