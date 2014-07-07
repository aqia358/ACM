package leetcode;

public class Candy {

	public static int candy(int[] ratings) {
		int len = ratings.length;
		int[] f = new int[len];
		f[0] = 1;
		for(int i = 1; i < len; i++){
			if(ratings[i] > ratings[i - 1]){
				f[i] = f[i - 1] + 1;
			}else
				f[i] = 1;
		}
		f[len - 1] = Math.max(f[len - 1], 1);
		for(int i = len - 2; i >= 0; i--){
			if(ratings[i] > ratings[i + 1]){
				f[i] = Math.max(f[i], f[i + 1] + 1);
			}
		}
		int sum = 0;
		for(Integer t : f)
			sum += t;
		return sum;
	}
	public static int candy2(int[] ratings) {
		int sum = 1;
		int p = 0;
		int prev = 1;
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				p = i;
				++prev;
				sum += prev;
			} else {
				if(prev == 1 && ratings[i] != ratings[i - 1])
					sum += i - p + 1;
				else{
					if(ratings[i] == ratings[i - 1])
						p = i;
					sum++;
					prev = 1;
				}
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		int[] a = {1,2,4,3,2,1};
//		int[] a = {1,1,1};
		System.out.println(candy(a));
	}

}
