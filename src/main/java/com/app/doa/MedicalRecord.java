/**
 * 
 */
package com.app.doa;

import java.util.Date;
import java.util.Map;

/**
 * @author nk17kumar
 *
 */
public class MedicalRecord {
	
	/**
	 * Stores date of medical check up
	 */
	private Date date;
	
	/**
	 * Stores the medical diagnostics
	 */
	private String Diagnostic;
	
	/**
	 * Maps the MedicalTest with their result
	 */
	private Map < String , String> medicalTestResult;
	
	
	/**
	 * @param date
	 * @param diagnostic
	 * @param medicalTestResult
	 */
	public MedicalRecord(Date date, String diagnostic, Map<String, String> medicalTestResult) {
		super();
		this.date = date;
		Diagnostic = diagnostic;
		this.medicalTestResult = medicalTestResult;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
		return medicines;
	
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the diagnostic
	 */
	public String getDiagnostic() {
		return Diagnostic;
	}
	/**
	 * @param diagnostic the diagnostic to set
	 */
	public void setDiagnostic(String diagnostic) {
		Diagnostic = diagnostic;
	}
	/**
	 * @return the medicalTestResult
	 */
	public Map<String, String> getMedicalTestResult() {
		return medicalTestResult;
	}
	/**
	 * @param medicalTestResult the medicalTestResult to set
	 */
	public void setMedicalTestResult(Map<String, String> medicalTestResult) {
		this.medicalTestResult = medicalTestResult;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Diagnostic == null) ? 0 : Diagnostic.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((medicalTestResult == null) ? 0 : medicalTestResult.hashCode());
		return result;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MedicalRecord [date=" + date + ", Diagnostic=" + Diagnostic + ", medicalTestResult=" + medicalTestResult
				+ "]";
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
		MedicalRecord other = (MedicalRecord) obj;
		if (Diagnostic == null) {
			if (other.Diagnostic != null)
				return false;
		} else if (!Diagnostic.equals(other.Diagnostic))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (medicalTestResult == null) {
			if (other.medicalTestResult != null)
				return false;
		} else if (!medicalTestResult.equals(other.medicalTestResult))
			return false;
		return true;
	}
	
	
	
}
