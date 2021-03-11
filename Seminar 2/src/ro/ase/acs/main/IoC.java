package ro.ase.acs.main;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class IoC {
    private Map<Class<?>, Class<?>> map = new HashMap<>();
	
	public void register(Class<?> contract, Class<?> implementation) {
		if(!map.containsKey(contract)) {
			map.put(contract, implementation);
		}
	}
	
	public <T> T resolve(Class<?> c) {
		Class<?> implementation = map.get(c);
		try {
			Object obj = implementation.getConstructor().newInstance();
			if(implementation.isInstance(obj)) {				
				return (T) obj;
			}
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
