package practice.day1.bubblesort;

/**
 * 2014年3月20日 17:18:26
 * @author aqia358
 *
 */
public class Main {

	public static void bubble(int[] a){
		for(int i = 0; i < a.length; i++){
			for(int j = i + 1; j < a.length; j++){
				if(a[j - 1] > a[j]){
					int temp = a[j];
					a[j] = a[j - 1];
					a[j - 1] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5,6,7,8,9};
		Main.bubble(a);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i]+" ");
		}
	}

}
