package application;

import java.io.Serializable;

public class Lorry extends Motor_Vehicle implements Serializable{
	
	

	public double Weight_Lorry;
	
	
	
	  Lorry(String reg_number,String make_Vehicle,String model_Vehicle,double speed_Vehicle,double hire_Rate_Vehicle,int number_doors,double weight_Lorry,String vehicle_type,String vehicle_status){
		  super( reg_number, make_Vehicle, model_Vehicle, speed_Vehicle, hire_Rate_Vehicle, number_doors, vehicle_type,vehicle_status);
		  Weight_Lorry=weight_Lorry;
	  }
	  
	  
		public double getWeight_Lorry() {
			return Weight_Lorry;
		}

		public void setWeight_Lorry(double weight_Lorry) {
			Weight_Lorry = weight_Lorry;
		}

	
	

}
