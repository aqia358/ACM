package interview.collection.o1filemerge;

import java.io.File;

public class Client {

	public static void testFileMerge(){
		File a = new File("d:a.txt");
		File b = new File("d:b.txt");
		File c = new File("d:c.txt");
		FileMerge.merge(a, b, c);
	}
	
	public static void main(String[] args) {
		testFileMerge();
	}

}
