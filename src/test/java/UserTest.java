import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.management.InvalidAttributeValueException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.app.doa.*;
import com.app.util.Logger;

@RunWith(JUnit4.class)
public class UserTest {

	private static Patient p;
	private static Doctor d;
	private static Pharmacist ph;
	private static Logger log;
	private static Prescription pr;
	
	public void createDataMembers() {
		
		log = new Logger();
		// creating patient object
		PersonalDetails info1 = new PersonalDetails("Nitish",22,"male","B+","xyz@abc.com","1234","abc area");
		p = new Patient(info1);
				
		// creating doctor object
		PersonalDetails info2 = new PersonalDetails("Rohan",23,"male","B+","xyz@abc.com","1234","abc area");
		d = new Doctor(info2,"physiotherapist");
				
		// creating pharmacist object
				
		PersonalDetails info3 = new PersonalDetails("Mohan",22,"male","B+","xyz@abc.com","1234","abc area");
	    ph= new Pharmacist(info3,"ayurvedic medicines");
	    
	    Date date1 = new Date(System.currentTimeMillis());
		List < String > medi1 = new ArrayList <String>();
		medi1.add("Combiflame");
		medi1.add("amlopinAT");
		String inst1 = "1 tab morning and evening";
		String extraInst1 = "bed rest";
		pr = new Prescription(date1,medi1,inst1,extraInst1);
	   
	}
	
	@Test(expected = NullPointerException.class)
	public void getPreviousPrescriptionTestNoPrescriptionFailure() throws InvalidAttributeValueException, UnsupportedOperationException {
		createDataMembers();
		p.approveRequests(ph);
		ph.getPreviousPrescription(p);
		
	}
	
	@Test(expected = InvalidAttributeValueException.class)
	public void getPreviousPrescriptionTestAccessFailure() throws InvalidAttributeValueException, UnsupportedOperationException {
		createDataMembers();
		ph.getPreviousPrescription(p);
	}
	
	@Test(expected = UnsupportedOperationException.class)
	public void getPreviousPrescriptionTestUnsupportedAccessFailure() throws InvalidAttributeValueException, UnsupportedOperationException {
		createDataMembers();
		Patient p1 = p;
		p.getPreviousPrescription(p1);
	}
	
	@Test
	public void getPreviousPrescriptionDoctorSuccess() throws InvalidAttributeValueException, UnsupportedOperationException {
		createDataMembers();
		d.givePrescription(p, pr);
		p.approveRequests(ph);
		Prescription tmp = ph.getPreviousPrescription(p);
		assertEquals(tmp,pr);
	}
	
	@Test
	public void getPreviousPrescriptionPharmacistSuccess() throws InvalidAttributeValueException, UnsupportedOperationException {
		createDataMembers();
		d.givePrescription(p, pr);
		p.approveRequests(d);
		Prescription tmp = d.getPreviousPrescription(p);
		assertEquals(tmp,pr);
	}
	
	@Test
	public void getPreviousPrescriptionMatch() throws InvalidAttributeValueException, UnsupportedOperationException {
		createDataMembers();
		d.givePrescription(p, pr);
		p.approveRequests(ph);
		p.approveRequests(d);
		Prescription tmp1 = ph.getPreviousPrescription(p);
		Prescription tmp2 = ph.getPreviousPrescription(p);
		assertEquals(tmp1,tmp2);
	}
	
	
	
	
}
