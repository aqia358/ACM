package leetcode;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

	public static List<String> fullJustify(String[] words, int L) {
		List<String> re = new ArrayList<String>();
        if(L == 0 && words.length == 0) return re;
		int begin = 0;
		while(begin < words.length){
			int num = 0;
			int sum = L;
			int i = begin;
			while(i < words.length && sum - words[i].length() - num >= 0) {
				sum -= words[i++].length();
				num++;
			}
			int step = num == 1 ? 0 : sum/(num - 1);
			int m = num == 1 ? 0 : sum%(num - 1);
			if(i == words.length){
				step = 1;
				m = 0;
			}
			StringBuilder sb = new StringBuilder(L);
			for(int j = begin; j < i; j++){
				sb.append(words[j]);
				for(int k = 0; k < step && j + 1 < i; k++)
					sb.append(" ");
				if(m > 0) {
					sb.append(" ");
					m--;
				}				
			}
			begin = i;
			while(sb.length() < L)
				sb.append(" ");
			re.add(sb.toString());
		}
		
		return re;
	}
	public static void main(String[] args) {
		String[] words = {"What","must","be","shall","be."};
//		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		fullJustify(words, 12);
	}

}
