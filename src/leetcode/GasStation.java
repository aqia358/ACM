package leetcode;

public class GasStation {

	public static int canCompleteCircuit(int[] gas, int[] cost){
		int len = gas.length;
		int sum = 0;
		int totalSum = 0;
		int index = -1;
		for(int i = 0; i < len; i++){
			sum += gas[i] - cost[i];
			totalSum += gas[i] - cost[i];
			if(sum < 0){
				index = i;
				sum = 0;
			}
		}
		return totalSum >= 0 ? index + 1 : -1;
	}
	public static int canCompleteCircuit2(int[] gas, int[] cost){
		int len = gas.length;
		int[] f = new int[len];
		for(int i = 0; i < len; i++){
			f[i] = gas[i] - cost[i];
		}
		int max = 0;
		int sum = 0;
		int index = 0;
		for(int i = 0; i <= 2*(len - 1); i++){
			sum += f[i%len];
			if(sum > 0){
				if(sum > max)
					max = sum;
			}else{
				index = (i+1)%len;
				sum = 0;
			}
		}
		sum = 0;
		for(int j = index; j < index + len; j ++){
			sum += f[j%len];
			if(sum < 0)
				return -1;
		}
		return index;
	}
	
	public static void main(String[] args) {
		int[] a = {2};
		int[] b = {1};
		System.out.println(canCompleteCircuit(a, b));
	}

}
