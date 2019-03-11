package application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;

public class Customer_View extends JFrame {

	private JPanel contentPane;
	public JPanel customer_main_panel,customer_first_view,customer_details, view_available_car_panel, view_vehicle_first_panel,view_available_minibus_panel,view_available_lorry_panel;
	public JLabel lbl_customer_view_id,lbl_customer_view_phone,lbl_customer_view_first,lbl_customer_view_last,lbl_customer_view_birth,lbl_customer_view_username,
	lbl_customer_view_password,lbl_customer_view_address,lbl_customer;
	public JTable table_available_car_view,table_available_minibus_view,table_available_lorry_view;
	public JScrollPane scrollPane_available_car,scrollPane_available_minibus,scrollPane_available_lorry;
	public String username,password,identification_number;
	static ArrayList<Car> vehicle_list = new ArrayList<Car>();
	static ArrayList<MiniBus> minibus_list = new ArrayList<MiniBus>();
	static ArrayList<Lorry> lorry_list = new ArrayList<Lorry>();
	static ArrayList<Customer> customer_list = new ArrayList<Customer>();
	static ArrayList<Hired_vehicle> hired_vehicle_list = new ArrayList<Hired_vehicle>();
	public DefaultTableModel model_available_car,model_available_minibus,model_available_lorry;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_View frame = new Customer_View();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});



	}
	
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

