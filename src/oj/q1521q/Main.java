package oj.q1521q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
	public int data;
	public Main left = null;
	public Main right = null;
	public static int n;

	public Main(int data) {
		this.data = data;
	}

	public static Main find(int data, Main root) {
		if (root == null)
			return null;
		if (root.data == data)
			return root;
		Main m = find(data, root.left);
		if (m == null) {
			return find(data, root.right);
		}
		return m;
	}

	public static void print(Main root) {
		if (root != null) {
			n--;
			if (n == 0)
				System.out.println(root.data);
			else
				System.out.print(root.data + " ");
			print(root.right);
			print(root.left);
		}
	}

	public static void main(String[] args) throws IOException {
		StreamTokenizer st = new StreamTokenizer(new BufferedReader(
				new InputStreamReader(System.in)));
		while (st.nextToken() != StreamTokenizer.TT_EOF) {
			int n = (int) st.nval;
			if (n == 0)
				System.out.println("NULL");
			else {
				int[] array = new int[n];
				for (int i = 0; i < n; i++) {
					st.nextToken();
					array[i] = (int) st.nval;
				}
				Main root = new Main(array[0]);
				for (int i = 0; i < n; i++) {
					Main m = Main.find(array[i], root);
					st.nextToken();
					String o = st.sval;
					if (o.equals("d")) {
						st.nextToken();
						int p = (int) st.nval;
						m.left = new Main(array[p - 1]);
						st.nextToken();
						p = (int) st.nval;
						m.right = new Main(array[p - 1]);
					} else if (o.equals("l")) {
						st.nextToken();
						int p = (int) st.nval;
						m = Main.find(array[i], root);
						m.left = new Main(array[p - 1]);
					} else if (o.equals("r")) {
						st.nextToken();
						int p = (int) st.nval;
						m = Main.find(array[i], root);
						m.right = new Main(array[p - 1]);
					}
				}
				Main.n = n;
				Main.print(root);
			}
		}
	}

}
