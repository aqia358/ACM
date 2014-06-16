package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public static List<List<Integer>> combine(int n, int k){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		combine(n, k, 1, result, new ArrayList<Integer>());
		return result;
	}
	
	public static void combine(int n, int k , int start, List<List<Integer>> result, ArrayList<Integer> l){
		if(k == 0){
			result.add(l);
			return;
		}
		for(int i = start; i <= n; ++i){
			ArrayList<Integer> a = (ArrayList<Integer>) l.clone();
			a.add(i);
			combine(n, k - 1, i + 1, result, a);
		}
	}
	public static void combine(int n, int k , int start, List<List<Integer>> result, String temp){
		if(k == 0){
			System.out.println(temp);
			return;
		}
		for(int i = start; i <= n; ++i){
			combine(n, k - 1, i + 1, result, temp + i);
		}
	}
	
	public static void combine (int n, int k, List<List<Integer>> result, List<Integer> l){
		if(k == 0){
			result.add(l);
			return;
		}
		for(int i = 0; i < n; i++){
			l.add(i);
			combine(n, k - 1, result, l);
			l.remove(i);
		}
	}
	public static void main(String[] args) {
		combine(4, 3);
	}

}
