package Pack;

import javax.persistence.*;

@Entity
public class Purchase {
	@Id
	@GeneratedValue
	int id;

	@ManyToOne
	private Client client;

	@ManyToOne
	private Music music;

	public Purchase() {}

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