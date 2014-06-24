package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BTZigzagLevelOrder {

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root){
		List<List<Integer>> re = new ArrayList<List<Integer>>();
		if(root  == null) return re;
		Queue<TreeNode> p = new LinkedList<TreeNode>();
		p.add(root);
		levelOrder(p, new LinkedList<TreeNode>(), re, 0)	;	
		return re;
	}
	
	public static void levelOrder(Queue<TreeNode> p, Queue<TreeNode> q,List<List<Integer>> re, int level){
		if(p.isEmpty()) return;
		Stack<Integer> s = new Stack<Integer>();
		List<Integer> l = new ArrayList<Integer>();
		while(!p.isEmpty()){
			TreeNode t = p.poll();
			if(level % 2 == 0)
				l.add(t.val);
			else
				s.push(t.val);
			if(t.left != null)
				q.add(t.left);
			if(t.right != null)
				q.add(t.right);
		}
		while(!s.isEmpty())
			l.add(s.pop());
		re.add(l);
		levelOrder(q, p, re, level + 1);
	}
	public static void main(String[] args) {
		TreeNode t = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		t.left = t2;
		t.right = t3;
		t3.left = t4;
		t3.right = t5;
		zigzagLevelOrder(t);
	}

}
