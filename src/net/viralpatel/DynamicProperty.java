package net.viralpatel;

import java.lang.reflect.Proxy;

public class DynamicProperty {
	
	public static <T extends Constants> T  create(Class<T> clazz) {
		
		T object = (T) Proxy.newProxyInstance(clazz
				.getClassLoader(), new Class[] { clazz },
				new Handler(clazz));  
		
		return object;
		
	}
}
