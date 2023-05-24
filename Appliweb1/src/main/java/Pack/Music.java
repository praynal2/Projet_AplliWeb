package Pack;

import javax.persistence.*;

@Entity
public class Music {
	@Id
	@GeneratedValue
	int id;
	String name;
	int price;
	Style style;
	String url;
	String image_url;

	@OneToMany
	private Favorite fav;

	@OneToMany
	private Purchase sale;

	public Music() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Favorite getFav() {
		return this.fav;
	}

	public void setFav(Favorite fav) {
		this.fav = fav;
	}

	public Purchase getSale() {
		return this.sale;
	}

	public void setSale(Purchase sale) {
		this.sale = sale;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Style getStyle() {
		return this.style;
	}

	public void setStyle(Style style) {
		this.style = style;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}		
}
