package practice.day14.dp.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CGLibProxy implements MethodInterceptor{

	private static CGLibProxy proxy = new CGLibProxy();
	
	public static CGLibProxy getInstance(){
		return proxy;
	}
	
	public <T> T proxy(Class cl){
		return (T) Enhancer.create(cl, this);
	}
	
	public Object intercept(Object arg0, Method arg1, Object[] arg2,
			MethodProxy arg3) throws Throwable {
		System.out.println("cglib proxy woring");
		Object result;
		result = arg3.invokeSuper(arg0, arg2);
		return result;
	}


}
