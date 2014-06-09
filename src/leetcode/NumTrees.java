package leetcode;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 *	
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 *
 *   1         3     3      2      1
 *    \       /     /      / \      \
 *     3     2     1      1   3      2
 *    /     /       \                 \
 *   2     1         2                 3
 * @author aqia358
 *
 */
public class NumTrees {

	public static int numTrees(int n){
		if(n == 0 || n == 1)return 1;
		int[] f = new int[n+1];
		f[0] = f[1] = 1;
		for(int i = 2; i < n + 1; ++i){
			for(int j = 1; j <= i; ++j){
				f[i] += f[i - j] * f[j - 1];
			}
		}
		return f[n];
	}
	
	public static void main(String[] args) {
		System.out.println(numTrees(3));
		System.out.println(numTrees(4));
		System.out.println(numTrees(13));
	}

}
