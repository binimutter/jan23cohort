package com.codingdojo.com.caresoft;

import java.util.Date;
import java.util.ArrayList;

public class Physician extends User implements HIPAACompliantUser{
    
    // Inside class:    
    private ArrayList<String> patientNotes;
	
    // TO DO: Constructor that takes an ID
    
    public Physician(Integer id) {
    	super(id);
    }
    
    //==========
    // METHODS
    //==========
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
	
	//==========
	// GETTERS & SETTERS
	//==========
    
    public ArrayList<String> getPatientNotes() {
    	return patientNotes;
    }
    
    public void setPatientNotes(ArrayList<String> patientNotes) {
    	this.patientNotes = patientNotes;
    }
	
    // TO DO: Implement HIPAACompliantUser!

	@Override
	public boolean assignPin(int pin) {
		// TODO Auto-generated method stub
		int pinLength = String.valueOf(pin).length();
		
		if (pinLength != 4) {
			return false;
		} else {
			return true;
		}
	}
	

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(confirmedAuthID == this.id) {
			return true;
		} else {
			return false;
		}
	}
}
