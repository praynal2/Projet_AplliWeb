package Pack;

import javax.persistence.*;

@Entity
public class Favorite {
	@Id
	@GeneratedValue
	private int id;

	@ManyToOne(mappedBy="favorite")
	private Client client;

	@ManyToOne(mappedBy="fav")
	private Music music;

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
}
