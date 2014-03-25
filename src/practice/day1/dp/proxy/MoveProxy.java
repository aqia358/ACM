package practice.day1.dp.proxy;

public class MoveProxy implements Moveable{

	private Moveable m;
	public MoveProxy(Moveable m){
		this.m = m;
	}
	
	public void move() {
		System.out.println(System.currentTimeMillis());
		m.move();
		System.out.println(System.currentTimeMillis());
	}
	
	public void stop() {
		System.out.println(System.currentTimeMillis());
		m.stop();
		System.out.println(System.currentTimeMillis());
	}
	
}
