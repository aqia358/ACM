package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class SumThree {

	public static List<List<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		List<List<Integer>> re = new ArrayList<List<Integer>>();
		int len = num.length;
		int temp;
		for (int i = 0; i < len; i = next(i, num)) {
			int s = i + 1;
			int e = len - 1;
			while(s < e){
				temp = num[i] + num[s] + num[e];
				if(temp == 0){
					List<Integer> l = new ArrayList<Integer>();
					l.add(num[i]);
					l.add(num[s]);
					l.add(num[e]);
					re.add(l);
					s = next(s, num);
					e = pre(e, num);
				}else if(temp < 0)
					s++;
				else
					e--;
			}
		}
		return re;
	}
	public static List<List<Integer>> threeSum0(int[] num) {
		Arrays.sort(num);
		List<Integer> numList = new ArrayList<Integer>();
		for (Integer t : num)
			numList.add(t);
		List<List<Integer>> re = new ArrayList<List<Integer>>();
		int len = num.length;
		int temp;
		for (int i = 0; i <= len - 3; i++) {
			if (i > 0 && num[i] == num[i - 1])
				continue;
			for (int j = i + 1; j <= len - 2; j++) {
				temp = -(num[i] + num[j]);
				if (temp < 0)
					break;
				if (numList.contains(temp)) {
					List<Integer> l = new ArrayList<Integer>();
					l.add(num[i]);
					l.add(num[j]);
					l.add(temp);
					re.add(l);
				}
			}
		}
		return re;
	}
	public static int next(int i, int[] num){
		int len = num.length;
		while(i < len - 1 && num[i] == num[i + 1])
			i++;
		return i + 1;
	}
	public static int pre(int i, int[] num){
		int len = num.length;
		while(i > 0 && num[i] == num[i - 1])
			i--;
		return i - 1;
	}
	public static List<List<Integer>> threeSum1(int[] num){
		Arrays.sort(num);
		List<List<Integer>> re = new ArrayList<List<Integer>>();
		int len = num.length;
		int temp;
		for(int i = 0; i <= len - 3; i++){
			if(i > 0 && num[i] == num[i - 1]) continue;
			for(int j = i+1; j <= len - 2; j++){
				temp = -(num[i] + num[j]);
				if(temp < 0) break;
				for(int m = j + 1; m < len && num[m] <= temp;m++){
					if(num[m] == temp){
						List<Integer> l = new ArrayList<Integer>();
						l.add(num[i]);
						l.add(num[j]);
						l.add(num[m]);
						re.add(l);
					}
				}
			}
		}
		return re;
	}
	public static List<List<Integer>> threeSum2(int[] num){
		Set<List<Integer>> list = new TreeSet<List<Integer>>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int len = num.length;
		for(int i = 0; i < len; i++){
			map.put(num[i], i);
		}
		int temp;
		for(int i = 0; i <= len - 3; i++){
			for(int j = i+1; j <= len - 2; j++ ){
				temp = -(num[i] + num[j]);
				if(map.containsKey(temp) && map.get(temp) > j){
					list.add(numSort(num[i], num[j], -(num[i] + num[j])));
				}
			}
		}
		List<List<Integer>> re = new ArrayList<List<Integer>>();
		re.addAll(list);
		return re;
	}
	
	public static List<Integer> numSort(int a, int b, int c){
		int[] t = {a,b,c};
		Arrays.sort(t);
		List<Integer> list = new ArrayList<Integer>();
		list.add(t[0]);
		list.add(t[1]);
		list.add(t[2]);
		return list;
	}
	public static void main(String[] args) {
		int[] s = {-2,0,1,1,2};
//		threeSum(s);
		System.out.println(next(2, s));
		System.out.println(pre(3, s));
	}

}
