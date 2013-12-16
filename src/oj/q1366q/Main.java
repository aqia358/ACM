package oj.q1366q;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static boolean isTrue(List<Integer> s1, List<Integer> s2) {
		boolean flag = true;
		if (s1.size() == 1 && s1.get(0) != s2.get(0))
			return false;
		else {
			int n = s1.size();
			if (s1.get(n - 1) != s2.get(1) || s1.get(n - 2) != s2.get(0))
				return false;
			for (int i = 0; i < n - 2; i++) {
				if (s1.get(i) != s2.get(n - i - 1))
					return false;
			}
		}

		return flag;
	}

	public static void main(String[] args) {
		Scanner sin = new Scanner(System.in);
		while (sin.hasNext()) {
			int n = sin.nextInt();
			int count = 0;
			List<Integer> s1 = new ArrayList<Integer>();
			List<Integer> s2 = new ArrayList<Integer>();
			while (count < n) {
				count++;
				s1.add(sin.nextInt());
			}
			count = 0;
			while (count < n) {
				count++;
				s2.add(sin.nextInt());
			}
			if (Main.isTrue(s1, s2))
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}

}
