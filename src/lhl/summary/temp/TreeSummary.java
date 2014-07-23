package lhl.summary.temp;

/**
 * 深度遍历（preOrder,inOrder,postOrder)递归非递归
 * 广度遍历
 * 树的最大最小深度，路径
 * 是否是平衡二叉树
 * 生成1-n所有二叉树
 */
import java.util.List;
import java.util.Stack;

public class TreeSummary {
	public static int maxDepth;

	public static void preOrder(Tree root) {
		if (root == null)
			return;
		preOrder(root.left);
		System.out.print(root.val);
		preOrder(root.right);
	}

	public static void postOrder(Tree root) {
	}

	public static void inOrder(Tree root) {
	}

	public static void inOrderByStack(Tree root) {
		Stack<Tree> s = new Stack<Tree>();
		if (root == null) {
			System.out.println("null tree");
			return;
		}
		while (root != null || !s.isEmpty()) {
			while (root != null) {
				s.push(root);
				root = root.left;
			}
			root = s.pop();
			System.out.print(root.val);
			root = root.right;
		}
	}

	public static void preOrderByStack(Tree root) {
		Stack<Tree> s = new Stack<Tree>();
		if (root == null) {
			System.out.println("null tree");
			return;
		}
		while (root != null || !s.isEmpty()) {
			while (root != null) {
				s.push(root);
				System.out.print(root.val);
				root = root.left;
			}
			root = s.pop();
			root = root.right;
		}
	}

	public static void postOrderByStack(Tree root) {
		if (root == null) {
			System.out.println("null tree");
			return;
		}
		int[] flag = new int[20];
		Stack<Tree> s = new Stack<Tree>();
		while (root != null) {
			s.push(root);
			flag[s.size()] = 0;
			root = root.left;
		}
		while (!s.isEmpty()) {
			root = s.peek();
			while (root.right != null && flag[s.size()] == 0) {
				flag[s.size()] = 1;
				root = root.right;
				while (root != null) {
					s.push(root);
					flag[s.size()] = 0;
					root = root.left;
				}
			}
			root = s.pop();
			System.out.print(root.val);

		}
	}

	public static int depth(Tree root) {
		if (root == null)
			return 0;
		return 1 + Math.max(depth(root.left), depth(root.right));
	}
	
	public static int minDepth(Tree root, int depth){
		if(root == null) return 9999;
		if(root.left == null && root.right == null)
			return depth;
		return Math.min(minDepth(root.left, depth), minDepth(root.right, depth));
	}

	public static boolean isBalanced(Tree root) {
		if (root == null)
			return true;
		int leftDepth = depth(root.left);
		int rightDepth = depth(root.right);
		if(Math.abs(leftDepth - rightDepth) > 1)
			return false;
		else
			return isBalanced(root.left) && isBalanced(root.right);
	}
	
	public static boolean isBalanced(Tree root, Depth d){
		if(root == null){
			d.height = 0;
			return true;
		}
		Depth left = new Depth();
		Depth right = new Depth();
		if(isBalanced(root.left, left) && isBalanced(root.right, right)){
			if(Math.abs(left.height - right.height) <= 1){
				d.height = Math.max(left.height, right.height);
				return true;
			}
		}
		return false;
	}
	public static void treeDepth(Tree root, int depth) {
		if (root == null)
			return;
		treeDepth(root.left, depth + 1);
		treeDepth(root.right, depth + 1);
		if (maxDepth < depth)
			maxDepth = depth;
	}

	public static List<Tree> generateTree(int n){
		
		return null;
	}
	public static void main(String[] args) {
		Tree t0 = new Tree(0);
		Tree t1 = new Tree(1);
		Tree t2 = new Tree(2);
		Tree t3 = new Tree(3);
		Tree t4 = new Tree(4);
		Tree t5 = new Tree(5);
		Tree t6 = new Tree(6);
		t0.left = t1;
		t0.right = t2;
		t1.left = t3;
		t1.right = t4;
		t2.left = t5;
		t2.right = t6;
		preOrder(t0);
		preOrderByStack(t0);
	}

}

class Depth{
	public int height;
}
class Tree {
	public int val;
	public Tree left;
	public Tree right;

	public Tree(int value) {
		val = value;
	}
}