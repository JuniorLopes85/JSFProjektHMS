package com.jsf.hello.EJBs;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.jsf.hello.MBs.HospitalStaffMB;
import com.jsf.hello.MBs.Patient;
@ManagedBean(name = "patBean")

public class PatientEJB {

	List<Patient> list;
	Connection con = null;
	PreparedStatement stat = null;
	ResultSet rs = null;
	
	
	
	public List<Patient> getPatList()
	{
		list = new ArrayList<>();

		
		try{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmsdb?autoReconnect=true&useSSL=false", "root", "Sommar15");
			String myStat = "SELECT * FROM patient";
			stat = con.prepareStatement(myStat);
			rs = stat.executeQuery();
			while(rs.next()){
				
				Patient usr = new Patient();
				usr.setSsn(rs.getInt("ssn"));
				usr.setFirstName(rs.getString("firstName"));
				usr.setLastName(rs.getString("lastName"));
				usr.setUserName(rs.getString("userName"));
				usr.setPassword(rs.getString("password"));
				usr.setDoctorId(rs.getInt("doctorId"));
				usr.setNurseId(rs.getInt("nurseId"));
				//usr.setTestId(rs.getInt("testId"));		
				//usr.setRoomId(rs.getInt("roomId"));
				//usr.setReceptionistId(rs.getInt("receptionistId"));
				//usr.setJournalId(rs.getInt("journalId"));

				list.add(usr);
			}
			con.close();
			stat.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	public void add(Patient patient) {

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmsdb?autoReconnect=true&useSSL=false",
					"root", "Sommar15");
			String myStat = "INSERT INTO patient(ssn,firstName,lastName,username,password, doctorId, nurseId) VALUES(?,?,?,?,?,?,?)";
			stat = con.prepareStatement(myStat);

			stat.setInt(1, patient.getSsn());
			stat.setString(2, patient.getFirstName());
			stat.setString(3, patient.getLastName());
			stat.setString(4, patient.getUserName());
			stat.setString(5, patient.getPassword());
			stat.setInt(6, patient.getDoctorId());
			stat.setInt(7, patient.getNurseId());
			//stat.setInt(8, patient.getTestId());
			//stat.setInt(9, patient.getRoomId());
			//stat.setInt(8, patient.getReceptionistId());
			//stat.setInt(11, patient.getJournalId());
			stat.executeUpdate();

			System.out.println("Info added successfully");

			con.close();
			stat.close();
		} catch (Exception e) {
			System.out.println(" SQLException :(");
			e.printStackTrace();
		}
	}
	public void delete(int ssn) {
		
		if (ssn !=0){
	    try {
	    	//Class.forName("com.mysql.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmsdb?autoReconnect=true&useSSL=false", "root", "Sommar15");
	        String myStat ="delete FROM patient WHERE ssn=" + ssn;
	        stat = con.prepareStatement(myStat); 
	        int i = stat.executeUpdate();
	        if (i >0){

	        System.out.println("user deleted successfully");
	        }
	        con.close();
			stat.close();


	    } catch (Exception e) {
	        System.out.println(" SQLException :(");
	        e.printStackTrace();
	    }

	    }}
	public void update(Patient patient) {
		
	    try {
	    	//Class.forName("com.mysql.jdbc.Driver");
	    	System.out.println("in HospitalStaffEJB.update .. in try");
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmsdb?autoReconnect=true&useSSL=false", "root", "Sommar15");
	        String myStat ="UPDATE patient SET firstName = ?, lastName= ?, userName= ?, password= ?, doctorId =?, nurseId=? WHERE ssn = ?";
	        stat = con.prepareStatement(myStat);
	        System.out.println("in PatientEJB.update .. in patient.getFirstName() = "+patient.getFirstName());
	        stat.setString(1, patient.getFirstName());
	        stat.setString(2, patient.getLastName());
	        stat.setString(3, patient.getUserName());
	        stat.setString(4, patient.getPassword());
	        stat.setInt(5, patient.getDoctorId());
	        stat.setInt(6, patient.getNurseId());
	        stat.setInt(7, patient.getSsn());
	        System.out.println("in PatientEJB.update .. stat.toString(); = "+stat.toString());
	        stat.executeUpdate();
	        
	        con.close();
			stat.close();


	    } catch (Exception e) {
	        System.out.println(" SQLException :(");
	        e.printStackTrace();
	    }

	    }
	public void updateJournal(Patient journal) {
		
	    try {
	    	//Class.forName("com.mysql.jdbc.Driver");
	    	System.out.println("in PatientEJB.update .. in try");
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmsdb?autoReconnect=true&useSSL=false", "root", "Sommar15");
	        String myStat ="UPDATE journal SET notes= ? WHERE patient_ssn = ?";
	        stat = con.prepareStatement(myStat);
	        System.out.println("in PatientEJB.update .. in patient.getFirstName() = "+journal.getSsn());
	        //stat.setInt(1, journal.getJournalId());
	        stat.setString(1, journal.getNotes());
	        //stat.setInt(3, journal.getDoctorId());
	        //stat.setInt(4, journal.getNurseId());
	        stat.setInt(2, journal.getSsn());
	        System.out.println("in PatientEJB.update .. stat.toString(); = "+stat.toString());
	        stat.executeUpdate();
	        
	        con.close();
			stat.close();


	    } catch (Exception e) {
	        System.out.println(" SQLException :(");
	        e.printStackTrace();
	    }

	    }
	public List<Patient> searchPat(String search)
	{
		list = new ArrayList<>();

		
		try{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hmsdb?autoReconnect=true&useSSL=false", "root", "Sommar15");
			String myStat = "SELECT patient.ssn, notes FROM patient INNER JOIN journal ON journal.patient_ssn = patient.ssn WHERE patient.ssn LIKE '%"+search+"%'";
			stat = con.prepareStatement(myStat);
			rs = stat.executeQuery();
			while(rs.next()){
				
				Patient usr = new Patient();
				usr.setSsn(rs.getInt("ssn"));
				//usr.setJournalId(rs.getInt("journalId"));
				/*usr.setFirstName(rs.getString("firstName"));
				usr.setLastName(rs.getString("lastName"));
				usr.setUserName(rs.getString("userName"));
				usr.setPassword(rs.getString("password"));

				usr.setDoctorId(rs.getInt("doctorId"));
				usr.setNurseId(rs.getInt("nurseId"));
				usr.setTestId(rs.getInt("testId"));		
				usr.setRoomId(rs.getInt("roomId"));
				usr.setReceptionistId(rs.getInt("receptionistId"));*/
				usr.setNotes(rs.getString("notes"));
				list.add(usr);
			}
			con.close();
			stat.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;
	
		
	}


	
	
}