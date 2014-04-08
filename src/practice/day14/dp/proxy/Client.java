package practice.day14.dp.proxy;

public class Client {

	public static void dynamicProxyTest(){
		DynamicProxy proxy = new DynamicProxy(new Human());
		Animal man = proxy.proxy();
		man.move();
	}
	
	public static void cglibProxyTest(){
		CGLibProxy proxy = CGLibProxy.getInstance();
		Hello h = proxy.proxy(Hello.class);
		h.say();
	}
	public static void main(String[] args) {
		dynamicProxyTest();
		cglibProxyTest();
	}

}
