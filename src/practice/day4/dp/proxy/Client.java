package practice.day4.dp.proxy;

public class Client {

	public static void staticProxyTest(){
		StaticProxy proxy = new StaticProxy(new Car());
		proxy.run();
	}
	
	public static void InvocationHandlerProxyTest(){
		MoveProxy proxy = new MoveProxy(new Car());
		Move m = proxy.proxy();
		m.run();
	}
	
	public static void CGLibProxyTest()	{
		CGLibProxy proxy = CGLibProxy.getInstance();
		Test t = proxy.proxy(Test.class);
		t.say();
	}
	public static void main(String[] args) {
		InvocationHandlerProxyTest();
		CGLibProxyTest();
		staticProxyTest();
	}

}
