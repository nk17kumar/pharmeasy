package com.app.util;

import java.util.HashMap;
import java.util.Map;

import com.app.doa.Entity;

/**
 * <h1>Utility</h1>
 * <p>Various calculation and computational functionalities are provided
 * in the utility class</p>
 * @author nk17kumar
 */
public class Utilility {
	
	/**
	 * Maps the maximum id assigned to each type of Entity
	 */
    private static Map <Entity,Integer> index = new HashMap<>();
    
    /**
     * Generates the unique id for each entity type
     * @param type denotes the enum value of the entity
     * @return String unique id for the specified entity type
     */
	public static String getNextSequenceId(Entity type) {
		int id = 0;
		if(index.containsKey(type)) {
			id = index.get(type);
			index.replace(type, id, id+1);
			id++;
		}
		else {
			index.put(type, 0);
		}
		Logger.writeLog("Generating unique id for " + type.toString() + ": " + type.toString() + id,false);
		return type.toString() + id;
 	}

}
