package oj.q1351q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CopyOfMain {

	public static void print(List<Integer> list){
		for(int i = 0; i < list.size(); i++){
		}
		int count = 0;
		int[] r = new int[2];
		while(count != 2){
			int a = list.get(0);
			list.remove(0);
			if(!list.contains(a)){
				r[count++] = a;
			}else
				list.remove((Integer)a);
		}
		if(r[0] < r[1])
			System.out.println(r[0]+" "+r[1]);
		else
			System.out.println(r[1]+" "+r[0]);
	}
	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		List<Integer> list = new ArrayList<Integer>();
		int count = 0;
		while(st.nextToken() != st.TT_EOF){
			count++;
			list.add((int)st.nval);
		}
		print(list);
	}

}
