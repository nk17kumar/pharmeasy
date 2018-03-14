/**
 * 
 */
package com.app.doa;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nk17kumar
 *
 */
public class Pharmacist extends User  {

	/**
	 * Stores specialization of the pharmacist
	 */
	private String speclization; 
	
	/**
	 * Maps the medicines in the pharmacy stores with its quantity
	 */
	private Map <String,Integer> medicineStore;
	
	/**
	 * @return the medicineStore
	 */
	public Map<String, Integer> getMedicineStore() {
		return medicineStore;
	}

	/**
	 * @param medicineStore the medicineStore to set
	 */
	public void setMedicineStore(Map<String, Integer> medicineStore) {
		this.medicineStore = medicineStore;
	}
	
	/**
	 * Parameterized constructor
	 * @param info stores the personal details of the pharmacist
	 * @param spec denotes the specialization of the  pharmacist
	 */
	public Pharmacist(PersonalDetails info,String spec) {
		super(Entity.PHARMACIST,info);
		this.setSpeclization(spec);
		this.setMedicineStore(new HashMap <String,Integer>());
	}

	/**
	 * @return the speclization
	 */
	public String getSpeclization() {
		return speclization;
	}

	/**
	 * @param speclization the speclization to set
	 */
	public void setSpeclization(String speclization) {
		this.speclization = speclization;
	}
	
	/**
	 * updates the medicine store
	 * @param medicineName name of the medicine 
	 * @param quantity extra amount in units to be added
	 */
	public void addMedicineStock(String medicineName,int quantity) {
		if(this.medicineStore.containsKey(medicineName)) {
			this.getMedicineStore().replace(medicineName, this.getMedicineStore().get(medicineName) + quantity);
		}
		else {
			this.getMedicineStore().put(medicineName, quantity);
		}
	}
	


}
