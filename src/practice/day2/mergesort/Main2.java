package practice.day2.mergesort;

/**
 * 2014年3月19日 17:10:59
 * 2014年3月19日 17:17:18
 * @author aqia358
 *
 */
public class Main2 {
	public static int[] temp;

	public static void mergeSort(int[] a, int left, int right){
		int center = (left+right)/2;
		if(left < right){
			mergeSort(a, left, center);
			mergeSort(a, center + 1, right);
			int i = left;
			int leftBegin = left;
			int rightBegin = center + 1;
			while(leftBegin <= center && rightBegin <= right){
				if(a[leftBegin] < a[rightBegin]){
					temp[i++] = a[leftBegin++];
				}else{
					temp[i++] = a[rightBegin++];
				}
			}
			while(leftBegin <= center)
				temp[i++] = a[leftBegin++];
			while(rightBegin <= right)
				temp[i++] = a[rightBegin++];
			for(int j = left; j <= right; j++)
				a[j] = temp[j];
		}
	}
	
	public static void main(String[] args) {
		int[] a = {9,8,7,6,5,4,3,2,1};
		Main.temp = new int[a.length];
		Main.mergeSort(a, 0, a.length - 1);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i]+" ");
		}
	}

}
