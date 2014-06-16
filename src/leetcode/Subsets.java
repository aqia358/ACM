package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

	public static List<List<Integer>> subsets(int[] S){
		Arrays.sort(S);
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		for(int i = 0; i <= S.length; i++){
			subsets(S, 0, i, lists, new ArrayList<Integer>());
		}
		return lists;
	}
	public static List<List<Integer>> testSubsets(int[] S){
		Arrays.sort(S);
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		subsets2(S, 0, lists, new ArrayList<Integer>());
		return lists;
	}
	
	public static void subsets2(int[] S, int step, List<List<Integer>> lists, ArrayList<Integer> l){
		if(step == S.length){
			lists.add(l);
			return;
		}
		//不选这个元素
		subsets2(S, step + 1, lists, l);
		ArrayList<Integer> c = (ArrayList<Integer>) l.clone();
		c.add(S[step]);//选择这个元素
		subsets2(S, step + 1, lists, c);
	}
	public static void subsets(int[] S, int begin, int num, List<List<Integer>> lists, ArrayList<Integer> l){
		if(begin == num){
			lists.add(l);
			return;
		}
		for(int i = begin; i < num; i++){
			ArrayList<Integer> c = (ArrayList<Integer>) l.clone();
			c.add(S[i]);
			subsets(S, i + 1, num, lists, c);
		}
	}
	public static void subsets(int[] S, int begin, int num, List<List<Integer>> lists, String temp){
		if(begin == num){
			System.out.println(temp);
			return;
		}
		for(int i = begin; i < num; i++){
			subsets(S, i + 1, num, lists, temp + S[i]);
		}
	}
	
	public static void main(String[] args) {
		int[] s = {1,2,3};
		subsets(s);
		testSubsets(s);
	}

}
