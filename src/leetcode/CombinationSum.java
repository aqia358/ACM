package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

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
		for (int i = s; i < a.length; i = next(a, i)) {
			if (target - a[i] < 0)
				break;
			else {
				ArrayList<Integer> c = (ArrayList<Integer>) l.clone();
				c.add(a[i]);
				getSum(a, i + 1, target - a[i], re, c);
			}
		}
	}
	public static int next(int[] a, int i){
		while(i < a.length - 1 && a[i + 1] == a[i])
			i++;
		return i + 1;
	}

	public static void main(String[] args) {
		int[] a = { 10,1,2,7,6,1,5 };
		combinationSum(a, 8);
	}

}
