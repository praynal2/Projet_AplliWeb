package Pack;

import javax.persistence.*;
import java.util.List;

public interface Facade_Itf {
	void addUser(String login, String password);
	boolean isUser(String login, String password);
	Client getClient(String login);
	List<List<String>> getAllMusic(); // [id, name, genre, path]
	List<Favorite> getFavs(String login);
	void addFavs(String login, List<Integer> idMusic);
	void delFavs(String login, List<Integer> idMusic);
}