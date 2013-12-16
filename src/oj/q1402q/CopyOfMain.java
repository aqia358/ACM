package oj.q1402q;

import java.util.Scanner;

public class CopyOfMain {

	public static void qSort(int[] a, int begin, int end) {
		if (begin > end)
			return;
		int temp = a[begin];
		int lbegin = begin;
		int right = end;
		while (lbegin < right) {
			while (lbegin < right && a[right] >= temp)
				right--;
			a[lbegin] = a[right];
			while (lbegin < right && a[lbegin] < temp)
				lbegin++;
			a[right] = a[lbegin];
		}
		if (lbegin == right)
			a[lbegin] = temp;
		qSort(a, begin, lbegin - 1);
		qSort(a, lbegin + 1, end);

	}

	public static void print(int[] a, int end) {
		for (int i = 0; i < end - 1; i++) {
			System.out.print(a[i] + " ");
		}
		if(end == 0)
			System.out.println("0");
		else
			System.out.println(a[end - 1]);
	}

	public static void main(String[] args) {
		// int[] a = { 2, 1, 4, 3, 6, 5, 8, 7, 9 };
		Scanner sin = new Scanner(System.in);
		while (sin.hasNext()) {
			int[] a = new int[1000000];
			int n = sin.nextInt();
			int[] b = new int[n];
			int count = 0;
			while (count < n) {
				int val = sin.nextInt();
				b[count] = val;
				a[val] = a[val] + 1;
				count++;
			}
			count = 0;
			for (int i = 0; i < n; i++) {
				if (a[b[i]] == 1) {
					b[count++] = b[i];
				}
			}
			CopyOfMain.qSort(b, 0, count - 1);
			CopyOfMain.print(b, count);
		}
	}

}
