package leetcode;

public class SingleNumber {

	public static int singleNumber(int[] array){
		int result = 0;
		for(int i = 0, len = array.length; i < len; ++i){
			result = result^array[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] array = {1,1,2,2,3,3,4,4,5};
		System.out.println(singleNumber(array));
	}

}
