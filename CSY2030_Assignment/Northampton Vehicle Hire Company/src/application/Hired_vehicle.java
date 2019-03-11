package application;

import java.io.Serializable;

public class Hired_vehicle implements Serializable{
	public String Vehicle_Reg_No;
	public String Customer_Name;
	public String Customer_Reg_No;
	public String Vehicle_Make;
	public String Vehicle_Type;
	public String Vehicle_Status;

	public Hired_vehicle(String vehicle_Reg_No,String customer_Reg_No,String vehicle_Type,String customer_Name,String vehicle_Make,String vehicle_Status){
		
		Vehicle_Reg_No=vehicle_Reg_No;
		Customer_Reg_No=customer_Reg_No;
		Vehicle_Type=vehicle_Type;
		Customer_Name=customer_Name;
		Vehicle_Make=vehicle_Make; 
		Vehicle_Status=vehicle_Status;
	}


	public String getCustomer_Name() {
		return Customer_Name;
	}


	public void setCustomer_Name(String customer_Name) {
		Customer_Name = customer_Name;
	}


	public String getVehicle_Make() {
		return Vehicle_Make;
	}


	public void setVehicle_Make(String vehicle_Make) {
		Vehicle_Make = vehicle_Make;
	}


	public String getVehicle_Status() {
		return Vehicle_Status;
	}


	public void setVehicle_Status(String vehicle_Status) {
		Vehicle_Status = vehicle_Status;
	}


	public String getVehicle_Type() {
		return Vehicle_Type;
	}


	public void setVehicle_Type(String vehicle_Type) {
		Vehicle_Type = vehicle_Type;
	}


	public String getVehicle_Reg_No() {
		return Vehicle_Reg_No;
	}


	public void setVehicle_Reg_No(String vehicle_Reg_No) {
		Vehicle_Reg_No = vehicle_Reg_No;
	}


	public String getCustomer_Reg_No() {
		return Customer_Reg_No;
	}


	public void setCustomer_Reg_No(String customer_Reg_No) {
		Customer_Reg_No = customer_Reg_No;
	}

}
