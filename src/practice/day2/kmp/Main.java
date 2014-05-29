package practice.day2.kmp;

/**
 * 2014年5月6日 09:05:15
 * @author aqia358
 * 2014年5月6日 09:34:48
 */
public class Main {

	public static int search(char[] target, char[] a, int[] next){
		int i = 0;
		int j = 0;
		while (i < target.length && j < a.length) {
			if (j == -1 || target[i] == a[j]) {
				i++;
				j++;
			} else {
				j = next[j];
			}
		}
		if(j == a.length) return i - j;
		else return -1;
	}
	
	public static int[] getNext(char[] a){
		int[] next = new int[a.length];
		int i = 1;
		int j = 0;
		next[0] = -1;
		next[1] = 0;
		while(i < a.length){
			if(j == -1 || a[i] == a[j]){
				++i;
				++j;
				if(i < a.length)
					next[i] = j;
			}else{
				j = next[j];
			}
		}
		return next;
	}

	public static void print(int[] a){
		for(int i = 0; i < a.length; ++i)
			System.out.print(a[i]+" ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		String t = "asdflajsdflkjlaskdjfljabcabcc";
		String s = "abcabcc";
		char[] tarray = t.toCharArray();
		char[] sarray = s.toCharArray();
		print(getNext(sarray));
		System.out.println(search(tarray, sarray, getNext(sarray)));
	}

}
