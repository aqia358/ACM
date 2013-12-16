package oj.q1214q;

import java.util.Scanner;

/**
 * 丑数
 * @author aqia358
 *
 */
public class Main {

	public void countUgly(int count) {
		if(count <= 0)return;
		int[] array = new int[count];
		int pos = 0;
		array[0] = 1;
		int i = 0;
		int j = 0;
		int k = 0;
		while (pos < count - 1) {
			while (array[pos] >= array[i] * 2)
				i++;
			while (array[pos] >= array[j] * 3)
				j++;
			while (array[pos] >= array[k] * 5)
				k++;
			array[++pos] = Min(array[i] * 2, array[j] * 3, array[k] * 5);
		}
		System.out.println(array[pos]);
	}

	public int Min(int a, int b, int c) {
		a = Math.min(a, b);
		return Math.min(a, c);
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Main m = new Main();
		while(s.hasNext())
			m.countUgly(s.nextInt());
	}

}
