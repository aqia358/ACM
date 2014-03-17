package practice.insertsort;

/**
 * 2014年3月15日 16:37:31
 * @author aqia358
 * 2014年3月15日 16:49:58
 */
public class Main {

	public static void insertSort(int[] a){
		for(int i = 1; i < a.length; i ++){
			int j = i;
			int temp = a[j];
			while(j > 0 && temp < a[j - 1]){
				a[j] = a[j-1]; 
				j--;
			}
			a[j] = temp;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {9,8,2,1,4,3,6,5,7};
		Main.insertSort(a);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i]+" ");
		}
	}

}
