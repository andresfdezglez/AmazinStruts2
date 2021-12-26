package com.miw.infrastructure;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * Esta clase solo tiene métodos de utilidad usados desde @see Factories
 * 
 * @author alb
 *
 */
public class Helper {

	/**
	 * Devuelve instancia de la clase factory deseada. Crea un objeto a partir
	 * del nombre de la clase
	 * 
	 * @param file  
	 * 		El fichero de propiedades 
	 * @param factoryType 
	 * 		El nombre de la propiedad en el fichero de proerties
	 * @return 
	 * 		El objeto de la clase factoria adecuada
	 */
	static Object createFactory(String file, String factoryType) {
		
		String className = loadProperty(file, factoryType);
		try {
			
			Class<?> clazz = Class.forName(className);
			return clazz.getDeclaredConstructor().newInstance();
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		} catch (InstantiationException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Carga un propiedad desde fichero de propiedades
	 * Lanza runtime exception si no existe la propiedad
	 * @param file
	 * @param property
	 * @return
	 */
	static String loadProperty(String file, String property) {
		Properties p = new Properties();
		try {
			
			p.load(Factories.class.getResourceAsStream(file));
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		String value = p.getProperty(property);
		if (value == null){
			throw new RuntimeException("Property not found in " + file);
		}
		return value;
	}

}
