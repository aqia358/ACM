package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * @author aqia358
 *
 */
public class Permutations {

	public static List<List<Integer>> permute(int[] num){
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		permute(num, lists, 0);
		return lists;
	}
	
	public static void permute(int[] num, List<List<Integer>> lists, int begin){
		int len = num.length;
		if(begin == len){
			List<Integer> list = new ArrayList<Integer>();
			for(Integer a : num)
				list.add(a);
			lists.add(list);
		}
		for(int i = begin; i < len; ++i){
			swap(num, begin, i);
			permute(num, lists, begin + 1);
			swap(num, i, begin);
		}
	}
	
	public static void swap(int[] num, int src, int pos){
		int temp = num[src];
		num[src] = num[pos];
		num[pos] = temp;
	}
	public static void print(int[] a){
		for(int i = 0; i < a.length; ++i)
			System.out.print(a[i]+",");
		System.out.println();
	}
	public static void main(String[] args) {
		int[] num = {1,2,3};
		permute(num);
	}

}
