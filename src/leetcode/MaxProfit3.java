package leetcode;

public class MaxProfit3 {
	 // 基本思想是分成两个时间段，然后对于某一天，计算之前的最大值和之后的最大值  
	public static int maxProfit(int[] prices) {
		int len = prices.length;
		int profit = 0;
		if (len == 0)
			return profit;
		// dp数组保存左边和右边的利润最大值  
		int[] left = new int[len]; // 计算[0,i]区间的最大值  
		int[] right = new int[len];// 计算[i,len-1]区间的最大值  
		process(prices, left, right);
		for (int i = 0; i < len; ++i) {
			profit = Math.max(profit, left[i]+right[i]);
		}
		return profit;
	}

	public static void process(int[] prices, int[] left, int right[]){
		int len = prices.length;
		int max = prices[len - 1];
		right[len - 1] = 0;
		// 右边递推公式  
		for(int i = len - 2; i >= 0; --i){
			max = Math.max(max, prices[i]);
			right[i] = Math.max(left[i + 1], max - prices[i]);
		}
		int min = prices[0];
		left[0] = 0;
		// 左边递推公式  
		for(int i = 1; i < len; ++i){
			left[i] = Math.max(left[i - 1], prices[i] - min);
			min = Math.min(min, prices[i]);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
