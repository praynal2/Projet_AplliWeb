package Pack;

import java.util.Collection;
import java.util.List;

import javax.persistence.*;

@Entity
public class Client {
	
	@Id	
	private String login;
	private String password;

	@OneToMany(fetch = FetchType.EAGER)
	private Collection<Favorite> favorites;

	@OneToMany(fetch = FetchType.EAGER)
	private Collection<Purchase> purchases;

	public Client() {
	}
	
	public Client(String login, String password) {
		this.login = login; 
		this.password = password; 
	}
	
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

	public List<Favorite> getFavorites() {
		return (List<Favorite>) this.favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

	public Collection<Purchase> getPurchases() {
		return this.purchases;
	}

	public void setPurchase(Collection<Purchase> purchase) {
		this.purchases = purchase;
	}
}
