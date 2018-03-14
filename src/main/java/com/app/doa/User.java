/**
 * 
 */
package com.app.doa;

import javax.management.InvalidAttributeValueException;

import com.app.util.Logger;
import com.app.util.Utilility;

/**
 * <H1>User</H1> 
 * <p>User is an abstract base class which is inherited by other
 * specific data objects like Patient, Doctor and Pharmacist</p>
 * @author nk17kumar
 */
public abstract class User {
	
	/**
	 * Holds personal details of an user
	 */
	private PersonalDetails info;
	
	/**
	 * Stores unique string identity for an user
	 */
	private String id;
	
	/**
	 * Stores the ENUM type for the user
	 */
	private Entity type;

	/**
	 * Parameterized Constructor
	 * @param id2 unique id for the user
	 * @param type2 enum type of the user
	 * @param info personal detail object of the user
	 */
	public User(Entity type2,PersonalDetails info) {
		this.setType(type2);
		this.setId(getUniqueId());
		this.setInfo(info);
	}
	
	/**
	 * @param patient user whose prescription is requested to be accessible
	 * @return most recent prescription of the requested user
	 * @throws InvalidAttributeValueException if no permission is given by the PATIENT to access prescription
	 * @throws UnsupportedOperationException if enum type PATIENT requests for prescription of other PATIENT
	 */
	public Prescription getPreviousPrescription(User patient) 
			throws InvalidAttributeValueException,UnsupportedOperationException {
		if(this.getType() == Entity.PATIENT) {
			throw new UnsupportedOperationException("Patient cannot request another patient to view his prescription");
		}
		if(patient.getType() != Entity.PATIENT) {
			throw new InvalidAttributeValueException();
		}
		
		Patient tmp = (Patient)patient;
		
		if(tmp.isApproved(this.getId())) {
			Logger.writeLog(this.getType() + this.getInfo().getName() + " is accessing prescription",false);
			return tmp.showRecentPrescription();
		}
		else {
			throw new InvalidAttributeValueException();
		}
		
	}

	/**
	 * @param patient user whose prescription is requested to be accessible
	 * @param prescriptionId unique id of the  prescription to be accessed
	 * @return specified prescription  of the PATIENT
	 * @throws InvalidAttributeValueException if no permission is given by the PATIENT to access prescription
	 * or given prescription id donot exists
	 * @throws UnsupportedOperationException if enum type PATIENT requests for prescription of other PATIENT
	 */
	public Prescription getPrescription(User patient, String prescriptionId)
			throws InvalidAttributeValueException {
		if(this.getType() == Entity.PATIENT) {
			throw new UnsupportedOperationException("Patient cannot request another patient to view his prescription");
		}
		if(patient.getType() != Entity.PATIENT) {
			throw new InvalidAttributeValueException();
		}
		
		Patient tmp = (Patient)patient;
		
		if(tmp.isApproved(this.getId())) {
			Logger.writeLog(this.getType() + this.getInfo().getName() + " is accessing prescription",false);
			return tmp.showPrescription(prescriptionId);
		}
		else {
			throw new InvalidAttributeValueException();
		}
	}
	
	/**
	 * 
	 * @param info2 Personal Detail object 
	 */
	private void setInfo(PersonalDetails info2) {
		this.info = info2;
	}
	
	/**
	 * @return the info
	 */
	public PersonalDetails getInfo() {
		return this.info;
	}
	/**
	 * @return the unique id for a user
	 */
	public String getUniqueId() {
		return Utilility.getNextSequenceId(this.type);
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the entity type
	 */
	public Entity getType() {
		return type;
	}

	/**
	 * @param type the enum type to set
	 */
	public void setType(Entity type) {
		this.type = type;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [info=");
		builder.append(info);
		builder.append(", id=");
		builder.append(id);
		builder.append(", type=");
		builder.append(type);
		builder.append("]");
		return builder.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((info == null) ? 0 : info.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (info == null) {
			if (other.info != null)
				return false;
		} else if (!info.equals(other.info))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
	
}
