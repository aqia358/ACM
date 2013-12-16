package oj.q1214q;

import java.util.Scanner;

public class Copy_2_of_Main {

	public boolean isUgly(int number) {
		while (number % 2 == 0)
			number /= 2;
		while (number % 3 == 0)
			number /= 3;
		while (number % 5 == 0)
			number /= 5;
		return number == 1;
	}

	public void countUgly(int count) {
		int j = 0;
		int number = 1;
		while (j < count) {
			if (isUgly(number++)) {
				j++;
			}
		}
		System.out.println(number - 1);
	}

	public static void main(String[] args) {
		// Scanner s = new Scanner(System.in);
		Copy_2_of_Main m = new Copy_2_of_Main();
		// m.countUgly(s.nextInt());
		for (int i = 1; i < 20; i++)
			m.countUgly(i);
	}

}
