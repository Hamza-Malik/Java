package application;

import java.io.Serializable;

public class Customer implements Serializable {
	public String First_name;
	public String Last_name;
	public String Id_number;
	public String Phone_number;
	public String Email;
	public String Date_of_birth;
	public String User_name;
	public String Password;
	public String Address;
	
	public Customer(String first_name,String last_name,String id_number, String phone_number,String email, String date_of_birth, String user_name,String password, String address){
		First_name=first_name;
		Last_name=last_name;
		Id_number=id_number;
		Phone_number=phone_number;
		Email=email;
		Date_of_birth=date_of_birth;
		User_name=user_name;
		Password=password;
		Address=address;
	}

	public String getFirst_name() {
		return First_name;
	}

	public void setFirst_name(String first_name) {
		First_name = first_name;
	}

	public String getLast_name() {
		return Last_name;
	}

	public void setLast_name(String last_name) {
		Last_name = last_name;
	}

	public String getId_number() {
		return Id_number;
	}

	public void setId_number(String id_number) {
		Id_number = id_number;
	}

	public String getPhone_number() {
		return Phone_number;
	}

	public void setPhone_number(String phone_number) {
		Phone_number = phone_number;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getDate_of_birth() {
		return Date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		Date_of_birth = date_of_birth;
	}

	public String getUser_name() {
		return User_name;
	}

	public void setUser_name(String user_name) {
		User_name = user_name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}









}
