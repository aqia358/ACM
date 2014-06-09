package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the following perfect binary tree,
 *          1
 *        /  \
 *       2    3
 *      / \  / \
 *     4  5  6  7
 * After calling your function, the tree should look like:
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \  / \
 *     4->5->6->7 -> NULL
 */
public class NodeRightPointers {

	public static void connect(TreeLinkNode root){
		if(root == null)return;
		Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
		q.add(root);
		int n = 0;
		TreeLinkNode temp,head = new TreeLinkNode(0);
		while(!q.isEmpty()){
			temp = q.poll();
			if(temp.left != null){
				if(q.size() == Math.pow(2, n) - 1){
					++n;
					root.next = null;
					head = temp.left;
					head.next = temp.right;
					head = temp.right;
				}else{
					head.next = temp.left;
					temp.left.next = temp.right;
					head = temp.right;
				}
				q.add(temp.left);
				q.add(temp.right);
			}
		}
	}
	
	public static void main(String[] args) {

	}

}
class TreeLinkNode{
	int val;
	TreeLinkNode left, right, next;
	public TreeLinkNode(int x){
		val = x;
	}
}