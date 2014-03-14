package second.insertSort;

public class Main {

	public void insesrt(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int j = i;
			int temp = a[i];
			while (j > 0 && temp < a[j-1]) {
				a[j] = a[j-1];
				j--;
			}
			a[j] = temp;
		}

	}

	public static void main(String[] args) {
		int[] a = {9,8,1,2,6,5,4,8,7};
		Main m = new Main();
		m.insesrt(a);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i]+" ");
		}
	}

}
