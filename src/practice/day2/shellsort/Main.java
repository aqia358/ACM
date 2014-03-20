package practice.day2.shellsort;

/**
 * 2014年3月18日 11:10:18
 * 2014年3月18日 11:14:34
 * @author aqia358
 *
 */
public class Main {

	public static void shell(int[] a){
		int step = a.length/2;
		while(step > 0){
			for(int i = 1; i < a.length; i ++){
				int j = i;
				int temp = a[j];
				while(j >= step && temp < a[j - step]){
					a[j] = a[j - step];
					j -= step;
				}
				a[j] = temp;
			}
			step /= 2;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {9,8,7,6,5,4,3,2,1};
		Main.shell(a);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i]+" ");
		}
		
	}

}
