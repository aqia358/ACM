package lhl.summary.temp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dijkstra {
	public static int N;
	public static int[][] f;
	public static int[] vis;
	public static int[] fa;

	public static void dijkstra(int start, int end){
		int next = 0;
		while(next != end){
			int min = Integer.MAX_VALUE;
			for(int i = 1; i < N; i++){
				if(vis[i] == 0 && f[start][i] < min){
					min = f[start][i];
					next = i;
				}
			}
			vis[next] = 1;
			for(int j = 1; j < N; j++){
				if(vis[j] == 0 && f[start][next] + f[next][j] < f[start][j]){
					f[start][j] = f[start][next] + f[next][j];
					fa[j] = next;
				}
			}
		}
		print(end);
	}
	
	public static void print(int i){
		if(fa[i] == i){
			System.out.print(i);
			return;
		}else{
			print(fa[i]);
			System.out.print("=>"+i);
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
            dijkstra(0, 1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

	}

}
