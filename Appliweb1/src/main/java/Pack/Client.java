package Pack;

import javax.persistence.*;

@Entity
public class Client {
	
	@Id
	@GeneratedValue
	int id; 	
	String login;
	String password;
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	
}
