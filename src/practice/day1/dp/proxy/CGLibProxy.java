package practice.day1.dp.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGLibProxy implements MethodInterceptor {

	private static CGLibProxy cglib = new CGLibProxy();
	
	public static CGLibProxy getInstance(){
		return cglib;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T proxy(Class<T> cls){
		return (T) Enhancer.create(cls, this);
	}
	
	public Object intercept(Object arg0, Method method, Object[] arg2,
			MethodProxy proxy) throws Throwable {
		System.out.println("before cglib method");
		Object result = proxy.invokeSuper(arg0, arg2);
		System.out.println("before cglib method");
		return result;
	}

}
