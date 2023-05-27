package Pack;

import java.util.Collection;
import java.util.List;
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
	private Collection<Favorite> favs;

	@OneToMany
	private Collection<Purchase> sales;

	public Music() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Collection<Favorite> getFav() {
		return this.favs;
	}

	public void setFav(List<Favorite> favs) {
		this.favs = favs;
	}

	public Collection<Purchase> getSales() {
		return this.sales;
	}

	public void setSales(List<Purchase> sales) {
		this.sales = sales;
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
