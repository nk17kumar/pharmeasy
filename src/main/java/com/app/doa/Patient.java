/**
 * 
 */
package com.app.doa;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.management.InvalidAttributeValueException;

import com.app.util.Logger;
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
        Logger.writeLog("creating new Patient user", false);
	}
	
	/**
	 * grants prescription viewing access to user with specific id
	 * @param requestId user's unique id
	 */
	public void approveRequests(User requestId) {
		if(this.approvedIds.contains(requestId.getId())) {
			Logger.writeLog("Request Already approved",true);
		}
		else {
			this.approvedIds.add(requestId.getId());
			Logger.writeLog("Patient " + this.getId() + " is approving request id " + requestId.getId(), false);
		}
	}
	
	/**
	 * removes the access of a particular user to access prescription
	 * @param usr user id of the user whose access is to be removed
	 * @throws InvalidAttributeValueException if the specified user has no access already
	 */
	public void removeApprovedRequests(User usr) throws InvalidAttributeValueException {
		if(this.approvedIds.contains(usr.getId())) {
			this.approvedIds.remove(usr.getId());
			Logger.writeLog("removing approval grant for " + usr.getId(), false);
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
		Logger.writeLog("new medical history added by " + this.getId(), false);
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
	public boolean isApproved(User requestId) {
		if(this.approvedIds.contains(requestId.getId()))
			return true;
		else
			return false;
	}
	
	/**
	 * @return Prescription id along with its respective date so that user may
	 * request to view any selective prescription according to date of prescription 
	 */
	public Map <String,Date> displayPrescriptionIds() {
		Map <String,Date> ret = new HashMap <String,Date>();
		for(Map.Entry<String,Prescription> entry : this.prescriptionHistory.entrySet()) {
			ret.put(entry.getKey(), entry.getValue().getPresDate());
		}
		return ret;
	}
	
}
