package practice.day1.dynamicprogram;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dijkstra {

	public static int[][] f;
	public static int[] vis;
	public static int[] fa;
	public static int N;

	public static void dijkstra() {
		int i, j, start, dmin, next;
		i = j = start = next = 0;
		vis[start] = 1;
		fa[0] = 0;

		for(int count = 1; count < N - 1; ++count){
			dmin = 9999;
			for (i = 1; i < N; ++i) {
				if (vis[i] == 0 && f[start][i] < dmin) {
					dmin = f[start][i];
					next = i;
				}
			}
			vis[next] = 1;
			for (j = 1; j < N; ++j) {
				if (vis[j] == 0
						&& f[start][next] + f[next][j] < f[start][j]) {
					fa[j] = next;
					f[start][j] = f[start][next] + f[next][j];
				}
			}
		}
		print();
	}
	public static void dijkstra(int start, int end) {
		int i, j, dmin, next;
		i = j = start = next = 0;
		vis[start] = 1;
		
		while(next != end){
			dmin = 9999;
			for (i = 1; i < N; ++i) {
				if (vis[i] == 0 && f[start][i] < dmin) {
					dmin = f[start][i];
					next = i;
				}
			}
			vis[next] = 1;
			for (j = 1; j < N; ++j) {
				if (vis[j] == 0
						&& f[start][next] + f[next][j] < f[start][j]) {
					f[start][j] = f[start][next] + f[next][j];
					fa[j] = next;
				}
			}
		}
		print();
		printPath(start, end);
	}

	
	public static void print(){
		for(int i = 0; i < N; ++i){
			for(int j = 0; j < N; ++j){
				System.out.print(f[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	public static void printPath(int start, int target){
		if(target == start){
			System.out.print(start);
		}else{
			printPath(start, fa[target]);
			System.out.print("=>"+target);
		}
	}
	public static void main(String[] args) {
		try {
			Scanner s = new Scanner(new File("d:/c.txt"));
			N = s.nextInt();
			f = new int[N][N];
			vis = new int[N];
			fa = new int[N];
			for(int i = 0; i < N; ++i){
				for(int j = 0; j < N; ++j){
					f[i][j] = s.nextInt();
				}
			}
//			dijkstra();
			dijkstra(0, 1);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
