package com.jsf.hello.EJBs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.jsf.hello.MBs.MedicalStoreMB;
import com.jsf.hello.Util.DBHelper;

@ManagedBean(name = "medStoreBean")
@SessionScoped
public class MedicalStoreEJB {
	
	List<MedicalStoreMB> list;

	Connection con = null;
	PreparedStatement stat = null;
	ResultSet rs = null;

	
	public List<MedicalStoreMB> getMedStoreList() {
		list = new ArrayList<>();

		try {
			con = DBHelper.getDBConnection();
			String myStat = "SELECT * FROM medicalstore";
			stat = con.prepareStatement(myStat);
			rs = stat.executeQuery();
			while (rs.next()) {

				MedicalStoreMB usr = new MedicalStoreMB();
				usr.setMedicalStoreId(rs.getInt("medicalStoreId"));
				usr.setMedicine(rs.getString("Medicine"));
				usr.setQuantity(rs.getInt("quantity"));
				usr.setPrice(rs.getFloat("price"));
				list.add(usr);
			}
			con.close();
			stat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public List<MedicalStoreMB> getMedicineList() {
		List<MedicalStoreMB> list = new ArrayList<MedicalStoreMB>();

		try {
			con = DBHelper.getDBConnection();
			String myStat = "SELECT medicine FROM medicalstore";
			stat = con.prepareStatement(myStat);
			rs = stat.executeQuery();
			while (rs.next()) {

				MedicalStoreMB usr = new MedicalStoreMB();
				//usr.setMedicalStoreId(rs.getInt("medicalStoreId"));
				usr.setMedicine(rs.getString("Medicine"));
				//usr.setQuantity(rs.getInt("quantity"));
				//usr.setPrice(rs.getFloat("price"));
				list.add(usr);
			}
			con.close();
			stat.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
