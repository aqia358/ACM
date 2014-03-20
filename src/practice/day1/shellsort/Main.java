package practice.day1.shellsort;

/**
 * 2014年3月15日 16:50:32
 * @author aqia358
 * 2014年3月15日 17:07:19
 */
public class Main {

	public static void shell(int[] a){
		int step = a.length/2;
		while(step > 0){
			for(int i  = step; i < a.length; i++){
				int j = i;
				int temp = a[j];
				while(j - step >= 0 && temp < a[j - step]){
					a[j] = a[j - step];
					j = j - step;
				}
				a[j] = temp;
			}
			step = step/2;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {9,8,2,1,4,3,6,5,7};
		Main.shell(a);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i]+" ");
		}
	}

}
