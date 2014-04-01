package practice.day14.shellsort;

/**
 * 2014年4月1日 20:07:16
 * 2014年4月1日 20:27:36
 * @author aqia358
 *
 */
public class Main {

	public static void shellSort(int[] a){
		int step = a.length/2;
		while(step > 0){
			for(int x = 0; x <= step; ++x){
				for(int i = x + step; i < a.length; i = i + step){
					int j = i;
					int temp = a[j];
					while(j >= step && temp < a[j - step]){
						a[j] = a[j - step];
						j -= step;
					}
					a[j] = temp;
				}
			}
			step /= 2;
		}
	}
	
	public static void insertSort(int[] a){
		for(int i = 0; i < a.length; ++i){
			int j = i;
			int temp = a[j];
			while(j > 0 && temp < a[j - 1]){
				a[j] = a[j - 1];
				j--;
			}
			a[j] = temp;
		}
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
		int[] c = {1,2,3,4,5,6,7,8,8};
//		insertSort(a);
		shellSort(a);
		print(a);
		shellSort(b);
		print(b);
		shellSort(c);
		print(c);
	}

}
