package practice.day7.shellsort;

/**
 * 2014年3月24日 13:45:14
 * 2014年3月24日 13:51:06
 * @author aqia358
 *
 */
public class Main {

	public static void shell(int[] a, int step){
		while(step > 0){
			for(int x = 0; x <= step; x++){
				for(int i = step + x; i < a.length; i += step){
					int j = i;
					int key = a[j];
					while(j >= step && key < a[j - step]){
						a[j] = a[j - step];
						j -= step;
					}
					a[j] = key;
				}
			}
			step /= 2;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {9,8,7,6,5,4,3,2,1};
		Main.shell(a, a.length - 1);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i]+" ");
		}
	}

}
