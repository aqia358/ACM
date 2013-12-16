package test.mergesort;

/**
 * 11时33分27秒
 * 11时41分23秒
 * @author aqia358
 *
 */
public class Main2 {

	public void merge(int[]a, int begin, int end){
		if(begin >= end)return;
		int center = (begin + end)/2;
		merge(a, begin, center);
		merge(a, center + 1, end);
		int lbegin = begin;
		int rbegin = center + 1;
		int[] temp = new int[a.length];
		int i = begin;
		while(lbegin <= center && rbegin <= end){
			if(a[lbegin] <= a[rbegin]){
				temp[i++] = a[lbegin++]; 
			}else{
				temp[i++] = a[rbegin++];
			}
		}
		while(lbegin <= center)
			temp[i++] = a[lbegin++];
		while(rbegin <= end)
			temp[i++] = a[rbegin++];
		for(int j = begin; j <= end;j++)
			a[j] = temp[j];
	}
	public static void main(String[] args) {
		int[] a = {1,2,4,3,6,5,8,7,0,9};
		Main2 m = new Main2();
		m.merge(a, 0, a.length - 1);
		for(int i = 0; i < a.length; i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}

}
