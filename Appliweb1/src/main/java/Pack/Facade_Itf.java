package Pack;

import javax.persistence.*;
import java.util.List;

public interface Facade_Itf {
	void addUser(String login, String password);
	boolean isUser(String login, String password);
	Client getClient(String login);
	List<List<String>> getAllMusic(); // [id, name, genre, path]
	List<Integer> getFavs(String login);
	void addFav(String login, int idMusic);
	void delFav(String login, int idMusic);
}