package mvp;
import java.util.Date;

public class User {
	String email;
	String password;
	String username;
	String name;
	String surname;
	String gender;
	Date dateBirth;
	String country;
	boolean listVisibility;
	boolean receptionStatus;
	boolean commentsStatus;
	
	public boolean isCommentsStatus() {
		return commentsStatus;
	}
	public void setCommentsStatus(boolean commentsStatus) {
		this.commentsStatus = commentsStatus;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDateBirth() {
		return dateBirth;
	}
	
	public void setDateBirth(Date dateBirth){
		this.dateBirth = dateBirth;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public boolean isListVisibility() {
		return listVisibility;
	}
	public void setListVisibility(boolean listVisibility) {
		this.listVisibility = listVisibility;
	}
	public boolean isReceptionStatus() {
		return receptionStatus;
	}
	public void setReceptionStatus(boolean receptionStatus) {
		this.receptionStatus = receptionStatus;
	}

}
