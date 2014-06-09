package lhl.summary;

import java.util.Stack;

public class TreeSummary {
	public static int maxDepth;

	public static void preOrder(Tree root){
		if(root == null)return;
		preOrder(root.left);
		System.out.print(root.val);
		preOrder(root.right);
	}
	public static void postOrder(Tree root){}
	public static void inOrder(Tree root){}
	
	public static void preOrderByStack(Tree root){
		Stack<Tree> s = new Stack<Tree>();
		if(root == null){
			System.out.println("null tree");
			return; 
		}
		while(root != null || !s.isEmpty()){
			while(root != null){
				s.push(root);
				root = root.left;
			}
			root = s.pop();
			System.out.print(root.val);
			root = root.right;
		}
	}
	public static void inOrderByStack(Tree root){
		Stack<Tree> s = new Stack<Tree>();
		if(root == null){
			System.out.println("null tree");
			return;
		}
		while(root != null || !s.isEmpty()){
			while(root != null){
				s.push(root);
				System.out.print(root.val);
				root = root.left;
			}
			root = s.pop();
			root = root.right;
		}
	}
	public static void postOrderByStack(Tree root){
		if(root == null){
			System.out.println("null tree");
			return;
		}
		int[] flag = new int[20];
		Stack<Tree> s = new Stack<Tree>();
		while(root != null){
			s.push(root);
			flag[s.size()] = 0;
			root = root.left;
		}
		while(!s.isEmpty()){
			root = s.peek();
			while(root.right != null && flag[s.size()] == 0){
				flag[s.size()] = 1;
				root = root.right;
				while(root != null){
					s.push(root);
					flag[s.size()] = 0;
					root = root.left;
				}
			}
			root = s.pop();
			System.out.print(root.val);
			
		}
	}
	
	public static void treeDepth(Tree root, int depth){
		if(root == null)return;
		treeDepth(root.left, depth + 1);
		treeDepth(root.right, depth + 1);
		if(maxDepth < depth)
			maxDepth = depth;
	}
	
	public static void main(String[] args) {
		Tree t0 = new Tree(0);
		Tree t1 = new Tree(1);
		Tree t2 = new Tree(2);
		Tree t3 = new Tree(3);
		Tree t4 = new Tree(4);
		Tree t5 = new Tree(5);
		Tree t6 = new Tree(6);
		t0.left =t1;
		t0.right = t2;
		t1.left = t3;
		t1.right = t4;
		t2.left = t5;
		t2.right = t6;
		preOrder(t0);
		preOrderByStack(t0);
	}

}
class Tree{
	public int val;
	public Tree left;
	public Tree right;
	public Tree(int value){
		val = value;
	}
}