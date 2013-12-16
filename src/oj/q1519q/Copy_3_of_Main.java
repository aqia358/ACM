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
public class Copy_3_of_Main {

	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(
				new InputStreamReader(System.in)));
		while (st.nextToken() != StreamTokenizer.TT_EOF) {
			int m = (int) st.nval;
			st.nextToken();
			int n = (int) st.nval;
			LinkedList<Integer> list1 = new LinkedList<Integer>();
			LinkedList<Integer> list2 = new LinkedList<Integer>();
			int count1 = 0;
			int count2 = 0;
			while (count1 < m) {
				st.nextToken();
				int t = (int) st.nval;
				list1.add(t);
				count1++;
			}
			count1 = 0;
			while (count2 < n) {
				st.nextToken();
				int t = (int) st.nval;
				while(count1 < m && list1.get(count1) < t){
					list2.add(list1.get(count1++));
				}
				list2.add(t);
				count2++;
			}
			while(count1 < m)
				list2.add(list1.get(count1++));
			if (n + m <= 0)
				System.out.println("NULL");
			else {
				int size = list2.size();
				for (int i = 0; i < size - 1; i++) {
					System.out.print(list2.get(i) + " ");
				}
				System.out.println(list2.get(list2.size() - 1));
			}
		}
	}

}
