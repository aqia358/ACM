package leetcode;

public class MaxArea {

	public static int maxArea(int[] height){
		int max = 0;
		int len = height.length;
		int low = 0;
		int high = len - 1;
		while(low < high){
			max = Math.max(max, Math.min(height[low], height[high]) * (high - low));
			if(height[low] < height[high])
				low++;
			else
				high--;
		}
		return max;
	}
	public static int maxArea2(int[] height){
		int max = 0;
		int len = height.length;
		for(int i = 0; i < len - 1; i++){
			for(int j = i + 1; j < len; j++){
				max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
			}
		}
		return max;
	}
	public static void main(String[] args) {

	}

}
