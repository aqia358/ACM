package leetcode;

import java.util.HashMap;
import java.util.Map;

public class CopyList {

	public static RandomListNode copyrandomList(RandomListNode head){
		if(head == null) return null;
		Map<RandomListNode, RandomListNode> m = new HashMap<RandomListNode, RandomListNode>();
		RandomListNode p = head;
		RandomListNode newHead = new RandomListNode(-1);
		RandomListNode newp = newHead;
		while(p != null){
			RandomListNode t = new RandomListNode(p.label);
			m.put(p, t);
			newp.next = t;
			newp = t;
			p = p.next;
		}
		p = head;
		newp = newHead.next;
		while(p != null){
			if(p.random != null)
				newp.random = m.get(p.random);
			else
				newp.random = null;
			p = p.next;
			newp = newp.next;
		}
		return newHead.next;
	}
	
	public static void main(String[] args) {

	}

}
class RandomListNode{
	int label;
	RandomListNode next, random;
	RandomListNode(int x){
		this.label = x;
	}
	
}
