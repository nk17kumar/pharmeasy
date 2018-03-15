/**
 * 
 */
package com.app.doa;

import java.util.Date;
import java.util.List;

import com.app.util.Logger;

/**
 * @author nk17kumar
 *
 */
public class Prescription {
	
	/**
	 * Stores the prescription date
	 */
	private Date presDate;
	/**
	 * Stores the list of medicines in the current prescription
	 */
	private List <String> medicines;   
	/**
	 * Paramaterized constructor
	 * @param presDate prescription issuing date
	 * @param medicines list of medicines prescribed
	 * @param instructions instructions regarding medicines 
	 * @param extraInstructions additional instructions
	 */
	public Prescription(Date presDate, List<String> medicines, String instructions, String extraInstructions) {
		super();
		this.presDate = presDate;
		this.medicines = medicines;
		this.instructions = instructions;
		this.extraInstructions = extraInstructions;
		Logger.writeLog("creating new Prescription", false);
	}
	/**
	 * Stores instruction regarding the medicines
	 */
	private String  instructions;
	/**
	 * Stores some additional instructions of the doctor
	 */
	private String extraInstructions;
	/**
	 * @return the presDate
	 */
	public Date getPresDate() {
		return presDate;
	}
	/**
	 * @param presDate the presDate to set
	 */
	public void setPresDate(Date presDate) {
		this.presDate = presDate;
	}
	/**
	 * @return the medicines
	 */
	public List<String> getMedicines() {
		return medicines;
	}
	/**
	 * @param medicines the medicines to set
	 */
	public void setMedicines(List<String> medicines) {
		this.medicines = medicines;
	}
	
	/**
	 * @return the instructions
	 */
	public String getInstructions() {
		return instructions;
	}
	/**
	 * @param instructions the instructions to set
	 */
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	/**
	 * @return the extraInstructions
	 */
	public String getExtraInstructions() {
		return extraInstructions;
	}
	/**
	 * @param extraInstructions the extraInstructions to set
	 */
	public void setExtraInstructions(String extraInstructions) {
		this.extraInstructions = extraInstructions;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((extraInstructions == null) ? 0 : extraInstructions.hashCode());
		result = prime * result + ((instructions == null) ? 0 : instructions.hashCode());
		result = prime * result + ((medicines == null) ? 0 : medicines.hashCode());
		result = prime * result + ((presDate == null) ? 0 : presDate.hashCode());
		return result;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prescription other = (Prescription) obj;
		if (extraInstructions == null) {
			if (other.extraInstructions != null)
				return false;
		} else if (!extraInstructions.equals(other.extraInstructions))
			return false;
		if (instructions == null) {
			if (other.instructions != null)
				return false;
		} else if (!instructions.equals(other.instructions))
			return false;
		if (medicines == null) {
			if (other.medicines != null)
				return false;
		} else if (!medicines.equals(other.medicines))
			return false;
		if (presDate == null) {
			if (other.presDate != null)
				return false;
		} else if (!presDate.equals(other.presDate))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Prescription [presDate=" + presDate + ", medicines=" + medicines + ", instructions=" + instructions
				+ ", extraInstructions=" + extraInstructions + "]";
	}
	
	
	
}
