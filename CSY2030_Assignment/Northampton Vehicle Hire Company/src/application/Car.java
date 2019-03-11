package application;

import java.io.Serializable;

public class Car extends Motor_Vehicle implements Serializable {

	
	public String Fuel_Type;

		public Car(String reg_number,String make_Vehicle,String model_Vehicle,double speed_Vehicle,double hire_Rate_Vehicle,int number_doors,String fuel_Type,String vehicle_type,String vehicle_status){
			super( reg_number, make_Vehicle, model_Vehicle, speed_Vehicle, hire_Rate_Vehicle, number_doors, vehicle_type,vehicle_status);
			
			Fuel_Type=fuel_Type;
			
		}
		
		public String getFuel_Type() {
			return Fuel_Type;
		}
		
		public void setFuel_Type(String fuel_Type) {
			Fuel_Type = fuel_Type;
		}




}
