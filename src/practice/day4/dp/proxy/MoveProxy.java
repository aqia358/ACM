package practice.day4.dp.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MoveProxy implements InvocationHandler{

	private Object target;
	
	public MoveProxy(Object o){
		this.target = o;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T proxy(){
		return (T)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("proxy before method ---------");
		Object result;
		result = method.invoke(target, args);
		return result;
	}

}
