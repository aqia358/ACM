package oj.q1352q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 和为S的两个数字
 * @author aqia358
 *
 */
public class Main {

	public static void find(int[] a,int target){
		int m = 0;
		int n = 0;
		boolean flag = false;
		for(int i = 0; i < a.length; i++){
			for(int j = i+1; j < a.length; j++){
				if(a[i] * 2 > target){
					i = a.length;
					j = a.length;
					break;
				}
				int temp = a[i] + a[j];
				if(temp > target){
					break;
				}else if(temp == target){
					m = a[i];
					n = a[j];
					flag = true;
					i = a.length;
					j = a.length;
					break;
				}
			}
		}
		if(!flag){
			System.out.println("-1 -1");
		}else{
			if(m > n)
				System.out.println(n+" "+m);
			else
				System.out.println(m+" "+n);
		}
			
	}
	public static void find2(int[] a, int target){
		int low = 0;
		int high = a.length -1;
		while(low < high){
			if(a[low] + a[high] == target)break;
			else if(a[low] + a[high] < target)
				low++;
			else
				high--;
		}
		if(low < high)
			System.out.println(a[low]+" "+a[high]);
		else
			System.out.println("-1 -1");
	}
	
	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while(st.nextToken() != st.TT_EOF){
			int n = (int) st.nval;
			st.nextToken();
			int target = (int) st.nval;
			int[] a = new int[n];
			int count = 0;
			while(count < n){
				st.nextToken();
				a[count++] = (int) st.nval;
			}
			find2(a, target);
		}
	}

}
