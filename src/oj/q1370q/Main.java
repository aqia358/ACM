package oj.q1370q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(
				new InputStreamReader(System.in)));
		while (st.nextToken() != StreamTokenizer.TT_EOF) {
			int n = (int) st.nval;
			int count = 0;
			int[] array = new int[n];
			while (count < n) {
				st.nextToken();
				int a = (int) st.nval;
				array[count] = a;
				count++;
			}
			// int[] array = {1};
			// int n = 1;
			int p = -1;
			int temp = array[0];
			int num = 0;
			for (int i = 0; i < n; i++) {
				if (num == 0) {
					temp = array[i];
					num = 1;
				} else if (array[i] == temp) {
					num++;
				} else
					num--;
			}
			if (num > 0) {
				num = 0;
				for (int j = 0; j < n; j++) {
					if (array[j] == temp)
						num++;
				}
				if (num > n / 2)
					p = temp;
			}
			System.out.println(p);
		}
	}
}
