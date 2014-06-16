package leetcode;

import java.util.HashSet;

public class LongestSequence {

	public static int longestConsecutive(int[] num){
		int len = num.length;
		if(len <= 1) return len;
		HashSet<Integer> hash = new HashSet<Integer>();
		for(int i = 0; i < len; i++){
			hash.add(num[i]);
		}
		int longest = 0;
		for(int i = 0; i < len; i++){
			int tempnum = num[i] + 1;
			int templen = 1;
			while(hash.contains(tempnum)){
				hash.remove(tempnum);
				templen++;
				tempnum++;
			}
			tempnum = num[i] - 1;
			while(hash.contains(tempnum)){
				hash.remove(tempnum);
				templen++;
				tempnum--;
			}
			if(templen > longest)
				longest = templen;
			if(longest >= len)
				break;
		}
		return longest;
	}
	public static int longestConsecutive2(int[] num){
		int len = num.length;
		if(len == 0) return 0;
		int max = 0;
		int min = num[0];
		for(int i = 0; i < len; i++){
			if(max < num[i])
				max = num[i];
			if(min > num[i])
				min = num[i];
		}
		len = max - min + 1;
			
		int[] t = new int[len];
		for(int i = 0; i < num.length; i++){
			t[num[i] - min] = 1;
		}
		int re = 0;
		int j = 0;
		for(int i = 0; i < len; i++){
			if(t[i] == 1)
				j++;
			else{
				if(j > re)
					re = j;
				j = 0;
			}
		}
		return re;
	}
	public static void main(String[] args) {
		int[] num = {2147483646,-2147483647,0,2,2147483644,-2147483645,2147483645};
		System.out.println(longestConsecutive(num));
	}

}
