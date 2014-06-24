package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

	public static List<List<Integer>> combinationSum(int[] candidates,
			int target) {
		List<List<Integer>> re = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		ArrayList<Integer> a = new ArrayList<Integer>();
		getSum(candidates, 0, target, re, a);

		return re;
	}

	public static void getSum(int[] a, int s, int target,
			List<List<Integer>> re, ArrayList<Integer> l) {
		if (target == 0) {
			re.add(l);
			return;
		}
		for (int i = s; i < a.length; i++) {
			if (target - a[i] < 0)
				break;
			else {
				ArrayList<Integer> c = (ArrayList<Integer>) l.clone();
				c.add(a[i]);
				getSum(a, i, target - a[i], re, c);
			}
		}
	}

	public static void main(String[] args) {
		int[] a = { 2, 3, 6, 7 };
		combinationSum(a, 7);
	}

}
