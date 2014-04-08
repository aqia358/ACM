package interview.collection.o3stringsplit;

public class StringSplit {
	
	public static String split(String src, int n){
		int num = trimGBK(src.getBytes(), n);
		if(num == -1)
			return "error";
		return src.substring(0, num);
	}

	public static int trimGBK(byte[] buf, int n){
		int num = 0;
		boolean bChineseFirstHalf = false;
		if(n > buf.length)return -1;
		for(int i = 0; i < n; ++i){
			if(buf[i] < 0 && !bChineseFirstHalf){
				bChineseFirstHalf = true;
			}else{
				num++;
				bChineseFirstHalf = false;
			}
		}
		return num;
	}
}
