package interview.collection.o6countname;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;

public class CountName {

	public static String[] readFromFile(String path){
		File f = new File(path);
		if(!f.exists())
			return null;
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String str;
			String[] a = new String[3];
			HashMap map = new HashMap();
			while((str = br.readLine()) != null){
				a = str.split(",");
				Integer num = (Integer) map.get(a[1]);
				if(num == null)
					num = 0;
				else
					num++;
				map.put(a[1], num);
			}
			Iterator itr = map.keySet().iterator();
			while(itr.hasNext()){
				String name = (String) itr.next();
				System.out.println(name+map.get(name));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public static void main(String[] args) {
		readFromFile("d:delbat/name.txt");
	}

}
