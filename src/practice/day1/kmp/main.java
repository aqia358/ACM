package practice.day1.kmp;

public class main {

	public static int find(char[] target, char[] a, int[] next){
		int i = 0;
		int j = i;
		int m = 0;
		while (j < target.length && m < a.length) {
			if (target[j] == a[m]) {
				j++;
				m++;
			} else {
				i++;
				j = i;
				m = 0;
			}
		}
		if(m == a.length)return i;
		else return -1;
	}
	
	public static int find2(char[] target, char[] a, int[] next){
		int i = 0;
		int j = i;
		int m = 0;
		while (j < target.length && m < a.length) {
			if (target[j] == a[m]) {
				j++;
				m++;
			} else {
				j = next[j];
				m = 0;
			}
		}
		if(m == a.length)return i;
		else return -1;
	}
	
	public static int[] getNext(char[] a){
		int[] next = new int[a.length];
		int i = 1;
		int pos = 0;
		next[0] = -1;
		next[1] = 0;
		while(i < a.length){
			if(pos == -1 || a[i] == a[pos]){
				i++;
				pos++;
				if(i < a.length)
					if(a[i] == a[i - 1])
						next[i] = next[i - 1];
					else
						next[i] = pos;
			}else{
				pos = next[pos];
			}
		}
		return next;
	}
	
	public static void print(int[] a){
		for(int i = 0; i < a.length; ++i)
			System.out.print(a[i] + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		String s = "abcabcadasfabcabcc";
		String str = "abcabcc";
		char[] a = str.toCharArray();
		char[] target = s.toCharArray();
		print(getNext(a));
		System.out.println(find(target, a, null));
		System.out.println(find(target, a, getNext(a)));
	}

}
