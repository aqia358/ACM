package leetcode;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class LongestCommonPrefix {

	public static String longestCommonPrefix(String[] strs){
		if(strs.length == 0)return "";
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < strs[0].length(); i++){
			char temp = strs[0].charAt(i);
			for(int j = 1; j < strs.length; j++){
				if(i >= strs[j].length() || strs[j].charAt(i) != temp)
					return sb.toString();
			}
			sb.append(temp);
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		String[] str = {""};
		System.out.println(longestCommonPrefix(str));
		DateFormat d5 = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL); //显示日期，周，时间（精确到秒）
		String str5 = d5.format(new Date());
		String date=new SimpleDateFormat("EEE, d MMM yyyy z HH:mm:ss",Locale.US).format(new Date());
		System.out.println(date);
		System.out.println(Calendar.getInstance().getTime());
	}

}
