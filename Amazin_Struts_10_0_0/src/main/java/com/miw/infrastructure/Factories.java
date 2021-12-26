package com.miw.infrastructure;

import com.miw.business.ServicesFactory;
import com.miw.persistence.DataServicesFactory;

/**
 * Esta clase es la que realemente relaciona las interfaces de las capas con sus
 * implementaciones finales.
 * 
 * Se toma la configración de un fichero de propiedades de manera que cambiar la
 * configraciónn de la aplicación (cambiar de implementación en alguna capa)
 * quedará ahora reducido a cambiar el contenido del fichero
 * "factories.properties".
 * 
 * Este fichero, para esta implementación debe tener al menos estas dos
 * propiedades SERVICES_FACTORY y PERSISTENCE_FACTORY
 *  
 * Hay frameworks especializados en esto precisamente, por ejemplo Spring.
 * 
 * @author alb
 * @author dflanvin
 * 
 */
public class Factories {
	private static String CONFIG_FILE = "/factories.properties";

	public static ServicesFactory services = (ServicesFactory) 
			Helper.createFactory(CONFIG_FILE, "SERVICES_FACTORY");
	
	public static DataServicesFactory dataServices = (DataServicesFactory) 
			Helper.createFactory(CONFIG_FILE, "PERSISTENCE_FACTORY");

}
