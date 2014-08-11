package leetcode;

public class Pow {

	public static double pow(double x, int n){
		if(n < 0)
			return 1/power(x, -n);
		else
			return power(x, n);
	}
	
	public static double power(double x, int n) {
		if(n == 0) return 1;
		double temp = power(x, n/2);
		if(n%2 == 0){
			return temp * temp;
		}else
			return x * temp * temp;
	}
	public static double pow2(double x, int n){
		if(n == 0) return 1;
		boolean flag = false;
		if(n < 0){
			flag = true;
			n = -n;
		}
		double re = 1;
		if(n %2 == 0){
			re = pow(x, n/2);
			re *= re;
		}else{
			re = pow(x, (n -1)/2);
			re *= re * x;
		}
		if(flag)
			return 1/re;
		else
			return re;
	}
	
	public static void main(String[] args) {
//		System.out.println(pow(2, 10));
		System.out.println(pow(2, -1));
	}

}
