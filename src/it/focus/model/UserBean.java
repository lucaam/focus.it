package it.focus.model;

import java.sql.Date;

public class UserBean {
	
	private int id;
	private String usr;
	private String nome;
	private String cognome;
	private String email;
	private String pwd;
	private String role;
	private String birthplace;
	private String phone;
	private Date date;
	private int id_usrorder;
	private int id_addr;
	
	public UserBean(String userpwd, String userid)
	{
		setUsr(userid);
		setPwd(userpwd);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUsr() {
		return usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date2) {
		this.date = date2;
	}

	public int getId_usrorder() {
		return id_usrorder;
	}

	public void setId_usrorder(int id_usrorder) {
		this.id_usrorder = id_usrorder;
	}

	public int getId_addr() {
		return id_addr;
	}

	public void setId_addr(int id_addr) {
		this.id_addr = id_addr;
	}
	
	
}
