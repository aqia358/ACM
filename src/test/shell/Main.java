package test.shell;

/**
 * 11时11分16秒
 * @author aqia358
 * 11时31分08秒
 */
public class Main {
	
	public void shell(int a[]){
		for(int c = a.length/2; c > 0; c = c/2){
			for(int i = c; i < a.length; i++){
				int temp = a[i];
				int j = i;
				for(;j - c >= 0 && a[j-c] > temp;j = j-c){
					a[j] = a[j - c];
				}
				a[j] = temp;
			}
		}
		print(a);
	}
	public void shell2(int a[]){
		for(int c = a.length/2; c > 0; c = c/2){
			for(int i = c; i < a.length; i++){
				int temp = a[i];
				int j = i;
				while(j - c >= 0 && a[j - c] > temp){
					a[j] = a[j-c];
					j = j-c;
				}
				a[j] = temp;
			}
		}
		print(a);
	}
	public void print(int[]a){
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i]+" ");
		}
	}
	public static void main(String[] args) {
		int[] a = {2,1,4,3,6,5,8,7,0,9};
		Main m = new Main();
		m.shell2(a);
	}

}
