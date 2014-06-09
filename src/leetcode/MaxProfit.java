package leetcode;

public class MaxProfit {

	public static int maxProfit(int[] prices){
		int sum,begin,end;
		int len = prices.length;
		sum = begin = end = 0;
		while(end < len){
			begin = end;
			while(begin < len - 1 && prices[begin] > prices[begin + 1])
				begin++;
			end = begin + 1;
			while(end < len && prices[end] > prices[end - 1])
				end++;
			if(begin < end)
				sum += prices[end - 1] - prices[begin];
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int[] a = {3,2,1,2,3,4,5,4,3,2,1,2,3,4};
		System.out.println(maxProfit(a));
		int[] a1 = {1,1};
		System.out.println(maxProfit(a1));
	}

}
