package leetcode;

public class DivideTwoIntegers {

	
	public static int divide(int dividend, int divisor){
		if(divisor == 0) return Integer.MAX_VALUE;
		int re = 0;
		if(dividend == Integer.MIN_VALUE){
			re = 1;
			dividend += Math.abs(divisor);
		}
		if(divisor == Integer.MIN_VALUE)
			return re;
		boolean isNeg = ((dividend^divisor) >>> 31 == 1) ? true : false;
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		int digit = 0;
		while(divisor <= (dividend >> 1)){
			divisor <<= 1;
			digit ++;
		}
		while(digit >= 0){
			if(dividend >= divisor){
				dividend -= divisor;
				re += 1<< digit;
			}
			divisor >>= 1;
			digit--;
		}
		return isNeg ? -re : re;
	}
	public static int divide2(int dividend, int divisor){
		int re = 0;
		boolean flag = (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0);
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		while(dividend - divisor >= 0){
			dividend -= divisor;
			re++;
		}
		return flag ? re : -re;
	}
	
	public static void main(String[] args) {
		System.out.println(divide(9, 3));
		System.out.println(divide(10, 3));
		System.out.println(divide(11, 3));
		System.out.println(divide(12, 3));
	}

}
