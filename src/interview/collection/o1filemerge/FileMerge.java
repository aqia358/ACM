package interview.collection.o1filemerge;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileMerge {

	public static void merge(File a, File b, File c){
		if(a == null || b == null || c == null)return;
		String[] as = split(a, "\r\n");
		String[] bs = split(b, " |\n");
		int abegin = 0;
		int bbegin = 0;
		try {
			FileWriter fw = new FileWriter(c, true);
			while(abegin < as.length &&  bbegin < bs.length){
				fw.write(as[abegin++]+"\n");
				fw.write(bs[bbegin++]+"\n");
			}
			while(abegin < as.length)
				fw.write(as[abegin++]+"\n");
			while(bbegin < bs.length)
				fw.write(bs[bbegin++]+"\n");
			fw.flush();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String[] split(File file, String regex){
		String str = "";
		try {
			FileReader fr = new FileReader(file);
			char[] c = new char[(int) file.length()];
			fr.read(c);
			str = new String(c);
			fr.close();
		} catch ( Exception e) {
			e.printStackTrace();
		}
		return str.split(regex);
	}
}
