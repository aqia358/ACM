package leetcode;

import java.util.Arrays;

public class SumThreeClosest {

	public static int threeSumCloset(int[] num, int target){
		int closest = 9999;
		Arrays.sort(num);
		int len = num.length;
		int temp;
		int d = 9999;
		for(int i = 0; i < len - 2; i++){
			int s = i + 1;
			int e = len - 1;
			while(s < e){
				temp = num[i] + num[s] + num[e];
				if(Math.abs(target - temp) < d){
					d = Math.abs(target - temp);
					closest = temp;
				}
				if(temp - target > 0){
					e--;
				}else{
					s++;
				}
			}
		}
		return closest;
	}
	public static void main(String[] args) {
		int[] s = {-1,2,1,-4};
		System.out.println(threeSumCloset(s, 1));
	}

}
