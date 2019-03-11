package application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;

public class LogInStaff extends JFrame {

	private JPanel contentPane;
	private JTextField textField_staff_username;
	static LogInStaff frame;
	private JPasswordField textField_staff_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new LogInStaff();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LogInStaff() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1950, 1040);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(LogInStaff.class.getResource("/application/Images/carr.png")));
		button.setForeground(SystemColor.inactiveCaption);
		button.setBorderPainted(false);
		button.setBorder(null);
		button.setBackground(new Color(0, 102, 102));
		button.setBounds(561, 79, 126, 84);
		contentPane.add(button);
		
		JLabel label = new JLabel("Northampton Vehicle Hire Company");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 36));
		label.setBounds(725, 74, 660, 77);
		contentPane.add(label);
		
		JButton button_extra = new JButton("");
		button_extra.setIcon(new ImageIcon(LogInStaff.class.getResource("/application/Images/uu.png")));
		button_extra.setBorderPainted(false);
		button_extra.setBorder(null);
		button_extra.setBackground(new Color(0, 102, 102));
		button_extra.setBounds(578, 311, 69, 67);
		contentPane.add(button_extra);
		
		JLabel lblStaffUsername = new JLabel("Staff Username :");
		lblStaffUsername.setForeground(Color.WHITE);
		lblStaffUsername.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblStaffUsername.setBounds(647, 309, 210, 77);
		contentPane.add(lblStaffUsername);
		
		textField_staff_username = new JTextField();
		textField_staff_username.setColumns(10);
		textField_staff_username.setBounds(869, 323, 468, 49);
		contentPane.add(textField_staff_username);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(LogInStaff.class.getResource("/application/Images/key.png")));
		button_2.setBorderPainted(false);
		button_2.setBorder(null);
		button_2.setBackground(new Color(0, 102, 102));
		button_2.setBounds(578, 598, 69, 67);
		contentPane.add(button_2);
		
		JLabel lblStaffPassword = new JLabel("Staff Password :");
		lblStaffPassword.setForeground(Color.WHITE);
		lblStaffPassword.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblStaffPassword.setBounds(647, 588, 210, 77);
		contentPane.add(lblStaffPassword);
		
		JButton button_staff_login_exit_pic = new JButton("");
		button_staff_login_exit_pic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_staff_login_exit_pic.setIcon(new ImageIcon(LogInStaff.class.getResource("/application/Images/close.png")));
		button_staff_login_exit_pic.setBorderPainted(false);
		button_staff_login_exit_pic.setBorder(null);
		button_staff_login_exit_pic.setBackground(new Color(0, 102, 102));
		button_staff_login_exit_pic.setBounds(761, 878, 97, 67);
		contentPane.add(button_staff_login_exit_pic);
		
		JButton button_staff_login_exit = new JButton("Exit");
		button_staff_login_exit.setForeground(Color.WHITE);
		button_staff_login_exit.setBackground(new Color(51, 102, 102));
		button_staff_login_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_staff_login_exit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button_staff_login_exit.setBounds(859, 878, 184, 67);
		contentPane.add(button_staff_login_exit);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(LogInStaff.class.getResource("/application/Images/signIn.png")));
		button_3.setBorderPainted(false);
		button_3.setBorder(null);
		button_3.setBackground(new Color(0, 102, 102));
		button_3.setBounds(1154, 878, 97, 67);
		contentPane.add(button_3);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.setForeground(Color.WHITE);
		btnSignIn.setBackground(new Color(51, 102, 102));
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField_staff_username.getText().equals("staff") && textField_staff_password.getText().equals("staff")){
					
					Admin_menu admin_panel=new Admin_menu();
					Admin_menu.add_Car_list();
					Admin_menu.add_miniBus_list();
					Admin_menu.add_Lorry_list();
					Admin_menu .add_Customer_list();
					Admin_menu.add_Hired_vehicle_list();
					admin_panel.show();
		              dispose();


				}
				
				else{
		            JOptionPane.showMessageDialog(null, "Username Or Passowrd Wrong","ERROR",JOptionPane.ERROR_MESSAGE);

					
				}
			}
		});
		btnSignIn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSignIn.setBounds(1252, 878, 184, 67);
		contentPane.add(btnSignIn);
		
		textField_staff_password = new JPasswordField();
		textField_staff_password.setBounds(869, 610, 468, 44);
		contentPane.add(textField_staff_password);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(LogInStaff.class.getResource("/application/Images/back.png")));
		button_4.setBorderPainted(false);
		button_4.setBorder(null);
		button_4.setBackground(new Color(0, 102, 102));
		button_4.setBounds(345, 878, 97, 67);
		contentPane.add(button_4);
		
		JButton buttonBack = new JButton("Back");
		buttonBack.setForeground(Color.WHITE);
		buttonBack.setBackground(new Color(51, 102, 102));
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Admin_Sign sign_page= new Admin_Sign();
				sign_page.show();
				dispose();
			}
		});
		buttonBack.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonBack.setBounds(443, 878, 184, 67);
		contentPane.add(buttonBack);
	}
}