public static void add_Hired_vehicle_list(){
	
	try {

		FileInputStream fis = new FileInputStream("hired_vehicle.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
	    Hired_vehicle hired_obj=null;
		
		while ((hired_obj=(Hired_vehicle)ois.readObject())!=null) {
		
			
				
			hired_vehicle_list.add(hired_obj);

			
			

			
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
	
public void  Remove_Previous_Panel(){
		
		//Removing Panel
	
		customer_main_panel.removeAll();
		customer_main_panel.repaint();
		customer_main_panel.revalidate();
		
		//Adding new Panel
		
		customer_main_panel.repaint();
		customer_main_panel.revalidate();
		
	}

public void cutomer_detail(String user,String id){
	
	username=user;
	identification_number=id;
}

	/**
	 * Create the frame.
	 */
	public Customer_View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, 1950, 1040);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(Customer_View.class.getResource("/application/Images/carr.png")));
		button.setForeground(SystemColor.inactiveCaption);
		button.setBorderPainted(false);
		button.setBorder(null);
		button.setBackground(new Color(0, 102, 102));
		button.setBounds(512, 69, 126, 84);
		contentPane.add(button);
		
		JLabel label = new JLabel("Northampton Vehicle Hire Company");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 36));
		label.setBounds(676, 64, 663, 77);
		contentPane.add(label);
		
		 customer_main_panel = new JPanel();
		customer_main_panel.setBounds(12, 166, 1888, 792);
		contentPane.add(customer_main_panel);
		customer_main_panel.setLayout(new CardLayout(0, 0));
		
		customer_first_view = new JPanel();
		customer_first_view.setBackground(new Color(0, 102, 102));
		customer_first_view.setLayout(null);
		customer_main_panel.add(customer_first_view);
		
		JButton btnCheckDetails = new JButton("CHECK DETAILS");
		btnCheckDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Remove_Previous_Panel();
				customer_main_panel.add(customer_details);
				
				set_customer_info();

			}
		});
		btnCheckDetails.setForeground(Color.WHITE);
		btnCheckDetails.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnCheckDetails.setBackground(new Color(51, 102, 102));
		btnCheckDetails.setBounds(815, 179, 342, 129);
		customer_first_view.add(btnCheckDetails);
		
		JButton button_2 = new JButton("");
		button_2.setBackground(new Color(0, 102, 102));
		button_2.setIcon(new ImageIcon(Customer_View.class.getResource("/application/Images/customerrr.png")));
		button_2.setForeground(SystemColor.inactiveCaptionBorder);
		button_2.setBorderPainted(false);
		button_2.setBorder(null);
		button_2.setBounds(654, 179, 148, 129);
		customer_first_view.add(button_2);
		
		JButton button_1 = new JButton("");
		button_1.setBackground(new Color(0, 102, 102));
		button_1.setIcon(new ImageIcon(Customer_View.class.getResource("/application/Images/vvh.png")));
		button_1.setForeground(SystemColor.inactiveCaptionBorder);
		button_1.setBorderPainted(false);
		button_1.setBorder(null);
		button_1.setBounds(654, 472, 148, 129);
		customer_first_view.add(button_1);
		
		JButton btnViewVehicles = new JButton("VIEW VEHICLE'S");
		btnViewVehicles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Remove_Previous_Panel();
				customer_main_panel.add(view_vehicle_first_panel);
			}
		});
		btnViewVehicles.setForeground(Color.WHITE);
		btnViewVehicles.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnViewVehicles.setBackground(new Color(51, 102, 102));
		btnViewVehicles.setBounds(815, 472, 342, 129);
		customer_first_view.add(btnViewVehicles);
		
		 customer_details = new JPanel();
		 customer_details.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		 customer_details.setBackground(new Color(102, 153, 153));
		customer_details.setLayout(null);
		customer_main_panel.add(customer_details);
		
		JLabel label_1 = new JLabel("Identification Number:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_1.setBounds(73, 146, 226, 40);
		customer_details.add(label_1);
		
		JLabel label_2 = new JLabel("First Name:");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_2.setBounds(755, 146, 143, 40);
		customer_details.add(label_2);
		
		JLabel label_3 = new JLabel("Last Name:");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_3.setBounds(1376, 146, 124, 40);
		customer_details.add(label_3);
		
		JLabel label_4 = new JLabel("Date Of Birth:");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_4.setBounds(1358, 380, 143, 40);
		customer_details.add(label_4);
		
		JLabel label_5 = new JLabel("E-mail:");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_5.setBounds(789, 380, 73, 40);
		customer_details.add(label_5);
		
		JLabel label_6 = new JLabel("Phone Number :");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_6.setBounds(142, 380, 159, 40);
		customer_details.add(label_6);
		
		JLabel label_7 = new JLabel("Username:");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_7.setBounds(191, 588, 113, 40);
		customer_details.add(label_7);
		
		JLabel label_8 = new JLabel("Password:");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_8.setBounds(749, 588, 113, 40);
		customer_details.add(label_8);
		
		JLabel label_9 = new JLabel("Address:");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 19));
		label_9.setBounds(1406, 588, 95, 40);
		customer_details.add(label_9);
		
		JButton button_3 = new JButton("< Back");
		button_3.setBackground(new Color(51, 102, 102));
		button_3.setForeground(Color.WHITE);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Remove_Previous_Panel();
				customer_main_panel.add(customer_first_view);

			}
		});
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_3.setBounds(592, 718, 159, 47);
		customer_details.add(button_3);
		
		JButton button_4 = new JButton("Exit");
		button_4.setBackground(new Color(51, 102, 102));
		button_4.setForeground(Color.WHITE);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_4.setBounds(959, 718, 159, 47);
		customer_details.add(button_4);
		
		 lbl_customer_view_id = new JLabel("");
		lbl_customer_view_id.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lbl_customer_view_id.setBounds(345, 146, 252, 40);
		customer_details.add(lbl_customer_view_id);
		
		 lbl_customer_view_phone = new JLabel("");
		lbl_customer_view_phone.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lbl_customer_view_phone.setBounds(346, 380, 252, 40);
		customer_details.add(lbl_customer_view_phone);
		
		 lbl_customer_view_first = new JLabel("");
		lbl_customer_view_first.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lbl_customer_view_first.setBounds(915, 146, 297, 40);
		customer_details.add(lbl_customer_view_first);
		
		 lbl_customer = new JLabel("");
		lbl_customer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lbl_customer.setBounds(916, 380, 297, 40);
		customer_details.add(lbl_customer);
		
		 lbl_customer_view_last = new JLabel("");
		lbl_customer_view_last.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lbl_customer_view_last.setBounds(1545, 146, 252, 40);
		customer_details.add(lbl_customer_view_last);
		
		 lbl_customer_view_birth = new JLabel("");
		lbl_customer_view_birth.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lbl_customer_view_birth.setBounds(1546, 380, 252, 40);
		customer_details.add(lbl_customer_view_birth);
		
		 lbl_customer_view_username = new JLabel("");
		lbl_customer_view_username.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lbl_customer_view_username.setBounds(346, 588, 252, 40);
		customer_details.add(lbl_customer_view_username);
		
		 lbl_customer_view_password = new JLabel("");
		lbl_customer_view_password.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lbl_customer_view_password.setBounds(913, 588, 300, 40);
		customer_details.add(lbl_customer_view_password);
		
		 lbl_customer_view_address = new JLabel("");
		lbl_customer_view_address.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lbl_customer_view_address.setBounds(1546, 588, 252, 40);
		customer_details.add(lbl_customer_view_address);
		
		JButton btnSignOut = new JButton("Sign Out");
		btnSignOut.setBackground(new Color(51, 102, 102));
		btnSignOut.setForeground(Color.WHITE);
		btnSignOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin_Sign sign_page= new Admin_Sign();
				sign_page.show();
				dispose();
			}
		});
		btnSignOut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSignOut.setBounds(1331, 718, 159, 47);
		customer_details.add(btnSignOut);
		
		JLabel lblYourDetailsAre = new JLabel("Your Details");
		lblYourDetailsAre.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblYourDetailsAre.setBounds(882, 28, 169, 40);
		customer_details.add(lblYourDetailsAre);
		
		 view_vehicle_first_panel = new JPanel();
		 view_vehicle_first_panel.setBackground(new Color(0, 102, 102));
		view_vehicle_first_panel.setLayout(null);
		customer_main_panel.add(view_vehicle_first_panel);
		
		JButton btnViewCar = new JButton("View Available Car");
		btnViewCar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Remove_Previous_Panel();
				customer_main_panel.add(view_available_car_panel);
				table_available_car_view = new JTable();
				table_available_car_view.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 15));
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment( JLabel.CENTER );
				table_available_car_view.setDefaultRenderer(Object.class, centerRenderer);
				table_available_car_view.setModel(new DefaultTableModel(
					
					null, new String[] {
						"Registeration Number Of Car", "Make Of Car", "Model Of car", "Speed Of Car", "Day Hire Rate", "Number Of Doors","Fuel Type", "Status Of Car"
					}
				));
				table_available_car_view.setRowHeight(30);
				table_available_car_view.setFont(new Font("Tahoma", Font.PLAIN, 18));
				scrollPane_available_car.setViewportView(table_available_car_view);
				model_available_car=(DefaultTableModel)table_available_car_view.getModel();
				Object[] row_view_car=new Object[8];
				for(int i=0;i<vehicle_list.size();i++){
					if(vehicle_list.get(i).Vehicle_status.equals("Ready To Hire")){
					row_view_car[0]=vehicle_list.get(i).Reg_number;
					row_view_car[1]=vehicle_list.get(i).Make_Vehicle;
					row_view_car[2]=vehicle_list.get(i).Model_Vehicle;
					row_view_car[3]=vehicle_list.get(i).Speed_Vehicle;
					row_view_car[4]=vehicle_list.get(i).Hire_Rate_Vehicle;
					row_view_car[5]=vehicle_list.get(i).Number_doors;
					row_view_car[6]=vehicle_list.get(i).Fuel_Type;
					row_view_car[7]=vehicle_list.get(i).Vehicle_status;

					
					model_available_car.addRow(row_view_car);
					}
				
				}
			}
		});
		btnViewCar.setForeground(Color.WHITE);
		btnViewCar.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnViewCar.setBackground(new Color(51, 102, 102));
		btnViewCar.setBounds(838, 102, 373, 122);
		view_vehicle_first_panel.add(btnViewCar);
		
		JButton button_6 = new JButton("");
		button_6.setIcon(new ImageIcon(Customer_View.class.getResource("/application/Images/view_vehic.png")));
		button_6.setForeground(SystemColor.inactiveCaptionBorder);
		button_6.setBorderPainted(false);
		button_6.setBorder(null);
		button_6.setBackground(new Color(0, 102, 102));
		button_6.setBounds(655, 102, 147, 122);
		view_vehicle_first_panel.add(button_6);
		
		JButton button_7 = new JButton("");
		button_7.setIcon(new ImageIcon(Customer_View.class.getResource("/application/Images/minui.png")));
		button_7.setForeground(SystemColor.inactiveCaptionBorder);
		button_7.setBorderPainted(false);
		button_7.setBorder(null);
		button_7.setBackground(new Color(0, 102, 102));
		button_7.setBounds(655, 338, 147, 122);
		view_vehicle_first_panel.add(button_7);
		
		JButton btnViewMinibuses = new JButton("View Available Minibus");
		btnViewMinibuses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Remove_Previous_Panel();
				customer_main_panel.add(view_available_minibus_panel);
				table_available_minibus_view = new JTable();
				table_available_minibus_view.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 15));
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment( JLabel.CENTER );
				table_available_minibus_view.setDefaultRenderer(Object.class, centerRenderer);
				table_available_minibus_view.setModel(new DefaultTableModel(
					
					null, new String[] {
						"Registeration Number Of MiniBus", "Make Of MiniBus", "Model Of MiniBus", "Speed Of MiniBus", "Day Hire Rate", "Number Of Doors","Seating Capacity", "Status Of MiniBus"
					}
				));
				table_available_minibus_view.setRowHeight(30);
				table_available_minibus_view.setFont(new Font("Tahoma", Font.PLAIN, 18));
				scrollPane_available_minibus.setViewportView(table_available_minibus_view);
				model_available_minibus=(DefaultTableModel)table_available_minibus_view.getModel();
				Object[] row_view_minibus=new Object[8];
				for(int i=0;i<minibus_list.size();i++){
					if(minibus_list.get(i).Vehicle_status.equals("Ready To Hire")){
					row_view_minibus[0]=minibus_list.get(i).Reg_number;
					row_view_minibus[1]=minibus_list.get(i).Make_Vehicle;
					row_view_minibus[2]=minibus_list.get(i).Model_Vehicle;
					row_view_minibus[3]=minibus_list.get(i).Speed_Vehicle;
					row_view_minibus[4]=minibus_list.get(i).Hire_Rate_Vehicle;
					row_view_minibus[5]=minibus_list.get(i).Number_doors;
					row_view_minibus[6]=minibus_list.get(i).Seat_Capacity_MiniBus;
					row_view_minibus[7]=minibus_list.get(i).Vehicle_status;

					
					model_available_minibus.addRow(row_view_minibus);
					}
				
				}
			}
		});
		btnViewMinibuses.setForeground(Color.WHITE);
		btnViewMinibuses.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnViewMinibuses.setBackground(new Color(51, 102, 102));
		btnViewMinibuses.setBounds(838, 338, 373, 122);
		view_vehicle_first_panel.add(btnViewMinibuses);
		
		JButton button_5 = new JButton("");
		button_5.setIcon(new ImageIcon(Customer_View.class.getResource("/application/Images/lorryyy.png")));
		button_5.setForeground(SystemColor.inactiveCaptionBorder);
		button_5.setBorderPainted(false);
		button_5.setBorder(null);
		button_5.setBackground(new Color(0, 102, 102));
		button_5.setBounds(655, 560, 147, 122);
		view_vehicle_first_panel.add(button_5);
		
		JButton btnViewLorry = new JButton("View Available Lorry");
		btnViewLorry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Remove_Previous_Panel();
				customer_main_panel.add(view_available_lorry_panel);
				table_available_lorry_view = new JTable();
				table_available_lorry_view.getTableHeader().setFont(new Font("SansSerif", Font.ITALIC, 15));
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment( JLabel.CENTER );
				table_available_lorry_view.setDefaultRenderer(Object.class, centerRenderer);
				table_available_lorry_view.setModel(new DefaultTableModel(
					
					null, new String[] {
						"Registeration Number Of Lorry", "Make Of Lorry", "Model Of Lorry", "Speed Of Lorry", "Day Hire Rate", "Number Of Doors","Load Weight", "Status Of Lorry"
					}
				));
				table_available_lorry_view.setRowHeight(30);
				table_available_lorry_view.setFont(new Font("Tahoma", Font.PLAIN, 18));
				scrollPane_available_lorry.setViewportView(table_available_lorry_view);
				model_available_lorry=(DefaultTableModel)table_available_lorry_view.getModel();
				Object[] row_view_lorry=new Object[8];
				for(int i=0;i<lorry_list.size();i++){
					if(lorry_list.get(i).Vehicle_status.equals("Ready To Hire")){
					row_view_lorry[0]=lorry_list.get(i).Reg_number;
					row_view_lorry[1]=lorry_list.get(i).Make_Vehicle;
					row_view_lorry[2]=lorry_list.get(i).Model_Vehicle;
					row_view_lorry[3]=lorry_list.get(i).Speed_Vehicle;
					row_view_lorry[4]=lorry_list.get(i).Hire_Rate_Vehicle;
					row_view_lorry[5]=lorry_list.get(i).Number_doors;
					row_view_lorry[6]=lorry_list.get(i).Weight_Lorry;
					row_view_lorry[7]=lorry_list.get(i).Vehicle_status;

					
					model_available_lorry.addRow(row_view_lorry);
					}
				
				}
			}
		});
		btnViewLorry.setForeground(Color.WHITE);
		btnViewLorry.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnViewLorry.setBackground(new Color(51, 102, 102));
		btnViewLorry.setBounds(838, 560, 373, 122);
		view_vehicle_first_panel.add(btnViewLorry);
		
		JButton button_back = new JButton("Back");
		button_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Remove_Previous_Panel();
				customer_main_panel.add(customer_first_view);

			}
		});
		button_back.setForeground(Color.WHITE);
		button_back.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button_back.setBackground(new Color(51, 102, 102));
		button_back.setBounds(647, 712, 184, 67);
		view_vehicle_first_panel.add(button_back);
		
		JButton button_exit = new JButton("Exit");
		button_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		button_exit.setForeground(Color.WHITE);
		button_exit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button_exit.setBackground(new Color(51, 102, 102));
		button_exit.setBounds(980, 712, 184, 67);
		view_vehicle_first_panel.add(button_exit);
		
		 view_available_car_panel = new JPanel();
		 view_available_car_panel.setBackground(new Color(102, 153, 153));
		view_available_car_panel.setLayout(null);
		customer_main_panel.add(view_available_car_panel);
		
		JLabel lblAvailableCars = new JLabel("Available Car's");
		lblAvailableCars.setForeground(Color.WHITE);
		lblAvailableCars.setFont(new Font("Tahoma", Font.BOLD, 39));
		lblAvailableCars.setBounds(751, 33, 306, 77);
		view_available_car_panel.add(lblAvailableCars);
		
		 scrollPane_available_car = new JScrollPane();
		scrollPane_available_car.setBounds(181, 146, 1497, 526);
		view_available_car_panel.add(scrollPane_available_car);
		
		JButton button_back_car = new JButton("< Back");
		button_back_car.setBackground(new Color(51, 102, 102));
		button_back_car.setForeground(Color.WHITE);
		button_back_car.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Remove_Previous_Panel();
				customer_main_panel.add(view_vehicle_first_panel);
			}
		});
		button_back_car.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_back_car.setBounds(793, 717, 159, 47);
		view_available_car_panel.add(button_back_car);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(new Color(51, 102, 102));
		btnExit.setForeground(Color.WHITE);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnExit.setBounds(1083, 717, 159, 47);
		view_available_car_panel.add(btnExit);
		
		 view_available_minibus_panel = new JPanel();
		 view_available_minibus_panel.setBackground(new Color(102, 153, 153));
		view_available_minibus_panel.setLayout(null);
		customer_main_panel.add(view_available_minibus_panel);
		
		JLabel lblAvailableMinibus = new JLabel("Available MiniBus");
		lblAvailableMinibus.setForeground(Color.WHITE);
		lblAvailableMinibus.setFont(new Font("Tahoma", Font.BOLD, 39));
		lblAvailableMinibus.setBounds(745, 33, 356, 77);
		view_available_minibus_panel.add(lblAvailableMinibus);
		
		
		 scrollPane_available_minibus = new JScrollPane();
		scrollPane_available_minibus.setBounds(186, 146, 1497, 526);
		view_available_minibus_panel.add(scrollPane_available_minibus);
		
		JButton button_back_minibus = new JButton("< Back");
		button_back_minibus.setBackground(new Color(51, 102, 102));
		button_back_minibus.setForeground(Color.WHITE);
		button_back_minibus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Remove_Previous_Panel();
				customer_main_panel.add(view_vehicle_first_panel);
			}
		});
		button_back_minibus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_back_minibus.setBounds(780, 718, 159, 47);
		view_available_minibus_panel.add(button_back_minibus);
		
		JButton button_exit_minibus = new JButton("Exit");
		button_exit_minibus.setBackground(new Color(51, 102, 102));
		button_exit_minibus.setForeground(Color.WHITE);
		button_exit_minibus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_exit_minibus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_exit_minibus.setBounds(1070, 718, 159, 47);
		view_available_minibus_panel.add(button_exit_minibus);
		
		 view_available_lorry_panel = new JPanel();
		 view_available_lorry_panel.setBackground(new Color(102, 153, 153));
		view_available_lorry_panel.setLayout(null);
		customer_main_panel.add(view_available_lorry_panel);
		
		
		JLabel lblAvailableLorry = new JLabel("Available Lorry");
		lblAvailableLorry.setForeground(Color.WHITE);
		lblAvailableLorry.setFont(new Font("Tahoma", Font.BOLD, 39));
		lblAvailableLorry.setBounds(774, 33, 311, 77);
		view_available_lorry_panel.add(lblAvailableLorry);
		
		 scrollPane_available_lorry = new JScrollPane();
		scrollPane_available_lorry.setBounds(186, 146, 1497, 526);
		view_available_lorry_panel.add(scrollPane_available_lorry);
		
		JButton button_back_lorry = new JButton("< Back");
		button_back_lorry.setForeground(Color.WHITE);
		button_back_lorry.setBackground(new Color(51, 102, 102));
		button_back_lorry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Remove_Previous_Panel();
				customer_main_panel.add(view_vehicle_first_panel);
			}
		});
		button_back_lorry.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_back_lorry.setBounds(732, 717, 159, 47);
		view_available_lorry_panel.add(button_back_lorry);
		
		JButton button_exit_lorry = new JButton("Exit");
		button_exit_lorry.setForeground(Color.WHITE);
		button_exit_lorry.setBackground(new Color(51, 102, 102));
		button_exit_lorry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		button_exit_lorry.setFont(new Font("Tahoma", Font.PLAIN, 18));
		button_exit_lorry.setBounds(1022, 717, 159, 47);
		view_available_lorry_panel.add(button_exit_lorry);
	}
	
	public void set_customer_info(){
		
		for(int i=0;i<customer_list.size();i++){
			
			if(customer_list.get(i).Id_number.equals(identification_number)){

				lbl_customer_view_last.setText(customer_list.get(i).Last_name);
				lbl_customer_view_first.setText(customer_list.get(i).First_name);
				lbl_customer_view_phone.setText(customer_list.get(i).Phone_number);
				lbl_customer_view_birth.setText(customer_list.get(i).Date_of_birth);
				lbl_customer_view_username.setText(customer_list.get(i).User_name);
				lbl_customer_view_password.setText(customer_list.get(i).Password);
				lbl_customer_view_address.setText(customer_list.get(i).Address);
				lbl_customer_view_id.setText(customer_list.get(i).Id_number);
				lbl_customer.setText(customer_list.get(i).Email);





				
			}
		}
	}
}