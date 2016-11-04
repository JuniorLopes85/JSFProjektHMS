package com.jsf.hello.MBs;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import com.jsf.hello.EJBs.WaitingEJB;

@ManagedBean(name="waiting")
@SessionScoped
public class WaitingMB {
	
	WaitingEJB waitingEjb = new WaitingEJB();
	private int waitingId;
	private int receptionstId;
	private int patient_ssn;
	private int rooms_roomId;

	
	



	public int getWaitingId() {
		return waitingId;
	}
	public void setWaitingId(int waitingId) {
		this.waitingId = waitingId;
	}
	public int getReceptionstId() {
		return receptionstId;
	}
	public void setReceptionstId(int receptionstId) {
		this.receptionstId = receptionstId;
	}
	public int getPatient_ssn() {
		return patient_ssn;
	}
	public void setPatient_ssn(int patient_ssn) {
		this.patient_ssn = patient_ssn;
	}
	public int getRooms_roomId() {
		return rooms_roomId;
	}
	public void setRooms_roomId(int rooms_roomId) {
		this.rooms_roomId = rooms_roomId;
	} 
	public List<WaitingMB> getWaitList(){
		return waitingEjb.getWaitList();
	}
	public List<WaitingMB> getPatientSsnList(){
		return waitingEjb.getPatientSsnList();
	}
	
}