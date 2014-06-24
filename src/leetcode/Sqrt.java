package leetcode;

import java.util.Stack;

public class Sqrt {

	public static int sqrt(int x) {
		if(x < 2) return x;
		int left = 1;
		int right = x/2;
		int lastMid = 1;
		while(left <= right){
			int mid = (left + right)/2;
			if(x/mid > mid){
				left = mid + 1;
				lastMid = mid;
			}else if(x/mid < mid){
				right = mid - 1;
			}else
				return mid;
		}
		return lastMid;
	}
	public static int sqrt1(int x) {
		float re = 1;
		for(int i = 0; i < x; i++){
			re = (re + i/re)/2;
		}
		return (int)Math.round(re);
	}

	public static void main(String[] args) {
		for(int i = 1; i < 26; i++)
		System.out.println(i+" sqrt is "+sqrt(i));
		System.out.println(" sqrt is "+sqrt(2147395599));
	}
}
