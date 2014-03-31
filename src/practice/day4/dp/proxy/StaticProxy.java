package practice.day4.dp.proxy;

public class StaticProxy implements Move{
	private Move m;
	
	public StaticProxy(Move m){
		this.m = m;
	}

	public void run() {
		System.out.println("static proxy before----");
		m.run();
	}

	public void stop() {
		System.out.println("static proxy before----");
		m.run();
	}
}
