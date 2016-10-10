package com.jsf.hello.MBs;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Login {

	private String username;
	private String password;
	private String staffRole;

	//list of StaffRole
	List<String> staffRoleOptions;
	
	public Login(){
		//populate list of StaffRole
		staffRoleOptions = new ArrayList<>();
		
		staffRoleOptions.add("Admin");
		staffRoleOptions.add("Doctor");
		staffRoleOptions.add("Nurse");
		staffRoleOptions.add("Receptionist");
	}
	

	public String getStaffRole() {
		return staffRole;
	}


	public void setStaffRole(String staffRole) {
		this.staffRole = staffRole;
	}


	public List<String> getStaffRoleOptions() {
		return staffRoleOptions;
	}


	public void setStaffRoleOptions(List<String> staffRoleOptions) {
		this.staffRoleOptions = staffRoleOptions;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String LoginOK(){
		if(this.username.equals("admin") && this.password.equals("1234") && this.staffRole.equals("Admin")){
			return "welcomePage";
		}
		else {
			System.out.println("Wrong username or password!!!!");
		}
		return "hej";
	}
}
