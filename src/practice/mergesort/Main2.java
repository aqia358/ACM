package practice.mergesort;

/**
 * 2014年3月18日 14:32:27
 * 2014年3月18日 14:40:59
 * @author aqia358
 *
 */
public class Main2 {
	public static int[] temp;

	public static void merge(int[] a, int left, int right){
		if(left < right){
			int center = (left + right)/2;
			merge(a, left, center);
			merge(a, center+1, right);
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
			for(int j = left; j <= right; j++){
				a[j] = temp[j];
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = {9,8,7,6,5,4,3,2,1};
		Main2.temp = new int[a.length];
		Main2.merge(a, 0, a.length - 1);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i]+" ");
		}
	}

}
