package Pack;

import javax.persistence.*;
import java.util.List;

public interface Facade_Itf {
	void addUser(String login, String password);
	boolean isUser(String login, String password);
	List<List<String>> getAllMusic(); // [id, name, genre, path]
	List<Integer> getFavs(Integer idUser);
	void addFavs(Integer idUser, List<Integer> idMusic);
	void delFavs(Integer idUser, List<Integer> idMusic);
}