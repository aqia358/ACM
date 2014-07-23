package leetcode;

import java.util.Stack;

public class LargestRectangle {

	public static int largestRectangleArea(int[] height){
		int len = height.length;
		int max =0;
		int i= 0;
		Stack<Integer> s = new Stack<Integer>();
		while(i < len){
			if(s.isEmpty() || height[i] >= height[s.peek()]){
				s.push(i++);
			}else{
				int p = s.pop();
				max = Math.max(max, height[p] * (s.isEmpty() ? i : i - s.peek() - 1));
				//p之前可能已经把大的出栈了s.peek()才是比当前值小的
			}
		}
		while(!s.isEmpty()){
			int p = s.pop();
			max = Math.max(max, height[p] * (s.isEmpty() ? i : i - s.peek() - 1));
		}
		return max;
	}
	public static int largestRectangleArea2(int[] height){
		int max = 0;
		int len = height.length;
		int step = 1;
		int i = 0;
		while(i < len){
			int left = i;
			int right = i;
			while(left >= 0 && height[left] >= height[i]){
				left--;
			}
			left++;
			while(right < len && height[right] >= height[i]){
				if(i+step < len && height[i+step] == height[i]) step++;
				right++;
			}
			right--;
			max = Math.max(max, (right - left + 1) * height[i]);
			i += step;
			step = 1;
		}
		return max;
	}
	
	public static void main(String[] args) {
//		int[] a = {2,2,2,2,2,3};
		int[] a = {4,2,0,1,2,5};
//		int[] a = {2,1,5,6,2,3};
		System.out.println(largestRectangleArea(a));
	}

}
