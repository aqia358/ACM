package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Triangle {

	public static int minnumTotal(List<List<Integer>> triangle){
		int n = triangle.size();
		if(n == 0) return 0;
		int[] f = new int[n];
		f[0] = triangle.get(0).get(0);
		for(int i = 1; i < n; i++){
			f[i] = f[i - 1] + triangle.get(i).get(i);
			for(int j = i - 1; j > 0; j--){
				f[j] = Math.min(f[j - 1], f[j]) + triangle.get(i).get(j);
			}
			f[0] = f[0] + triangle.get(i).get(0);
		}
		int min = f[0];
		for(Integer t : f)
			if(min > t)
				min = t;
		return min;
	}
	
	public static void main(String[] args) {
		List<List<Integer>> s = new ArrayList<List<Integer>>();
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(2);
		List<Integer> l2 = new ArrayList<Integer>();
		l2.add(3);l2.add(4);
		List<Integer> l3 = new ArrayList<Integer>();
		l3.add(6);l3.add(5);l3.add(7);
		List<Integer> l4 = new ArrayList<Integer>();
		l4.add(4);l4.add(1);l4.add(8);l4.add(3);
		s.add(l1);s.add(l2);s.add(l3);s.add(l4);
		System.out.println(minnumTotal(s));
	}

}
