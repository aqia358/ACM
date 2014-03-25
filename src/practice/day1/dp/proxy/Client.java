package practice.day1.dp.proxy;

/**
 * 1，什么是代理模式？
 * 代理模式的作用是：为其他对象提供一种代理以控制对这个对象的访问。
 * 
 * 2，策略模式有什么好处？
 * 在某些情况下，一个客户不想或者不能直接引用另一个对象，而代理对象可以在客户端和目标对象之间起到中介的作用。
 * 
 * 3，代理模式一般涉及到的角色有：
 * 抽象角色：声明真实对象和代理对象的共同接口； 
 * 代理角色：代理对象角色内部含有对真实对象的引用，从而可以操作真实对象，同时代理对象提供与真实对象相同的接口以便在任何时刻都能代替真实对象。同时，代理对象可以在执行真实对象操作时，附加其他的操作，相当于对真实对象进行封装。 
 * 真实角色：代理角色所代表的真实对象，是我们最终要引用的对象。
 * 
 * @author aqia358
 *
 */
public class Client {

	public static void main(String[] args) {
		System.out.println("static proxy -------");
		MoveProxy move;
		Bike bike = new Bike();//得到一辆自行车
		move = new MoveProxy(bike);
		move.move();
		move.stop();
		
		Car car = new Car();//得到一辆车
		move = new MoveProxy(car);
		move.move();
		move.stop();
		
		System.out.println("dynamic proxy -------");
		DynamicProxy dynamicProxy = new DynamicProxy(bike);
		Moveable m = dynamicProxy.proxy();
		m.move();
		System.out.println("cglib proxy -------");
		CGLibProxy cglibProxy = CGLibProxy.getInstance();
		Moveable mm = cglibProxy.proxy(Car.class);
		mm.move();
		
		Test t = cglibProxy.proxy(Test.class);
		t.say();
		
	}

}
