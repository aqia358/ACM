package practice.day7.mergesort;

/**
 * 2014年3月25日 11:14:06
 * 2014年3月25日 11:22:07
 * @author aqia358
 *
 */
public class Main {
	public static int[] temp;

	public static void merge(int[] a, int begin, int end){
		if(begin < end){
			int center = (begin + end)/2;
			merge(a, begin, center);
			merge(a, center + 1, end);
			int i = begin;
			int left = begin;
			int right = center + 1;
			while(left <= center && right <= end){
				if(a[left] < a[right]){
					temp[i++] = a[left++];
				}else{
					temp[i++] = a[right++];
				}
			}
			while(left <= center)
				temp[i++] = a[left++];
			while(right <= end)
				temp[i++] = a[right++];
			for(int j = begin; j <= end; j++){
				a[j] = temp[j];
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = {9,8,7,6,5,4,3,2,1};
		Main.temp = new int[a.length];
		Main.merge(a, 0, a.length - 1);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i]+" ");
		}
	}

}
