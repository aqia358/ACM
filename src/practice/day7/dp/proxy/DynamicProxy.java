package practice.day7.dp.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler{

	private Object target;
	
	public DynamicProxy(Object o){
		this.target = o;
	}
	
	public <T> T proxy(){
		return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result;
		result = method.invoke(target, args);
		System.out.println("dynamic proxy ");
		return result;
	}

}
