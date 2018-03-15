/**
 * 
 */
package com.app.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.management.InvalidAttributeValueException;

import com.app.doa.Doctor;
import com.app.doa.Patient;
import com.app.doa.PersonalDetails;
import com.app.doa.Pharmacist;
import com.app.doa.Prescription;
import com.app.util.Logger;

/**
 * <h1>Driver</h1>
 * <p>This is a demo class that displays the use of the functionalities 
 * provided by the pharmeasy application.</p>
 * @author nk17kumar
 */
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		Logger log = new Logger();
		
		// creating patient object
		PersonalDetails info1 = new PersonalDetails("Nitish",22,"male","B+","xyz@abc.com","1234","abc area");
		Patient p1 = new Patient(info1);
		
		// creating doctor object
		PersonalDetails info2 = new PersonalDetails("Rohan",23,"male","B+","xyz@abc.com","1234","abc area");
		Doctor d1 = new Doctor(info2,"physiotherapist");
		
		// creating pharmacist object
		
		PersonalDetails info3 = new PersonalDetails("Mohan",22,"male","B+","xyz@abc.com","1234","abc area");
	    Pharmacist ph1 = new Pharmacist(info3,"ayurvedic medicines");
	    
	    // doctor gives first prescription to patient
	    
	    Date date1 = new Date(System.currentTimeMillis());
		List < String > medi1 = new ArrayList <String>();
		medi1.add("Combiflame");
		medi1.add("amlopinAT");
		String inst1 = "1 tab morning and evening";
		String extraInst1 = "bed rest";
		Prescription pres1 = new Prescription(date1,medi1,inst1,extraInst1);
	    d1.givePrescription(p1,pres1);
	    
	    // doctor gives second prescription to patient
	    
	    Date date2 = new Date(System.currentTimeMillis());
		List < String > medi2 = new ArrayList <String>();
		medi2.add("Crocin");
		medi2.add("strepsils");
		String inst2 = "1 tab morning and evening";
		String extraInst2 = "bed rest";
		Prescription pres2 = new Prescription(date2,medi2,inst2,extraInst2);
	    d1.givePrescription(p1,pres2);
	    
	    
	    // pharmacist tries to view patient's prescription without his approval
	    
	    try {
			ph1.getPreviousPrescription(p1);
		} catch (InvalidAttributeValueException e) {
			Logger.writeLog("Pharmacist " + ph1.getId() + " is trying to acccess prescription without approval", true);
			
		} catch (UnsupportedOperationException e) {
			Logger.writeLog("Patient is accessing paitient's prescription", true);
		}
	    
	    // patient gives approval to the pharmacist
	    p1.approveRequests(ph1);
	    
	    // pharmacist tries to view patient's prescription with his approval
	    
	    try {
			System.out.println(ph1.getPreviousPrescription(p1));
		} catch (InvalidAttributeValueException e) {
			Logger.writeLog("Pharmacist " + ph1.getId() + " is trying to acccess prescription without approval", true);
		} catch (UnsupportedOperationException e) {
			Logger.writeLog("Patient is accessing paitient's prescription", true);
		}
		
        // doctor tries to view patient's prescription without his approval
	    
	    try {
			d1.getPreviousPrescription(p1);
		} catch (InvalidAttributeValueException e) {
			Logger.writeLog("Doctor " + d1.getId() + " is trying to acccess prescription without approval", true);
			
		} catch (UnsupportedOperationException e) {
			Logger.writeLog("Patient is accessing paitient's prescription", true);
		}
	    
	    // patient gives approval to the doctor
	    p1.approveRequests(d1);
	    
	    // doctor tries to view patient's prescription with his approval
	    
	    try {
			System.out.println(d1.getPreviousPrescription(p1));
		} catch (InvalidAttributeValueException e) {
			Logger.writeLog("Doctor " + d1.getId() + " is trying to acccess prescription without approval", true);
		} catch (UnsupportedOperationException e) {
			Logger.writeLog("Patient is accessing paitient's prescription", true);
		}
	    
	    
	    // removing approval for pharmacist 
	    try {
			p1.removeApprovedRequests(ph1);
		} catch (InvalidAttributeValueException e) {
			Logger.writeLog("Pharmacist  not previously approved", true);
		}
	    
	    // removing approval for doctor
	    try {
			p1.removeApprovedRequests(d1);
		} catch (InvalidAttributeValueException e) {
			Logger.writeLog("Doctor not previously approved", true);
		}
	}

}
