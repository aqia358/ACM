package practice.day7.dp.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGLibProxy implements MethodInterceptor{

	private static CGLibProxy cglibProxy = new CGLibProxy();
	
	public static CGLibProxy getInstance(){
		return cglibProxy;
	}
	
	public <T> T proxy(Class cl){
		return (T) Enhancer.create(cl, this);
	}
	
	public Object intercept(Object arg0, Method arg1, Object[] arg2,
			MethodProxy arg3) throws Throwable {
		Object result;
		result = arg3.invokeSuper(arg0, arg2);
		System.out.println("cglib proxy ");
		return result;
	}

}
