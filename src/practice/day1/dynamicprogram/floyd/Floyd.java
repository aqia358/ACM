package practice.day1.dynamicprogram.floyd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//4
//0	9999	3	9999
//2	0	9999	9999
//9999	7	0	1
//6	9999	9999	0

public class Floyd {

	public static int N;
	public static int[][] f;
	public static int[][] path;
	
	public static void floyd(){
		int i,j,k;
		i = j = k = 0;
		for(k = 0; k < N; ++k)
			for(i = 0; i < N; ++i)
				for(j = 0; j < N; ++j)
					if(f[i][j] > f[i][k] + f[k][j]){
						f[i][j] = f[i][k] + f[k][j];
						path[i][j] = k;
					}
		print();
	}
	
	public static void print(){
		for(int i = 0; i < N; ++i){
			for(int j = 0; j < N; ++j){
				printPath(i, j);
				System.out.print("="+f[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public static void printPath(int i, int j){
		if(i == j || path[i][j] == -1)
			System.out.print(i+"->"+j);
		else{
			printPath(i,path[i][j]);
			System.out.print("->"+j);
		}
	}
	
	public static void main(String[] args) {
		String p = "d:/b.txt";
		try {
			Scanner s = new Scanner(new File(p));
			while(s.hasNext()){
				N = s.nextInt();
				f = new int[N][N];
				path = new int[N][N];
				for(int i = 0; i < N; ++i){
					for(int j =0; j < N; ++j){
						f[i][j] = s.nextInt();
						path[i][j] = -1;
					}
				}
				floyd();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
