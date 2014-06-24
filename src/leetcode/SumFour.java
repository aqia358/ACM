package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumFour {

	public static List<List<Integer>> fourSum(int[] num, int target){
		List<List<Integer>> re = new ArrayList<List<Integer>>();
		int len = num.length;
		Arrays.sort(num);
		int temp;
		for(int i = 0; i <= len - 4; i = next(num, i)){
			for(int j = i + 1; j <= len - 3; j = next(num, j)){
				int s = j + 1;
				int e = len - 1;
				while(s < e){
					temp = num[i] + num[j] + num[s] + num[e];
					if(temp == target){
						ArrayList<Integer> l = new ArrayList<Integer>();
						l.add(num[i]);
						l.add(num[j]);
						l.add(num[s]);
						l.add(num[e]);
						re.add(l);
						s = next(num, s);
						e = prev(num, e);
					}else if(temp < target)
						++s;
					else
						--e;
				}
			}
		}
		return re;
	}
	
	public static int next(int[] num, int i){
		int len = num.length;
		while(i < len - 1 && num[i] == num[i + 1])
			i++;
		return i+1;
	}
	
	public static int prev(int[] num, int i){
		while(i > 0 && num[i] == num[i - 1])
			i--;
		return i - 1;
	}
	
	public static void main(String[] args) {
		int[] s = {1,0,-1,0,-2,2};
		fourSum(s, 0);
	}

}
