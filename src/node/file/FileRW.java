package node.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileRW {

	public static void fileWrite(String name){
		try {
			FileWriter fw = new FileWriter(name,true);
			fw.append("next rowasdfasdf\t ");
//			fw.write("wirite by FileWriter ");
			fw.flush();
//			fw.write("not override ");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void fileReader(String name){
		try {
			FileReader fr = new FileReader(name);
			char[] temp = new char[1024];
			StringBuffer b = new StringBuffer();
			while(fr.read(temp) > 0){
				b.append(temp);
				System.out.println(temp);
			}
			System.out.println(b);
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void fileInputStream(String name){
		try {
			FileInputStream fis = new FileInputStream(name);
			InputStreamReader inReader = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(inReader);
			byte[] buf = new byte[1024];
			System.out.println(br.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String name = "D:/file.txt";
		fileInputStream(name);
		System.out.println("-----");
		fileWrite(name);
		fileReader(name);
	}

}
