package practice.day4.shellsort;

/**
 * 2014年3月20日 16:58:21
 * 2014年3月20日 17:05:42
 * @author aqia358
 *
 */
public class Main {

	public static void shell(int[] a){
		int step = a.length/2;
		while(step > 0){
			for(int x = 0; x <= step; x++){
				for(int i = x + step; i < a.length; i = i + step){
					int j = i;
					int key = a[j];
					while(j >= step && a[j - step] > key){
						a[j] = a[j - step];
						j -= step;
					}
					a[j] = key;
				}
			}
			step /= 2;
		}
	}
	
	public static void insert(int[] a){
		for(int i = 1; i < a.length; i++){
			int j = i;
			int key = a[j];
			while(j >= 1 && a[j - 1] > key){
				a[j] = a[j - 1];
				j--;
			}
			a[j] = key;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {9,8,7,6,5,4,3,2,1};
//		Main.insert(a);
		Main.shell(a);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i]+" ");
		}
	}

}
