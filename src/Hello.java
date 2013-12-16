import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

public class Hello {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		int type;
		StreamTokenizer tok = new StreamTokenizer(new StringReader("qwertyuiopasdfghjkllzxcvbnm"));
//		StreamTokenizer tok = new StreamTokenizer(new BufferedReader(
//				new InputStreamReader(System.in)));
		System.out.println("please input :");
		try {
			while ((type = tok.nextToken()) != tok.TT_EOL) {
				if (type == tok.TT_NUMBER) {
					System.out.println(tok.nval);
				} else if (type == tok.TT_WORD) {
					if (tok.sval.equalsIgnoreCase("exit")) {
						System.exit(1);
					}
					System.out.println(tok.sval);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
