package Pack;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Favorite implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	private Client client;

	@ManyToOne
	private Music music;

	@OneToOne
	private FavoriteStyle favorite_style;

	public Favorite() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Music getMusic() {
		return this.music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}

	public FavoriteStyle getFavoriteStyle() {
		return this.favorite_style;
	}

	public void setFavoriteStyle(FavoriteStyle favorite_style) {
		this.favorite_style = favorite_style;
	}

}
