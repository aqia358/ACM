package oj.q1373q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {

	public static int sum(int n){
		if(n < 1)return 0;
		int count = 0;
		int Factor = 1;
		int LowerNum = 0;
		int CurrNum = 0;
		int HigherNum = 0;
		while(n/Factor != 0){
			LowerNum = n - (int)Math.floor(n/Factor)*Factor;
			CurrNum = (n/Factor)%10;
			HigherNum = n/(Factor*10);
			switch(CurrNum){
				case 0:
					count += HigherNum*Factor;
					break;
				case 1:
					count += HigherNum*Factor + LowerNum + 1;
					break;
				default:
					count += (HigherNum + 1) * Factor;
					break;
			}
			Factor *= 10;
		}
		return count;
	}
	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while(st.nextToken() != StreamTokenizer.TT_EOF){
			int a = (int) st.nval;
			st.nextToken();
			int b = (int) st.nval;
			if(a < b)
				System.out.println(sum(b) - sum(a-1));
			else
				System.out.println(sum(a) - sum(b-1));
		}
		
	}

}
