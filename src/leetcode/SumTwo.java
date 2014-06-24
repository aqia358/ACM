package leetcode;

import java.util.HashMap;
import java.util.Map;

public class SumTwo {

	public static int[] twoSum(int[] numbers, int target){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] re = new int[2];
		for(int i = 0; i < numbers.length; i++){
			if(map.containsKey(target - numbers[i])){
				re[0] = map.get(target - numbers[i]) + 1;
				re[1] = i + 1;
				return re;
			}else
				map.put(numbers[i], i);
		}
		return re;
	}
	
	public static void main(String[] args) {

	}

}
