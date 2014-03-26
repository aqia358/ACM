package practice.day2.dp.proxy;

public class MoveProxy implements Move{
	
	private Move m;
	
	public MoveProxy(Move m){
		this.m = m;
	}

	public void run() {
		System.out.println("move by proxy");
		m.run();
	}

	public void stop() {
		System.out.println("stop by proxy");
		m.run();
	}

}
