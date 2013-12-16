package test.mergesort;

/**
 * 20时48分26秒
 * @author aqia358
 * 21时27分06秒
 */
public class Main {

	public void merge(int[]	array, int left, int right){
		if(left >= right)return;
		int center = (left + right)/2;
		merge(array, left, center);
		merge(array, center + 1, right);
		
		int begin = left;
		int rbegin = center + 1;
		int[] temp = new int[array.length];
		int i = left;
		while(begin <= center && rbegin <= right){
			while(begin <= center && array[begin] <= array[rbegin]){
				temp[i] = array[begin];
				begin++;
				i++;
			}
			while(array[begin] > array[rbegin] && rbegin <= right){
				temp[i] = array[rbegin];
				rbegin++;
				i++;
			}
		}
		while(begin <= center){
			temp[i] = array[begin];
			i++;
			begin++;
		}
		while(rbegin <= right){
			temp[i] = array[rbegin];
			i++;
			rbegin++;
		}
		for(int j = left; j <= right; j++){
			array[j] = temp[j];
			System.out.print(temp[j]+" ");
		}
		System.out.println("");
	}
	public static void main(String[] args) {
		int[] a = {2,1,4,3,6,5,8,7,0,9};
		Main m = new Main();
		m.merge(a, 0, a.length - 1);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i]+" ");
		}
	}

}
