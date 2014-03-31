package practice.day7.dp.proxy;

import org.omg.CORBA.CTX_RESTRICT_SCOPE;

public class Client {

	public static void cglibProxyTest(){
		CGLibProxy proxy = CGLibProxy.getInstance();
		Test t = proxy.proxy(Test.class);
		t.say();
	}
	
	public static void dynamicProxyTest(){
		DynamicProxy proxy = new DynamicProxy(new CarImpl());
		Car c = proxy.proxy();
		c.move();
	}
	public static void main(String[] args) {
		cglibProxyTest();
		dynamicProxyTest();
	}

}
