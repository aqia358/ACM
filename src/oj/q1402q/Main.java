package oj.q1402q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
//		Scanner sin = new Scanner(System.in);
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while (st.nextToken() != StreamTokenizer.TT_EOF) {
			byte [] a = new byte[1000001];
			int n = (int)st.nval;

			int max = 0;
			for(int i = 0; i < n; i++){
				st.nextToken();
				int val = (int)st.nval;
				if(a[val] == 0 || a[val] == 1)
					a[val]++;
				if(val > max)
					max = val;
			}
			int count = 0;
			for(int i = 0; i <= max ; i++){
				if(a[i] == 1){
					count++;
				}
			}
			System.out.println(count);
			int count2 = 0;
			for (int i = 0; i <= max; i++) {
				if (a[i] == 1) {
					if(count2 < count - 1){
						System.out.print(i+" ");
						count2++;
					}else{
						System.out.println(i);
						break;
					}
				}
			}
		}
	}

}
