package application;

import java.io.Serializable;

public class Motor_Vehicle implements Serializable{
	
	public String Reg_number;
	public String Make_Vehicle;
	public String Model_Vehicle;
	public double Speed_Vehicle;
	public double Hire_Rate_Vehicle;
	public int Number_doors;
	public String Vehicle_type;
	public String Vehicle_status;
	
	public Motor_Vehicle(String reg_number,String make_Vehicle,String model_Vehicle,double speed_Vehicle,double hire_Rate_Vehicle,int number_doors,String vehicle_type, String vehicle_status){
		
		Reg_number=reg_number;
		Make_Vehicle=make_Vehicle;
		Model_Vehicle=model_Vehicle;
		Speed_Vehicle=speed_Vehicle;
		Hire_Rate_Vehicle=hire_Rate_Vehicle;
		Number_doors=number_doors;
		Vehicle_type=vehicle_type;
		Vehicle_status=vehicle_status;
	}

	public String getVehicle_status() {
		return Vehicle_status;
	}

	public void setVehicle_status(String vehicle_status) {
		Vehicle_status = vehicle_status;
	}

	public String getVehicle_type() {
		return Vehicle_type;
	}

	public void setVehicle_type(String vehicle_type) {
		Vehicle_type = vehicle_type;
	}

	public String getReg_number() {
		return Reg_number;
	}

	public void setReg_number(String reg_number) {
		Reg_number = reg_number;
	}

	public String getMake_Vehicle() {
		return Make_Vehicle;
	}

	public void setMake_Vehicle(String make_Vehicle) {
		Make_Vehicle = make_Vehicle;
	}
	
	

	public String getModel_Vehicle() {
		return Model_Vehicle;
	}

	public void setModel_Vehicle(String model_Vehicle) {
		Model_Vehicle = model_Vehicle;
	}

	public double getSpeed_Vehicle() {
		return Speed_Vehicle;
	}

	public void setSpeed_Vehicle(double speed_Vehicle) {
		Speed_Vehicle = speed_Vehicle;
	}

	public double getHire_Rate_Vehicle() {
		return Hire_Rate_Vehicle;
	}

	public void setHire_Rate_Vehicle(double hire_Rate_Vehicle) {
		Hire_Rate_Vehicle = hire_Rate_Vehicle;
	}

	public int getNumber_doors() {
		return Number_doors;
	}

	public void setNumber_doors(int number_doors) {
		Number_doors = number_doors;
	}

}
