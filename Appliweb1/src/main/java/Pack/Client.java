package Pack;

import javax.persistence.*;

@Entity
public class Client {
	
	@Id
	private String login;
	private String password;

	@OneToMany
	private Favorite favorite;

	@OneToMany
	private FavoriteStyle favorite_style;

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

	public Favorite getFavorite() {
		return this.favorite;
	}

	public void setFavorite(Favorite favorite) {
		this.favorite = favorite;
	}

	public FavoriteStyle getFavoriteStyle() {
		return this.favorite_style;
	}

	public void setFavoriteStyle(FavoriteStyle favorite_style) {
		this.favorite_style = favorite_style;
	}

	public Purchase getPurchase() {
		return this.purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}
}
