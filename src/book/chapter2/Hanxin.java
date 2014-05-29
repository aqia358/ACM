package book.chapter2;

public class Hanxin {

	public static int find(int a, int b, int c){
		for(int i = 10; i <= 100; i++){
			if((i - a)%3 != 0)
				continue;
			if((i - b)%5 != 0)
				continue;
			if((i - c)%7 != 0)
				continue;
			return i;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(find(2,1,6));
	}

}
