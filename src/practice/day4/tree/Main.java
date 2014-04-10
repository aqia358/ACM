package practice.day4.tree;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static Tree buildTree(){
		Tree t1 = new Tree(1);
		Tree t2 = new Tree(2);
		Tree t3 = new Tree(3);
		Tree t4 = new Tree(4);
		Tree t5 = new Tree(5);
		Tree t6 = new Tree(6);
		Tree t7 = new Tree(7);
		Tree t8 = new Tree(8);
		Tree t9 = new Tree(9);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		t4.left = t8;
		t4.right = t9;
		return t1;
	}
	
	public static void levelOrder(Tree t){
		if(t == null)return;
		Queue<Tree> q = new LinkedList<Tree>();
		q.add(t);
		while(!q.isEmpty()){
			Tree temp = q.poll();
			System.out.println(temp.value);
			if(temp.left != null)
				q.add(temp.left);
			if(temp.right != null)
				q.add(temp.right);
		}
	}
	
	public static void main(String[] args) {
		levelOrder(buildTree());
	}

}

class Tree{
	public int value;
	public Tree left;
	public Tree right;
	
	public Tree(int value){
		this.value = value;
	}
}
