package second.mergesort;

import java.lang.reflect.Array;

public class Main {

	public void mergeSort(){
		
	}
	
	public void merge(int left, int right, int[] a, int[] result){
		if(left < right){
			int center = (left + right)/2;
			merge(left, center, a, result);
			merge(center + 1, right, a, result);
			int i = left;
			int leftBegin = left;
			int rightBegin = center + 1;
			while(leftBegin <= center && rightBegin <= right){
				if(a[leftBegin] < a[rightBegin]){
					result[i++] = a[leftBegin++];
				}else{
					result[i++] = a[rightBegin++];
				}
			}
			while(leftBegin <= center){
				result[i++] = a[leftBegin++];
			}
			while(rightBegin <= right){
				result[i++] = a[rightBegin++];
			}
			for(int j = left;j <= right; j++){
				a[j] = result[j];
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = {2,1,4,3,6,5,8,7,9};
		int[] b = new int[10];
		Main m = new Main();
		m.merge(0, a.length - 1, a, b);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i]+" ");
		}
	}

}
