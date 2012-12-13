package net.viralpatel;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import net.viralpatel.annotations.DefaultStringValue;
import net.viralpatel.annotations.Key;

public class Handler implements InvocationHandler {
	
	Object obj;

	public Handler(Object obj) {
		this.obj = obj;
	}
	
	public Object invoke(Object proxy, Method m, Object[] args)
			throws Throwable {
		String key = null;
		String defaultValue = null;
		try {

			Annotation[] annotations = m.getAnnotations();
			for (Annotation annotation : annotations) {
				if (annotation instanceof Key) {
					key = ((Key)annotation).value();
				} else if (annotation instanceof DefaultStringValue) {
					defaultValue = ((DefaultStringValue)annotation).value();
				}
			}

			String ret = PropertyLoader.get(key);
			return (null == ret) ? defaultValue : ret;
			
			// result = m.invoke(obj, args);

		} catch (Exception e) {
			// We could also put some code here if we want to do
			// anything special in case an Exception is thrown from
			// the inside of invoked method.
			throw e;
		}
	}
}