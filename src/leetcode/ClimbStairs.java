package leetcode;

public class ClimbStairs {
	
	public static int climibingStairs(int n){
		if(n == 1)
			return 1;
		else if(n == 2)
			return 2;
		else
			return climibingStairs(n - 1) + climibingStairs(n - 2);
	}
	public static int climbStairs(int n){
		int a = 1;
		int b = 2;
		if(n == 1)
			return 1;
		else if(n == 2)
			return 2;
		int sum = 0;
		for(int i = 2; i < n; ++i){
			sum = a + b;
			a = b;
			b = sum;
		}
		return sum;
	}
	public static void main(String[] args) {
//		System.out.println(climibingStairs(3));
//		System.out.println(climibingStairs(4));
//		System.out.println(climibingStairs(5));
//		System.out.println(climibingStairs(44));
//		System.out.println(climibingStairs(3));
//		System.out.println(climibingStairs(4));
//		System.out.println(climibingStairs(5));
//		System.out.println(climibingStairs(44));
		System.out.println(climbStairs(1));
		System.out.println(climbStairs(2));
		System.out.println(climbStairs(3));
		System.out.println(climbStairs(4));
	}

}
