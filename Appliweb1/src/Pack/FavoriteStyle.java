package Pack;

import javax.persistence.*;

@Entity
public class FavoriteStyle {
	@Id
	@GeneratedValue
	private int id;

	private Style style;

	@ManyToOne(mappedBy="favorite_style")
	private Client client;

	public FavoriteStyle() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Style getStyle() {
		return this.style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
