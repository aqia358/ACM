package second.shell;

/**
 * 2014年3月12日 22:04:18
 * 
 * @author aqia358
 * 
 */
public class Main {

	public void shell(int step, int[] a) {
		if (step > 0) {
			int n = step / 2;
			for (int i = 0; i < step; i++) {
				for (int j = i; j < a.length; j = j + step) {
					for (int m = j; m < a.length; m = m + step) {
						int min = a[j];
						if (a[j] > a[m]) {
							a[j] = a[m];
							a[m] = min;
						}
					}
					if (j < a.length)
						System.out.print(a[j] + " ");
				}
			}
			System.out.println();
			shell(n, a);
		}
	}

	public void shellSort(int[] a) {
		int step = a.length;
		while (step > 0) {
			step = step / 2;
			// 分组
			for (int x = 0; x < step; x++) {
				// 插入排序
				for (int i = x + step; i < a.length; i = i + step) {
					int j = i;
					int temp = a[i];
					while (j > 0 && temp < a[j - step]) {
						a[j] = a[j - step];
						j = j - step;
					}
					a[j] = temp;
					System.out.print(a[i]+" ");
				}
				System.out.println(" --next group");
			}
		}
	}

	public static void main(String[] args) {
		int[] a = { 2, 1, 4, 3, 6, 5, 8, 7, 9 };
		Main m = new Main();
//		m.shell(a.length / 2, a);
		m.shellSort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
