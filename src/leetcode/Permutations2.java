package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {

	public static List<List<Integer>> permuteUnique(int[] num){
		List<List<Integer>> re = new ArrayList<List<Integer>>();
		if(num.length == 0) return re;
		Arrays.sort(num);
		permute(num, re);
		return re;
	}
	
	public static void permute(int[] num, List<List<Integer>> re) {
		re.add(conver(num));
		int len = num.length - 1;
		int e = len;
		int s = len;
		while(s > 0 && num[s] <= num[s - 1]){
			s--;
		}
		if(s == 0){
			Arrays.sort(num);
			return;
		}
		while(s < e && num[s - 1] >= num[e])
			e--;
		swap(num, s - 1, e);
		Arrays.sort(num, s, len + 1);
		permute(num, re);
	}
	public static void swap(int[] num, int s, int e){
		int temp = num[s];
		num[s] = num[e];
		num[e] = temp;
	}
	
	public static List<Integer> conver(int[] num){
		List<Integer> l = new ArrayList<Integer>();
		for(Integer t : num)
			l.add(t);
		return l;
	}
	
	public static void main(String[] args) {
		int[] m = {1,1,3};
		permuteUnique(m);
	}

}
