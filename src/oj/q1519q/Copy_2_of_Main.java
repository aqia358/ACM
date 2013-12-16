package oj.q1519q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.LinkedList;

/**
 * 合并两个排序的链表
 * 
 * @author aqia358
 * 
 */
public class Copy_2_of_Main {

	public static void merger(LinkedList<Integer> a, LinkedList<Integer> b) {
		int apos = 0;
		int bpos = 0;
		while (apos < a.size() && bpos < b.size()) {
			if (a.get(apos) < b.get(bpos)) {
				System.out.print(a.get(apos) + " ");
				apos++;
			} else {
				System.out.print(b.get(bpos) + " ");
				bpos++;
			}
		}
		if (apos < a.size()) {
			while (apos < a.size()-1)
				System.out.print(a.get(apos++) + " ");
			System.out.println(a.get(apos));
		}
		if (bpos < b.size()) {
			while (bpos < b.size()-1)
				System.out.print(b.get(bpos++) + " ");
			System.out.println(b.get(bpos));
		}
	}

	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(
				new InputStreamReader(System.in)));
		while (st.nextToken() != StreamTokenizer.TT_EOF) {
			LinkedList<Integer> list1 = new LinkedList<Integer>();
			LinkedList<Integer> list2 = new LinkedList<Integer>();
			int m = (int) st.nval;
			st.nextToken();
			int n = (int) st.nval;
			int count1 = 0;
			int count2 = 0;
			while (count1 < m) {
				st.nextToken();
				int t = (int) st.nval;
				list1.add(t);
				count1++;
			}
			while (count2 < n) {
				st.nextToken();
				int t = (int) st.nval;
				list2.add(t);
				count2++;
			}
			if (n + m <= 0)
				System.out.println("NULL");
			else {
				merger(list1, list2);
			}
		}
	}

}
