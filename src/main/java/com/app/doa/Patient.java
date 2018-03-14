/**
 * 
 */
package com.app.doa;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.management.InvalidAttributeValueException;

import com.app.util.Utilility;

/**
 * 
 * @author nk17kumar
 */
public class Patient extends User {
	
	/**
	 * Stores the id's of the user whose prescription accessing
	 * request is accepted 
	 */
	private Set <String> approvedIds;
	
	/**
	 * Maps the medical history of the user with a unique medical id
	 */
	private Map <String,MedicalRecord> medicalHistory;
	
	/**
	 * Maps the prescription  of the user with a unique prescription id
	 */
	private Map <String,Prescription> prescriptionHistory;
	
	/**
	 * Stores the prescription id of the most recent prescription
	 * for fast access
	 */
	private String recentPrescription;

	/**
	 * @param info
	 */
	public Patient(PersonalDetails info) {
		super(Entity.PATIENT,info);
        this.medicalHistory = new HashMap <String,MedicalRecord>();
        this.prescriptionHistory = new HashMap <String,Prescription>();
        this.approvedIds = new HashSet <String>();
	}
	
	/**
	 * grants prescription viewing access to user with specific id
	 * @param requestId user's unique id
	 */
	public void approveRequests(String requestId) {
		if(this.approvedIds.contains(requestId)) {
			System.err.println("Request Already approved");
		}
		else {
			this.approvedIds.add(requestId);
		}
	}
	
	/**
	 * removes the access of a particular user to access prescription
	 * @param requestId user id of the user whose access is to be removed
	 * @throws InvalidAttributeValueException if the specified user has no access already
	 */
	public void removeApprovedRequests(String requestId) throws InvalidAttributeValueException {
		if(this.approvedIds.contains(requestId)) {
			this.approvedIds.remove(requestId);
		}
		else {
			throw new InvalidAttributeValueException();
		}
	}
	
	/**
	 * Adds the specified current medical record to the Patient's history
	 * @param rec medical record object to be added in the medical history
	 */
	public void addMedicalHistory(MedicalRecord rec) {
		String nextId = Utilility.getNextSequenceId(Entity.RECORD);
		this.medicalHistory.put(nextId, rec);
	}
	
	/**
	 * Adds the specified current medical prescription to the Patient's history
	 * @param prec prescription record object to be added in the prescription history
	 */
	public void addPrescriptionHistory(Prescription prec) {
		String nextId = Utilility.getNextSequenceId(Entity.PRESCCRIPTION);
		this.prescriptionHistory.put(nextId, prec);
		this.recentPrescription = nextId;
	}
	
	/**
	 * @param prescriptionId unique prescription id to be viewed
	 * @return specified prescription of the user
	 * @throws NullPointerException if no such prescription id exist
	 */
	public Prescription showPrescription(String prescriptionId) throws NullPointerException {
			return this.prescriptionHistory.get(prescriptionId);
	}
	
	/**
	 * Returns the most recent prescription of the patient
	 * @return most recent prescription of the patient
	 * @throws NullPointerException if there is no prescription of the patient
	 */
	public Prescription showRecentPrescription() throws NullPointerException {
		if(this.recentPrescription == null) {
			throw new NullPointerException();
		}
		else {
			return this.prescriptionHistory.get(this.recentPrescription);
		}
	}
	
	/**
	 * Validates whether the specified user is approved to access prescription
	 * @param requestId unique id of the user 
	 * @return true or false if the request id is approved or false vice-versa
	 */
	public boolean isApproved(String requestId) {
		if(this.approvedIds.contains(requestId))
			return true;
		else
			return false;
	}
	
}
