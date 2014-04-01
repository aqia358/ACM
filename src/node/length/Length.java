package node.length;

public class Length {

	public static void char_byte(){
		char a = 0xffff;
		a = '中';
		byte b = 127;
		int c = 0xff;
		b = -127;
		System.out.println(a);
		System.out.println(b);
		
	}
	public static void main(String[] args) {
		char_byte();
	}

}
