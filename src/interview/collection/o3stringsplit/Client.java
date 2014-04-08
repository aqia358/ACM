package interview.collection.o3stringsplit;

import java.io.UnsupportedEncodingException;

public class Client {

	public void test() throws Exception{
		String str = "我是中国人azAZ10-=+";
		byte[] b = str.getBytes("GBK");
		for(int i = 0; i < b.length; ++i){
			System.out.println(i+":"+b[i]);
		}
		byte c = -122;
	}
	
	public static void stringSplitTest(){
		String str = "ert我a是a中b国c人azAZ10-=+";
		System.out.println(StringSplit.split(str , 4));
	}
	
	public static void main(String[] args) throws Exception {
		stringSplitTest();
	}

}
