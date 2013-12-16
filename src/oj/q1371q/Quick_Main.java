package oj.q1371q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 挡板快排
 * 
 * @author aqia358 20时47分03秒
 */
public class Quick_Main {

	public void Partition(int[] a, int k, int begin, int end) {
		int left = begin;
		int right = end;
		int temp = a[left];
		while (left < right) {
			while (left < right && a[right] >= temp)
				right--;
			if (left < right)
				a[left] = a[right];
			while (left < right && a[left] < temp)
				left++;
			if (left < right)
				a[right] = a[left];
		}
		a[left] = temp;
		if (k < left)
			Partition(a, k, begin, left - 1);
		else if (k > left)
			Partition(a, k, left + 1, end);
	}

	public void quickSort(int[] a, int begin, int end) {
		int left = begin;
		int right = end;
		int temp = a[left];
		while (left < right) {
			while (left < right && a[right] >= temp)
				right--;
			if (left < right)
				a[left] = a[right];
			while (left < right && a[left] < temp)
				left++;
			if (left < right)
				a[right] = a[left];
		}
		a[left] = temp;
		if (left - begin > 1)
			quickSort(a, begin, left - 1);
		if (end - left > 1)
			quickSort(a, left + 1, end);
	}

	public static void main(String[] args) throws IOException {
		// int[] a = { 9, 12, 17, 30, 50, 20, 60, 65, 4, 19 };
		Quick_Main m = new Quick_Main();

		StreamTokenizer st = new StreamTokenizer(new BufferedReader(
				new InputStreamReader(System.in)));
		while (st.nextToken() != StreamTokenizer.TT_EOF) {
			int n = (int) st.nval;
			st.nextToken();
			int k = (int) st.nval;
			int count = 0;
			int[] a = new int[n];
			while (count < n) {
				st.nextToken();
				a[count++] = (int) st.nval;
			}
			m.Partition(a, k - 1, 0, a.length - 1);
			m.quickSort(a, 0, k - 1);
			for (int i = 0; i < k - 1; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println(a[k - 1]);
		}
	}

}
