package oj.q1367q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
/**
 * 二叉搜索树的后序遍历序列 
 * @author aqia358
 *
 */
public class Main {

	public static boolean isBST(int[] array, int begin, int end) {
		int left = begin;
		int right = end - 1;
		if(end - begin <= 1)
			return true;
		while (left < end && array[end] > array[left])
			left++;
		while (right > begin && array[end] < array[right])
			right--;
		if(left - 1 == right || left == right)
			return isBST(array, begin, left - 1) && isBST(array, left, end - 1);
		else
			return false;
	}

	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(
				new InputStreamReader(System.in)));
		while (st.nextToken() != StreamTokenizer.TT_EOF) {
			int n = (int) st.nval;
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				st.nextToken();
				a[i] = (int) st.nval;
			}
			if (Main.isBST(a, 0, n - 1))
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}

}
