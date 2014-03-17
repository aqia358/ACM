package oj.q1348q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 数组中的逆序对
 * 2014年3月15日 20:44:15
 * @author aqia358
 * 
 */
public class Main {

	public static long num = 0;
	public static int[] result;
	
	public static void merge(int[] a, int begin, int end){
		if(begin != end){
			int center = (begin+end)/2;
			merge(a, begin, center);
			merge(a, center+1, end);
			int i = begin;
			int left = begin;
			int right = center+1;
			while(left <= center && right <= end){
				if(a[left] > a[right]){
					result[i++] = a[right++];
					num = num + center - left + 1;
				}else{
					result[i++] = a[left++];
				}
			}
			while(left <= center ){
				result[i++] = a[left++];
			}
			while(right <= end){
				result[i++] = a[right++];
			}
			for(int j = begin; j <= end; j++){
				a[j] = result[j];
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
//		int[] a = {9,8,7,6,5,4,3,2,1,0};
//		int[] a = {7,5,6,4};
//		Main.merge(a, 0, a.length - 1);
//		System.out.println(Main.num);
//		Main.num = 0;
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while(st.nextToken() != st.TT_EOF){
			int m = (int) st.nval;
			int[] a = new int[m];
			Main.result = new int[m];
			for(int i = 0; i < m; i++){
				st.nextToken();
				a[i] = (int) st.nval;
			}
			Main.merge(a, 0, a.length - 1);
			System.out.println(Main.num);
			Main.num = 0;
		}
	}
}
