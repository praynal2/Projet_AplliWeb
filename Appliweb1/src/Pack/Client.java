package Pack;

import javax.persistence.*;

@Entity
public class Client {
	
	@Id
	private String login;
	private String password;

	@OneToMany
	private List<Favorite> favorites;

	@OneToMany
	private Purchase purchase;

	public Client() {}
	
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
		return this.favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

	public Purchase getPurchase() {
		return this.purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}
}
