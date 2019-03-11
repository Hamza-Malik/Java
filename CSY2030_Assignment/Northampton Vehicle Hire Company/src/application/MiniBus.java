package application;

import java.io.Serializable;

public class MiniBus extends Motor_Vehicle implements Serializable{
	

	public int  Seat_Capacity_MiniBus;
	
	public MiniBus(String reg_number,String make_Vehicle,String model_Vehicle,double speed_Vehicle,double hire_Rate_Vehicle,int number_doors,int seat_Capacity_MiniBus,String vehicle_type,String vehicle_status){
		super( reg_number, make_Vehicle, model_Vehicle, speed_Vehicle, hire_Rate_Vehicle, number_doors, vehicle_type,vehicle_status);
		
		Seat_Capacity_MiniBus=seat_Capacity_MiniBus;
		
	}

	public int getSeat_Capacity_MiniBus() {
		return Seat_Capacity_MiniBus;
	}

	public void setSeat_Capacity_MiniBus(int seat_Capacity_MiniBus) {
		Seat_Capacity_MiniBus = seat_Capacity_MiniBus;
	}

	
}
