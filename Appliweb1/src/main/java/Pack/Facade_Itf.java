package Pack;

import javax.persistence.*;
import java.util.List;

public interface Facade_Itf {
	void addUser(String login, String password);
	boolean isUser(String login, String password);
	Client getClient(String login);
	void addMusic(String name, Style genre, String path);
	List<List<String>> getAllMusic(); // [id, name, genre, path]
	List<Favorite> getFavs(String login);
	void addFav(String login, int idMusic);
	void setFavs(String login, List<Integer> idMusic);
	void delFav(String login, int idMusic);
	List<Purchase> getPurchases(String login);
	void setPurchases(String login, List<Integer> idMusic);
}