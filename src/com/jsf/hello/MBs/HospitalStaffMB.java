package com.jsf.hello.MBs;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import com.jsf.hello.EJBs.HospitalStaffEJB;;
 
@ManagedBean(name = "staff")
@RequestScoped
public class HospitalStaffMB {
	//private static final long serialVersionUID = 1L;
	HospitalStaffEJB hospitalStaffEjb = new HospitalStaffEJB();
	
	private int employeeId;
	private String jobTitle;
	private String firstName;
	private String lastName;
	private int departmentId;
	private String userName;
	private String password;
	private String search;
	
	//list of StaffRole
	List<String> staffRoleOptions;
		
	//list of DepartmentId
	List<Integer> deptId;
	
	public HospitalStaffMB(){
		//populate list of StaffRole
				staffRoleOptions = new ArrayList<>();
				
				staffRoleOptions.add("Admin");
				staffRoleOptions.add("Doctor");
				staffRoleOptions.add("Nurse");
				staffRoleOptions.add("Receptionist");
				
				//populate list of StaffRole
				deptId = new ArrayList<Integer>();
				
				deptId.add(10);
				deptId.add(11);
				deptId.add(12);
				deptId.add(13);
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
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
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> getStaffRoleOptions() {
		return staffRoleOptions;
	}

	public void setStaffRoleOptions(List<String> staffRoleOptions) {
		this.staffRoleOptions = staffRoleOptions;
	}
	public List<Integer> getDeptId() {
		return deptId;
	}

	public void setDeptId(List<Integer> deptId) {
		this.deptId = deptId;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	public List<HospitalStaffMB> getUserList(){
		return hospitalStaffEjb.getUserList();
	}

	public void add(){
		hospitalStaffEjb.add(this);
		clear(); //Clears form after adding new room
    }
	
	public void delete(int employeeId) {
		hospitalStaffEjb.delete(employeeId);
	}

	public void clear(){
		setJobTitle(null);
		setFirstName(null);
		setLastName(null);
		setDepartmentId(0);
		setUserName(null);
		setPassword(null);
	}
	
	public void staffById(int employeeId, String jobTitle, String firstName, String lastName, int departmentId, String userName, String password){
		this.employeeId = employeeId;
		this.jobTitle = jobTitle;
		this.firstName = firstName;
		this.lastName = lastName;
		this.departmentId = departmentId;
		this.userName = userName;
		this.password = password;
	}
	
	public void updateStaff(){
		hospitalStaffEjb.update(this);
	}
	
	public List<HospitalStaffMB> searchStaff(){
		return hospitalStaffEjb.searchUser(search);
	}
	
}
