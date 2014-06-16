package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Subsets2 {

	public static List<List<Integer>> subsetSWithDup(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		subset(num, 0, lists, new ArrayList<Integer>());
		return lists;
	}

	public static void subset(int[] num, int step, List<List<Integer>> lists,
			ArrayList<Integer> l) {
		if (num.length == step) {
			lists.add(l);
			return;
		}
		int plus = 1;
		while (step + plus < num.length && num[step] == num[step + plus])
			plus++;
		subset(num, step + plus, lists, l);
		ArrayList<Integer> c = (ArrayList<Integer>) l.clone();
		c.add(num[step]);
		subset(num, step + 1, lists, c);
	}

	public static void main(String[] args) {
		int[] num = { 2, 2, 2, 2, 2 };
		subsetSWithDup(num);
		Set<List<Integer>> s = new TreeSet<List<Integer>>();
		ArrayList<Integer> l = new ArrayList<Integer>();
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		l.add(1);
		l1.add(1);
		s.add(l);
		s.add(l1);
		System.out.println(s.size());
		
	}

}
