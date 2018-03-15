/**
 * 
 */
package com.app.doa;

import com.app.util.Logger;

/**
 * @author nk17kumar
 *
 */
public class Doctor extends User  {

	/**
	 * stores specilization of the doctor
	 */
	private String specialization;
	
	/**
	 * parameterized constructor
	 * @param info denotes the personal details object
	 * @param spec specialization of the doctor
	 */
	public Doctor(PersonalDetails info,String spec) {
		super(Entity.DOCTOR,info);
		this.setSpecialization(spec);
		Logger.writeLog("creating new Doctor user", false);
	}

	/**
	 * @return the specialization
	 */
	public String getSpecialization() {
		return specialization;
	}

	/**
	 * @param specialization the specialization to set
	 */
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Doctor [specialization=");
		builder.append(specialization);
		builder.append("]");
		return builder.toString();
	}
	
	/**
	 * creates prescription and adds to patient  history
	 * @param p1 patient recieving the prescription
	 */
	public void givePrescription(Patient p1,Prescription p) {
		p1.addPrescriptionHistory(p);
		Logger.writeLog("Doctor "+ this.getId() + " is giving prescription to " + p1.getId(), false);
	}

	@Override
	public boolean equals(Object other) {
		User cur = (User)this;
		User cmp = (User)other;
		return cur.equals(other);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode(java.lang.Object)
	 */
	@Override
	public int hashCode() {
		User tmp = this;
		return tmp.hashCode();
	}
}
