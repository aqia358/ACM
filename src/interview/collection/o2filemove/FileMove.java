package interview.collection.o2filemove;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileMove {
	
	public static void moveFile(String src, String target){
		File[] files = getFile(src);
		for(File f : files){
			move(f, target);
		}
	}
	
	public static File[] getFile(String dir){
		File srcDir = new File(dir);
		if(srcDir == null)return null;
		File[] files = srcDir.listFiles(new FileMove().new MyFileFilter());
		return files;
	}
	
	public static void move(File f, String target){
		File tFile = new File(target);
		if(!tFile.exists())
			tFile.mkdirs();
		String newf = target+"/"+f.getName().replace(".txt", ".bat");
		File nFile = new File(newf);
		try {
			FileInputStream fr = new FileInputStream(f);
			FileOutputStream fw = new FileOutputStream(nFile);
			byte[] temp = new byte[1024];
			while(fr.read(temp) > 0){
				fw.write(temp);
			}
			fr.close();
			fw.close();
		} catch ( Exception e) {
			e.printStackTrace();
		}
	}
	
	class MyFileFilter implements FileFilter{

		public boolean accept(File pathname) {
			return pathname.getName().endsWith(".txt");
		}
		
	}
}
