package del.test;


public class Main {
	private boolean flag = true;
	private Thread thread;
	private int count = 0;

	private class Test extends Thread{
		
		public void run(){
			while(flag){
				try {
					System.out.println("thread is running");
					count++;
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("thread closed exception");
					e.printStackTrace();
				}
			}
		}
	}
	public void gotorun(){
		thread = new Test();
		thread.start();
	}
	public void stop(){
		flag = false;
//		thread.interrupt();
		thread = null;
	}
	public static void main(String[] args) throws InterruptedException {
		Main m = new Main();
		m.gotorun();
		Thread.sleep(3000);
		m.stop();
		Thread.sleep(3000);
		m.flag = true;
		m.gotorun();
//		int code = 0xf6;
//		String str = "中国";
//		byte[] buff = str.getBytes();
//		System.out.println(buff.length);
//		StringBuffer builder = new StringBuffer();
//		for (int i = 0; i < buff.length; i++) {
//		    buff[i] |= code;
//		    builder.append(buff[i]);
//		}
//		System.out.println("中国");
//		System.out.println(new String(buff));
//		System.out.println(builder.toString());
//
//		HashMap<Long,String> hh = new HashMap<Long,String>();
//		hh.put( 1l, "1");
//		hh.put(1l, "2");
//		hh.remove(1l);
//		if(hh.isEmpty())
//			System.out.println("is empty");
//		else
//			System.out.println(hh.get(1l));
//		int tem = 0xfe;
//		byte b = (byte) 0xfe;
//		System.out.println(tem);
//		System.out.println(b);
//		System.out.println((int)b);
//		byte[] b = new byte[2];
//		b[0] = 0x33;
//		b[1] = 0x33;
//		System.out.println(b[0] << 8 & 0xff00 | b[1] & 0xff);
//		Map<Integer,String> m = new HashMap<Integer,String>();
//		m.put(1, "11");
//		m.put(2, "22");
//		String s = m.get(3);
//		if(s == null)
//			System.out.print("null");
//		else
//			System.out.print("hello");
		
	}

}
