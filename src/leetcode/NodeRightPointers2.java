package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class NodeRightPointers2 {

	public static void connect2(TreeLinkNode root){
		while(root != null){
			TreeLinkNode next = null;
			TreeLinkNode prev = null;
			while(root != null){
				if(next == null){
					if(root.left != null)
						next = root.left;
					else
						next = root.right;
				}
				if(root.left != null){
					if(prev != null)
						prev.next = root.left;
					prev = root.left;
				}
				if(root.right != null){
					if(prev != null)
						prev.next = root.right;
					prev = root.right;
				}
				root = root.next;
			}
			root = next;
		}
	}
	public static void connect(TreeLinkNode root){
		if(root == null) return;
		Queue<TreeLinkNode> p = new LinkedList<TreeLinkNode>();
		Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
		p.add(root);
		connect(p, q);
	}
	
	public static void connect(Queue<TreeLinkNode> p, Queue<TreeLinkNode> q){
		if(p.isEmpty()) return;
		TreeLinkNode temp = null;
		TreeLinkNode head = null;
		while(!p.isEmpty()){
			temp = p.poll();
			if(temp.left != null)
				q.add(temp.left);
			if(temp.right != null)
				q.add(temp.right);
			if(head == null)
				head = temp;
			else{
				head.next = temp;
				head = head.next;
			}
		}
		head.next = null;
		connect(q, p);
	}
	
	public static void main(String[] args) {
		TreeLinkNode t1 = new TreeLinkNode(1);
		TreeLinkNode t2 = new TreeLinkNode(2);
		TreeLinkNode t3 = new TreeLinkNode(3);
		t1.left = t2;
		t1.right = t3;
		connect(t1);
	}

}
