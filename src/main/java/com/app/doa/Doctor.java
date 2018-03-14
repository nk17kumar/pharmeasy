/**
 * 
 */
package com.app.doa;

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


}
