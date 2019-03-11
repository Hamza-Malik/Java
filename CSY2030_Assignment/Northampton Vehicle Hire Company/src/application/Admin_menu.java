package application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;



import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;

import java.awt.Toolkit;
import javax.swing.JPasswordField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollPane;

public class Admin_menu extends JFrame {

	
	                                                 // All TextFields that are used in Application
	
	public JTextField text_firstname,text_lastname,text_idnumber,text_phonenumber,text_email,text_dateofbirth,text_username,text_address,textfield_Car_Reg_No,textfield_Speed_Car,
	textfield_Make_Car,textfield_Hire_Rate,textfield_Model_Car,textfield_Number_Doors,textfield_MiniBus_Reg_No,textField_Make_MiniBus,textfield_Speed_MiniBus,textfield_Hire_Rate_MiniBus,
	textfield_Model_MiniBus,textfield_Number_Doors_MiniBus,textfield_Seat_Capacity_MiniBus,textfield_Lorry_Reg_No,textfield_Make_Lorry,textfield_Top_Speed_Lorry,textfield_Daily_Rate_Lorry,
	textfield_Load_Weight_Lorry,textfield_Model_Lorry,textfield_Lorry_Number_Doors;
	public static JTextField txtRegistrationNumber;
	public static JPanel main_panel ;
	int refresh=0;
	
	public JButton btnShowHiredVehicle;
	
                                                     // All Main Panels that are used in Application

	public JPanel view_hired_customer,customer_details_show,view_car,view_minibus,view_lorry,remove_lorry,remove_minibus,remove_car,return_lorry, return_minibus, return_car, hire_lorry,select_customer,contentPane,hire_minibus,add_vehicle,add_car_panel,textfield_Make_MiniBus,add_lorry_panel,hire_vehicle,return_vehicle,remove_vehicle,view_vehicle,add_customer,view_customer,left_panel,hire_car;
	public JLabel lbl_remove_vehicle;
	private JPasswordField text_password;
	public ButtonGroup group;
	
                                                    // All ArrayLists that are used in Application

	static ArrayList<Car> vehicle_list = new ArrayList<Car>();
	static ArrayList<MiniBus> minibus_list = new ArrayList<MiniBus>();
	static ArrayList<Lorry> lorry_list = new ArrayList<Lorry>();
	static ArrayList<Customer> customer_list = new ArrayList<Customer>();
	static ArrayList<Hired_vehicle> hired_vehicle_list = new ArrayList<Hired_vehicle>();
	//Object[] row=new Object[8];

	
	                                                // All ScroolPanes that are used in Application
	
	
	public JScrollPane scrollPane_removeCar,scrollPane_mini_table,customer_scroll,table_scroll_pane,scrollPane_lorry_table, scrollPane_return_car,scrollPane_return_MiniBus
	,scrollPane_return_lorry,scrollPane_remove_minibus,scrollPane_remove_lorry,scrollPane_view_lorry,scrollPane_view_car,scrollPane_view_minibus,scrollPane_customer_view,scrollPane_hired_customer;
	
	
                                                    // All Tables that are used in Application

	private JTable table_car_hire,table_minibus,table_lorry,table_select_customer,table_car_return,table_minibus_return,table_lorry_return,table_car_remove,table_minibus_remove,
	table_lorry_remove,table_lorry_view,table_car_view,table_minibus_view,table_customer_view,table_hired_customer;
	
