package leetcode;

public class MaxProfit1 {

	public static int maxProfit(int[] prices){
		int len = prices.length;
		int profit = 0;
		if(len == 0) return profit;
		int max = prices[len - 1];
		for(int i = len - 1; i >= 0; --i){
			max = Math.max(max, prices[i]);
			profit = Math.max(profit, max - prices[i]);
		}
		return profit;
	}
	
	public static void main(String[] args) {
		int[] a = {2,1,2,3,4,5,4,3,0,1};
		System.out.println(maxProfit(a));
	}

}
