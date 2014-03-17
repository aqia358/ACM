package practice.shellsort;

/**
 * 2014年3月17日 19:51:36 insert 2014年3月17日 19:56:39 
 * 2014年3月17日 20:07:51
 * 2014年3月17日 20:37:00
 * @author aqia358
 * 
 */
public class Main2 {

	public static void shell(int[] a, int step) {
		while (step > 1) {
			step = step / 2;
			for (int x = 0; x <= step; x++) {
				for (int i = step; i < a.length; i = i + step) {
					int j = i;
					int temp = a[i];
					while (j > 0 && temp < a[j - step]) {
						a[j] = a[j - step];
						j = j - step;
					}
					a[j] = temp;
				}
			}
		}
	}

	public static void shell2(int[] a) {
		int step = a.length / 2;
		while (step > 1) {
			for (int i = step; i < a.length; i++) {
				int j = i;
				int temp = a[i];
				for (; j >= step && temp < a[j - step]; j = j - step) {
					a[j] = a[j - step];
				}
				a[j] = temp;
			}
			step /= 2;
		}
	}

	public static void shell3(int[] a){
		int step = a.length/2;
		while(step > 0){
			for(int i = step; i < a.length; i++){
				int j = i;
				int temp = a[i];
				while(j >= step && temp < a[j - step]){
					a[j] = a[j - step];
					j -= step;
				}
				a[j] = temp;
			}
			step /= 2;
		}
	}
	public static void insert(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int j = i;
			int temp = a[i];
			while (j > 0 && temp < a[j - 1]) {
				a[j] = a[j - 1];
				j--;
			}
			a[j] = temp;
		}
	}

	public static void main(String[] args) {
		int[] a = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		// Main2.insert(a);
		 Main2.shell(a, a.length - 1);
//		Main2.shell2(a);
//		Main2.shell3(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