	public JLabel lbl_customer_id,lbl_customer_first,lbl_customer_last,lbl_customer_phone,lbl_customer_email,lbl_customer_birth,lbl_customer_username,
	lbl_customer_password,lbl_customer_address;

	
	public DefaultTableModel model,model_mini,model_lorry,model_customer,model_return_car,model_return_minibus,model_return_lorry,model_car_remove,model_minibus_remove
	,model_lorry_remove,model_lorry_view,model_minibus_view,model_car_view,model_customer_view,model_hired_customer;
	int select_op=0;
	Motor_Vehicle car,mini,lorry;
	Hired_vehicle hire_vehicle_file;
	Customer customer;
	public String Vehicle_type;
	public String customer_reg_no;
	private JTextField textField_Customer;
	private JTextField textField_search_Minibus;
	private JTextField textField_search_Lorry;
	private JTextField textField_return_car;
	
	
   static String car_reg,minibus_reg,lorry_reg;
   static String vehicle_reg,vehicle_make,vehicle_status;
   public  String customer_name,car_reg_return,minibus_reg_return,lorry_reg_return,car_reg_remove,minibus_reg_remove,lorry_reg_remove,lorry_reg_view,minibus_reg_view
   ,car_reg_view,customer_reg_view;
   private JTextField textField;
   private JTextField textField_1;
   private JTextField textField_2;
   private JTextField textField_3;
   private JTextField textField_4;
   private JTextField textField_5;
   private JTextField textField_6;
   private JTextField textField_7;
	
	
	
	
	
	
	                                           // Main Function 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_menu frame = new Admin_menu();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		
	}
	
	public void go_back_to_view_lorry(){
		
		Remove_Previous_Panel();
		main_panel.add(view_lorry);
		
		table_lorry_view = new JTable();
		table_lorry_view.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 15));
		//table_car_hire.getTableHeader().setAlignmentX(alignmentX);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table_lorry_view.setDefaultRenderer(Object.class, centerRenderer);
		table_lorry_view.setModel(new DefaultTableModel(
			
			null, new String[] {
				"Registeration Number Of Lorry", "Make Of Lorry", "Model Of Lorry", "Speed Of Lorry", "Day Hire Rate", "Number Of Doors","Weight Carraige", "Status Of Lorry"
			}
		));
		table_lorry_view.setRowHeight(30);
		table_lorry_view.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scrollPane_view_lorry.setViewportView(table_lorry_view);
		model_lorry_view=(DefaultTableModel)table_lorry_view.getModel();
		// setTable();
		Object[] row_view_lorry=new Object[8];
		for(int i=0;i<lorry_list.size();i++){
			row_view_lorry[0]=lorry_list.get(i).Reg_number;
			row_view_lorry[1]=lorry_list.get(i).Make_Vehicle;
			row_view_lorry[2]=lorry_list.get(i).Model_Vehicle;
			row_view_lorry[3]=lorry_list.get(i).Speed_Vehicle;
			row_view_lorry[4]=lorry_list.get(i).Hire_Rate_Vehicle;
			row_view_lorry[5]=lorry_list.get(i).Number_doors;
			row_view_lorry[6]=lorry_list.get(i).Weight_Lorry;
			row_view_lorry[7]=lorry_list.get(i).Vehicle_status;

			
			model_lorry_view.addRow(row_view_lorry);
		
		}
	}
	
	public void go_back_to_view_customer(){
		
		Remove_Previous_Panel();
		main_panel.add(view_customer);
		
		table_customer_view = new JTable();
		table_customer_view.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 15));
		//table_car_hire.getTableHeader().setAlignmentX(alignmentX);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table_customer_view.setDefaultRenderer(Object.class, centerRenderer);
		table_customer_view.setModel(new DefaultTableModel(
			
			null, new String[] {
				"Identification Number", "First Name", "Last Name", "Date Of Birth", "Phone Number"
			}
		));
		table_customer_view.setRowHeight(30);
		table_customer_view.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scrollPane_customer_view.setViewportView(table_customer_view);
		model_customer_view=(DefaultTableModel)table_customer_view.getModel();
		// setTable();
		Object[] row_view_customer=new Object[5];
		for(int i=0;i<customer_list.size();i++){
			row_view_customer[0]=customer_list.get(i).Id_number;
			row_view_customer[1]=customer_list.get(i).First_name;
			row_view_customer[2]=customer_list.get(i).Last_name;
			row_view_customer[3]=customer_list.get(i).Date_of_birth;
			row_view_customer[4]=customer_list.get(i).Phone_number
					;
			

			
			model_customer_view.addRow(row_view_customer);
		
		}
	}
	public void go_back_to_view_minibus(){
		
		Remove_Previous_Panel();
		main_panel.add(view_minibus);
		
		table_minibus_view = new JTable();
		table_minibus_view.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 15));
		//table_car_hire.getTableHeader().setAlignmentX(alignmentX);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table_minibus_view.setDefaultRenderer(Object.class, centerRenderer);
		table_minibus_view.setModel(new DefaultTableModel(
			
			null, new String[] {
				"Registeration Number Of MiniBus", "Make Of MiniBus", "Model Of MiniBus", "Speed Of MiniBus", "Day Hire Rate", "Number Of Doors","Seat Capacity", "Status Of MiniBus"
			}
		));
		table_minibus_view.setRowHeight(30);
		table_minibus_view.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scrollPane_view_minibus.setViewportView(table_minibus_view);
		model_minibus_view=(DefaultTableModel)table_minibus_view.getModel();
		// setTable();
		Object[] row_view_minibus=new Object[8];
		for(int i=0;i<minibus_list.size();i++){
			row_view_minibus[0]=minibus_list.get(i).Reg_number;
			row_view_minibus[1]=minibus_list.get(i).Make_Vehicle;
			row_view_minibus[2]=minibus_list.get(i).Model_Vehicle;
			row_view_minibus[3]=minibus_list.get(i).Speed_Vehicle;
			row_view_minibus[4]=minibus_list.get(i).Hire_Rate_Vehicle;
			row_view_minibus[5]=minibus_list.get(i).Number_doors;
			row_view_minibus[6]=minibus_list.get(i).Seat_Capacity_MiniBus;
			row_view_minibus[7]=minibus_list.get(i).Vehicle_status;

			
			model_minibus_view.addRow(row_view_minibus);
		
		}
	}
	
	public void go_back_to_view_car(){
		Remove_Previous_Panel();
		main_panel.add(view_car);
		
		table_car_view = new JTable();
		table_car_view.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 15));
		//table_car_hire.getTableHeader().setAlignmentX(alignmentX);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table_car_view.setDefaultRenderer(Object.class, centerRenderer);
		table_car_view.setModel(new DefaultTableModel(
			
			null, new String[] {
				"Registeration Number Of Car", "Make Of Car", "Model Of car", "Speed Of Car", "Day Hire Rate", "Number Of Doors","Fuel Type", "Status Of Car"
			}
		));
		table_car_view.setRowHeight(30);
		table_car_view.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scrollPane_view_car.setViewportView(table_car_view);
		model_car_view=(DefaultTableModel)table_car_view.getModel();
		// setTable();
		Object[] row_view_car=new Object[8];
		for(int i=0;i<vehicle_list.size();i++){
			row_view_car[0]=vehicle_list.get(i).Reg_number;
			row_view_car[1]=vehicle_list.get(i).Make_Vehicle;
			row_view_car[2]=vehicle_list.get(i).Model_Vehicle;
			row_view_car[3]=vehicle_list.get(i).Speed_Vehicle;
			row_view_car[4]=vehicle_list.get(i).Hire_Rate_Vehicle;
			row_view_car[5]=vehicle_list.get(i).Number_doors;
			row_view_car[6]=vehicle_list.get(i).Fuel_Type;
			row_view_car[7]=vehicle_list.get(i).Vehicle_status;

			
			model_car_view.addRow(row_view_car);
		
		}
	}
	
    public void setTable_ReturnLorry(){
		
		Object[] row_return_lorry=new Object[6];
		
	for(int i=0;i<hired_vehicle_list.size();i++){
		if(hired_vehicle_list.get(i).Vehicle_Status.equals("Hired") && hired_vehicle_list.get(i).Vehicle_Type.equals("Lorry")){
			

			row_return_lorry[0]=hired_vehicle_list.get(i).Vehicle_Reg_No;
			row_return_lorry[1]=hired_vehicle_list.get(i).Customer_Name;
			row_return_lorry[2]=hired_vehicle_list.get(i).Customer_Reg_No;
			row_return_lorry[3]=hired_vehicle_list.get(i).Vehicle_Make;
			row_return_lorry[4]=hired_vehicle_list.get(i).Vehicle_Type;
			row_return_lorry[5]=hired_vehicle_list.get(i).Vehicle_Status;

			
			model_return_lorry.addRow(row_return_lorry);
		}
	}
		
	}
	
    public void setTable_ReturnMiniBus(){
		
		Object[] row_return_minbus=new Object[6];
		
	for(int i=0;i<hired_vehicle_list.size();i++){
		if(hired_vehicle_list.get(i).Vehicle_Status.equals("Hired") && hired_vehicle_list.get(i).Vehicle_Type.equals("MiniBus")){
			

			row_return_minbus[0]=hired_vehicle_list.get(i).Vehicle_Reg_No;
			row_return_minbus[1]=hired_vehicle_list.get(i).Customer_Name;
			row_return_minbus[2]=hired_vehicle_list.get(i).Customer_Reg_No;
			row_return_minbus[3]=hired_vehicle_list.get(i).Vehicle_Make;
			row_return_minbus[4]=hired_vehicle_list.get(i).Vehicle_Type;
			row_return_minbus[5]=hired_vehicle_list.get(i).Vehicle_Status;

			
			model_return_minibus.addRow(row_return_minbus);
		}
	}
		
	}
	
	public void setTable_ReturnCar(){
		
		Object[] row_return_car=new Object[6];
		
	for(int i=0;i<hired_vehicle_list.size();i++){
		if(hired_vehicle_list.get(i).Vehicle_Status.equals("Hired") && hired_vehicle_list.get(i).Vehicle_Type.equals("Car")){
			

			row_return_car[0]=hired_vehicle_list.get(i).Vehicle_Reg_No;
			row_return_car[1]=hired_vehicle_list.get(i).Customer_Name;
            row_return_car[2]=hired_vehicle_list.get(i).Customer_Reg_No;
			row_return_car[3]=hired_vehicle_list.get(i).Vehicle_Make;
			row_return_car[4]=hired_vehicle_list.get(i).Vehicle_Type;
			row_return_car[5]=hired_vehicle_list.get(i).Vehicle_Status;

			
			model_return_car.addRow(row_return_car);
		}
	}
		
	}
	
	public void sort_customer(){
		textField_Customer.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub

			TableRowSorter<DefaultTableModel> sort_customer = new TableRowSorter<DefaultTableModel>(model_customer);
			table_select_customer.setRowSorter(sort_customer);
			sort_customer.setRowFilter(RowFilter.regexFilter(textField_Customer.getText()));
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}});
	}
	
	public static void add_Hired_vehicle_list(){
		
		try {

			FileInputStream fis = new FileInputStream("hired_vehicle.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
		    Hired_vehicle hired_obj=null;
			
			while ((hired_obj=(Hired_vehicle)ois.readObject())!=null) {
			
				
					
				hired_vehicle_list.add(hired_obj); //To write onbects from binary files to arraylist

				
				
	
				
			}

			
			 ois.close();
			 
			} catch (EOFException ex) { //This exception will be caught when EOF is reached
			 System.out.println("End of file reached.");
			 } catch (ClassNotFoundException ex) {
			 ex.printStackTrace();
			 } catch (FileNotFoundException ex) {
			 ex.printStackTrace();
			 } catch (IOException ex) {
			 ex.printStackTrace();
			 } 
		
	}

	public void add_hire_vehicle_file(){
		
		hired_vehicle_list.add(new Hired_vehicle(vehicle_reg, customer_reg_no, Vehicle_type,customer_name,vehicle_make,"Hired"));

		

	try {
		
		FileOutputStream fos = new FileOutputStream("hired_vehicle.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		for (int i = 0; i < hired_vehicle_list.size( ); i++)
      	{ // write one object
			hire_vehicle_file = (Hired_vehicle) hired_vehicle_list.get(i);
      		oos.writeObject(hire_vehicle_file); // this one line writes an entire object!!!!
      	} 
		oos.close();

		} catch (EOFException ex) { //This exception will be caught when EOF is reached
		 System.out.println("End of file reached.");
		 } catch (FileNotFoundException ex) {
		 ex.printStackTrace();
		 } catch (IOException ex) {
		 ex.printStackTrace();
		 } 
	}
	
	
	                                                             // Function to Store the Hire Lorry
	
	
	public void get_hire_lorry(){
		
		if(table_lorry.getSelectionModel().isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "No Row is Selected","ERROR",JOptionPane.ERROR_MESSAGE);

		}
		else{
		
		int select_lorry =table_lorry.getSelectedRow();
		vehicle_reg=(String) model_lorry.getValueAt(select_lorry, 0);
		vehicle_make=(String) model_lorry.getValueAt(select_lorry, 1);

		System.out.println(""+vehicle_reg);
		
		
				for(int i=0;i<lorry_list.size();i++){
					
			                if(lorry_list.get(i).Reg_number==vehicle_reg){
			                	
			                
			                	lorry_list.get(i).setVehicle_status("Hired");
			                	
			                }
					
				
				}			
				

	}
	
	}
	                                                      // Function to Store the Hire Car
	
	public void get_hire_car(){
		if(table_car_hire.getSelectionModel().isSelectionEmpty()){
            JOptionPane.showMessageDialog(null, "No Row is Selected","ERROR",JOptionPane.ERROR_MESSAGE);
            

		}
		else{

		int select_car =table_car_hire.getSelectedRow();
		vehicle_reg=(String) model.getValueAt(select_car, 0);
		vehicle_make=(String) model.getValueAt(table_car_hire.getSelectedRow(), 1);

		System.out.println("Reg number is ----"+vehicle_reg);

		
		
				for(int i=0;i<vehicle_list.size();i++){
					
			                if(vehicle_list.get(i).Reg_number.equals(vehicle_reg)){
			                	
			                
			                	vehicle_list.get(i).setVehicle_status("Hired");
			                	
			                }
					
				
				}
				
				for(int i=0;i<vehicle_list.size();i++){

			                System.out.println(vehicle_list.get(i).Vehicle_status);
		
				}
				

	}	
	}
	
	                                                     // Function to Store the Hire MiniBus
	public void get_hire_minibus(){
	
	
	if(table_minibus.getSelectionModel().isSelectionEmpty()){
        JOptionPane.showMessageDialog(null, "No Row is Selected","ERROR",JOptionPane.ERROR_MESSAGE);

	}
	else{
		int select_minibus =table_minibus.getSelectedRow();
		vehicle_reg=(String) model_mini.getValueAt(select_minibus, 0);
		vehicle_make=(String) model_mini.getValueAt(select_minibus, 1);

		System.out.println(""+vehicle_reg);
		
		
				for(int i=0;i<minibus_list.size();i++){
					
			                if(minibus_list.get(i).Reg_number==vehicle_reg){
			                	
			                
			                	minibus_list.get(i).setVehicle_status("Hired");
			                	
			                }
					
				
				}
				
				for(int i=0;i<minibus_list.size();i++){

			                System.out.println(minibus_list.get(i).Vehicle_status);
		
				}
				
				

	}

}
                                                            // Function to Replace the Hire Lorry Binary with the new one


	public void replace_hired_lorry(){



				try {
					
				
				new FileOutputStream("lorry.dat").close(); // Deleting the file
				
				
				FileOutputStream fos= new FileOutputStream("lorry.dat");
				
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				
				
				for (int i = 0; i < lorry_list.size(); i++)  //Writing again with new ArrayList
				{ // write one object
				lorry = (Lorry) lorry_list.get(i);
				oos.writeObject(lorry); // this one line writes an entire object!!!!
				} 
				oos.close();
				
				
				
				
				FileInputStream fis = new FileInputStream("lorry.dat");
				
				ObjectInputStream ois = new ObjectInputStream(fis);
				Lorry obj_l=null;
				
				while ((obj_l=(Lorry)ois.readObject())!=null) {
				//  System.out.println(car_reg);
				
				
				if(obj_l.Reg_number.equals(vehicle_reg)){
					obj_l.setVehicle_status("Hired");
				
				//
				System.out.println("Yah");
				}
				
				else{
				System.out.println("NOO");
				
				}
				
				
				}
				
				
				ois.close();
				
				} catch (EOFException ex) { //This exception will be caught when EOF is reached
				System.out.println("End of file reached.");
				} catch (ClassNotFoundException ex) {
				ex.printStackTrace();
				} catch (FileNotFoundException ex) {
				ex.printStackTrace();
				} catch (IOException ex) {
				ex.printStackTrace();
				} 

}



                                                                // Function to Replace the Hire Car Binary with the new one


    public void replace_hired_minibus(){
	
	
	
	try {
		
		 new FileOutputStream("minibus.dat").close(); // Deleting the file
		 
		 
		 FileOutputStream fos= new FileOutputStream("minibus.dat");
		 
		ObjectOutputStream oos = new ObjectOutputStream(fos);


		for (int i = 0; i < minibus_list.size(); i++)  //Writing again with new ArrayList
      	{ // write one object
			mini = (MiniBus) minibus_list.get(i);
      		oos.writeObject(mini); // this one line writes an entire object!!!!
      	} 
		oos.close();
		
		
		

		FileInputStream fis = new FileInputStream("minibus.dat");
		
		ObjectInputStream ois = new ObjectInputStream(fis);
		MiniBus obj_m=null;
		
		while ((obj_m=(MiniBus)ois.readObject())!=null) {
    		
           if(obj_m.Reg_number.equals(vehicle_reg)){
        	   obj_m.setVehicle_status("Hired");
       	   
        	   
      	   System.out.println("Yah");
           }
           
           else{
        	   System.out.println("NOO");
        	   
           }

			
		}
		
		
		 ois.close();
		 
		} catch (EOFException ex) { //This exception will be caught when EOF is reached
		 System.out.println("End of file reached.");
		 } catch (ClassNotFoundException ex) {
		 ex.printStackTrace();
		 } catch (FileNotFoundException ex) {
		 ex.printStackTrace();
		 } catch (IOException ex) {
		 ex.printStackTrace();
		 } 
	
}
                                                      // Function to Replace the Hire MiniBus Binary File to new one	
	public void replace_hired_car(){
		
		
				
		try {
			
			 new FileOutputStream("vehicle.dat").close(); // Deleting the file
			 
			 
			 FileOutputStream fos= new FileOutputStream("vehicle.dat");
			 
			ObjectOutputStream oos = new ObjectOutputStream(fos);


			for (int i = 0; i < vehicle_list.size(); i++)  //Writing again with new ArrayList
	      	{ // Write one object
				car = (Car) vehicle_list.get(i);
	      		oos.writeObject(car); // This one line writes an entire object!!!!
	      	} 
			oos.close();
			
			
			

			FileInputStream fis = new FileInputStream("vehicle.dat");
			
			ObjectInputStream ois = new ObjectInputStream(fis);
		    Car objo=null;
			
			while ((objo=(Car)ois.readObject())!=null) {
         	 //  System.out.println(car_reg);

				
               if(objo.Reg_number.equals(vehicle_reg)){
           	   objo.setVehicle_status("Hired");
           	   
//            	   
          	   System.out.println("Yah");
               }
               
               else{
            	   System.out.println("NOO");
            	   
               }

				
			}
			
			
			 ois.close();
			 
			} catch (EOFException ex) { //This exception will be caught when EOF is reached
			 System.out.println("End of file reached.");
			 } catch (ClassNotFoundException ex) {
			 ex.printStackTrace();
			 } catch (FileNotFoundException ex) {
			 ex.printStackTrace();
			 } catch (IOException ex) {
			 ex.printStackTrace();
			 } 
		
	}
	
	
	
	
                                                       	 // Function to Add Customers into Binary File
	
	
	public static void add_Customer_list(){
		
		try {

			FileInputStream fis = new FileInputStream("customer.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
		    Customer obj_customer=null;
			
			while ((obj_customer=(Customer)ois.readObject())!=null) {
					
				customer_list.add(obj_customer);
			
			}
			
			 ois.close();
			 
			} catch (EOFException ex) { //This exception will be caught when EOF is reached
			 System.out.println("End of file reached.");
			 } catch (ClassNotFoundException ex) {
			 ex.printStackTrace();
			 } catch (FileNotFoundException ex) {
			 ex.printStackTrace();
			 } catch (IOException ex) {
			 ex.printStackTrace();
			 } 
		
		
	}
	

	  
	
	                                           // Function to add lorries into ArrayList when program runs
	
	
	public static void add_Lorry_list(){
		
		try {

			FileInputStream fis = new FileInputStream("lorry.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
		    Lorry obj_lorry=null;
			
			while ((obj_lorry=(Lorry)ois.readObject())!=null) {
					
				lorry_list.add(obj_lorry);
			


				
			}
			
			 ois.close();
			 
			} catch (EOFException ex) { //This exception will be caught when EOF is reached
			 System.out.println("End of file reached.");
			 } catch (ClassNotFoundException ex) {
			 ex.printStackTrace();
			 } catch (FileNotFoundException ex) {
			 ex.printStackTrace();
			 } catch (IOException ex) {
			 ex.printStackTrace();
			 } 
	}
	


	
	
	                                                   // Function to add Cars into ArrayList when program runs
	
	public static void add_Car_list(){
		try {

			FileInputStream fis = new FileInputStream("vehicle.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
		    Car obj=null;
			
			while ((obj=(Car)ois.readObject())!=null) {
					
				vehicle_list.add(obj);
							
			}
			
			 ois.close();
			 
			} catch (EOFException ex) { //This exception will be caught when EOF is reached
			 System.out.println("End of file reached.");
			 } catch (ClassNotFoundException ex) {
			 ex.printStackTrace();
			 } catch (FileNotFoundException ex) {
			 ex.printStackTrace();
			 } catch (IOException ex) {
			 ex.printStackTrace();
			 } 
		
	}

	
	
	                                                   // Function to add MiniBus into ArrayList when program runs
	
	
	public static void add_miniBus_list(){
		
		try {

			FileInputStream fis = new FileInputStream("minibus.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
		    MiniBus mini_obj=null;
			
			while ((mini_obj=(MiniBus)ois.readObject())!=null) {
			
				
					
				minibus_list.add(mini_obj);

				
				
	
				
			}
			
			 ois.close();
			 
			} catch (EOFException ex) { //This exception will be caught when EOF is reached
			 System.out.println("End of file reached.");
			 } catch (ClassNotFoundException ex) {
			 ex.printStackTrace();
			 } catch (FileNotFoundException ex) {
			 ex.printStackTrace();
			 } catch (IOException ex) {
			 ex.printStackTrace();
			 } 
	}
	
	
	                                        
	
																/**
																 * Function to Remove previous Panel when new panel loads
																 */
	
	public static  void  Remove_Previous_Panel(){
		
		//Removing Panel
		main_panel.removeAll();
		main_panel.repaint();
		main_panel.revalidate();
		
		//Adding new Panel
		main_panel.repaint();
		main_panel.revalidate();
		
	}
	
	
	

	/**
	 * Actual Frame
	 */
	public Admin_menu(){
		setIconImage(Toolkit.getDefaultToolkit().getImage(Admin_menu.class.getResource("/application/Images/carr.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, 1950, 1040);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(204, 204, 255));
		contentPane.setBackground(new Color(0, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 main_panel = new JPanel();
		main_panel.setBounds(345, 146, 1555, 834);
		contentPane.add(main_panel);
		main_panel.setLayout(new CardLayout(0, 0));
		
	
		
		
		
		add_vehicle = new JPanel();
		add_vehicle.setBackground(new Color(95, 158, 160));
		main_panel.add(add_vehicle);
		add_vehicle.setLayout(null);
		
		 add_car_panel = new JPanel();
		add_car_panel.setBackground(new Color(95, 158, 160));
		add_car_panel.setLayout(null);
		main_panel.add(add_car_panel);
		
		select_customer = new JPanel();
		select_customer.setLayout(null);
		select_customer.setBackground(new Color(95, 158, 160));
		main_panel.add(select_customer);
		
		 customer_scroll = new JScrollPane();
		customer_scroll.setBounds(25, 176, 1497, 523);
		select_customer.add(customer_scroll);
		
		 textfield_Make_MiniBus = new JPanel();
		 textfield_Make_MiniBus.setBackground(new Color(95, 158, 160));
		textfield_Make_MiniBus.setLayout(null);
		main_panel.add(textfield_Make_MiniBus);
		
		add_lorry_panel = new JPanel();
		add_lorry_panel.setBackground(new Color(95, 158, 160));
		add_lorry_panel.setLayout(null);
		main_panel.add(add_lorry_panel);
		
		 remove_vehicle = new JPanel();
		remove_vehicle.setBackground(new Color(95, 158, 160));
		main_panel.add(remove_vehicle);
		remove_vehicle.setLayout(null);
		
		lbl_remove_vehicle = new JLabel("Remove Vehicle");
		lbl_remove_vehicle.setForeground(Color.WHITE);
		lbl_remove_vehicle.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 38));
		lbl_remove_vehicle.setBounds(645, 36, 268, 33);
		remove_vehicle.add(lbl_remove_vehicle);
		
		 remove_minibus = new JPanel();
		remove_minibus.setLayout(null);
		remove_minibus.setBackground(new Color(95, 158, 160));
		main_panel.add(remove_minibus);
		
		
		 scrollPane_remove_minibus = new JScrollPane();
		scrollPane_remove_minibus.setBounds(25, 191, 1497, 526);
		remove_minibus.add(scrollPane_remove_minibus);
		
		remove_lorry = new JPanel();
		remove_lorry.setLayout(null);
		remove_lorry.setBackground(new Color(95, 158, 160));
		main_panel.add(remove_lorry);
		
		 scrollPane_remove_lorry = new JScrollPane();
		scrollPane_remove_lorry.setBounds(25, 191, 1497, 526);
		remove_lorry.add(scrollPane_remove_lorry);
		
		 view_car = new JPanel();
		view_car.setLayout(null);
		view_car.setBackground(new Color(95, 158, 160));
		main_panel.add(view_car);
		
		 scrollPane_view_car = new JScrollPane();
		scrollPane_view_car.setBounds(25, 191, 1497, 526);
		view_car.add(scrollPane_view_car);
		
		 view_minibus = new JPanel();
		view_minibus.setLayout(null);
		view_minibus.setBackground(new Color(95, 158, 160));
		main_panel.add(view_minibus);
		
		 scrollPane_view_minibus = new JScrollPane();
		scrollPane_view_minibus.setBounds(25, 191, 1497, 526);
		view_minibus.add(scrollPane_view_minibus);
		
		 view_lorry = new JPanel();
		view_lorry.setLayout(null);
		view_lorry.setBackground(new Color(95, 158, 160));
		main_panel.add(view_lorry);
		
		 scrollPane_view_lorry = new JScrollPane();
		scrollPane_view_lorry.setBounds(25, 191, 1497, 526);
		view_lorry.add(scrollPane_view_lorry);
		
		
		
		JPanel minibus_details_show = new JPanel();
		minibus_details_show.setLayout(null);
		minibus_details_show.setBackground(new Color(95, 158, 160));
		main_panel.add(minibus_details_show);
		
		JLabel lbl_minibus_reg = new JLabel("");
		lbl_minibus_reg.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lbl_minibus_reg.setBounds(268, 160, 252, 40);
		minibus_details_show.add(lbl_minibus_reg);
		
		JLabel lbl_minibus_make = new JLabel("");
		lbl_minibus_make.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_minibus_make.setBounds(722, 160, 252, 40);
		minibus_details_show.add(lbl_minibus_make);
		
		JLabel lbl_minibus_model = new JLabel("");
		lbl_minibus_model.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_minibus_model.setBounds(1287, 160, 252, 40);
		minibus_details_show.add(lbl_minibus_model);
		
		JLabel lbl_minibus_speed = new JLabel("");
		lbl_minibus_speed.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_minibus_speed.setBounds(256, 296, 81, 40);
		minibus_details_show.add(lbl_minibus_speed);
		
		JLabel label_30 = new JLabel("Km/h");
		label_30.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_30.setBounds(331, 296, 56, 40);
		minibus_details_show.add(label_30);
		
		JLabel lbl_minibus_hire = new JLabel("");
		lbl_minibus_hire.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_minibus_hire.setBounds(725, 296, 252, 40);
		minibus_details_show.add(lbl_minibus_hire);
		
		JLabel lbl_minibus_doors = new JLabel("");
		lbl_minibus_doors.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_minibus_doors.setBounds(1303, 296, 226, 40);
		minibus_details_show.add(lbl_minibus_doors);
		
		JLabel lbl_minibus_seat = new JLabel("");
		lbl_minibus_seat.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_minibus_seat.setBounds(256, 441, 252, 40);
		minibus_details_show.add(lbl_minibus_seat);
		
		JLabel lbl_minibus_status = new JLabel("");
		lbl_minibus_status.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_minibus_status.setBounds(722, 441, 252, 40);
		minibus_details_show.add(lbl_minibus_status);
		
		JLabel lbl_minibus_customer = new JLabel("");
		lbl_minibus_customer.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_minibus_customer.setBounds(1297, 441, 252, 40);
		minibus_details_show.add(lbl_minibus_customer);
		
		JLabel lbl_minibus_customer_reg = new JLabel("");
		lbl_minibus_customer_reg.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_minibus_customer_reg.setBounds(279, 588, 252, 40);
		minibus_details_show.add(lbl_minibus_customer_reg);
		
		
		
		JButton button_10 = new JButton("");
		button_10.setIcon(new ImageIcon(Admin_menu.class.getResource("/application/Images/Webp.net-resizeimage.png")));
		button_10.setForeground(SystemColor.inactiveCaptionBorder);
		button_10.setBorderPainted(false);
		button_10.setBorder(null);
		button_10.setBackground(new Color(95, 158, 160));
		button_10.setBounds(620, 233, 102, 109);
		remove_vehicle.add(button_10);
		
		JButton btnRemoveCar = new JButton("REMOVE CAR");
		btnRemoveCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Remove_Previous_Panel();
				main_panel.add(remove_car);
				
				table_car_remove = new JTable();
				table_car_remove.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 15));
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment( JLabel.CENTER );
				table_car_remove.setDefaultRenderer(Object.class, centerRenderer);
				table_car_remove.setModel(new DefaultTableModel(
					
					null, new String[] {
						"Registeration Number Of Car", "Make Of Car", "Model Of car", "Speed Of Car", "Day Hire Rate", "Number Of Doors","Fuel Type", "Status Of Car"
					}
				));
				table_car_remove.setRowHeight(30);
				table_car_remove.setFont(new Font("Tahoma", Font.PLAIN, 18));
				scrollPane_removeCar.setViewportView(table_car_remove);
				model_car_remove=(DefaultTableModel)table_car_remove.getModel();
				// setTable();
				Object[] row_remove_car=new Object[8];
				for(int i=0;i<vehicle_list.size();i++){
					if(vehicle_list.get(i).Vehicle_status.equals("Ready To Hire")){
					row_remove_car[0]=vehicle_list.get(i).Reg_number;
					row_remove_car[1]=vehicle_list.get(i).Make_Vehicle;
					row_remove_car[2]=vehicle_list.get(i).Model_Vehicle;
					row_remove_car[3]=vehicle_list.get(i).Speed_Vehicle;
					row_remove_car[4]=vehicle_list.get(i).Hire_Rate_Vehicle;
					row_remove_car[5]=vehicle_list.get(i).Number_doors;
					row_remove_car[6]=vehicle_list.get(i).Fuel_Type;
					row_remove_car[7]=vehicle_list.get(i).Vehicle_status;

					
					model_car_remove.addRow(row_remove_car);
				}
				}
			}
		});
		btnRemoveCar.setForeground(Color.WHITE);
		btnRemoveCar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRemoveCar.setBackground(new Color(51, 102, 102));
		btnRemoveCar.setBounds(735, 235, 231, 107);
		remove_vehicle.add(btnRemoveCar);
		
		
		
		JButton button_20 = new JButton("");
		button_20.setIcon(new ImageIcon(Admin_menu.class.getResource("/application/Images/hhhjk.png")));
		button_20.setForeground(SystemColor.inactiveCaptionBorder);
		button_20.setBorderPainted(false);
		button_20.setBorder(null);
		button_20.setBackground(new Color(95, 158, 160));
		button_20.setBounds(621, 455, 102, 106);
		remove_vehicle.add(button_20);
		
		JPanel car_details_show = new JPanel();
		car_details_show.setLayout(null);
		car_details_show.setBackground(new Color(95, 158, 160));
		main_panel.add(car_details_show);
		
		JLabel lbl_car_reg_no = new JLabel("");
		lbl_car_reg_no.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lbl_car_reg_no.setBounds(268, 160, 252, 40);
		car_details_show.add(lbl_car_reg_no);
		
		JLabel lbl_car_make = new JLabel("");
		lbl_car_make.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_car_make.setBounds(722, 160, 252, 40);
		car_details_show.add(lbl_car_make);
		
		JLabel lbl_car_model = new JLabel("");
		lbl_car_model.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_car_model.setBounds(1287, 160, 252, 40);
		car_details_show.add(lbl_car_model);
		
		JLabel lbl_car_spped = new JLabel("");
		lbl_car_spped.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_car_spped.setBounds(256, 296, 81, 40);
		car_details_show.add(lbl_car_spped);
		
		JLabel lblKmh = new JLabel("Km/h");
		lblKmh.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblKmh.setBounds(331, 296, 56, 40);
		car_details_show.add(lblKmh);
		
		JLabel lbl_car_hire = new JLabel("");
		lbl_car_hire.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_car_hire.setBounds(725, 296, 252, 40);
		car_details_show.add(lbl_car_hire);
		
		JLabel lbl_car_doors = new JLabel("");
		lbl_car_doors.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_car_doors.setBounds(1303, 296, 252, 40);
		car_details_show.add(lbl_car_doors);
		
		JLabel lbl_car_fuel = new JLabel("");
		lbl_car_fuel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_car_fuel.setBounds(256, 441, 252, 40);
		car_details_show.add(lbl_car_fuel);
		
		JLabel lbl_car_status = new JLabel("");
		lbl_car_status.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_car_status.setBounds(722, 441, 252, 40);
		car_details_show.add(lbl_car_status);
		
		JLabel lbl_car_customer_name = new JLabel("");
		lbl_car_customer_name.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_car_customer_name.setBounds(1297, 441, 252, 40);
		car_details_show.add(lbl_car_customer_name);
		
		JLabel lbl_car_customer_reg = new JLabel("");
		lbl_car_customer_reg.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_car_customer_reg.setBounds(279, 588, 252, 40);
		car_details_show.add(lbl_car_customer_reg);
		
		JButton btnRemoveMinibus = new JButton("REMOVE MINIBUS");
		btnRemoveMinibus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Remove_Previous_Panel();
				main_panel.add(remove_minibus);
				
				table_minibus_remove = new JTable();
				table_minibus_remove.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 15));
				//table_car_hire.getTableHeader().setAlignmentX(alignmentX);
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment( JLabel.CENTER );
				table_minibus_remove.setDefaultRenderer(Object.class, centerRenderer);
				table_minibus_remove.setModel(new DefaultTableModel(
					
					null, new String[] {
						"Registeration Number Of MiniBus", "Make Of MiniBus", "Model Of MiniBus", "Speed Of MiniBus", "Day Hire Rate", "Number Of Doors","Fuel Type", "Status Of MiniBus"
					}
				));
				table_minibus_remove.setRowHeight(30);
				table_minibus_remove.setFont(new Font("Tahoma", Font.PLAIN, 18));
				scrollPane_remove_minibus.setViewportView(table_minibus_remove);
				model_minibus_remove=(DefaultTableModel)table_minibus_remove.getModel();
				// setTable();
				Object[] row_remove_minibus=new Object[8];
				for(int i=0;i<minibus_list.size();i++){
					if(minibus_list.get(i).Vehicle_status.equals("Ready To Hire")){
					row_remove_minibus[0]=minibus_list.get(i).Reg_number;
					row_remove_minibus[1]=minibus_list.get(i).Make_Vehicle;
					row_remove_minibus[2]=minibus_list.get(i).Model_Vehicle;
					row_remove_minibus[3]=minibus_list.get(i).Speed_Vehicle;
					row_remove_minibus[4]=minibus_list.get(i).Hire_Rate_Vehicle;
					row_remove_minibus[5]=minibus_list.get(i).Number_doors;
					row_remove_minibus[6]=minibus_list.get(i).Seat_Capacity_MiniBus;
					row_remove_minibus[7]=minibus_list.get(i).Vehicle_status;

					
					model_minibus_remove.addRow(row_remove_minibus);
				}
				}
			}
		});
		btnRemoveMinibus.setForeground(Color.WHITE);
		btnRemoveMinibus.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRemoveMinibus.setBackground(new Color(51, 102, 102));
		btnRemoveMinibus.setBounds(735, 455, 231, 107);
		remove_vehicle.add(btnRemoveMinibus);
		
		JButton button_22 = new JButton("");
		button_22.setIcon(new ImageIcon(Admin_menu.class.getResource("/application/Images/loo.png")));
		button_22.setForeground(SystemColor.inactiveCaptionBorder);
		button_22.setBorderPainted(false);
		button_22.setBorder(null);
		button_22.setBackground(new Color(95, 158, 160));
		button_22.setBounds(621, 666, 102, 106);
		remove_vehicle.add(button_22);
		
		JButton btnRemoveLorry = new JButton("REMOVE LORRY");
		btnRemoveLorry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Remove_Previous_Panel();
				main_panel.add(remove_lorry);
				
				table_lorry_remove = new JTable();
				table_lorry_remove.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 15));
				//table_car_hire.getTableHeader().setAlignmentX(alignmentX);
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment( JLabel.CENTER );
				table_lorry_remove.setDefaultRenderer(Object.class, centerRenderer);
				table_lorry_remove.setModel(new DefaultTableModel(
					
					null, new String[] {
						"Registeration Number Of Lorry", "Make Of Lorry", "Model Of Lorry", "Speed Of Lorry", "Day Hire Rate", "Number Of Doors","Weight Of Lorry", "Status Of Lorry"
					}
				));
				table_lorry_remove.setRowHeight(30);
				table_lorry_remove.setFont(new Font("Tahoma", Font.PLAIN, 18));
				scrollPane_remove_lorry.setViewportView(table_lorry_remove);
				model_lorry_remove=(DefaultTableModel)table_lorry_remove.getModel();
				Object[] row_remove_lorry=new Object[8];
				for(int i=0;i<lorry_list.size();i++){
					if(lorry_list.get(i).Vehicle_status.equals("Ready To Hire")){
						row_remove_lorry[0]=lorry_list.get(i).Reg_number;
						row_remove_lorry[1]=lorry_list.get(i).Make_Vehicle;
						row_remove_lorry[2]=lorry_list.get(i).Model_Vehicle;
						row_remove_lorry[3]=lorry_list.get(i).Speed_Vehicle;
						row_remove_lorry[4]=lorry_list.get(i).Hire_Rate_Vehicle;
						row_remove_lorry[5]=lorry_list.get(i).Number_doors;
						row_remove_lorry[6]=lorry_list.get(i).Weight_Lorry;
						row_remove_lorry[7]=lorry_list.get(i).Vehicle_status;

					
					model_lorry_remove.addRow(row_remove_lorry);
				}
				}
			}
		});
		btnRemoveLorry.setForeground(Color.WHITE);
		btnRemoveLorry.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnRemoveLorry.setBackground(new Color(51, 102, 102));
		btnRemoveLorry.setBounds(735, 666, 231, 107);
		remove_vehicle.add(btnRemoveLorry);
		
		JLabel lblSelectTheVehicle_1 = new JLabel("Select the vehicle you want to Remove:");
		lblSelectTheVehicle_1.setForeground(Color.WHITE);
		lblSelectTheVehicle_1.setFont(new Font("Candara", Font.BOLD, 29));
		lblSelectTheVehicle_1.setBounds(28, 98, 517, 67);
		remove_vehicle.add(lblSelectTheVehicle_1);
		
		 hire_car = new JPanel();
		hire_car.setLayout(null);
		hire_car.setBackground(new Color(95, 158, 160));
		main_panel.add(hire_car);
		
		 hire_minibus = new JPanel();
		hire_minibus.setLayout(null);
		hire_minibus.setBackground(new Color(95, 158, 160));
		main_panel.add(hire_minibus);
		
		scrollPane_mini_table = new JScrollPane();
		scrollPane_mini_table.setBounds(26, 186, 1497, 532);
		hire_minibus.add(scrollPane_mini_table);
		
		 table_scroll_pane = new JScrollPane();
		table_scroll_pane.setBounds(25, 191, 1497, 526);
		hire_car.add(table_scroll_pane);
		
		 return_car = new JPanel();
		return_car.setLayout(null);
		return_car.setBackground(new Color(95, 158, 160));
		main_panel.add(return_car);
		
		 scrollPane_return_car = new JScrollPane();
		scrollPane_return_car.setBounds(25, 191, 1497, 526);
		return_car.add(scrollPane_return_car);
		
		 return_minibus = new JPanel();
		return_minibus.setLayout(null);
		return_minibus.setBackground(new Color(95, 158, 160));
		main_panel.add(return_minibus);
		
		 scrollPane_return_MiniBus = new JScrollPane();
		scrollPane_return_MiniBus.setBounds(25, 191, 1497, 526);
		return_minibus.add(scrollPane_return_MiniBus);
		
		 return_lorry = new JPanel();
		return_lorry.setLayout(null);
		return_lorry.setBackground(new Color(95, 158, 160));
		main_panel.add(return_lorry);
		
		 scrollPane_return_lorry = new JScrollPane();
		scrollPane_return_lorry.setBounds(25, 191, 1497, 526);
		return_lorry.add(scrollPane_return_lorry);
		
		 hire_vehicle = new JPanel();
		hire_vehicle.setBackground(new Color(95, 158, 160));
		hire_vehicle.setLayout(null);
		main_panel.add(hire_vehicle);
		
		 hire_lorry = new JPanel();
		hire_lorry.setLayout(null);
		hire_lorry.setBackground(new Color(95, 158, 160));
		main_panel.add(hire_lorry);
		
		 scrollPane_lorry_table = new JScrollPane();
		scrollPane_lorry_table.setBounds(26, 182, 1497, 525);
		hire_lorry.add(scrollPane_lorry_table);
		
		 remove_car = new JPanel();
		remove_car.setLayout(null);
		remove_car.setBackground(new Color(95, 158, 160));
		main_panel.add(remove_car);
		
		
		 scrollPane_removeCar = new JScrollPane();
		scrollPane_removeCar.setBounds(25, 191, 1497, 526);
		remove_car.add(scrollPane_removeCar);
		
		JLabel lbl_hire_vehicle = new JLabel("Hire Vehicle");
		lbl_hire_vehicle.setForeground(Color.WHITE);
		lbl_hire_vehicle.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 38));
		lbl_hire_vehicle.setBounds(709, 27, 195, 41);
		hire_vehicle.add(lbl_hire_vehicle);
		
		JPanel lorry_details_show = new JPanel();
		lorry_details_show.setLayout(null);
		lorry_details_show.setBackground(new Color(95, 158, 160));
		main_panel.add(lorry_details_show);
		
		JLabel lbl_lorry_reg = new JLabel("");
		lbl_lorry_reg.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lbl_lorry_reg.setBounds(268, 160, 252, 40);
		lorry_details_show.add(lbl_lorry_reg);
		
		JLabel lbl_lorry_make = new JLabel("");
		lbl_lorry_make.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_lorry_make.setBounds(722, 160, 252, 40);
		lorry_details_show.add(lbl_lorry_make);
		
		JLabel lbl_lorry_model = new JLabel("");
		lbl_lorry_model.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_lorry_model.setBounds(1287, 160, 252, 40);
		lorry_details_show.add(lbl_lorry_model);
		
		JLabel lbl_lorry_speed = new JLabel("");
		lbl_lorry_speed.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_lorry_speed.setBounds(256, 296, 81, 40);
		lorry_details_show.add(lbl_lorry_speed);
		
		JLabel label_31 = new JLabel("Km/h");
		label_31.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_31.setBounds(331, 296, 56, 40);
		lorry_details_show.add(label_31);
		
		JLabel lbl_lorry_hire = new JLabel("");
		lbl_lorry_hire.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_lorry_hire.setBounds(725, 296, 252, 40);
		lorry_details_show.add(lbl_lorry_hire);
		
		JLabel lbl_lorry_doors = new JLabel("");
		lbl_lorry_doors.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_lorry_doors.setBounds(1303, 296, 226, 40);
		lorry_details_show.add(lbl_lorry_doors);
		
		JLabel lbl_lorry_weight = new JLabel("");
		lbl_lorry_weight.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_lorry_weight.setBounds(256, 441, 252, 40);
		lorry_details_show.add(lbl_lorry_weight);
		
		JLabel lbl_lorry_status = new JLabel("");
		lbl_lorry_status.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_lorry_status.setBounds(722, 441, 252, 40);
		lorry_details_show.add(lbl_lorry_status);
		
		JLabel lbl_lorry_customer = new JLabel("");
		lbl_lorry_customer.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_lorry_customer.setBounds(1297, 441, 252, 40);
		lorry_details_show.add(lbl_lorry_customer);
		
		JLabel lbl_lorry_customer_reg = new JLabel("");
		lbl_lorry_customer_reg.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_lorry_customer_reg.setBounds(279, 588, 252, 40);
		lorry_details_show.add(lbl_lorry_customer_reg);
		
		JButton btn_Hire_Car_pic = new JButton("");
		btn_Hire_Car_pic.setIcon(new ImageIcon(Admin_menu.class.getResource("/application/Images/Webp.net-resizeimage.png")));
		btn_Hire_Car_pic.setForeground(SystemColor.inactiveCaptionBorder);
		btn_Hire_Car_pic.setBorderPainted(false);
		btn_Hire_Car_pic.setBorder(null);
		btn_Hire_Car_pic.setBackground(new Color(95, 158, 160));
		btn_Hire_Car_pic.setBounds(629, 217, 102, 109);
		hire_vehicle.add(btn_Hire_Car_pic);
		
		JButton btnHireCar = new JButton("HIRE CAR");
		btnHireCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
								
				Remove_Previous_Panel();
				main_panel.add(hire_car);
				table_car_hire = new JTable();
				table_car_hire.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 15));
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment( JLabel.CENTER );
				table_car_hire.setDefaultRenderer(Object.class, centerRenderer);
				table_car_hire.setModel(new DefaultTableModel(
					
					null, new String[] {
						"Registeration Number Of Car", "Make Of Car", "Model Of car", "Speed Of Car", "Day Hire Rate", "Number Of Doors","Fuel Type", "Status Of Car"
					}
				));
				table_car_hire.setRowHeight(30);
				table_car_hire.setFont(new Font("Tahoma", Font.PLAIN, 18));
				table_scroll_pane.setViewportView(table_car_hire);
				  model=(DefaultTableModel)table_car_hire.getModel();
				Object[] row=new Object[8];
				for(int i=0;i<vehicle_list.size();i++){
					if(vehicle_list.get(i).Vehicle_status.equals("Ready To Hire")){
					
					row[0]=vehicle_list.get(i).Reg_number;
					row[1]=vehicle_list.get(i).Make_Vehicle;
					row[2]=vehicle_list.get(i).Model_Vehicle;
					row[3]=vehicle_list.get(i).Speed_Vehicle;
					row[4]=vehicle_list.get(i).Hire_Rate_Vehicle;
					row[5]=vehicle_list.get(i).Number_doors;
					row[6]=vehicle_list.get(i).Fuel_Type;
					row[7]=vehicle_list.get(i).Vehicle_status;

					
		            model.addRow(row);
				}
				}
				txtRegistrationNumber.addKeyListener(new KeyListener(){

					@Override
					public void keyPressed(KeyEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void keyReleased(KeyEvent arg0) {
						// TODO Auto-generated method stub
					TableRowSorter<DefaultTableModel> sort_hire_car = new TableRowSorter<DefaultTableModel>(model);
					table_car_hire.setRowSorter(sort_hire_car);
					sort_hire_car.setRowFilter(RowFilter.regexFilter(txtRegistrationNumber.getText()));
						
					}

					@Override
					public void keyTyped(KeyEvent arg0) {
						// TODO Auto-generated method stub
						
					}});
				
				
			}
		});
		btnHireCar.setForeground(Color.WHITE);
		btnHireCar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnHireCar.setBackground(new Color(51, 102, 102));
		btnHireCar.setBounds(744, 219, 188, 107);
		hire_vehicle.add(btnHireCar);
		
		JButton btn_Hire_Minibus_pic = new JButton("");
		btn_Hire_Minibus_pic.setIcon(new ImageIcon(Admin_menu.class.getResource("/application/Images/hhhjk.png")));
		btn_Hire_Minibus_pic.setForeground(SystemColor.inactiveCaptionBorder);
		btn_Hire_Minibus_pic.setBorderPainted(false);
		btn_Hire_Minibus_pic.setBorder(null);
		btn_Hire_Minibus_pic.setBackground(new Color(95, 158, 160));
		btn_Hire_Minibus_pic.setBounds(630, 439, 102, 106);
		hire_vehicle.add(btn_Hire_Minibus_pic);
		
		JButton btnHireMinibus = new JButton("HIRE MINIBUS");
		btnHireMinibus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Remove_Previous_Panel();
				main_panel.add(hire_minibus);
				table_minibus = new JTable();
				table_minibus.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 15));
				//table_car_hire.getTableHeader().setAlignmentX(alignmentX);
				DefaultTableCellRenderer centerRenderer_mini = new DefaultTableCellRenderer();
				centerRenderer_mini.setHorizontalAlignment( JLabel.CENTER );
				table_minibus.setDefaultRenderer(Object.class, centerRenderer_mini);
				table_minibus.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Registration number", "Make Of MiniBus", "Model Of MiniBus", "Speed Of MiniBus", "Daily Hire Rate", "Number Of Doors", "Seating Capacity", "Status Of MiniBus"
					}
				));
				table_minibus.setRowHeight(30);
				table_minibus.setFont(new Font("Tahoma", Font.PLAIN, 18));
				scrollPane_mini_table.setViewportView(table_minibus);
				 model_mini=(DefaultTableModel)table_minibus.getModel();
				Object[] row_mini=new Object[8];
				for(int i=0;i<minibus_list.size();i++){
					if(minibus_list.get(i).Vehicle_status.equals("Ready To Hire")){
					
					row_mini[0]=minibus_list.get(i).getReg_number();
					row_mini[1]=minibus_list.get(i).getMake_Vehicle();
					row_mini[2]=minibus_list.get(i).getModel_Vehicle();
					row_mini[3]=minibus_list.get(i).getSpeed_Vehicle();
					row_mini[4]=minibus_list.get(i).getHire_Rate_Vehicle();
					row_mini[5]=minibus_list.get(i).getNumber_doors();
					row_mini[6]=minibus_list.get(i).getSeat_Capacity_MiniBus();
					row_mini[7]=minibus_list.get(i).getVehicle_status();

					
					model_mini.addRow(row_mini);
					
				}
				}
				textField_search_Minibus.addKeyListener(new KeyListener(){

					@Override
					public void keyPressed(KeyEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void keyReleased(KeyEvent arg0) {
						// TODO Auto-generated method stub

					TableRowSorter<DefaultTableModel> sort_search_mini = new TableRowSorter<DefaultTableModel>(model_mini);
					table_minibus.setRowSorter(sort_search_mini);
					sort_search_mini.setRowFilter(RowFilter.regexFilter(textField_search_Minibus.getText()));
						
					}

					@Override
					public void keyTyped(KeyEvent arg0) {
						// TODO Auto-generated method stub
						
					}});
			}
		});
		btnHireMinibus.setForeground(Color.WHITE);
		btnHireMinibus.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnHireMinibus.setBackground(new Color(51, 102, 102));
		btnHireMinibus.setBounds(744, 439, 188, 107);
		hire_vehicle.add(btnHireMinibus);
		
		JButton btn_Hire_Lorry_pic = new JButton("");
		btn_Hire_Lorry_pic.setIcon(new ImageIcon(Admin_menu.class.getResource("/application/Images/loo.png")));
		btn_Hire_Lorry_pic.setForeground(SystemColor.inactiveCaptionBorder);
		btn_Hire_Lorry_pic.setBorderPainted(false);
		btn_Hire_Lorry_pic.setBorder(null);
		btn_Hire_Lorry_pic.setBackground(new Color(95, 158, 160));
		btn_Hire_Lorry_pic.setBounds(630, 650, 102, 106);
		hire_vehicle.add(btn_Hire_Lorry_pic);
		
		JButton btnHireLorry = new JButton("HIRE LORRY");
		btnHireLorry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Remove_Previous_Panel();
				main_panel.add(hire_lorry);
				table_lorry = new JTable();
				table_lorry.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 15));
				DefaultTableCellRenderer centerRenderer_lorry = new DefaultTableCellRenderer();
				centerRenderer_lorry.setHorizontalAlignment( JLabel.CENTER );
				table_lorry.setDefaultRenderer(Object.class, centerRenderer_lorry);
				table_lorry.setModel(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Registration number", "Make Of Lorry", "Model Of Lorry", "Speed Of Lorry", "Daily Hire Rate", "Number Of Doors", "Weight Of Lorry", "Status Of Lorry"
					}
				));
				table_lorry.setRowHeight(30);
				table_lorry.setFont(new Font("Tahoma", Font.PLAIN, 18));
				scrollPane_lorry_table.setViewportView(table_lorry);
				 model_lorry=(DefaultTableModel)table_lorry.getModel();
				Object[] row_lorry=new Object[8];
				for(int i=0;i<lorry_list.size();i++){
					if(lorry_list.get(i).Vehicle_status.equals("Ready To Hire")){
					
					row_lorry[0]=lorry_list.get(i).getReg_number();
					row_lorry[1]=lorry_list.get(i).getMake_Vehicle();
					row_lorry[2]=lorry_list.get(i).getModel_Vehicle();
					row_lorry[3]=lorry_list.get(i).getSpeed_Vehicle();
					row_lorry[4]=lorry_list.get(i).getHire_Rate_Vehicle();
					row_lorry[5]=lorry_list.get(i).getNumber_doors();
					row_lorry[6]=lorry_list.get(i).getWeight_Lorry();
					row_lorry[7]=lorry_list.get(i).getVehicle_status();

					
					model_lorry.addRow(row_lorry);
				}
			}
				
				textField_search_Lorry.addKeyListener(new KeyListener(){

					@Override
					public void keyPressed(KeyEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void keyReleased(KeyEvent arg0) {
						// TODO Auto-generated method stub

					TableRowSorter<DefaultTableModel> sort_hire_lorry = new TableRowSorter<DefaultTableModel>(model_lorry);
					table_lorry.setRowSorter(sort_hire_lorry);
					sort_hire_lorry.setRowFilter(RowFilter.regexFilter(textField_search_Lorry.getText()));
						
					}

					@Override
					public void keyTyped(KeyEvent arg0) {
						// TODO Auto-generated method stub
						
					}});
			}
		});
		btnHireLorry.setForeground(Color.WHITE);
		btnHireLorry.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnHireLorry.setBackground(new Color(51, 102, 102));
		btnHireLorry.setBounds(744, 650, 188, 107);
		hire_vehicle.add(btnHireLorry);
		
		JLabel lblSelectTheVehicle_2 = new JLabel("Select the vehicle you want to Hire:");
		lblSelectTheVehicle_2.setForeground(Color.WHITE);
		lblSelectTheVehicle_2.setFont(new Font("Candara", Font.BOLD, 29));
		lblSelectTheVehicle_2.setBounds(32, 113, 517, 67);
		hire_vehicle.add(lblSelectTheVehicle_2);
		
		return_vehicle = new JPanel();
		return_vehicle.setLayout(null);
		return_vehicle.setBackground(new Color(95, 158, 160));
		main_panel.add(return_vehicle);
		
		JLabel lbl_return = new JLabel("Return Vehicle");
		lbl_return.setForeground(Color.WHITE);
		lbl_return.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 38));
		lbl_return.setBounds(709, 27, 293, 33);
		return_vehicle.add(lbl_return);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(Admin_menu.class.getResource("/application/Images/Webp.net-resizeimage.png")));
		button_1.setForeground(SystemColor.inactiveCaptionBorder);
		button_1.setBorderPainted(false);
		button_1.setBorder(null);
		button_1.setBackground(new Color(95, 158, 160));
		button_1.setBounds(709, 171, 102, 109);
		return_vehicle.add(button_1);
		
		JButton btnReturnCar = new JButton("RETURN CAR");
		btnReturnCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Remove_Previous_Panel();
				main_panel.add(return_car);
				
				table_car_return = new JTable();
				table_car_return.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 15));
				//table_car_hire.getTableHeader().setAlignmentX(alignmentX);
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment( JLabel.CENTER );
				table_car_return.setDefaultRenderer(Object.class, centerRenderer);
				table_car_return.setModel(new DefaultTableModel(
					
					null, new String[] {
														
						"Registeration Number Of Car","Customer Name","Customer Identification", "Make Of Car", "Type Of Vehicle", "Status Of Car"
					}
				));
				table_car_return.setRowHeight(30);
				table_car_return.setFont(new Font("Tahoma", Font.PLAIN, 18));
				scrollPane_return_car.setViewportView(table_car_return);
				model_return_car=(DefaultTableModel)table_car_return.getModel();
				
				setTable_ReturnCar();
			}
		});
		btnReturnCar.setForeground(Color.WHITE);
		btnReturnCar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReturnCar.setBackground(new Color(51, 102, 102));
		btnReturnCar.setBounds(824, 173, 231, 107);
		return_vehicle.add(btnReturnCar);
		
		JButton button_11 = new JButton("");
		button_11.setIcon(new ImageIcon(Admin_menu.class.getResource("/application/Images/hhhjk.png")));
		button_11.setForeground(SystemColor.inactiveCaptionBorder);
		button_11.setBorderPainted(false);
		button_11.setBorder(null);
		button_11.setBackground(new Color(95, 158, 160));
		button_11.setBounds(710, 393, 102, 106);
		return_vehicle.add(button_11);
		
		JButton btnReturnMinibus = new JButton("RETURN MINIBUS");
		btnReturnMinibus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Remove_Previous_Panel();
				main_panel.add(return_minibus);
				
				table_minibus_return = new JTable();
				table_minibus_return.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 15));
				//table_car_hire.getTableHeader().setAlignmentX(alignmentX);
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment( JLabel.CENTER );
				table_minibus_return.setDefaultRenderer(Object.class, centerRenderer);
				table_minibus_return.setModel(new DefaultTableModel(
					
					null, new String[] {
														
						"Registeration Number Of MiniBus","Customer Name","Customer Identification", "Make Of MiniBus", "Type Of Vehicle", "Status Of MiniBus"
					}
				));
				table_minibus_return.setRowHeight(30);
				table_minibus_return.setFont(new Font("Tahoma", Font.PLAIN, 18));
				scrollPane_return_MiniBus.setViewportView(table_minibus_return);
				model_return_minibus=(DefaultTableModel)table_minibus_return.getModel();
				
				setTable_ReturnMiniBus();
			}
		});
		btnReturnMinibus.setForeground(Color.WHITE);
		btnReturnMinibus.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReturnMinibus.setBackground(new Color(51, 102, 102));
		btnReturnMinibus.setBounds(824, 393, 231, 107);
		return_vehicle.add(btnReturnMinibus);
		
		JButton button_13 = new JButton("");
		button_13.setIcon(new ImageIcon(Admin_menu.class.getResource("/application/Images/loo.png")));
		button_13.setForeground(SystemColor.inactiveCaptionBorder);
		button_13.setBorderPainted(false);
		button_13.setBorder(null);
		button_13.setBackground(new Color(95, 158, 160));
		button_13.setBounds(710, 604, 102, 106);
		return_vehicle.add(button_13);
		
		JButton btnReturnLorry = new JButton("RETURN LORRY");
		btnReturnLorry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Remove_Previous_Panel();
				main_panel.add(return_lorry);
				
				table_lorry_return = new JTable();
				table_lorry_return.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 15));
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment( JLabel.CENTER );
				table_lorry_return.setDefaultRenderer(Object.class, centerRenderer);
				table_lorry_return.setModel(new DefaultTableModel(
					
					null, new String[] {
														
						"Registeration Number Of Lorry","Customer Name","Customer Identification", "Make Of Lorry", "Type Of Vehicle", "Status Of Lorry"
					}
				));
				table_lorry_return.setRowHeight(30);
				table_lorry_return.setFont(new Font("Tahoma", Font.PLAIN, 18));
				scrollPane_return_lorry.setViewportView(table_lorry_return);
				model_return_lorry=(DefaultTableModel)table_lorry_return.getModel();
				
				setTable_ReturnLorry();
			}
		});
		btnReturnLorry.setForeground(Color.WHITE);
		btnReturnLorry.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnReturnLorry.setBackground(new Color(51, 102, 102));
		btnReturnLorry.setBounds(824, 604, 231, 107);
		return_vehicle.add(btnReturnLorry);
		
		 view_vehicle = new JPanel();
		view_vehicle.setLayout(null);
		view_vehicle.setBackground(new Color(95, 158, 160));
		main_panel.add(view_vehicle);
		
		JLabel lbl_view_v = new JLabel("View Vehicle");
		lbl_view_v.setForeground(Color.WHITE);
		lbl_view_v.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 38));
		lbl_view_v.setBounds(669, 31, 231, 53);
		view_vehicle.add(lbl_view_v);
		
		JButton button_17 = new JButton("");
		button_17.setIcon(new ImageIcon(Admin_menu.class.getResource("/application/Images/Webp.net-resizeimage.png")));
		button_17.setForeground(SystemColor.inactiveCaptionBorder);
		button_17.setBorderPainted(false);
		button_17.setBorder(null);
		button_17.setBackground(new Color(95, 158, 160));
		button_17.setBounds(644, 172, 102, 109);
		view_vehicle.add(button_17);
		
		JButton btnViewCar = new JButton("VIEW CAR");
		btnViewCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				go_back_to_view_car();
			}
		});
		btnViewCar.setForeground(Color.WHITE);
		btnViewCar.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnViewCar.setBackground(new Color(51, 102, 102));
		btnViewCar.setBounds(759, 174, 206, 107);
		view_vehicle.add(btnViewCar);
		
		JButton button_29 = new JButton("");
		button_29.setIcon(new ImageIcon(Admin_menu.class.getResource("/application/Images/hhhjk.png")));
		button_29.setForeground(SystemColor.inactiveCaptionBorder);
		button_29.setBorderPainted(false);
		button_29.setBorder(null);
		button_29.setBackground(new Color(95, 158, 160));
		button_29.setBounds(645, 394, 102, 106);
		view_vehicle.add(button_29);
		
		JButton btnViewMinibus = new JButton("VIEW MINIBUS");
		btnViewMinibus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				go_back_to_view_minibus();
			}
		});
		btnViewMinibus.setForeground(Color.WHITE);
		btnViewMinibus.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnViewMinibus.setBackground(new Color(51, 102, 102));
		btnViewMinibus.setBounds(759, 394, 206, 107);
		view_vehicle.add(btnViewMinibus);
		
		JButton button_31 = new JButton("");
		button_31.setIcon(new ImageIcon(Admin_menu.class.getResource("/application/Images/loo.png")));
		button_31.setForeground(SystemColor.inactiveCaptionBorder);
		button_31.setBorderPainted(false);
		button_31.setBorder(null);
		button_31.setBackground(new Color(95, 158, 160));
		button_31.setBounds(645, 605, 102, 106);
		view_vehicle.add(button_31);
		
		JButton btnViewLorry = new JButton("VIEW LORRY");
		btnViewLorry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				go_back_to_view_lorry();
			}
		});
		btnViewLorry.setForeground(Color.WHITE);
		btnViewLorry.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnViewLorry.setBackground(new Color(51, 102, 102));
		btnViewLorry.setBounds(759, 605, 206, 107);
		view_vehicle.add(btnViewLorry);
		
		 add_customer = new JPanel();
		add_customer.setLayout(null);
		add_customer.setBackground(new Color(95, 158, 160));
		main_panel.add(add_customer);
		
		JLabel lblAddCustomer_1 = new JLabel("ADD CUSTOMER");
		lblAddCustomer_1.setForeground(Color.WHITE);
		lblAddCustomer_1.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 38));
		lblAddCustomer_1.setBounds(668, 40, 265, 47);
		add_customer.add(lblAddCustomer_1);
		
		JLabel label_1 = new JLabel("First Name:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_1.setBounds(94, 212, 101, 40);
		add_customer.add(label_1);
		
		text_firstname = new JTextField();
		text_firstname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_firstname.setColumns(10);
		text_firstname.setBounds(207, 213, 234, 40);
		add_customer.add(text_firstname);
		
		JLabel label_2 = new JLabel("Last Name:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_2.setBounds(586, 212, 101, 40);
		add_customer.add(label_2);
		
		text_lastname = new JTextField();
		text_lastname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_lastname.setColumns(10);
		text_lastname.setBounds(699, 212, 234, 40);
		add_customer.add(text_lastname);
		
		JLabel label_3 = new JLabel("Identification Number:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_3.setBounds(1105, 212, 193, 40);
		add_customer.add(label_3);
		
		text_idnumber = new JTextField();
		text_idnumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		text_idnumber.setColumns(10);
		text_idnumber.setBounds(1310, 215, 214, 40);
		add_customer.add(text_idnumber);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPhoneNumber.setBounds(49, 393, 146, 40);
		add_customer.add(lblPhoneNumber);
		
		text_phonenumber = new JTextField();
		text_phonenumber.setFont(new Font("Dialog", Font.PLAIN, 18));
		text_phonenumber.setColumns(10);
		text_phonenumber.setBounds(207, 394, 234, 40);
		add_customer.add(text_phonenumber);
		
		JLabel lblEmailAddress = new JLabel("E-mail Address:");
		lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEmailAddress.setBounds(556, 393, 131, 40);
		add_customer.add(lblEmailAddress);
		
		text_email = new JTextField();
		text_email.setFont(new Font("Dialog", Font.PLAIN, 18));
		text_email.setColumns(10);
		text_email.setBounds(699, 393, 234, 40);
		add_customer.add(text_email);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth:");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDateOfBirth.setBounds(1172, 393, 125, 40);
		add_customer.add(lblDateOfBirth);
		
		text_dateofbirth = new JTextField();
		text_dateofbirth.setFont(new Font("Dialog", Font.PLAIN, 18));
		text_dateofbirth.setColumns(10);
		text_dateofbirth.setBounds(1310, 396, 214, 40);
		add_customer.add(text_dateofbirth);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblPassword.setBounds(595, 591, 92, 40);
		add_customer.add(lblPassword);
		
		text_username = new JTextField();
		text_username.setFont(new Font("Dialog", Font.PLAIN, 18));
		text_username.setColumns(10);
		text_username.setBounds(207, 592, 234, 40);
		add_customer.add(text_username);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblUsername.setBounds(94, 591, 101, 40);
		add_customer.add(lblUsername);
		
		JButton btnAddCustomer = new JButton("Add Customer");
		btnAddCustomer.setForeground(Color.WHITE);
		btnAddCustomer.setBackground(new Color(51, 102, 102));
		btnAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(text_address.getText().isEmpty() || text_username.getText().isEmpty() || text_dateofbirth.getText().isEmpty() || text_email.getText().isEmpty() || 
				   text_password.getPassword().toString().isEmpty() || text_idnumber.getText().isEmpty() || text_phonenumber.getText().isEmpty()|| text_firstname.getText().isEmpty()
				   || text_lastname.getText().isEmpty()){
					
					JOptionPane.showMessageDialog(null, "Some Details of customers are Empty","ERROR",JOptionPane.ERROR_MESSAGE);
					
				}
				else{
					//Car car=new Car()
					customer_list.add(new Customer(text_firstname.getText(),text_lastname.getText(),text_idnumber.getText(),text_phonenumber.getText(),text_email.getText(),
							text_dateofbirth.getText(),text_username.getText(),text_password.getPassword().toString(),text_address.getText()));
					
					try {
						
						FileOutputStream fos = new FileOutputStream("customer.dat");
						ObjectOutputStream oos = new ObjectOutputStream(fos);
			
						for (int i = 0; i < customer_list.size( ); i++)
				      	{ // write one object
							customer = (Customer) customer_list.get(i);
				      		oos.writeObject(customer); // this one line writes an entire object!!!!
				      	} 
						oos.close();
						
						} catch (EOFException ex) { //This exception will be caught when EOF is reached
						 System.out.println("End of file reached.");
						 } catch (FileNotFoundException ex) {
						 ex.printStackTrace();
						 } catch (IOException ex) {
						 ex.printStackTrace();
						 } 
					text_address.setText("");
					text_username.setText("");
					text_dateofbirth.setText("");
					text_email.setText("");
					text_password.setText("");
					text_idnumber.setText("");
					text_phonenumber.setText("");
					text_firstname.setText("");
					text_lastname.setText("");
					
				}
			}
		});
		btnAddCustomer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddCustomer.setBounds(790, 746, 159, 47);
		add_customer.add(btnAddCustomer);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAddress.setBounds(1205, 591, 93, 40);
		add_customer.add(lblAddress);
		
		text_address = new JTextField();
		text_address.setFont(new Font("Dialog", Font.PLAIN, 18));
		text_address.setColumns(10);
		text_address.setBounds(1309, 592, 215, 40);
		add_customer.add(text_address);
		
		text_password = new JPasswordField();
		text_password.setBounds(699, 591, 234, 40);
		add_customer.add(text_password);
		
		JButton btnExit_1 = new JButton("Exit");
		btnExit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.exit(0);
			}
		});
		btnExit_1.setForeground(Color.WHITE);
		btnExit_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExit_1.setBackground(new Color(51, 102, 102));
		btnExit_1.setBounds(989, 746, 159, 47);
		add_customer.add(btnExit_1);
		
		view_customer = new JPanel();
		view_customer.setLayout(null);
		view_customer.setBackground(new Color(95, 158, 160));
		main_panel.add(view_customer);
		
		JLabel lbl_view_customer = new JLabel("View Customer");
		lbl_view_customer.setForeground(Color.WHITE);
		lbl_view_customer.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 38));
		lbl_view_customer.setBounds(709, 27, 243, 40);
		view_customer.add(lbl_view_customer);
		
		
		
		JButton button_40 = new JButton("< Back");
		button_40.setBackground(new Color(51, 102, 102));
		button_40.setForeground(Color.WHITE);
		button_40.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_40.setBounds(480, 763, 159, 47);
		view_customer.add(button_40);
		
		JButton btnViewCustomer = new JButton("View Customer");
		btnViewCustomer.setBackground(new Color(51, 102, 102));
		btnViewCustomer.setForeground(Color.WHITE);
		btnViewCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(table_customer_view.getSelectionModel().isSelectionEmpty()){
		            JOptionPane.showMessageDialog(null, "No Row is Selected","ERROR",JOptionPane.ERROR_MESSAGE);
		            

				}
				else{
					Remove_Previous_Panel();
					main_panel.add(customer_details_show);
					int select_view_customer =table_customer_view.getSelectedRow();
					String view_lorry_state;
					customer_reg_view=(String) model_customer_view.getValueAt(select_view_customer, 0);
					//view_lorry_state=(String) model_customer_view.getValueAt(select_view_customer, 7);
					for(int i=0;i<customer_list.size();i++){
						if(customer_list.get(i).Id_number.equals(customer_reg_view)){
							
							lbl_customer_id.setText(customer_list.get(i).Id_number);
							lbl_customer_first.setText(customer_list.get(i).First_name);
							lbl_customer_last.setText(customer_list.get(i).Last_name);
							lbl_customer_username.setText(customer_list.get(i).User_name);
							lbl_customer_phone.setText(customer_list.get(i).Phone_number);
							lbl_customer_email.setText(customer_list.get(i).Email);
							lbl_customer_address.setText(customer_list.get(i).Address);
							lbl_customer_birth.setText(customer_list.get(i).Date_of_birth);
							lbl_customer_password.setText(customer_list.get(i).Password.toString());

								
//							for(int u=0;u<hired_vehicle_list.size();u++){
//								
//								
//								if(hired_vehicle_list.get(i).Customer_Reg_No.equals(customer_reg_view)){
////									lbl_lorry_status.setText("Hired");
////									lbl_lorry_customer.setText(hired_vehicle_list.get(u).Customer_Name);
////									lbl_lorry_customer_reg.setText(hired_vehicle_list.get(u).Customer_Reg_No);
//									btnShowHiredVehicle.setVisible(true);
//
//
//									
//								}
//							}
							
							
						
							






						}
						
					}

			}
			}
		});
		btnViewCustomer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnViewCustomer.setBounds(778, 763, 159, 47);
		view_customer.add(btnViewCustomer);
		
		JButton button_42 = new JButton("Exit");
		button_42.setBackground(new Color(51, 102, 102));
		button_42.setForeground(Color.WHITE);
		button_42.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_42.setBounds(1073, 763, 159, 47);
		view_customer.add(button_42);
		
		 scrollPane_customer_view = new JScrollPane();
		scrollPane_customer_view.setBounds(46, 192, 1497, 526);
		view_customer.add(scrollPane_customer_view);
		
		JLabel lblSelectTheCustomer = new JLabel("Select the customer you want to View:");
		lblSelectTheCustomer.setForeground(Color.WHITE);
		lblSelectTheCustomer.setFont(new Font("Candara", Font.BOLD, 29));
		lblSelectTheCustomer.setBounds(46, 88, 517, 67);
		view_customer.add(lblSelectTheCustomer);
		
		JLabel lblRegistrationNumber = new JLabel("Registration Number:");
		lblRegistrationNumber.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblRegistrationNumber.setBounds(30, 236, 207, 40);
		add_car_panel.add(lblRegistrationNumber);
		
		textfield_Car_Reg_No = new JTextField();
		textfield_Car_Reg_No.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textfield_Car_Reg_No.setColumns(10);
		textfield_Car_Reg_No.setBounds(249, 237, 234, 40);
		add_car_panel.add(textfield_Car_Reg_No);
		
		JLabel lblTopSpeed = new JLabel("Top Speed :");
		lblTopSpeed.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblTopSpeed.setBounds(114, 441, 123, 40);
		add_car_panel.add(lblTopSpeed);
		
		textfield_Speed_Car = new JTextField();
		textfield_Speed_Car.setFont(new Font("Dialog", Font.PLAIN, 18));
		textfield_Speed_Car.setColumns(10);
		textfield_Speed_Car.setBounds(249, 442, 234, 40);
		add_car_panel.add(textfield_Speed_Car);
		
		JLabel lblMakeOfCar = new JLabel("Make of Car :");
		lblMakeOfCar.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblMakeOfCar.setBounds(560, 236, 131, 40);
		add_car_panel.add(lblMakeOfCar);
		
		textfield_Make_Car = new JTextField();
		textfield_Make_Car.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textfield_Make_Car.setColumns(10);
		textfield_Make_Car.setBounds(703, 237, 240, 40);
		add_car_panel.add(textfield_Make_Car);
		
		JLabel lblModelOfCar = new JLabel("Model of Car :");
		lblModelOfCar.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblModelOfCar.setBounds(1125, 236, 144, 40);
		add_car_panel.add(lblModelOfCar);
		
		JLabel lblDailyHireRate = new JLabel("Daily Hire Rate :");
		lblDailyHireRate.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblDailyHireRate.setBounds(532, 441, 159, 40);
		add_car_panel.add(lblDailyHireRate);
		
		textfield_Hire_Rate = new JTextField();
		textfield_Hire_Rate.setFont(new Font("Dialog", Font.PLAIN, 18));
		textfield_Hire_Rate.setColumns(10);
		textfield_Hire_Rate.setBounds(703, 442, 245, 40);
		add_car_panel.add(textfield_Hire_Rate);
		
		JLabel lblFuelType = new JLabel("Fuel Type:");
		lblFuelType.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblFuelType.setBounds(104, 615, 106, 40);
		add_car_panel.add(lblFuelType);
		
		textfield_Model_Car = new JTextField();
		textfield_Model_Car.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textfield_Model_Car.setColumns(10);
		textfield_Model_Car.setBounds(1281, 237, 240, 40);
		add_car_panel.add(textfield_Model_Car);
		
		JLabel lblNumberOfDoors = new JLabel("Number of Doors :");
		lblNumberOfDoors.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNumberOfDoors.setBounds(1087, 441, 176, 40);
		add_car_panel.add(lblNumberOfDoors);
		
		textfield_Number_Doors = new JTextField();
		textfield_Number_Doors.setFont(new Font("Dialog", Font.PLAIN, 18));
		textfield_Number_Doors.setColumns(10);
		textfield_Number_Doors.setBounds(1281, 442, 240, 40);
		add_car_panel.add(textfield_Number_Doors);
		
		group=new ButtonGroup();
		JRadioButton radio_btn_Diesel = new JRadioButton("Diesel");
		radio_btn_Diesel.setBackground(new Color(95, 158, 160));
		radio_btn_Diesel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		radio_btn_Diesel.setBounds(236, 624, 106, 25);
		add_car_panel.add(radio_btn_Diesel);
		
		JRadioButton radio_btn_Petrol = new JRadioButton("Petrol");
		radio_btn_Petrol.setBackground(new Color(95, 158, 160));
		radio_btn_Petrol.setFont(new Font("Tahoma", Font.PLAIN, 19));
		radio_btn_Petrol.setBounds(373, 624, 91, 25);
		add_car_panel.add(radio_btn_Petrol);
		
		group.add(radio_btn_Petrol);
		group.add(radio_btn_Diesel);
		
		JButton btn_Add_Car_Data = new JButton("Add Car");
		btn_Add_Car_Data.setForeground(Color.WHITE);
		btn_Add_Car_Data.setBackground(new Color(51, 102, 102));
		btn_Add_Car_Data.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent event) {//When Add Car button is pressed
		                                   // Validation of TextFields for adding cars
				if(textfield_Car_Reg_No.getText().isEmpty() || textfield_Make_Car.getText().isEmpty() || textfield_Model_Car.getText().isEmpty() || textfield_Speed_Car.getText().isEmpty()
						|| textfield_Hire_Rate.getText().isEmpty() || textfield_Number_Doors.getText().isEmpty()	){					
					System.out.println("Empty");					
             JOptionPane.showMessageDialog(null, "Some Details are Empty","ERROR",JOptionPane.ERROR_MESSAGE);
				}
				else{
					for(int j=0;j<vehicle_list.size();j++){
						
						if(vehicle_list.get(j).Reg_number.equals(textfield_Car_Reg_No.getText())){
				             JOptionPane.showMessageDialog(null, "Car with same registration number has already in the system","ERROR",JOptionPane.ERROR_MESSAGE);
				            // Remove_Previous_Panel();
								main_panel.add(add_car_panel);
								textfield_Speed_Car.setText("");
								textfield_Hire_Rate.setText("");
								textfield_Number_Doors.setText("");
								textfield_Car_Reg_No.setText("");
								textfield_Model_Car.setText("");
								textfield_Make_Car.setText("");




						}
						else{
							
					//	kl
					
					String gen="" ;					
					if(radio_btn_Diesel.isSelected()){						
						  gen=radio_btn_Diesel.getText();
					}					
					else if(radio_btn_Petrol.isSelected()){						
						 gen=	radio_btn_Petrol.getText();
					}					
					double speed_car=Double.parseDouble(textfield_Speed_Car.getText());
					double car_hire_rate=Double.parseDouble(textfield_Hire_Rate.getText());
                   int car_doors=Integer.parseInt(textfield_Number_Doors.getText());
                   String veh_type="Car";
                   String veh_status="Ready To Hire";
          vehicle_list.add(new Car(textfield_Car_Reg_No.getText(),textfield_Make_Car.getText(),textfield_Model_Car.getText(),speed_car,car_hire_rate,car_doors,gen,veh_type,veh_status));							
									try {									
									FileOutputStream fos = new FileOutputStream("vehicle.dat");
									ObjectOutputStream oos = new ObjectOutputStream(fos);					
									for (int i = 0; i < vehicle_list.size( ); i++)
							      	{ // write one object
										car = (Car) vehicle_list.get(i);
							      		oos.writeObject(car); // this one line writes an entire object!!!!
							      	} 
									oos.close();
									} catch (EOFException ex) { //This exception will be caught when EOF is reached
									 System.out.println("End of file reached.");
									 } catch (FileNotFoundException ex) {
									 ex.printStackTrace();
									 } catch (IOException ex) {
									 ex.printStackTrace();
									 } 									
						             JOptionPane.showConfirmDialog(null, "Car Has Been Added Into Fleet","Confirm", JOptionPane.CLOSED_OPTION);
						             
						         	main_panel.add(add_car_panel);
									textfield_Speed_Car.setText("");
									textfield_Hire_Rate.setText("");
									textfield_Number_Doors.setText("");
									textfield_Car_Reg_No.setText("");
									textfield_Model_Car.setText("");
									textfield_Make_Car.setText("");
				}
						break;
					}
				}
				
				
			
			}
		});
		btn_Add_Car_Data.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_Add_Car_Data.setBounds(780, 736, 159, 47);
		add_car_panel.add(btn_Add_Car_Data);
		
		
		
		JButton btn_Back_Car = new JButton("< Back");
		btn_Back_Car.setForeground(Color.WHITE);
		btn_Back_Car.setBackground(new Color(51, 102, 102));
		btn_Back_Car.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Remove_Previous_Panel();
				main_panel.add(add_vehicle);

			}
		});
		btn_Back_Car.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_Back_Car.setBounds(482, 736, 159, 47);
		add_car_panel.add(btn_Back_Car);
		
		JButton btn_Exit = new JButton("Exit");
		btn_Exit.setForeground(Color.WHITE);
		btn_Exit.setBackground(new Color(51, 102, 102));
		btn_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		btn_Exit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_Exit.setBounds(1075, 736, 159, 47);
		add_car_panel.add(btn_Exit);
		
		JLabel lblAddCar = new JLabel("ADD CAR");
		lblAddCar.setForeground(Color.WHITE);
		lblAddCar.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 38));
		lblAddCar.setBounds(696, 24, 144, 47);
		add_car_panel.add(lblAddCar);
		
		JLabel lblFillDetails = new JLabel("Fill Details : ");
		lblFillDetails.setForeground(Color.WHITE);
		lblFillDetails.setFont(new Font("Candara", Font.BOLD, 30));
		lblFillDetails.setBounds(34, 106, 176, 67);
		add_car_panel.add(lblFillDetails);
		
		textfield_MiniBus_Reg_No = new JTextField();
		textfield_MiniBus_Reg_No.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textfield_MiniBus_Reg_No.setColumns(10);
		textfield_MiniBus_Reg_No.setBounds(227, 227, 234, 40);
		textfield_Make_MiniBus.add(textfield_MiniBus_Reg_No);
		
		JLabel label_4 = new JLabel("Registration Number:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_4.setBounds(30, 226, 185, 40);
		textfield_Make_MiniBus.add(label_4);
		
		JLabel lblMakeOfMinibus = new JLabel("Make of MiniBus :");
		lblMakeOfMinibus.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblMakeOfMinibus.setBounds(532, 226, 159, 40);
		textfield_Make_MiniBus.add(lblMakeOfMinibus);
		
		textField_Make_MiniBus = new JTextField();
		textField_Make_MiniBus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_Make_MiniBus.setColumns(10);
		textField_Make_MiniBus.setBounds(703, 227, 240, 40);
		textfield_Make_MiniBus.add(textField_Make_MiniBus);
		
		JLabel label_6 = new JLabel("Top Speed :");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_6.setBounds(106, 442, 112, 40);
		textfield_Make_MiniBus.add(label_6);
		
		textfield_Speed_MiniBus = new JTextField();
		textfield_Speed_MiniBus.setFont(new Font("Dialog", Font.PLAIN, 18));
		textfield_Speed_MiniBus.setColumns(10);
		textfield_Speed_MiniBus.setBounds(230, 443, 234, 40);
		textfield_Make_MiniBus.add(textfield_Speed_MiniBus);
		
		JLabel label_8 = new JLabel("Daily Hire Rate :");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_8.setBounds(550, 442, 144, 40);
		textfield_Make_MiniBus.add(label_8);
		
		textfield_Hire_Rate_MiniBus = new JTextField();
		textfield_Hire_Rate_MiniBus.setFont(new Font("Dialog", Font.PLAIN, 18));
		textfield_Hire_Rate_MiniBus.setColumns(10);
		textfield_Hire_Rate_MiniBus.setBounds(706, 443, 245, 40);
		textfield_Make_MiniBus.add(textfield_Hire_Rate_MiniBus);
		
		JLabel lblSeatingCapacity = new JLabel("Seating Capacity :");
		lblSeatingCapacity.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblSeatingCapacity.setBounds(53, 632, 165, 40);
		textfield_Make_MiniBus.add(lblSeatingCapacity);
		
		JLabel lblModelOfMinibus = new JLabel("Model of MiniBus :");
		lblModelOfMinibus.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblModelOfMinibus.setBounds(1104, 226, 165, 40);
		textfield_Make_MiniBus.add(lblModelOfMinibus);
		
		textfield_Model_MiniBus = new JTextField();
		textfield_Model_MiniBus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textfield_Model_MiniBus.setColumns(10);
		textfield_Model_MiniBus.setBounds(1281, 227, 240, 40);
		textfield_Make_MiniBus.add(textfield_Model_MiniBus);
		
		JLabel label_11 = new JLabel("Number of Doors :");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_11.setBounds(1107, 442, 159, 40);
		textfield_Make_MiniBus.add(label_11);
		
		textfield_Number_Doors_MiniBus = new JTextField();
		textfield_Number_Doors_MiniBus.setFont(new Font("Dialog", Font.PLAIN, 18));
		textfield_Number_Doors_MiniBus.setColumns(10);
		textfield_Number_Doors_MiniBus.setBounds(1284, 443, 240, 40);
		textfield_Make_MiniBus.add(textfield_Number_Doors_MiniBus);
		
		JButton btn_Add_MiniBus = new JButton("Add MiniBus");
		btn_Add_MiniBus.setBackground(new Color(51, 102, 102));
		btn_Add_MiniBus.setForeground(Color.WHITE);
		btn_Add_MiniBus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// When Add MiniBus button is pressed
				
				
			                // Validation of TextFields for MiniBus cars
			if(textfield_MiniBus_Reg_No.getText().isEmpty() || textField_Make_MiniBus.getText().isEmpty() || textfield_Model_MiniBus.getText().isEmpty() || textfield_Speed_MiniBus.getText().isEmpty()
					|| textfield_Hire_Rate_MiniBus.getText().isEmpty() || textfield_Number_Doors_MiniBus.getText().isEmpty() || textfield_Seat_Capacity_MiniBus.getText().isEmpty()	){
				
				System.out.println("EMpty");
				
			JOptionPane.showMessageDialog(null, "Details for addding MiniBus are Empty","ERROR",JOptionPane.ERROR_MESSAGE);

			}
			else{
				for(int j=0;j<minibus_list.size();j++){
					
					if(minibus_list.get(j).Reg_number.equals(textfield_MiniBus_Reg_No.getText())){
						
						 JOptionPane.showMessageDialog(null, "MiniBus with same registration number has already in the system","ERROR",JOptionPane.ERROR_MESSAGE);
			           
						 textfield_Speed_MiniBus.setText("");
						 textfield_Hire_Rate_MiniBus.setText("");
						 textfield_Number_Doors_MiniBus.setText("");
						 textfield_Seat_Capacity_MiniBus.setText("");
						 textfield_MiniBus_Reg_No.setText("");
						 textField_Make_MiniBus.setText("");
						 textfield_Model_MiniBus.setText("");

					}
					else{
					
				double speed_minibus=Double.parseDouble(textfield_Speed_MiniBus.getText());
				double hire_minibus=Double.parseDouble(textfield_Hire_Rate_MiniBus.getText());
				int number_door_minibus=Integer.parseInt(textfield_Number_Doors_MiniBus.getText());
				int minibus_seat_capacity=Integer.parseInt(textfield_Seat_Capacity_MiniBus.getText());
				String veh_type="MiniBus";
				String veh_status="Ready To Hire";
				
				minibus_list.add(new MiniBus(textfield_MiniBus_Reg_No.getText(),textField_Make_MiniBus.getText(),textfield_Model_MiniBus.getText(),speed_minibus,
			hire_minibus,number_door_minibus,minibus_seat_capacity,veh_type,veh_status));
				
				

				try {
				
				FileOutputStream fos = new FileOutputStream("minibus.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
	
				for (int i = 0; i < minibus_list.size( ); i++)
		      	{ // write one object
					mini = (MiniBus) minibus_list.get(i);
		      		oos.writeObject(mini); // this one line writes an entire object!!!!
		      	} 
				oos.close();

				} catch (EOFException ex) { //This exception will be caught when EOF is reached
				 System.out.println("End of file reached.");
				 } catch (FileNotFoundException ex) {
				 ex.printStackTrace();
				 } catch (IOException ex) {
				 ex.printStackTrace();
				 }
		        JOptionPane.showConfirmDialog(null, "MiniBus Has Been Added Into Fleet","Confirm", JOptionPane.CLOSED_OPTION);
		        
		        textfield_Speed_MiniBus.setText("");
				 textfield_Hire_Rate_MiniBus.setText("");
				 textfield_Number_Doors_MiniBus.setText("");
				 textfield_Seat_Capacity_MiniBus.setText("");
				 textfield_MiniBus_Reg_No.setText("");
				 textField_Make_MiniBus.setText("");
				 textfield_Model_MiniBus.setText("");

			}
					break;
			}
			
			}
							
						}
					});
					btn_Add_MiniBus.setFont(new Font("Tahoma", Font.PLAIN, 18));
					btn_Add_MiniBus.setBounds(781, 752, 159, 47);
					textfield_Make_MiniBus.add(btn_Add_MiniBus);
					
					textfield_Seat_Capacity_MiniBus = new JTextField();
					textfield_Seat_Capacity_MiniBus.setFont(new Font("Dialog", Font.PLAIN, 18));
					textfield_Seat_Capacity_MiniBus.setColumns(10);
					textfield_Seat_Capacity_MiniBus.setBounds(230, 633, 234, 40);
					textfield_Make_MiniBus.add(textfield_Seat_Capacity_MiniBus);
					
					JButton back_btn_again2 = new JButton("< Back");
					back_btn_again2.setBackground(new Color(51, 102, 102));
					back_btn_again2.setForeground(Color.WHITE);
					back_btn_again2.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							Remove_Previous_Panel();
							main_panel.add(add_vehicle);
			
						}
		});
		back_btn_again2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		back_btn_again2.setBounds(512, 752, 159, 47);
		textfield_Make_MiniBus.add(back_btn_again2);
		
		JButton button_6 = new JButton("Exit");
		button_6.setBackground(new Color(51, 102, 102));
		button_6.setForeground(Color.WHITE);
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_6.setBounds(1105, 752, 159, 47);
		textfield_Make_MiniBus.add(button_6);
		
		JLabel label_7 = new JLabel("Fill Details : ");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Candara", Font.BOLD, 30));
		label_7.setBounds(72, 105, 176, 67);
		textfield_Make_MiniBus.add(label_7);
		
		JLabel lblAddMinibus = new JLabel("ADD MINIBUS");
		lblAddMinibus.setForeground(Color.WHITE);
		lblAddMinibus.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 38));
		lblAddMinibus.setBounds(734, 23, 234, 47);
		textfield_Make_MiniBus.add(lblAddMinibus);
		
		JLabel label_5 = new JLabel("Registration Number:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_5.setBounds(29, 226, 185, 40);
		add_lorry_panel.add(label_5);
		
		textfield_Lorry_Reg_No = new JTextField();
		textfield_Lorry_Reg_No.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textfield_Lorry_Reg_No.setColumns(10);
		textfield_Lorry_Reg_No.setBounds(226, 227, 234, 40);
		add_lorry_panel.add(textfield_Lorry_Reg_No);
		
		JLabel lblMakeOfLorry = new JLabel("Make of Lorry :");
		lblMakeOfLorry.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblMakeOfLorry.setBounds(553, 226, 137, 40);
		add_lorry_panel.add(lblMakeOfLorry);
		
		textfield_Make_Lorry = new JTextField();
		textfield_Make_Lorry.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textfield_Make_Lorry.setColumns(10);
		textfield_Make_Lorry.setBounds(702, 227, 240, 40);
		add_lorry_panel.add(textfield_Make_Lorry);
		
		JLabel label_9 = new JLabel("Top Speed :");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_9.setBounds(102, 443, 112, 40);
		add_lorry_panel.add(label_9);
		
		textfield_Top_Speed_Lorry = new JTextField();
		textfield_Top_Speed_Lorry.setFont(new Font("Dialog", Font.PLAIN, 18));
		textfield_Top_Speed_Lorry.setColumns(10);
		textfield_Top_Speed_Lorry.setBounds(226, 444, 234, 40);
		add_lorry_panel.add(textfield_Top_Speed_Lorry);
		
		JLabel label_10 = new JLabel("Daily Hire Rate :");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_10.setBounds(546, 443, 144, 40);
		add_lorry_panel.add(label_10);
		
		textfield_Daily_Rate_Lorry = new JTextField();
		textfield_Daily_Rate_Lorry.setFont(new Font("Dialog", Font.PLAIN, 18));
		textfield_Daily_Rate_Lorry.setColumns(10);
		textfield_Daily_Rate_Lorry.setBounds(702, 444, 245, 40);
		add_lorry_panel.add(textfield_Daily_Rate_Lorry);
		
		JLabel lblLoadWeight = new JLabel("Load Weight :");
		lblLoadWeight.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblLoadWeight.setBounds(77, 650, 137, 40);
		add_lorry_panel.add(lblLoadWeight);
		
		textfield_Load_Weight_Lorry = new JTextField();
		textfield_Load_Weight_Lorry.setFont(new Font("Dialog", Font.PLAIN, 18));
		textfield_Load_Weight_Lorry.setColumns(10);
		textfield_Load_Weight_Lorry.setBounds(226, 651, 234, 40);
		add_lorry_panel.add(textfield_Load_Weight_Lorry);
		
		JButton btn_Add_Lorry_Details = new JButton("Add Lorry");
		btn_Add_Lorry_Details.setBackground(new Color(51, 102, 102));
		btn_Add_Lorry_Details.setForeground(Color.WHITE);
		btn_Add_Lorry_Details.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
						// When Add MiniBus button is pressed
						
						
		                // Validation of TextFields for Lorry
		if(textfield_Lorry_Reg_No.getText().isEmpty() || textfield_Make_Lorry.getText().isEmpty() || textfield_Model_Lorry.getText().isEmpty() || textfield_Top_Speed_Lorry.getText().isEmpty()
				|| textfield_Daily_Rate_Lorry.getText().isEmpty() || textfield_Lorry_Number_Doors.getText().isEmpty() || textfield_Load_Weight_Lorry.getText().isEmpty()	){
			
			System.out.println("EMpty");
			
		JOptionPane.showMessageDialog(null, "Details for addding Lorry are Empty","ERROR",JOptionPane.ERROR_MESSAGE);
		
		}
		else{	
			for(int j=0;j<lorry_list.size();j++){
				
				if(lorry_list.get(j).Reg_number.equals(textfield_Lorry_Reg_No.getText())){
					
					 JOptionPane.showMessageDialog(null, "Lorry with same registration number has already in the system","ERROR",JOptionPane.ERROR_MESSAGE);
		           //  Remove_Previous_Panel();
						//main_panel.add(add_mini_panel);
		             textfield_Top_Speed_Lorry.setText("");
		             textfield_Daily_Rate_Lorry.setText("");
		             textfield_Lorry_Number_Doors.setText("");
		             textfield_Load_Weight_Lorry.setText("");
		             textfield_Lorry_Reg_No.setText("");
		             textfield_Make_Lorry.setText("");
		             textfield_Model_Lorry.setText("");

				}
				else{
					
			
			double speed_lorry=Double.parseDouble(textfield_Top_Speed_Lorry.getText());
			double hire_lorry=Double.parseDouble(textfield_Daily_Rate_Lorry.getText());
			int number_door_lorry=Integer.parseInt(textfield_Lorry_Number_Doors.getText());
			double load_weight_lorry=Double.parseDouble(textfield_Load_Weight_Lorry.getText());
			String veh_type="Lorry";
			String veh_status="Ready To Hire";
			
		 lorry_list.add(new Lorry(textfield_Lorry_Reg_No.getText(),textfield_Make_Lorry.getText(),textfield_Model_Lorry.getText(),speed_lorry,
				hire_lorry,number_door_lorry,load_weight_lorry,veh_type,veh_status));
		
		try {
			
			FileOutputStream fos = new FileOutputStream("lorry.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			for (int i = 0; i < lorry_list.size( ); i++)
	      	{ // write one object
				lorry = (Lorry) lorry_list.get(i);
	      		oos.writeObject(lorry); // this one line writes an entire object!!!!
	      	} 
			oos.close();

			} catch (EOFException ex) { //This exception will be caught when EOF is reached
			 System.out.println("End of file reached.");
			 } catch (FileNotFoundException ex) {
			 ex.printStackTrace();
			 } catch (IOException ex) {
			 ex.printStackTrace();
			 } 
        JOptionPane.showConfirmDialog(null, "Lorry Has Been Added Into Fleet","Confirm", JOptionPane.CLOSED_OPTION);
        textfield_Top_Speed_Lorry.setText("");
        textfield_Daily_Rate_Lorry.setText("");
        textfield_Lorry_Number_Doors.setText("");
        textfield_Load_Weight_Lorry.setText("");
        textfield_Lorry_Reg_No.setText("");
        textfield_Make_Lorry.setText("");
        textfield_Model_Lorry.setText("");

		
		}
				
				break;
			}
		}
			}
		});
		btn_Add_Lorry_Details.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_Add_Lorry_Details.setBounds(779, 762, 159, 47);
		add_lorry_panel.add(btn_Add_Lorry_Details);
		
		JLabel lblModelOfLorry = new JLabel("Model of Lorry :");
		lblModelOfLorry.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblModelOfLorry.setBounds(1103, 226, 165, 40);
		add_lorry_panel.add(lblModelOfLorry);
		
		textfield_Model_Lorry = new JTextField();
		textfield_Model_Lorry.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textfield_Model_Lorry.setColumns(10);
		textfield_Model_Lorry.setBounds(1280, 227, 240, 40);
		add_lorry_panel.add(textfield_Model_Lorry);
		
		JLabel label_14 = new JLabel("Number of Doors :");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label_14.setBounds(1103, 443, 159, 40);
		add_lorry_panel.add(label_14);
		
		textfield_Lorry_Number_Doors = new JTextField();
		textfield_Lorry_Number_Doors.setFont(new Font("Dialog", Font.PLAIN, 18));
		textfield_Lorry_Number_Doors.setColumns(10);
		textfield_Lorry_Number_Doors.setBounds(1280, 444, 240, 40);
		add_lorry_panel.add(textfield_Lorry_Number_Doors);
		
		JButton back_btn = new JButton("< Back");
		back_btn.setBackground(new Color(51, 102, 102));
		back_btn.setForeground(Color.WHITE);
		back_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Remove_Previous_Panel();
				main_panel.add(add_vehicle);

			}
		});
		back_btn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		back_btn.setBounds(479, 762, 159, 47);
		add_lorry_panel.add(back_btn);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(new Color(51, 102, 102));
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExit.setBounds(1072, 762, 159, 47);
		add_lorry_panel.add(btnExit);
		
		JLabel label_27 = new JLabel("Fill Details : ");
		label_27.setForeground(Color.WHITE);
		label_27.setFont(new Font("Candara", Font.BOLD, 30));
		label_27.setBounds(29, 104, 176, 67);
		add_lorry_panel.add(label_27);
		
		JLabel lblAddLorry = new JLabel("ADD LORRY");
		lblAddLorry.setForeground(Color.WHITE);
		lblAddLorry.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 38));
		lblAddLorry.setBounds(793, 33, 202, 47);
		add_lorry_panel.add(lblAddLorry);
		
		
		
		JLabel lbl_add_vehicle = new JLabel("ADD VEHICLE");
		lbl_add_vehicle.setForeground(Color.WHITE);
		lbl_add_vehicle.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 38));
		lbl_add_vehicle.setBounds(740, 28, 234, 47);
		add_vehicle.add(lbl_add_vehicle);
		
		JButton btn_Add_Car = new JButton("ADD CAR");
		btn_Add_Car.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Add_Car.setForeground(Color.WHITE);
		btn_Add_Car.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Remove_Previous_Panel();
				main_panel.add(add_car_panel);

				
			}
		});
		btn_Add_Car.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_Add_Car.setBackground(new Color(51, 102, 102));
		btn_Add_Car.setBounds(739, 247, 188, 107);
		add_vehicle.add(btn_Add_Car);
		
		JButton btn_Add_Minibus = new JButton("ADD MINIBUS");
		btn_Add_Minibus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Add_Minibus.setForeground(Color.WHITE);
		btn_Add_Minibus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Remove_Previous_Panel();
				main_panel.add(textfield_Make_MiniBus);

			}
		});
		btn_Add_Minibus.setFont(new Font("Tahoma", Font.BOLD, 20));
		btn_Add_Minibus.setBackground(new Color(51, 102, 102));
		btn_Add_Minibus.setBounds(739, 467, 188, 107);
		add_vehicle.add(btn_Add_Minibus);
		
		JButton btn_Add_Lorry = new JButton("ADD LORRY");
		btn_Add_Lorry.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Add_Lorry.setForeground(Color.WHITE);
		btn_Add_Lorry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Remove_Previous_Panel();
				main_panel.add(add_lorry_panel);

			}
		});
		btn_Add_Lorry.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_Add_Lorry.setBackground(new Color(51, 102, 102));
		btn_Add_Lorry.setBounds(739, 678, 188, 107);
		add_vehicle.add(btn_Add_Lorry);
		
		JButton btn_Add_Car_pic = new JButton("");
		btn_Add_Car_pic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Remove_Previous_Panel();
				main_panel.add(add_car_panel);

			}
		});
		btn_Add_Car_pic.setIcon(new ImageIcon(Admin_menu.class.getResource("/application/Images/Webp.net-resizeimage.png")));
		btn_Add_Car_pic.setForeground(SystemColor.inactiveCaptionBorder);
		btn_Add_Car_pic.setBorderPainted(false);
		btn_Add_Car_pic.setBorder(null);
		btn_Add_Car_pic.setBackground(new Color(95, 158, 160));
		btn_Add_Car_pic.setBounds(624, 245, 102, 109);
		add_vehicle.add(btn_Add_Car_pic);
		
		JButton btn_Add_Minibus_pic = new JButton("");
		btn_Add_Minibus_pic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Remove_Previous_Panel();
				main_panel.add(textfield_Make_MiniBus);

			}
		});
		btn_Add_Minibus_pic.setIcon(new ImageIcon(Admin_menu.class.getResource("/application/Images/hhhjk.png")));
		btn_Add_Minibus_pic.setForeground(SystemColor.inactiveCaptionBorder);
		btn_Add_Minibus_pic.setBorderPainted(false);
		btn_Add_Minibus_pic.setBorder(null);
		btn_Add_Minibus_pic.setBackground(new Color(95, 158, 160));
		btn_Add_Minibus_pic.setBounds(625, 467, 102, 106);
		add_vehicle.add(btn_Add_Minibus_pic);
		
		JButton btn_Add_Lorry_pic = new JButton("");
		btn_Add_Lorry_pic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Remove_Previous_Panel();
				main_panel.add(add_lorry_panel);

			}
		});
		btn_Add_Lorry_pic.setIcon(new ImageIcon(Admin_menu.class.getResource("/application/Images/loo.png")));
		btn_Add_Lorry_pic.setForeground(SystemColor.inactiveCaptionBorder);
		btn_Add_Lorry_pic.setBorderPainted(false);
		btn_Add_Lorry_pic.setBorder(null);
		btn_Add_Lorry_pic.setBackground(new Color(95, 158, 160));
		btn_Add_Lorry_pic.setBounds(625, 678, 102, 106);
		add_vehicle.add(btn_Add_Lorry_pic);
		
		JLabel lblSelectTheVehicle = new JLabel("Select the vehicle you want to Add:");
		lblSelectTheVehicle.setForeground(Color.WHITE);
		lblSelectTheVehicle.setFont(new Font("Candara", Font.BOLD, 29));
		lblSelectTheVehicle.setBounds(54, 139, 517, 67);
		add_vehicle.add(lblSelectTheVehicle);
		
	
		
		JLabel lblHireCar = new JLabel("HIRE CAR");
		lblHireCar.setForeground(Color.WHITE);
		lblHireCar.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 38));
		lblHireCar.setBounds(740, 28, 159, 47);
		hire_car.add(lblHireCar);
		
		JButton btn_Proceed = new JButton("Proceed");
		btn_Proceed.setBackground(new Color(51, 102, 102));
		btn_Proceed.setForeground(Color.WHITE);
		btn_Proceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//setTable();
				Vehicle_type="Car";
				select_op=1;
				//refresh=0;
				txtRegistrationNumber.setText("");
				
				
				
				get_hire_car();

				
				Remove_Previous_Panel();
				main_panel.add(select_customer);

				table_select_customer = new JTable();
				table_select_customer.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 15));
				//table_car_hire.getTableHeader().setAlignmentX(alignmentX);
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment( JLabel.CENTER );
				table_select_customer.setDefaultRenderer(Object.class, centerRenderer);
				table_select_customer.setModel(new DefaultTableModel(
					
					null, new String[] {
						"Customer Identification Number","Customer First Name", "Customer Last Name", "Date Of Birth"
					}
				));
				table_select_customer.setRowHeight(30);
				table_select_customer.setFont(new Font("Tahoma", Font.PLAIN, 18));
				customer_scroll.setViewportView(table_select_customer);
				model_customer=(DefaultTableModel)table_select_customer.getModel();
				
				Object[] row_customer=new Object[4];
				for(int i=0;i<customer_list.size();i++){
					
					row_customer[0]=customer_list.get(i).getId_number();
					row_customer[1]=customer_list.get(i).getFirst_name();
					row_customer[2]=customer_list.get(i).getLast_name();
					row_customer[3]=customer_list.get(i).getDate_of_birth();
				

					
					model_customer.addRow(row_customer);
				}

				
				sort_customer();
			}
		});
		
		btn_Proceed.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_Proceed.setBounds(780, 752, 159, 47);
		hire_car.add(btn_Proceed);
		
	
		
		JButton btn_hire_car_back = new JButton("< Back");
		btn_hire_car_back.setBackground(new Color(51, 102, 102));
		btn_hire_car_back.setForeground(Color.WHITE);
		btn_hire_car_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Remove_Previous_Panel();
				main_panel.add(hire_vehicle);
			}
		});
		btn_hire_car_back.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_hire_car_back.setBounds(482, 752, 159, 47);
		hire_car.add(btn_hire_car_back);
		
		JButton button_3 = new JButton("Exit");
		button_3.setBackground(new Color(51, 102, 102));
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_3.setBounds(1075, 752, 159, 47);
		hire_car.add(button_3);
		
		txtRegistrationNumber = new JTextField();
		txtRegistrationNumber.setBounds(1087, 109, 435, 47);
		hire_car.add(txtRegistrationNumber);
		txtRegistrationNumber.setColumns(10);
		//txtRegistrationNumber.
		
		JLabel lblSearchCar = new JLabel("Search Car");
		lblSearchCar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSearchCar.setBounds(963, 121, 112, 16);
		hire_car.add(lblSearchCar);
		

		
		JLabel lblHireMinibus = new JLabel("HIRE MINIBUS");
		lblHireMinibus.setForeground(Color.WHITE);
		lblHireMinibus.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 38));
		lblHireMinibus.setBounds(710, 28, 244, 47);
		hire_minibus.add(lblHireMinibus);
		
		JButton Hire_MiniBus_btn = new JButton("Proceed");
		Hire_MiniBus_btn.setForeground(Color.WHITE);
		Hire_MiniBus_btn.setBackground(new Color(51, 102, 102));
		Hire_MiniBus_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Vehicle_type="MiniBus";
				select_op=2;
				
				Remove_Previous_Panel();
				main_panel.add(select_customer);
				get_hire_minibus();

				table_select_customer = new JTable();
				table_select_customer.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 15));
				//table_car_hire.getTableHeader().setAlignmentX(alignmentX);
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment( JLabel.CENTER );
				table_select_customer.setDefaultRenderer(Object.class, centerRenderer);
				table_select_customer.setModel(new DefaultTableModel(
					
					null, new String[] {
						"Customer Identification Number","Customer First Name", "Customer Last Name", "Date Of Birth"
					}
				));
				table_select_customer.setRowHeight(30);
				table_select_customer.setFont(new Font("Tahoma", Font.PLAIN, 18));
				customer_scroll.setViewportView(table_select_customer);
				model_customer=(DefaultTableModel)table_select_customer.getModel();
				
				Object[] row_customer=new Object[4];
				for(int i=0;i<customer_list.size();i++){
					
					row_customer[0]=customer_list.get(i).Id_number;
					row_customer[1]=customer_list.get(i).First_name;
					row_customer[2]=customer_list.get(i).Last_name;
					row_customer[3]=customer_list.get(i).Date_of_birth;
				

					
					model_customer.addRow(row_customer);
				}
		
				sort_customer();
			}
		});
		Hire_MiniBus_btn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Hire_MiniBus_btn.setBounds(780, 755, 159, 47);
		hire_minibus.add(Hire_MiniBus_btn);
		
		JButton button_2 = new JButton("< Back");
		button_2.setForeground(Color.WHITE);
		button_2.setBackground(new Color(51, 102, 102));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Remove_Previous_Panel();
				main_panel.add(hire_vehicle);
			}
		});
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_2.setBounds(482, 755, 159, 47);
		hire_minibus.add(button_2);
		
		JButton button_4 = new JButton("Exit");
		button_4.setForeground(Color.WHITE);
		button_4.setBackground(new Color(51, 102, 102));
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_4.setBounds(1075, 755, 159, 47);
		hire_minibus.add(button_4);
		
		JLabel lblSearchMinibus = new JLabel("Search MiniBus");
		lblSearchMinibus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSearchMinibus.setBounds(942, 125, 134, 16);
		hire_minibus.add(lblSearchMinibus);
		
		textField_search_Minibus = new JTextField();
		textField_search_Minibus.setColumns(10);
		textField_search_Minibus.setBounds(1088, 113, 435, 47);
		hire_minibus.add(textField_search_Minibus);
		
		
		
		JLabel lblHireLorry = new JLabel("HIRE LORRY");
		lblHireLorry.setForeground(Color.WHITE);
		lblHireLorry.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 38));
		lblHireLorry.setBounds(710, 28, 244, 47);
		hire_lorry.add(lblHireLorry);
		
		JButton HireLorry_Btn = new JButton("Proceed");
		HireLorry_Btn.setBackground(new Color(51, 102, 102));
		HireLorry_Btn.setForeground(Color.WHITE);
		HireLorry_Btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Vehicle_type="Lorry";
				select_op=3;
				Remove_Previous_Panel();
				main_panel.add(select_customer);
				get_hire_lorry();

				table_select_customer = new JTable();
				table_select_customer.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 15));
				//table_car_hire.getTableHeader().setAlignmentX(alignmentX);
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment( JLabel.CENTER );
				table_select_customer.setDefaultRenderer(Object.class, centerRenderer);
				table_select_customer.setModel(new DefaultTableModel(
					
					null, new String[] {
						"Customer Identification Number","Customer First Name", "Customer Last Name", "Date Of Birth"
					}
				));
				table_select_customer.setRowHeight(30);
				table_select_customer.setFont(new Font("Tahoma", Font.PLAIN, 18));
				customer_scroll.setViewportView(table_select_customer);
				model_customer=(DefaultTableModel)table_select_customer.getModel();
				
				Object[] row_customer=new Object[4];
				for(int i=0;i<customer_list.size();i++){
					
					row_customer[0]=customer_list.get(i).getId_number();
					row_customer[1]=customer_list.get(i).getFirst_name();
					row_customer[2]=customer_list.get(i).getLast_name();
					row_customer[3]=customer_list.get(i).getDate_of_birth();
				

					
					model_customer.addRow(row_customer);
				}
				
				sort_customer();
			}
		});
		HireLorry_Btn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		HireLorry_Btn.setBounds(781, 755, 159, 47);
		hire_lorry.add(HireLorry_Btn);
		
		JButton button_5 = new JButton("< Back");
		button_5.setBackground(new Color(51, 102, 102));
		button_5.setForeground(Color.WHITE);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Remove_Previous_Panel();
				main_panel.add(hire_vehicle);
			}
		});
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_5.setBounds(483, 755, 159, 47);
		hire_lorry.add(button_5);
		
		JButton button_7 = new JButton("Exit");
		button_7.setBackground(new Color(51, 102, 102));
		button_7.setForeground(Color.WHITE);
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_7.setBounds(1076, 755, 159, 47);
		hire_lorry.add(button_7);
		
		JLabel lblSearchLorry = new JLabel("Search Lorry");
		lblSearchLorry.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSearchLorry.setBounds(947, 117, 122, 25);
		hire_lorry.add(lblSearchLorry);
		
		textField_search_Lorry = new JTextField();
		textField_search_Lorry.setColumns(10);
		textField_search_Lorry.setBounds(1088, 109, 435, 47);
		hire_lorry.add(textField_search_Lorry);
		
	
		JLabel lblCustomer = new JLabel("CUSTOMER");
		lblCustomer.setFont(new Font("Candara", Font.BOLD, 38));
		lblCustomer.setBounds(740, 28, 188, 47);
		select_customer.add(lblCustomer);
		
		JButton HireCar_btn = new JButton("Hire Vehicle");
		HireCar_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(select_op==1){
					
					
					 
				int cus_select=table_select_customer.getSelectedRow();
				System.out.println(""+model_customer.getValueAt(cus_select, 0));
				customer_reg_no=(String) model_customer.getValueAt(cus_select, 0);
				customer_name=(String) model_customer.getValueAt(cus_select, 1) + (String) model_customer.getValueAt(cus_select, 2);
				
				
				replace_hired_car();
				add_hire_vehicle_file();
				Remove_Previous_Panel();
				main_panel.add(hire_vehicle);
				}
				
				else if(select_op==2){
					
					int cus_select=table_select_customer.getSelectedRow();
					System.out.println(""+model_customer.getValueAt(cus_select, 0));
					customer_reg_no=(String) model_customer.getValueAt(cus_select, 0);
					customer_name=(String) model_customer.getValueAt(cus_select, 1) + (String) model_customer.getValueAt(cus_select, 2);


					replace_hired_minibus();
					add_hire_vehicle_file();

					Remove_Previous_Panel();

					main_panel.add(hire_vehicle);
					
				}
				
                else if(select_op==3){
					
					int cus_select=table_select_customer.getSelectedRow();
					System.out.println(""+model_customer.getValueAt(cus_select, 0));
					customer_reg_no=(String) model_customer.getValueAt(cus_select, 0);
					customer_name=(String) model_customer.getValueAt(cus_select, 1) + (String) model_customer.getValueAt(cus_select, 2);


					replace_hired_lorry();
					add_hire_vehicle_file();

					Remove_Previous_Panel();

					main_panel.add(hire_vehicle);
					
				}

				
			}
		});
		HireCar_btn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		HireCar_btn.setBounds(569, 742, 159, 47);
		select_customer.add(HireCar_btn);
		
		JButton button_9 = new JButton("Exit");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		button_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_9.setBounds(864, 742, 159, 47);
		select_customer.add(button_9);
		
		JLabel lblSearchCustomer = new JLabel("Search Customer");
		lblSearchCustomer.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSearchCustomer.setBounds(905, 128, 159, 16);
		select_customer.add(lblSearchCustomer);
		
		textField_Customer = new JTextField();
		textField_Customer.setColumns(10);
		textField_Customer.setBounds(1087, 116, 435, 47);
		select_customer.add(textField_Customer);
		
		
		
		JLabel lblReturnCar = new JLabel("RETURN CAR");
		lblReturnCar.setFont(new Font("Candara", Font.BOLD, 38));
		lblReturnCar.setBounds(666, 28, 233, 47);
		return_car.add(lblReturnCar);
		
		JButton btn_proceed_return_car = new JButton("Return Car");
		btn_proceed_return_car.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				int select_return_car =table_car_return.getSelectedRow();
				car_reg_return=(String) model_return_car.getValueAt(select_return_car, 0);
				System.out.println(""+car_reg_return);
				for(int k=0;k<hired_vehicle_list.size();k++){					
				if(car_reg_return.equals(hired_vehicle_list.get(k).Vehicle_Reg_No) && hired_vehicle_list.get(k).Vehicle_Type.equals("Car")){					
					hired_vehicle_list.remove(k);					
					try {
				
					new FileOutputStream("hired_vehicle.dat").close();
				} catch (FileNotFoundException s) {
					// TODO Auto-generated catch block
					s.printStackTrace();
				} catch (IOException s) {
					// TODO Auto-generated catch block
					s.printStackTrace();
				}
				
				try {
//					
					FileOutputStream fos = new FileOutputStream("hired_vehicle.dat");
					ObjectOutputStream oos = new ObjectOutputStream(fos);

					for (int i = 0; i < hired_vehicle_list.size( ); i++)
			      	{ // write one object
						hire_vehicle_file = (Hired_vehicle) hired_vehicle_list.get(i);
			      		oos.writeObject(hire_vehicle_file); // this one line writes an entire object!!!!
			      	} 
					oos.close();

					} catch (EOFException ex) { //This exception will be caught when EOF is reached
					 System.out.println("End of file reached.");
					 } catch (FileNotFoundException ex) {
					 ex.printStackTrace();
					 } catch (IOException ex) {
					 ex.printStackTrace();
					 } 
				
				
				for(int n=0;n<vehicle_list.size();n++){
					
					if(vehicle_list.get(n).Reg_number.equals(car_reg_return)){
						vehicle_list.get(n).setVehicle_status("Ready To Hire");
					}
				}
					
				
				try {
			
				new FileOutputStream("vehicle.dat").close();
			} catch (FileNotFoundException s) {
				// TODO Auto-generated catch block
				s.printStackTrace();
			} catch (IOException s) {
				// TODO Auto-generated catch block
				s.printStackTrace();
			}
				
				try {
//					
					FileOutputStream fos = new FileOutputStream("vehicle.dat");
					ObjectOutputStream oos = new ObjectOutputStream(fos);

					for (int i = 0; i < vehicle_list.size( ); i++)
			      	{ // write one object
						car = (Motor_Vehicle) vehicle_list.get(i);
			      		oos.writeObject(car); // this one line writes an entire object!!!!
			      	} 
					oos.close();

					} catch (EOFException ex) { //This exception will be caught when EOF is reached
					 System.out.println("End of file reached.");
					 } catch (FileNotFoundException ex) {
					 ex.printStackTrace();
					 } catch (IOException ex) {
					 ex.printStackTrace();
					 } 
					
				}
				}
				
				Remove_Previous_Panel();
				main_panel.add(return_vehicle);
			}
		});
		btn_proceed_return_car.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_proceed_return_car.setBounds(780, 752, 159, 47);
		return_car.add(btn_proceed_return_car);
		
		JButton button_12 = new JButton("< Back");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Remove_Previous_Panel();
				main_panel.add(return_vehicle);
			}
		});
		button_12.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_12.setBounds(482, 752, 159, 47);
		return_car.add(button_12);
		
		JButton button_14 = new JButton("Exit");
		button_14.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_14.setBounds(1075, 752, 159, 47);
		return_car.add(button_14);
		
		textField_return_car = new JTextField();
		textField_return_car.setColumns(10);
		textField_return_car.setBounds(1087, 109, 435, 47);
		return_car.add(textField_return_car);
		
		JLabel label_13 = new JLabel("Search Car");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_13.setBounds(963, 121, 112, 16);
		return_car.add(label_13);
		
		
		
		
		
		JLabel lblReturnMinibus = new JLabel("RETURN MINIBUS");
		lblReturnMinibus.setFont(new Font("Candara", Font.BOLD, 38));
		lblReturnMinibus.setBounds(607, 28, 292, 47);
		return_minibus.add(lblReturnMinibus);
		
		JButton btnReturnMinibus_1 = new JButton("Return MiniBus");
		btnReturnMinibus_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int select_return_minibus =table_minibus_return.getSelectedRow();
				minibus_reg_return=(String) model_return_minibus.getValueAt(select_return_minibus, 0);
				
				System.out.println(""+minibus_reg_return);
				
				
				for(int k=0;k<hired_vehicle_list.size();k++){
					
				if(minibus_reg_return.equals(hired_vehicle_list.get(k).Vehicle_Reg_No) && hired_vehicle_list.get(k).Vehicle_Type.equals("MiniBus")){
					
					hired_vehicle_list.remove(k);
					
					
					try {
				
					new FileOutputStream("hired_vehicle.dat").close();
				} catch (FileNotFoundException s) {
					// TODO Auto-generated catch block
					s.printStackTrace();
				} catch (IOException s) {
					// TODO Auto-generated catch block
					s.printStackTrace();
				}
					
				
				
				try {
//					
					FileOutputStream fos = new FileOutputStream("hired_vehicle.dat");
					ObjectOutputStream oos = new ObjectOutputStream(fos);

					for (int i = 0; i < hired_vehicle_list.size( ); i++)
			      	{ // write one object
						hire_vehicle_file = (Hired_vehicle) hired_vehicle_list.get(i);
			      		oos.writeObject(hire_vehicle_file); // this one line writes an entire object!!!!
			      	} 
					oos.close();

					} catch (EOFException ex) { //This exception will be caught when EOF is reached
					 System.out.println("End of file reached.");
					 } catch (FileNotFoundException ex) {
					 ex.printStackTrace();
					 } catch (IOException ex) {
					 ex.printStackTrace();
					 } 
				
				
				for(int n=0;n<minibus_list.size();n++){
					
					if(minibus_list.get(n).Reg_number.equals(minibus_reg_return)){
						minibus_list.get(n).setVehicle_status("Ready To Hire");
					}
				}
					
				
				try {
			
				new FileOutputStream("minibus.dat").close();
			} catch (FileNotFoundException s) {
				// TODO Auto-generated catch block
				s.printStackTrace();
			} catch (IOException s) {
				// TODO Auto-generated catch block
				s.printStackTrace();
			}
				
				try {
//					
					FileOutputStream fos = new FileOutputStream("minibus.dat");
					ObjectOutputStream oos = new ObjectOutputStream(fos);

					for (int i = 0; i < minibus_list.size( ); i++)
			      	{ // write one object
						mini = (Motor_Vehicle) minibus_list.get(i);
			      		oos.writeObject(mini); // this one line writes an entire object!!!!
			      	} 
					oos.close();

					} catch (EOFException ex) { //This exception will be caught when EOF is reached
					 System.out.println("End of file reached.");
					 } catch (FileNotFoundException ex) {
					 ex.printStackTrace();
					 } catch (IOException ex) {
					 ex.printStackTrace();
					 } 
					
				}
				}
				
				Remove_Previous_Panel();
				main_panel.add(return_vehicle);
			}
		});
		btnReturnMinibus_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnReturnMinibus_1.setBounds(780, 752, 159, 47);
		return_minibus.add(btnReturnMinibus_1);
		
		JButton button_15 = new JButton("< Back");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Remove_Previous_Panel();
				main_panel.add(return_vehicle);
			}
		});
		button_15.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_15.setBounds(482, 752, 159, 47);
		return_minibus.add(button_15);
		
		JButton button_16 = new JButton("Exit");
		button_16.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_16.setBounds(1075, 752, 159, 47);
		return_minibus.add(button_16);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(1087, 109, 435, 47);
		return_minibus.add(textField);
		
		JLabel lblSearchMinibus_1 = new JLabel("Search MiniBus");
		lblSearchMinibus_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSearchMinibus_1.setBounds(941, 121, 134, 16);
		return_minibus.add(lblSearchMinibus_1);
		
		
		
		JLabel lblReturnLorry = new JLabel("RETURN LORRY");
		lblReturnLorry.setFont(new Font("Candara", Font.BOLD, 38));
		lblReturnLorry.setBounds(607, 28, 292, 47);
		return_lorry.add(lblReturnLorry);
		
		JButton btnReturnLorry_1 = new JButton("Return Lorry");
		btnReturnLorry_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int select_return_lorry =table_lorry_return.getSelectedRow();
				lorry_reg_return=(String) model_return_lorry.getValueAt(select_return_lorry, 0);
				
				System.out.println(""+lorry_reg_return);
				
				for(int k=0;k<hired_vehicle_list.size();k++){
					
				if(lorry_reg_return.equals(hired_vehicle_list.get(k).Vehicle_Reg_No) && hired_vehicle_list.get(k).Vehicle_Type.equals("Lorry")){
					
					hired_vehicle_list.remove(k);
					
					
					try {
				
					new FileOutputStream("hired_vehicle.dat").close();
				} catch (FileNotFoundException s) {
					// TODO Auto-generated catch block
					s.printStackTrace();
				} catch (IOException s) {
					// TODO Auto-generated catch block
					s.printStackTrace();
				}
					
				
				
				try {
//					
					FileOutputStream fos = new FileOutputStream("hired_vehicle.dat");
					ObjectOutputStream oos = new ObjectOutputStream(fos);

					for (int i = 0; i < hired_vehicle_list.size( ); i++)
			      	{ // write one object
						hire_vehicle_file = (Hired_vehicle) hired_vehicle_list.get(i);
			      		oos.writeObject(hire_vehicle_file); // this one line writes an entire object!!!!
			      	} 
					oos.close();

					} catch (EOFException ex) { //This exception will be caught when EOF is reached
					 System.out.println("End of file reached.");
					 } catch (FileNotFoundException ex) {
					 ex.printStackTrace();
					 } catch (IOException ex) {
					 ex.printStackTrace();
					 } 
				
				
				for(int n=0;n<lorry_list.size();n++){
					
					if(lorry_list.get(n).Reg_number.equals(lorry_reg_return)){
						lorry_list.get(n).setVehicle_status("Ready To Hire");
					}
				}
					
				
				try {
			
				new FileOutputStream("lorry.dat").close();
			} catch (FileNotFoundException s) {
				// TODO Auto-generated catch block
				s.printStackTrace();
			} catch (IOException s) {
				// TODO Auto-generated catch block
				s.printStackTrace();
			}
				
				try {
//					
					FileOutputStream fos = new FileOutputStream("lorry.dat");
					ObjectOutputStream oos = new ObjectOutputStream(fos);

					for (int i = 0; i < lorry_list.size( ); i++)
			      	{ // write one object
						lorry = (Motor_Vehicle) lorry_list.get(i);
			      		oos.writeObject(lorry); // this one line writes an entire object!!!!
			      	} 
					oos.close();

					} catch (EOFException ex) { //This exception will be caught when EOF is reached
					 System.out.println("End of file reached.");
					 } catch (FileNotFoundException ex) {
					 ex.printStackTrace();
					 } catch (IOException ex) {
					 ex.printStackTrace();
					 } 
					
				}
				}
				
				Remove_Previous_Panel();
				main_panel.add(return_vehicle);
			}
		});
		btnReturnLorry_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnReturnLorry_1.setBounds(780, 752, 159, 47);
		return_lorry.add(btnReturnLorry_1);
		
		JButton button_18 = new JButton("< Back");
		button_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Remove_Previous_Panel();
				main_panel.add(return_vehicle);
			}
		});
		button_18.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_18.setBounds(482, 752, 159, 47);
		return_lorry.add(button_18);
		
		JButton button_19 = new JButton("Exit");
		button_19.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_19.setBounds(1075, 752, 159, 47);
		return_lorry.add(button_19);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(1087, 109, 435, 47);
		return_lorry.add(textField_1);
		
		JLabel lblSearchLorry_1 = new JLabel("Search Lorry");
		lblSearchLorry_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSearchLorry_1.setBounds(941, 121, 134, 25);
		return_lorry.add(lblSearchLorry_1);
		
		;
		
		JLabel lblRemoveCar = new JLabel("REMOVE CAR");
		lblRemoveCar.setForeground(Color.WHITE);
		lblRemoveCar.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 38));
		lblRemoveCar.setBounds(666, 28, 233, 47);
		remove_car.add(lblRemoveCar);
		
		JButton btnRemoveCar_1 = new JButton("Remove Car");
		btnRemoveCar_1.setBackground(new Color(51, 102, 102));
		btnRemoveCar_1.setForeground(Color.WHITE);
		btnRemoveCar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int select_remove_car =table_car_remove.getSelectedRow();
				//TableModel hh=table_car_hire.getModel();
				car_reg_remove=(String) model_car_remove.getValueAt(select_remove_car, 0);
				
				for(int j=0;j<vehicle_list.size();j++){
					
					if(vehicle_list.get(j).getReg_number().equals(car_reg_remove)){
						
						vehicle_list.remove(j);
					}
				}
				
				try {
					new FileOutputStream("vehicle.dat").close();
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
				
				FileOutputStream fos = new FileOutputStream("vehicle.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);

				for (int i = 0; i < vehicle_list.size( ); i++)
		      	{ // write one object
					car = (Motor_Vehicle) vehicle_list.get(i);
		      		oos.writeObject(car); // this one line writes an entire object!!!!
		      	} 
				oos.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				Remove_Previous_Panel();
				main_panel.add(remove_vehicle);
			}
			
		});
		btnRemoveCar_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRemoveCar_1.setBounds(780, 752, 159, 47);
		remove_car.add(btnRemoveCar_1);
		
		JButton button_21 = new JButton("< Back");
		button_21.setBackground(new Color(51, 102, 102));
		button_21.setForeground(Color.WHITE);
		button_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Remove_Previous_Panel();
				main_panel.add(remove_vehicle);
			}
		});
		button_21.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_21.setBounds(482, 752, 159, 47);
		remove_car.add(button_21);
		
		JButton button_23 = new JButton("Exit");
		button_23.setBackground(new Color(51, 102, 102));
		button_23.setForeground(Color.WHITE);
		button_23.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_23.setBounds(1075, 752, 159, 47);
		remove_car.add(button_23);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(1087, 109, 435, 47);
		remove_car.add(textField_2);
		
		JLabel label_12 = new JLabel("Search Car");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_12.setBounds(963, 121, 112, 16);
		remove_car.add(label_12);
		
		
		
		JLabel lblRemoveMinibus = new JLabel("REMOVE MINIBUS");
		lblRemoveMinibus.setForeground(Color.WHITE);
		lblRemoveMinibus.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 38));
		lblRemoveMinibus.setBounds(582, 28, 317, 47);
		remove_minibus.add(lblRemoveMinibus);
		
		JButton btnRemoveMinibus_1 = new JButton("Remove MiniBus");
		btnRemoveMinibus_1.setBackground(new Color(51, 102, 102));
		btnRemoveMinibus_1.setForeground(Color.WHITE);
		btnRemoveMinibus_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int select_remove_minibus =table_minibus_remove.getSelectedRow();
				//TableModel hh=table_car_hire.getModel();
				minibus_reg_remove=(String) model_minibus_remove.getValueAt(select_remove_minibus, 0);
				
				for(int j=0;j<minibus_list.size();j++){
					
					if(minibus_list.get(j).getReg_number().equals(minibus_reg_remove)){
						
						minibus_list.remove(j);
					}
				}
				try {
					new FileOutputStream("minibus.dat").close();
				
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
				
				FileOutputStream fos = new FileOutputStream("minibus.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);

				for (int i = 0; i < minibus_list.size( ); i++)
		      	{ // write one object
					mini = (Motor_Vehicle) minibus_list.get(i);
		      		oos.writeObject(mini); // this one line writes an entire object!!!!
		      	} 
				oos.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				Remove_Previous_Panel();
				main_panel.add(remove_vehicle);
			}
		});
		btnRemoveMinibus_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRemoveMinibus_1.setBounds(766, 752, 173, 47);
		remove_minibus.add(btnRemoveMinibus_1);
		
		JButton button_24 = new JButton("< Back");
		button_24.setBackground(new Color(51, 102, 102));
		button_24.setForeground(Color.WHITE);
		button_24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Remove_Previous_Panel();
				main_panel.add(remove_vehicle);
			}
		});
		button_24.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_24.setBounds(470, 752, 159, 47);
		remove_minibus.add(button_24);
		
		JButton button_25 = new JButton("Exit");
		button_25.setBackground(new Color(51, 102, 102));
		button_25.setForeground(Color.WHITE);
		button_25.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_25.setBounds(1075, 752, 159, 47);
		remove_minibus.add(button_25);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(1087, 109, 435, 47);
		remove_minibus.add(textField_3);
		
		JLabel lblSearchMinibus_2 = new JLabel("Search MiniBus");
		lblSearchMinibus_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSearchMinibus_2.setBounds(934, 121, 141, 16);
		remove_minibus.add(lblSearchMinibus_2);
		
		
		
		JLabel lblRemoveLorry = new JLabel("REMOVE LORRY");
		lblRemoveLorry.setForeground(Color.WHITE);
		lblRemoveLorry.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 38));
		lblRemoveLorry.setBounds(619, 28, 280, 47);
		remove_lorry.add(lblRemoveLorry);
		
		JButton btnRemoveLorry_1 = new JButton("Remove Lorry");
		btnRemoveLorry_1.setBackground(new Color(51, 102, 102));
		btnRemoveLorry_1.setForeground(Color.WHITE);
		btnRemoveLorry_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int select_remove_lorry =table_lorry_remove.getSelectedRow();
				//TableModel hh=table_car_hire.getModel();
				lorry_reg_remove=(String) model_lorry_remove.getValueAt(select_remove_lorry, 0);
				
				for(int j=0;j<lorry_list.size();j++){
					
					if(lorry_list.get(j).getReg_number().equals(lorry_reg_remove)){
						
						lorry_list.remove(j);
					}
				}
				try {
					new FileOutputStream("lorry.dat").close();
				
				} catch (FileNotFoundException z) {
					// TODO Auto-generated catch block
					z.printStackTrace();
				} catch (IOException z) {
					// TODO Auto-generated catch block
					z.printStackTrace();
				}
				
				try {
				
				FileOutputStream fos = new FileOutputStream("lorry.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);

				for (int i = 0; i < lorry_list.size( ); i++)
		      	{ // write one object
					lorry = (Motor_Vehicle) lorry_list.get(i);
		      		oos.writeObject(lorry); // this one line writes an entire object!!!!
		      	} 
				oos.close();
			} catch (FileNotFoundException z) {
				// TODO Auto-generated catch block
				z.printStackTrace();
			} catch (IOException z) {
				// TODO Auto-generated catch block
				z.printStackTrace();
			}
				
				Remove_Previous_Panel();
				main_panel.add(remove_vehicle);
			}
		});
		btnRemoveLorry_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRemoveLorry_1.setBounds(780, 752, 159, 47);
		remove_lorry.add(btnRemoveLorry_1);
		
		JButton button_27 = new JButton("< Back");
		button_27.setBackground(new Color(51, 102, 102));
		button_27.setForeground(Color.WHITE);
		button_27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Remove_Previous_Panel();
				main_panel.add(remove_vehicle);
			}
		});
		button_27.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_27.setBounds(482, 752, 159, 47);
		remove_lorry.add(button_27);
		
		JButton button_28 = new JButton("Exit");
		button_28.setBackground(new Color(51, 102, 102));
		button_28.setForeground(Color.WHITE);
		button_28.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_28.setBounds(1075, 752, 159, 47);
		remove_lorry.add(button_28);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(1087, 109, 435, 47);
		remove_lorry.add(textField_4);
		
		JLabel lblSearchLorry_2 = new JLabel("Search Lorry");
		lblSearchLorry_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSearchLorry_2.setBounds(963, 121, 112, 25);
		remove_lorry.add(lblSearchLorry_2);
		
	
		
		JLabel lblViewCar = new JLabel("VIEW CAR");
		lblViewCar.setFont(new Font("Candara", Font.BOLD, 38));
		lblViewCar.setBounds(666, 28, 233, 47);
		view_car.add(lblViewCar);
		
		JButton btnViewCarDetails = new JButton("View Car Details");
		btnViewCarDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table_car_view.getSelectionModel().isSelectionEmpty()){
		            JOptionPane.showMessageDialog(null, "No Row is Selected","ERROR",JOptionPane.ERROR_MESSAGE);
		            

				}
				else{
					Remove_Previous_Panel();
					main_panel.add(car_details_show);
					int select_view_car =table_car_view.getSelectedRow();
					String view_car_state;
					//TableModel hh=table_car_hire.getModel();
					car_reg_view=(String) model_car_view.getValueAt(select_view_car, 0);
					view_car_state=(String) model_car_view.getValueAt(select_view_car, 7);
					for(int i=0;i<vehicle_list.size();i++){
						if(vehicle_list.get(i).Reg_number.equals(car_reg_view)){
							
							lbl_car_reg_no.setText(vehicle_list.get(i).Reg_number);
							lbl_car_make.setText(vehicle_list.get(i).Make_Vehicle);
							lbl_car_model.setText(vehicle_list.get(i).Model_Vehicle);
							lbl_car_hire.setText(Double.toString(vehicle_list.get(i).Hire_Rate_Vehicle));
							lbl_car_fuel.setText(vehicle_list.get(i).Fuel_Type);
							lbl_car_doors.setText(Integer.toString(vehicle_list.get(i).Number_doors));
							lbl_car_spped.setText(Double.toString(vehicle_list.get(i).Speed_Vehicle));
							
							if(vehicle_list.get(i).Vehicle_status.equals("Hired")){
								
							for(int u=0;u<hired_vehicle_list.size();u++){
								
								
								if(vehicle_list.get(i).Reg_number.equals(hired_vehicle_list.get(u).Vehicle_Reg_No)){
									lbl_car_status.setText("Hired");
									lbl_car_customer_name.setText(hired_vehicle_list.get(u).Customer_Name);
									lbl_car_customer_reg.setText(hired_vehicle_list.get(u).Customer_Reg_No);

									
								}
							}
							
							
							}
							else{
								lbl_car_status.setText("Ready To Hired");

								lbl_car_customer_name.setText("Not Available");
								lbl_car_customer_reg.setText("Not Available");
								
							}






						}
						
					}

			}
			}
		});
		btnViewCarDetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnViewCarDetails.setBounds(780, 752, 159, 47);
		view_car.add(btnViewCarDetails);
		
		JButton button_view_car_back = new JButton("< Back");
		button_view_car_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Remove_Previous_Panel();
				main_panel.add(view_vehicle);
			}
		});
		button_view_car_back.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_view_car_back.setBounds(482, 752, 159, 47);
		view_car.add(button_view_car_back);
		
		JButton button_32 = new JButton("Exit");
		button_32.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_32.setBounds(1075, 752, 159, 47);
		view_car.add(button_32);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(1087, 109, 435, 47);
		view_car.add(textField_5);
		
		JLabel label_15 = new JLabel("Search Car");
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_15.setBounds(963, 121, 112, 16);
		view_car.add(label_15);
		
	
		
		JLabel lblViewMinibus = new JLabel("VIEW MINIBUS");
		lblViewMinibus.setFont(new Font("Candara", Font.BOLD, 38));
		lblViewMinibus.setBounds(630, 27, 273, 47);
		view_minibus.add(lblViewMinibus);
		
		JButton btnViewMinibusDetails = new JButton("View MiniBus Details");
		btnViewMinibusDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				if(table_minibus_view.getSelectionModel().isSelectionEmpty()){
		            JOptionPane.showMessageDialog(null, "No Row is Selected","ERROR",JOptionPane.ERROR_MESSAGE);
		            

				}
				else{
					Remove_Previous_Panel();
					main_panel.add(minibus_details_show);
					String view_minibus_state;
					int select_view_minibus =table_minibus_view.getSelectedRow();
					minibus_reg_view=(String) model_minibus_view.getValueAt(select_view_minibus, 0);
					view_minibus_state=(String) model_minibus_view.getValueAt(select_view_minibus, 7);
					for(int i=0;i<minibus_list.size();i++){
						if(minibus_list.get(i).Reg_number.equals(minibus_reg_view)){
							
							lbl_minibus_reg.setText(minibus_list.get(i).Reg_number);
							lbl_minibus_make.setText(minibus_list.get(i).Make_Vehicle);
							lbl_minibus_model.setText(minibus_list.get(i).Model_Vehicle);
							lbl_minibus_hire.setText(Double.toString(minibus_list.get(i).Hire_Rate_Vehicle));
							lbl_minibus_seat.setText(Integer.toString(minibus_list.get(i).Seat_Capacity_MiniBus));
							lbl_minibus_doors.setText(Integer.toString(minibus_list.get(i).Number_doors));
							lbl_minibus_speed.setText(Double.toString(minibus_list.get(i).Speed_Vehicle));
							
							if(minibus_list.get(i).Vehicle_status.equals("Hired")){
								
							for(int u=0;u<hired_vehicle_list.size();u++){
								
								
								if(minibus_list.get(i).Reg_number.equals(hired_vehicle_list.get(u).Vehicle_Reg_No)){
									lbl_minibus_status.setText("Hired");
									lbl_minibus_customer.setText(hired_vehicle_list.get(u).Customer_Name);
									lbl_minibus_customer_reg.setText(hired_vehicle_list.get(u).Customer_Reg_No);

									
								}
							}
							
							
							}
							else{
								lbl_minibus_status.setText("Ready To Hired");

								lbl_minibus_customer.setText("Not Available");
								lbl_minibus_customer_reg.setText("Not Available");
								
							}






						}
						
					}

			}
			}
		});
		btnViewMinibusDetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnViewMinibusDetails.setBounds(780, 752, 209, 47);
		view_minibus.add(btnViewMinibusDetails);
		
		JButton button_34 = new JButton("< Back");
		button_34.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Remove_Previous_Panel();
				main_panel.add(view_vehicle);
			}
		});
		button_34.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_34.setBounds(482, 752, 159, 47);
		view_minibus.add(button_34);
		
		JButton button_35 = new JButton("Exit");
		button_35.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_35.setBounds(1075, 752, 159, 47);
		view_minibus.add(button_35);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(1087, 109, 435, 47);
		view_minibus.add(textField_6);
		
		JLabel label_19 = new JLabel("Search Car");
		label_19.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_19.setBounds(963, 121, 112, 16);
		view_minibus.add(label_19);
		
		
		
		JLabel lblViewLorry = new JLabel("VIEW LORRY");
		lblViewLorry.setFont(new Font("Candara", Font.BOLD, 38));
		lblViewLorry.setBounds(666, 28, 233, 47);
		view_lorry.add(lblViewLorry);
		
		JButton btnViewLorryDetails = new JButton("View Lorry Details");
		btnViewLorryDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(table_lorry_view.getSelectionModel().isSelectionEmpty()){
		            JOptionPane.showMessageDialog(null, "No Row is Selected","ERROR",JOptionPane.ERROR_MESSAGE);
		            

				}
				else{
					Remove_Previous_Panel();
					main_panel.add(lorry_details_show);
					int select_view_lorry =table_lorry_view.getSelectedRow();
					String view_lorry_state;
					lorry_reg_view=(String) model_lorry_view.getValueAt(select_view_lorry, 0);
					view_lorry_state=(String) model_lorry_view.getValueAt(select_view_lorry, 7);
					for(int i=0;i<lorry_list.size();i++){
						if(lorry_list.get(i).Reg_number.equals(lorry_reg_view)){
							
							lbl_lorry_reg.setText(lorry_list.get(i).Reg_number);
							lbl_lorry_make.setText(lorry_list.get(i).Make_Vehicle);
							lbl_lorry_model.setText(lorry_list.get(i).Model_Vehicle);
							lbl_lorry_hire.setText(Double.toString(lorry_list.get(i).Hire_Rate_Vehicle));
							lbl_lorry_weight.setText(Double.toString(lorry_list.get(i).Weight_Lorry));
							lbl_lorry_doors.setText(Integer.toString(lorry_list.get(i).Number_doors));
							lbl_lorry_speed.setText(Double.toString(lorry_list.get(i).Speed_Vehicle));
							
							if(lorry_list.get(i).Vehicle_status.equals("Hired")){
								
							for(int u=0;u<hired_vehicle_list.size();u++){
								
								
								if(lorry_list.get(i).Reg_number.equals(hired_vehicle_list.get(u).Vehicle_Reg_No)){
									lbl_lorry_status.setText("Hired");
									lbl_lorry_customer.setText(hired_vehicle_list.get(u).Customer_Name);
									lbl_lorry_customer_reg.setText(hired_vehicle_list.get(u).Customer_Reg_No);

									
								}
							}
							
							
							}
							else{
								lbl_lorry_status.setText("Ready To Hired");

								lbl_lorry_customer.setText("Not Available");
								lbl_lorry_customer_reg.setText("Not Available");
								
							}






						}
						
					}

			}
				
				
				
			}
		});
		btnViewLorryDetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnViewLorryDetails.setBounds(780, 752, 159, 47);
		view_lorry.add(btnViewLorryDetails);
		
		JButton button_37 = new JButton("< Back");
		button_37.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Remove_Previous_Panel();
				main_panel.add(view_vehicle);
			}
		});
		button_37.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_37.setBounds(482, 752, 159, 47);
		view_lorry.add(button_37);
		
		JButton button_38 = new JButton("Exit");
		button_38.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_38.setBounds(1075, 752, 159, 47);
		view_lorry.add(button_38);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(1087, 109, 435, 47);
		view_lorry.add(textField_7);
		
		JLabel label_21 = new JLabel("Search Car");
		label_21.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_21.setBounds(963, 121, 112, 16);
		view_lorry.add(label_21);
		
		
		
		JLabel lblCarDetails = new JLabel("CAR DETAILS");
		lblCarDetails.setFont(new Font("Candara", Font.BOLD, 38));
		lblCarDetails.setBounds(740, 28, 234, 47);
		car_details_show.add(lblCarDetails);
		
		JLabel label_17 = new JLabel("Registration Number:");
		label_17.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_17.setBounds(31, 160, 207, 40);
		car_details_show.add(label_17);
		
		JLabel label_20 = new JLabel("Top Speed :");
		label_20.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_20.setBounds(118, 296, 123, 40);
		car_details_show.add(label_20);
		
		JLabel label_22 = new JLabel("Make of Car :");
		label_22.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_22.setBounds(561, 160, 131, 40);
		car_details_show.add(label_22);
		
		JLabel label_23 = new JLabel("Model of Car :");
		label_23.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_23.setBounds(1126, 160, 144, 40);
		car_details_show.add(label_23);
		
		JLabel label_24 = new JLabel("Daily Hire Rate :");
		label_24.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_24.setBounds(536, 296, 159, 40);
		car_details_show.add(label_24);
		
		JLabel label_25 = new JLabel("Fuel Type:");
		label_25.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_25.setBounds(129, 441, 106, 40);
		car_details_show.add(label_25);
		
		JLabel label_26 = new JLabel("Number of Doors :");
		label_26.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_26.setBounds(1097, 296, 176, 40);
		car_details_show.add(label_26);
		
		JButton button_car_detail = new JButton("< Back");
		button_car_detail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				go_back_to_view_car();
			}
		});
		button_car_detail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_car_detail.setBounds(632, 774, 159, 47);
		car_details_show.add(button_car_detail);
		
		JButton button_36 = new JButton("Exit");
		button_36.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_36.setBounds(912, 774, 159, 47);
		car_details_show.add(button_36);
		
		JLabel lblCarStatus = new JLabel("Car Status:");
		lblCarStatus.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblCarStatus.setBounds(573, 441, 106, 40);
		car_details_show.add(lblCarStatus);
		
		JLabel lblHiredCustomer = new JLabel("Hired Customer:");
		lblHiredCustomer.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblHiredCustomer.setBounds(1108, 441, 159, 40);
		car_details_show.add(lblHiredCustomer);
		
		JLabel lblCustomerName = new JLabel("Customer Identification:");
		lblCustomerName.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblCustomerName.setBounds(12, 588, 244, 40);
		car_details_show.add(lblCustomerName);
		
		
		JLabel lblMinibusDetails = new JLabel("MINIBUS DETAILS");
		lblMinibusDetails.setFont(new Font("Candara", Font.BOLD, 38));
		lblMinibusDetails.setBounds(677, 28, 326, 47);
		minibus_details_show.add(lblMinibusDetails);
		
		JLabel label_38 = new JLabel("Registration Number:");
		label_38.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_38.setBounds(31, 160, 207, 40);
		minibus_details_show.add(label_38);
		
		JLabel label_39 = new JLabel("Top Speed :");
		label_39.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_39.setBounds(118, 296, 123, 40);
		minibus_details_show.add(label_39);
		
		JLabel lblMakeOfMinibus_1 = new JLabel("Make of MiniBus :");
		lblMakeOfMinibus_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblMakeOfMinibus_1.setBounds(516, 160, 176, 40);
		minibus_details_show.add(lblMakeOfMinibus_1);
		
		JLabel lblModelOfMinibus_1 = new JLabel("Model of MiniBus :");
		lblModelOfMinibus_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblModelOfMinibus_1.setBounds(1092, 160, 178, 40);
		minibus_details_show.add(lblModelOfMinibus_1);
		
		JLabel label_42 = new JLabel("Daily Hire Rate :");
		label_42.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_42.setBounds(536, 296, 159, 40);
		minibus_details_show.add(label_42);
		
		JLabel lblSeatingCapacity_1 = new JLabel("Seating Capacity:");
		lblSeatingCapacity_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblSeatingCapacity_1.setBounds(59, 441, 176, 40);
		minibus_details_show.add(lblSeatingCapacity_1);
		
		JLabel label_44 = new JLabel("Number of Doors :");
		label_44.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_44.setBounds(1097, 296, 176, 40);
		minibus_details_show.add(label_44);
		
		JButton button_26 = new JButton("< Back");
		button_26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				go_back_to_view_minibus();
			}
		});
		button_26.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_26.setBounds(632, 774, 159, 47);
		minibus_details_show.add(button_26);
		
		JButton button_30 = new JButton("Exit");
		button_30.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_30.setBounds(912, 774, 159, 47);
		minibus_details_show.add(button_30);
		
		JLabel lblMinibusStatus = new JLabel("MiniBus Status:");
		lblMinibusStatus.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblMinibusStatus.setBounds(533, 441, 159, 40);
		minibus_details_show.add(lblMinibusStatus);
		
		JLabel label_46 = new JLabel("Hired Customer:");
		label_46.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_46.setBounds(1108, 441, 159, 40);
		minibus_details_show.add(label_46);
		
		JLabel label_47 = new JLabel("Customer Identification:");
		label_47.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_47.setBounds(12, 588, 244, 40);
		minibus_details_show.add(label_47);
		
		
		
		JLabel lblLorryDetails = new JLabel("LORRY DETAILS");
		lblLorryDetails.setForeground(Color.WHITE);
		lblLorryDetails.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 38));
		lblLorryDetails.setBounds(677, 28, 326, 47);
		lorry_details_show.add(lblLorryDetails);
		
		JLabel label_41 = new JLabel("Registration Number:");
		label_41.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_41.setBounds(31, 160, 207, 40);
		lorry_details_show.add(label_41);
		
		JLabel label_43 = new JLabel("Top Speed :");
		label_43.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_43.setBounds(118, 296, 123, 40);
		lorry_details_show.add(label_43);
		
		JLabel lblMakeOfLorry_1 = new JLabel("Make of Lorry:");
		lblMakeOfLorry_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblMakeOfLorry_1.setBounds(548, 160, 147, 40);
		lorry_details_show.add(lblMakeOfLorry_1);
		
		JLabel lblModelOfLorry_1 = new JLabel("Model of Lorry :");
		lblModelOfLorry_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblModelOfLorry_1.setBounds(1116, 160, 159, 40);
		lorry_details_show.add(lblModelOfLorry_1);
		
		JLabel label_49 = new JLabel("Daily Hire Rate :");
		label_49.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_49.setBounds(536, 296, 159, 40);
		lorry_details_show.add(label_49);
		
		JLabel lblWeightCapacity = new JLabel("Weight Capacity:");
		lblWeightCapacity.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblWeightCapacity.setBounds(59, 441, 176, 40);
		lorry_details_show.add(lblWeightCapacity);
		
		JLabel label_51 = new JLabel("Number of Doors :");
		label_51.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_51.setBounds(1097, 296, 176, 40);
		lorry_details_show.add(label_51);
		
		JButton button_33 = new JButton("< Back");
		button_33.setBackground(new Color(51, 102, 102));
		button_33.setForeground(Color.WHITE);
		button_33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				go_back_to_view_lorry();
			}
		});
		button_33.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_33.setBounds(584, 774, 159, 47);
		lorry_details_show.add(button_33);
		
		JButton button_39 = new JButton("Exit");
		button_39.setBackground(new Color(51, 102, 102));
		button_39.setForeground(Color.WHITE);
		button_39.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_39.setBounds(864, 774, 159, 47);
		lorry_details_show.add(button_39);
		
		JLabel lblLorryStatus = new JLabel("Lorry Status:");
		lblLorryStatus.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblLorryStatus.setBounds(564, 441, 131, 40);
		lorry_details_show.add(lblLorryStatus);
		
		JLabel label_53 = new JLabel("Hired Customer:");
		label_53.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_53.setBounds(1108, 441, 159, 40);
		lorry_details_show.add(label_53);
		
		JLabel label_54 = new JLabel("Customer Identification:");
		label_54.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_54.setBounds(12, 588, 244, 40);
		lorry_details_show.add(label_54);
		
		 customer_details_show = new JPanel();
		customer_details_show.setLayout(null);
		customer_details_show.setBackground(new Color(95, 158, 160));
		main_panel.add(customer_details_show);
		
		
		
		JLabel label_40 = new JLabel("");
		label_40.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_40.setBounds(279, 588, 252, 40);
		customer_details_show.add(label_40);
		
		JLabel lblCustomerDetails = new JLabel("CUSTOMER DETAILS");
		lblCustomerDetails.setForeground(Color.WHITE);
		lblCustomerDetails.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 38));
		lblCustomerDetails.setBounds(643, 28, 360, 47);
		customer_details_show.add(lblCustomerDetails);
		
		JLabel lblIdentificationNumber = new JLabel("Identification Number:");
		lblIdentificationNumber.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblIdentificationNumber.setBounds(12, 160, 226, 40);
		customer_details_show.add(lblIdentificationNumber);
		
		JLabel lblPhoneNumber_1 = new JLabel("Phone Number :");
		lblPhoneNumber_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblPhoneNumber_1.setBounds(80, 345, 159, 40);
		customer_details_show.add(lblPhoneNumber_1);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblFirstName.setBounds(552, 160, 143, 40);
		customer_details_show.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblLastName.setBounds(1114, 160, 124, 40);
		customer_details_show.add(lblLastName);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblEmail.setBounds(585, 345, 73, 40);
		customer_details_show.add(lblEmail);
		
		JLabel lblUsername_1 = new JLabel("Username:");
		lblUsername_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblUsername_1.setBounds(117, 558, 113, 40);
		customer_details_show.add(lblUsername_1);
		
		JLabel lblDateOfBirth_1 = new JLabel("Date Of Birth:");
		lblDateOfBirth_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblDateOfBirth_1.setBounds(1095, 345, 143, 40);
		customer_details_show.add(lblDateOfBirth_1);
		
		JButton button_41 = new JButton("< Back");
		button_41.setForeground(Color.WHITE);
		button_41.setBackground(new Color(51, 102, 102));
		button_41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Remove_Previous_Panel();
				main_panel.add(view_customer);
			}
		});
		button_41.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_41.setBounds(585, 774, 159, 47);
		customer_details_show.add(button_41);
		
		JButton button_43 = new JButton("Exit");
		button_43.setForeground(Color.WHITE);
		button_43.setBackground(new Color(51, 102, 102));
		button_43.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_43.setBounds(952, 774, 159, 47);
		customer_details_show.add(button_43);
		
		JLabel lblPassword_1 = new JLabel("Password:");
		lblPassword_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblPassword_1.setBounds(552, 558, 113, 40);
		customer_details_show.add(lblPassword_1);
		
		JLabel lblAddress_1 = new JLabel("Address:");
		lblAddress_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblAddress_1.setBounds(1143, 558, 95, 40);
		customer_details_show.add(lblAddress_1);
		
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(Admin_menu.class.getResource("/application/Images/carr.png")));
		button.setForeground(SystemColor.inactiveCaption);
		button.setBorderPainted(false);
		button.setBorder(null);
		button.setBackground(new Color(0, 102, 102));
		button.setBounds(545, 32, 126, 84);
		contentPane.add(button);
		
		JLabel label = new JLabel("Northampton Vehicle Hire Company");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Tahoma", Font.ITALIC, 36));
		label.setBounds(709, 27, 621, 77);
		contentPane.add(label);
		
		left_panel = new JPanel();
		left_panel.setBackground(new Color(102, 153, 153));
		left_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		left_panel.setBounds(12, 146, 321, 834);
		contentPane.add(left_panel);
		left_panel.setLayout(null);
		
		JLabel lblAdminOptions = new JLabel("Admin Options");
		lblAdminOptions.setForeground(new Color(255, 255, 255));
		lblAdminOptions.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblAdminOptions.setBounds(84, 23, 150, 32);
		left_panel.add(lblAdminOptions);
		
		JButton btn_Add_Vehicle_pic = new JButton("");
		btn_Add_Vehicle_pic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Add_Vehicle_pic.setForeground(new Color(102, 102, 102));
		btn_Add_Vehicle_pic.setBorderPainted(false);
		btn_Add_Vehicle_pic.setBorder(null);
		btn_Add_Vehicle_pic.setBackground(new Color(102, 153, 153));
		btn_Add_Vehicle_pic.setIcon(new ImageIcon(Admin_menu.class.getResource("/application/Images/if_car_add_35817.png")));
		btn_Add_Vehicle_pic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Remove_Previous_Panel();
				main_panel.add(add_vehicle);

			}
		});
		btn_Add_Vehicle_pic.setBounds(43, 94, 65, 51);
		left_panel.add(btn_Add_Vehicle_pic);
		
		JButton btn_Remove_Vehicle_pic = new JButton("");
		btn_Remove_Vehicle_pic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Remove_Vehicle_pic.setBorderPainted(false);
		btn_Remove_Vehicle_pic.setIcon(new ImageIcon(Admin_menu.class.getResource("/application/Images/if_car_delete_35818.png")));
		btn_Remove_Vehicle_pic.setBackground(new Color(102, 153, 153));
		btn_Remove_Vehicle_pic.setBorder(null);
		btn_Remove_Vehicle_pic.setForeground(new Color(102, 102, 102));
		btn_Remove_Vehicle_pic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Remove_Previous_Panel();
				main_panel.add(remove_vehicle);

			}
		});
		btn_Remove_Vehicle_pic.setBounds(43, 210, 65, 51);
		left_panel.add(btn_Remove_Vehicle_pic);
		
		JButton btn_Hire_Vehicle_pic = new JButton("");
		btn_Hire_Vehicle_pic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Hire_Vehicle_pic.setBorderPainted(false);
		btn_Hire_Vehicle_pic.setIcon(new ImageIcon(Admin_menu.class.getResource("/application/Images/if_BT_c3angle_905667.png")));
		btn_Hire_Vehicle_pic.setBackground(new Color(102, 153, 153));
		btn_Hire_Vehicle_pic.setBorder(null);
		btn_Hire_Vehicle_pic.setForeground(new Color(102, 102, 102));
		btn_Hire_Vehicle_pic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Remove_Previous_Panel();
				main_panel.add(hire_vehicle);

			}
		});
		btn_Hire_Vehicle_pic.setBounds(43, 330, 65, 51);
		left_panel.add(btn_Hire_Vehicle_pic);
		
		JButton btn_Return_Vehicle_pic = new JButton("");
		btn_Return_Vehicle_pic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Return_Vehicle_pic.setBorderPainted(false);
		btn_Return_Vehicle_pic.setIcon(new ImageIcon(Admin_menu.class.getResource("/application/Images/back.png")));
		btn_Return_Vehicle_pic.setBackground(new Color(102, 153, 153));
		btn_Return_Vehicle_pic.setBorder(null);
		btn_Return_Vehicle_pic.setForeground(new Color(102, 102, 102));
		btn_Return_Vehicle_pic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Remove_Previous_Panel();
				main_panel.add(return_vehicle);

				
			}
		});
		btn_Return_Vehicle_pic.setBounds(43, 451, 65, 51);
		left_panel.add(btn_Return_Vehicle_pic);
		
		JButton btn_View_Vehicle_pic = new JButton("");
		btn_View_Vehicle_pic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_View_Vehicle_pic.setBorderPainted(false);
		btn_View_Vehicle_pic.setIcon(new ImageIcon(Admin_menu.class.getResource("/application/Images/vision.png")));
		btn_View_Vehicle_pic.setBackground(new Color(102, 153, 153));
		btn_View_Vehicle_pic.setBorder(null);
		btn_View_Vehicle_pic.setForeground(new Color(102, 102, 102));
		btn_View_Vehicle_pic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Remove_Previous_Panel();
				main_panel.add(view_vehicle);

			}
		});
		btn_View_Vehicle_pic.setBounds(43, 564, 65, 51);
		left_panel.add(btn_View_Vehicle_pic);
		
		JButton btn_View_Customer_pic = new JButton("");
		btn_View_Customer_pic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_View_Customer_pic.setBorderPainted(false);
		btn_View_Customer_pic.setIcon(new ImageIcon(Admin_menu.class.getResource("/application/Images/if_computer_1055084 (1).png")));
		btn_View_Customer_pic.setBackground(new Color(102, 153, 153));
		btn_View_Customer_pic.setBorder(null);
		btn_View_Customer_pic.setForeground(new Color(102, 102, 102));
		btn_View_Customer_pic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Remove_Previous_Panel();
				main_panel.add(view_customer);

				
			}
		});
		btn_View_Customer_pic.setBounds(43, 768, 65, 51);
		left_panel.add(btn_View_Customer_pic);
		
		JButton btn_Add_Customer_pic = new JButton("");
		btn_Add_Customer_pic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Add_Customer_pic.setBorderPainted(false);
		btn_Add_Customer_pic.setIcon(new ImageIcon(Admin_menu.class.getResource("/application/Images/add-user.png")));
		btn_Add_Customer_pic.setBackground(new Color(102, 153, 153));
		btn_Add_Customer_pic.setBorder(null);
		btn_Add_Customer_pic.setForeground(new Color(102, 102, 102));
		btn_Add_Customer_pic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Remove_Previous_Panel();
				main_panel.add(add_customer);

			}
		});
		btn_Add_Customer_pic.setBounds(43, 668, 65, 51);
		left_panel.add(btn_Add_Customer_pic);
		
		JButton btn_Add_Vehicle = new JButton("Add Vehicle");
		btn_Add_Vehicle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Add_Vehicle.setBackground(Color.LIGHT_GRAY);
		btn_Add_Vehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Removing Panel
				main_panel.removeAll();
				main_panel.repaint();
				main_panel.revalidate();
				
				//Adding new Panel
				main_panel.repaint();
				main_panel.revalidate();
				main_panel.add(add_vehicle);

			}
		});
		btn_Add_Vehicle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_Add_Vehicle.setBounds(109, 94, 159, 47);
		left_panel.add(btn_Add_Vehicle);
		
		JButton btn_Remove_Vehicle = new JButton("Remove Vehicle");
		btn_Remove_Vehicle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Remove_Vehicle.setBackground(Color.LIGHT_GRAY);
		btn_Remove_Vehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Remove_Previous_Panel();
				main_panel.add(remove_vehicle);

			}
		});
		btn_Remove_Vehicle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_Remove_Vehicle.setBounds(109, 210, 159, 47);
		left_panel.add(btn_Remove_Vehicle);
		
		JButton btn_Hire_Vehicle = new JButton("Hire Vehicle");
		btn_Hire_Vehicle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Hire_Vehicle.setBackground(Color.LIGHT_GRAY);
		btn_Hire_Vehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Remove_Previous_Panel();
				main_panel.add(hire_vehicle);

			}
		});
		btn_Hire_Vehicle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_Hire_Vehicle.setBounds(109, 334, 159, 47);
		left_panel.add(btn_Hire_Vehicle);
		
		JButton btn_Return_Vehicle = new JButton("Return Vehicle");
		btn_Return_Vehicle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Return_Vehicle.setBackground(Color.LIGHT_GRAY);
		btn_Return_Vehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Remove_Previous_Panel();
				main_panel.add(return_vehicle);

			}
		});
		btn_Return_Vehicle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_Return_Vehicle.setBounds(109, 451, 159, 47);
		left_panel.add(btn_Return_Vehicle);
		
		JButton btn_View_Vehicle = new JButton("View Vehicle");
		btn_View_Vehicle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_View_Vehicle.setBackground(Color.LIGHT_GRAY);
		btn_View_Vehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Remove_Previous_Panel();
				main_panel.add(view_vehicle);

			}
		});
		btn_View_Vehicle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_View_Vehicle.setBounds(109, 564, 159, 47);
		left_panel.add(btn_View_Vehicle);
		
		JButton btn_Add_Customer = new JButton("Add Customer");
		btn_Add_Customer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_Add_Customer.setBackground(Color.LIGHT_GRAY);
		btn_Add_Customer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Removing Panel
				Remove_Previous_Panel();
				main_panel.add(add_customer);

			}
		});
		btn_Add_Customer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_Add_Customer.setBounds(109, 668, 159, 47);
		left_panel.add(btn_Add_Customer);
		
		JButton btn_View_Customer = new JButton("View Customer");
		btn_View_Customer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn_View_Customer.setBackground(Color.LIGHT_GRAY);
		btn_View_Customer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				go_back_to_view_customer();

			}
		});
		btn_View_Customer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btn_View_Customer.setBounds(109, 770, 159, 49);
		left_panel.add(btn_View_Customer);
		
		 lbl_customer_id = new JLabel("");
		lbl_customer_id.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lbl_customer_id.setBounds(256, 160, 252, 40);
		customer_details_show.add(lbl_customer_id);
		
		 lbl_customer_first = new JLabel("");
		lbl_customer_first.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_customer_first.setBounds(722, 160, 252, 40);
		customer_details_show.add(lbl_customer_first);
		
		 lbl_customer_last = new JLabel("");
		lbl_customer_last.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_customer_last.setBounds(1287, 160, 252, 40);
		customer_details_show.add(lbl_customer_last);
		
		 lbl_customer_phone = new JLabel("");
		lbl_customer_phone.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_customer_phone.setBounds(251, 345, 252, 40);
		customer_details_show.add(lbl_customer_phone);
		
		 lbl_customer_email = new JLabel("");
		lbl_customer_email.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_customer_email.setBounds(720, 345, 252, 40);
		customer_details_show.add(lbl_customer_email);
		
		 lbl_customer_birth = new JLabel("");
		lbl_customer_birth.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_customer_birth.setBounds(1282, 345, 242, 40);
		customer_details_show.add(lbl_customer_birth);
		

		
		 lbl_customer_username = new JLabel("");
		lbl_customer_username.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_customer_username.setBounds(242, 558, 252, 40);
		customer_details_show.add(lbl_customer_username);
		
		lbl_customer_password = new JLabel("");
		lbl_customer_password.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_customer_password.setBounds(722, 558, 252, 40);
		customer_details_show.add(lbl_customer_password);
		
		lbl_customer_address = new JLabel("");
		lbl_customer_address.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_customer_address.setBounds(1287, 558, 262, 40);
		customer_details_show.add(lbl_customer_address);
		
		 btnShowHiredVehicle = new JButton("Show Hired Vehicle By Customer");
		 btnShowHiredVehicle.setForeground(Color.WHITE);
		 btnShowHiredVehicle.setBackground(new Color(51, 102, 102));
		 btnShowHiredVehicle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Remove_Previous_Panel();
				main_panel.add(view_hired_customer);
				
				table_hired_customer = new JTable();
				table_hired_customer.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 15));
				//table_car_hire.getTableHeader().setAlignmentX(alignmentX);
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment( JLabel.CENTER );
				table_hired_customer.setDefaultRenderer(Object.class, centerRenderer);
				table_hired_customer.setModel(new DefaultTableModel(
					
					null, new String[] {
						"Customer Name", "Make Of Car", "Vehicle Type"
					}
				));
				table_hired_customer.setRowHeight(30);
				table_hired_customer.setFont(new Font("Tahoma", Font.PLAIN, 18));
				scrollPane_hired_customer.setViewportView(table_hired_customer);
				model_hired_customer=(DefaultTableModel)table_hired_customer.getModel();
				Object[] row_hired_customer=new Object[3];
				for(int i=0;i<hired_vehicle_list.size();i++){
					
					if(hired_vehicle_list.get(i).Customer_Reg_No.equals(customer_reg_view)){
					row_hired_customer[0]=hired_vehicle_list.get(i).Customer_Name;
					row_hired_customer[1]=hired_vehicle_list.get(i).Vehicle_Make;
					row_hired_customer[2]=hired_vehicle_list.get(i).Vehicle_Type;
					
					model_hired_customer.addRow(row_hired_customer);
				
				}
				}
			}
		});
		btnShowHiredVehicle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnShowHiredVehicle.setBounds(682, 681, 303, 47);
		customer_details_show.add(btnShowHiredVehicle);
		
		view_hired_customer = new JPanel();
		view_hired_customer.setLayout(null);
		view_hired_customer.setBackground(new Color(95, 158, 160));
		main_panel.add(view_hired_customer);
		
		JLabel lblViewHiredVehicle = new JLabel("View Hired Vehicle");
		lblViewHiredVehicle.setForeground(Color.WHITE);
		lblViewHiredVehicle.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 38));
		lblViewHiredVehicle.setBounds(645, 27, 305, 41);
		view_hired_customer.add(lblViewHiredVehicle);
		
		JButton button_44 = new JButton("< Back");
		button_44.setBackground(new Color(51, 102, 102));
		button_44.setForeground(Color.WHITE);
		button_44.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_44.setBounds(596, 748, 159, 47);
		view_hired_customer.add(button_44);
		
		JButton button_46 = new JButton("Exit");
		button_46.setBackground(new Color(51, 102, 102));
		button_46.setForeground(Color.WHITE);
		button_46.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_46.setBounds(879, 748, 159, 47);
		view_hired_customer.add(button_46);
		
		scrollPane_hired_customer = new JScrollPane();
		scrollPane_hired_customer.setBounds(46, 156, 1497, 526);
		view_hired_customer.add(scrollPane_hired_customer);
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Admin_Sign sign_page= new Admin_Sign();
				sign_page.show();
				dispose();
			}
		});
		btnSignOut.setForeground(Color.WHITE);
		btnSignOut.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSignOut.setBackground(new Color(51, 102, 102));
		btnSignOut.setBounds(1690, 63, 188, 70);
		contentPane.add(btnSignOut);
		//btnShowHiredVehicle.setVisible(false);
		
		
	}
}
