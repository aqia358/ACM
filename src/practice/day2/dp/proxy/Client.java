package practice.day2.dp.proxy;

public class Client {
	
	public static void MoveProxyTest(){
		System.out.println("----------moveproxy test---------------");
		Car c = new Car();
		Bike b = new Bike();
		MoveProxy proxy;
		proxy = new MoveProxy(c);
		proxy.run();
		proxy.stop();
		
		proxy = new MoveProxy(b);
		proxy.run();
		proxy.stop();
	}

	public static void DynamicProxyTest(){
		System.out.println("--------------dynamic proxy test-----------");
		Car c = new Car();
		DynamicProxy proxy = new DynamicProxy(c);
		Move m = proxy.proxy();
		m.run();
		m.stop();
	}
	
	public static void CGLibProxyTest(){
		System.out.println("--------------CGLlib proxy test-------");
		CGLibProxy proxy = CGLibProxy.getInstance();
		Common t = proxy.getProxy(Common.class);
		t.say();
	}
	
	public static void main(String[] args) {
		MoveProxyTest();
		DynamicProxyTest();
		CGLibProxyTest();
	}

}
