package application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Admin_Sign extends JFrame {

	private JPanel contentPane;
	private JLabel lblNorthamptonVehicle;
	private JButton button_lbl;
	static Admin_Sign frame;

	//Start Of the Applications
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new Admin_Sign();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	//Frame for SignIn Page
	public Admin_Sign() {
		setTitle("Northampton Vehicle Hire Company");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Admin_Sign.class.getResource("/application/Images/carr.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, 1950, 1040);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel main_panel = new JPanel();
		main_panel.setBorder(null);
		main_panel.setBackground(new Color(0, 102, 102));
		main_panel.setBounds(0, 0, 1924, 993);
		contentPane.add(main_panel);
		main_panel.setLayout(null);
		
		lblNorthamptonVehicle = new JLabel("Northampton Vehicle Hire Company");
		lblNorthamptonVehicle.setForeground(Color.WHITE);
		lblNorthamptonVehicle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 36));
		lblNorthamptonVehicle.setBounds(761, 54, 671, 77);
		main_panel.add(lblNorthamptonVehicle);
		
		button_lbl = new JButton("");
		button_lbl.setBackground(new Color(0, 102, 102));
		button_lbl.setForeground(SystemColor.inactiveCaption);
		button_lbl.setBorderPainted(false);
		button_lbl.setBorder(null);
		button_lbl.setIcon(new ImageIcon(Admin_Sign.class.getResource("/application/Images/carr.png")));
		button_lbl.setBounds(597, 59, 126, 84);
		main_panel.add(button_lbl);
		
		JButton btnLogInAsCustomer = new JButton("Log In As Customer");
		btnLogInAsCustomer.setForeground(Color.WHITE);
		btnLogInAsCustomer.setBackground(new Color(51, 102, 102));
		btnLogInAsCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LogInCustomer customer_login=new LogInCustomer();
				frame.setVisible(false);

				customer_login.show();
				dispose();
			}
		});
		btnLogInAsCustomer.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogInAsCustomer.setBounds(869, 261, 299, 138);
		main_panel.add(btnLogInAsCustomer);
		
		JButton btnLogInAsStaff = new JButton("Log In As Staff");
		btnLogInAsStaff.setForeground(Color.WHITE);
		btnLogInAsStaff.setBackground(new Color(51, 102, 102));
		btnLogInAsStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);

				LogInStaff staff_login=new LogInStaff();

				staff_login.show();
				dispose();
			}
		});
		btnLogInAsStaff.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogInAsStaff.setBounds(869, 565, 299, 138);
		main_panel.add(btnLogInAsStaff);
		
		JButton Btn_customer_logo = new JButton("");
		Btn_customer_logo.setBorder(null);
		Btn_customer_logo.setBorderPainted(false);
		Btn_customer_logo.setBackground(new Color(0, 102, 102));
		Btn_customer_logo.setIcon(new ImageIcon(Admin_Sign.class.getResource("/application/Images/customer_login.png")));
		Btn_customer_logo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LogInCustomer customer_login=new LogInCustomer();

				customer_login.show();
				//frame.setVisible(false);
	               dispose();



			}
		});
		Btn_customer_logo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Btn_customer_logo.setBounds(694, 261, 163, 138);
		main_panel.add(Btn_customer_logo);
		
		JButton button_staff_logo = new JButton("");
		button_staff_logo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LogInStaff staff_login=new LogInStaff();
				staff_login.show();
               dispose();
			}
		});
		button_staff_logo.setBorderPainted(false);
		button_staff_logo.setBackground(new Color(0, 102, 102));
		button_staff_logo.setBorder(null);
		button_staff_logo.setIcon(new ImageIcon(Admin_Sign.class.getResource("/application/Images/staff_logIn.png")));
		button_staff_logo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button_staff_logo.setBounds(694, 565, 163, 138);
		main_panel.add(button_staff_logo);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(new Color(51, 102, 102));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnExit.setBounds(936, 872, 184, 67);
		main_panel.add(btnExit);
		
		JButton Btn_exit_pic = new JButton("");
		Btn_exit_pic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);

			}
		});
		Btn_exit_pic.setBorder(null);
		Btn_exit_pic.setBorderPainted(false);
		Btn_exit_pic.setBackground(new Color(0, 102, 102));
		Btn_exit_pic.setIcon(new ImageIcon(Admin_Sign.class.getResource("/application/Images/close.png")));
		Btn_exit_pic.setBounds(838, 872, 97, 67);
		main_panel.add(Btn_exit_pic);
	}
}
