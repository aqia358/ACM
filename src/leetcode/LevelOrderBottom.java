package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBottom {

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Queue<TreeNode> p = new LinkedList<TreeNode>();
		q.add(root);
		levelOrder(q, p, lists);
		return lists;
	}

	public static void levelOrder(Queue<TreeNode> q, Queue<TreeNode> p, List<List<Integer>> lists){
		if(q.isEmpty())return;
		TreeNode temp;
		List<Integer> l = new ArrayList<Integer>();
		while(!q.isEmpty()){
			temp = q.poll();
			l.add(temp.val);
			if (temp.left != null)
				p.add(temp.left);
			if (temp.right != null)
				p.add(temp.right);
		}
		levelOrder(p, q, lists);	
		lists.add(l);
	}
	public static void levelOrder(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Queue<TreeNode> q2 = new LinkedList<TreeNode>();
		q.add(root);
		TreeNode temp;
		while (!q.isEmpty() || !q2.isEmpty()){
			while (!q.isEmpty()) {
				temp = q.poll();
				if (temp.left != null)
					q2.add(temp.left);
				if (temp.right != null)
					q2.add(temp.right);
			}
			while(!q2.isEmpty()){
				temp = q2.poll();
				if(temp.left != null)
					q.add(temp.left);
				if(temp.right != null)
					q.add(temp.right);
			}
		}
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		t1.left = t2;
		t1.right = t3;
		t3.left = t4;
		t3.right = t5;
		levelOrderBottom(t1);
		levelOrder(t1);
	}

}
