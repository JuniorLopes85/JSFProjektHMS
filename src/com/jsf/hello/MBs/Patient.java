package com.jsf.hello.MBs;

import java.sql.Timestamp;
import java.util.List;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import com.jsf.hello.EJBs.PatientEJB;

@ManagedBean(name = "patient")
@SessionScoped
public class Patient {

	PatientEJB patientEjb = new PatientEJB();

	private long ssn;
	private String firstName;
	private String lastName;
	private String password;
	private Timestamp checkIn;
	private String remissNotes;
	private String tests;
	private String medicine;
	private String testResult;
	private String search;
	private String PatNurseDuties;
	private int rooms_roomId; 

	private String notes;
	private int bill;
	private int doctorId;
	private int nurseId;
	private Integer id; 
	
	

	public void process() {
		
	}
	
	
	public List<Patient> getContent() {
		 return patientEjb.getDoctorList();
	}


	public void setContent(List<Patient> content) {
	}

	public void patientById(long ssn, String firstName, String lastName, String password, int doctorId,
			int nurseId) {
		this.ssn = ssn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.doctorId = doctorId;
		this.nurseId = nurseId;
	}
	
	public void PatientRemissById(long ssn, String firstName, String lastName, int doctorId, int nurseId){
		this.ssn = ssn; 
		this.firstName = firstName; 
		this.lastName = lastName; 
		this.doctorId = doctorId; 
		this.nurseId = nurseId;
	}
	
	public void journalById(long ssn, String notes, String tests, String medicine, String PatNurseDuties ) {
		this.ssn = ssn;
		this.tests = tests;
		this.notes = notes;
		this.medicine = medicine;
		this.PatNurseDuties = PatNurseDuties;
	}
	
	public void billById(long ssn, int bill){
		this.ssn = ssn;
		this.bill = bill;
	}
	public void medicineById(long ssn, String medicine){
		this.ssn = ssn;
		this.medicine = medicine;
	}
	public void testResultById(long ssn, String tests, String testResult){
		this.ssn = ssn;
		this.tests = tests;
		this.testResult = testResult;
	}
	public Timestamp getCheckIn() {
		return checkIn;
	}

	public String getPatNurseDuties() {
		return PatNurseDuties;
	}


	public void setPatNurseDuties(String patNurseDuties) {
		PatNurseDuties = patNurseDuties;
	}


	public String getRemissNotes() {
		return remissNotes;
	}

	public void setRemissNotes(String remissNotes) {
		this.remissNotes = remissNotes;
	}

	public void setCheckIn(Timestamp checkIn) {
		this.checkIn = checkIn;
	}

	public int getRooms_roomId() {
		return rooms_roomId;
	}

	public void setRooms_roomId(int rooms_roomId) {
		this.rooms_roomId = rooms_roomId;
	}
	public String getTestResult() {
		return testResult;
	}

	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}

	public int getBill() {
		return bill;
	}

	public void setBill(int bill) {
		this.bill = bill;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public String getTests() {
		return tests;
	}

	public void setTests(String tests) {
		this.tests = tests;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getNurseId() {
		return nurseId;
	}

	public void setNurseId(int nurseId) {
		this.nurseId = nurseId;
	}

	public long getSsn() {
		return ssn;
	}

	public void setSsn(long ssn) {
		this.ssn = ssn;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Patient> searchPat() {
		return patientEjb.searchPat(search);
	}

	public List<Patient> getPatList() {
		return patientEjb.getPatList();
	}
	
	public List<Patient> getDoctorList(){
		return patientEjb.getDoctorList();
	}
	public void add() {
		patientEjb.add(this);
		clear();
	}

	public void delete(long ssn) {
		patientEjb.delete(ssn);
	}
	public List<Patient> searchPatient(){
		return patientEjb.searchPatient(search);
	}
	public List<Patient> searchPatientRemiss(){
		return patientEjb.searchPatientRemiss(search);
	}
	public void updatePatientRemiss(){
		patientEjb.updatePatientRemiss(this);
	}
	public void updatePatient() {
		patientEjb.update(this);
	}

	public void updateJournal() {
		patientEjb.updateJournal(this);
	}
	public void payBill(){
		patientEjb.payBill(this);
	}
	public void updateTestResult(){
		patientEjb.updateTestResult(this);
	}
	public void clear(){
		setSsn(0);
		setFirstName(null);
		setLastName(null);
		setPassword(null);
		setDoctorId(0);
		setNurseId(0);
	}





	@Override
    public boolean equals(Object other) {
        return (other instanceof Patient) && (id != null)
            ? id.equals(((Patient) other).id)
            : (other == this);
    }

    @Override
    public int hashCode() {
        return (id != null)
            ? (this.getClass().hashCode() + id.hashCode())
            : super.hashCode();
    }

    @Override
    public String toString() {
        return String.format("Patient: " + ssn + " Treatment:  " + PatNurseDuties);
    }

	
   




}
