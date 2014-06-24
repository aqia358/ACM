package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

	public UndirectedGraphNode cloneGraphccccc(UndirectedGraphNode node) {
		// use LinkedList to bread first search, only offer those first met
		// nodes
		LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		// use hashmap to query quickly
		HashMap<Integer, UndirectedGraphNode> kv = new HashMap<Integer, UndirectedGraphNode>();

		if (node == null)
			return null;
		queue.offer(node);
		while (!queue.isEmpty()) {
			UndirectedGraphNode label = queue.poll();
			if (!kv.containsKey(label.label)) {
				kv.put(label.label, new UndirectedGraphNode(label.label));
			}
			for (UndirectedGraphNode nei : label.neighbors) {
				if (kv.containsKey(nei.label))
					kv.get(label.label).neighbors.add(kv.get(nei.label));
				else {
					queue.offer(nei);
					kv.put(nei.label, new UndirectedGraphNode(nei.label));
					kv.get(label.label).neighbors.add(kv.get(nei.label));
				}
			}
		}
		return kv.get(node.label);
	}

	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null)
			return null;
		HashMap<Integer, UndirectedGraphNode> m = new HashMap<Integer, UndirectedGraphNode>();
		LinkedList<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
		q.offer(node);
		while (!q.isEmpty()) {
			UndirectedGraphNode old = q.poll();
			if (!m.containsKey(old.label))
				m.put(old.label, new UndirectedGraphNode(old.label));
			UndirectedGraphNode n = m.get(old.label);
			for (UndirectedGraphNode i : old.neighbors) {
				if (!m.containsKey(i.label)) {
					q.offer(i);
					m.put(i.label, new UndirectedGraphNode(i.label));
				} 
				n.neighbors.add(m.get(i.label));
			}
		}
		return m.get(node.label);
	}

	public UndirectedGraphNode cloneGraph1(UndirectedGraphNode node) {
		if (node == null)
			return null;
		Map<UndirectedGraphNode, UndirectedGraphNode> m = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
		q.add(node);
		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		m.put(node, newNode);
		UndirectedGraphNode temp, n = null;
		while (!q.isEmpty()) {
			node = q.poll();
			n = m.get(node);
			for (UndirectedGraphNode i : node.neighbors) {
				temp = isExist(i, m);
				n.neighbors.add(temp);
				m.put(i, temp);
				if (node != i)
					q.offer(i);
			}
		}
		return newNode;
	}

	public UndirectedGraphNode cloneGraph2(UndirectedGraphNode node) {
		if (node == null)
			return null;
		Map<UndirectedGraphNode, UndirectedGraphNode> m = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		m.put(node, newNode);
		dfs(node, m);
		return newNode;
	}

	public static void dfs(UndirectedGraphNode node,
			Map<UndirectedGraphNode, UndirectedGraphNode> m) {
		UndirectedGraphNode newNode = isExist(node, m);
		for (UndirectedGraphNode i : node.neighbors) {
			newNode.neighbors.add(isExist(i, m));
			if (node != i)
				dfs(i, m);
		}
	}

	public static UndirectedGraphNode isExist(UndirectedGraphNode node,
			Map<UndirectedGraphNode, UndirectedGraphNode> m) {
		UndirectedGraphNode newNode;
		if (m.containsKey(node))
			newNode = m.get(node);
		else {
			newNode = new UndirectedGraphNode(node.label);
			m.put(node, newNode);
		}
		return newNode;
	}

	public static void main(String[] args) {
		UndirectedGraphNode u0 = new UndirectedGraphNode(0);
		UndirectedGraphNode u1 = new UndirectedGraphNode(1);
		UndirectedGraphNode u2 = new UndirectedGraphNode(2);
		u0.neighbors.add(u1);
		u1.neighbors.add(u2);
		u2.neighbors.add(u2);
		cloneGraph(u0);
	}

}

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	public UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}