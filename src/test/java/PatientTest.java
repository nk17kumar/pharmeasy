import junit.framework.TestCase;

import javax.management.InvalidAttributeValueException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.app.doa.*;
import com.app.util.Logger;

/**
 * @author nk17kumar
 *
 */
@RunWith(JUnit4.class)
public class PatientTest extends TestCase {
	
	private static Patient p;
	private static Doctor d;
	private static Pharmacist ph;
	private static Logger log;
	
	
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
	}
	
	
	@Test(expected = InvalidAttributeValueException.class)
	public void removeApprovedRequestsTest() throws InvalidAttributeValueException {
		createDataMembers();
		p.removeApprovedRequests(d);
	}
	
	@Test
	public void removeApprovedRequestsTestSuccess() throws InvalidAttributeValueException {
		createDataMembers();
		p.approveRequests(d);
		p.removeApprovedRequests(d);
		assert(true);
	}
	
	@Test
	public void isApprovedTestFailure() {
		createDataMembers();
		assertEquals(false, p.isApproved(d));
	}
	
	@Test
	public void isApprovedTestSuccess() {
		createDataMembers();
		p.approveRequests(d);
		assertEquals(true, p.isApproved(d));
	}
	
}