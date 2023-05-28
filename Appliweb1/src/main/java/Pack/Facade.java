package Pack;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.*;

@Singleton
public class Facade implements Facade_Itf {

	@PersistenceContext 
	private EntityManager em;

	// Utilisé pour l'inscription d'un utilisateur
	public void addUser(String login, String password) {
		Client user = new Client();
		user.setLogin(login);
		user.setPassword(password);
		em.persist(user);
	}

	// Utilisé pour la connexion d'un utilisateur
	public boolean isUser(String login, String password) {
		Client user = em.find(Client.class, login);
		if (user == null) {
			return false;
		}
		return user.getPassword().equals(password);
	}

	// Utilisé pour récupérer un utilisateur
	public Client getClient(String login) {
		Client user = em.find(Client.class, login);
		return user;
	}

	// Utilisé pour récupérer toutes les musiques
	public List<List<String>> getAllMusic() {
		List<List<String>> list = new ArrayList<List<String>>();
		List<Music> musics = em.createQuery("SELECT m FROM Music m").getResultList();
		for (Music m : musics) {
			List<String> carac = new ArrayList<String>();
			carac.add(String.valueOf(m.getId()));
			carac.add(m.getName());
			carac.add(m.getStyle().toString());
			carac.add(m.getUrl());
			list.add(carac);
		}
		return list;
	}

	// Utilisé pour récupérer les musiques favorites d'un utilisateur
	public List<Integer> getFavs(String login) {
		Client user = em.find(Client.class, login);
		List<Favorite> list = user.getFavorites();
		List<Integer> idList = new ArrayList<Integer>();
		for (Favorite fav : list) {
			idList.add(fav.getMusic().getId());
		}
		return idList;
	}

	// Utilisé pour ajouter une musique favorite à un utilisateur
	public void addFav(String login, int idMusic) {
		Client user = em.find(Client.class, login);
		List<Favorite> list = user.getFavorites();
		Music music = em.find(Music.class, idMusic);
		Favorite fav = new Favorite();
		fav.setClient(user);
		fav.setMusic(music);
		list.add(fav);
		em.persist(fav);
		// for (Integer id : idMusic) {
		// 	Music music = em.find(Music.class, id);
		// 	Favorite fav = new Favorite();
		// 	fav.setClient(user);
		// 	fav.setMusic(music);
		// 	list.add(fav);
		// 	em.persist(fav);
		// }
	}

	// Utilisé pour supprimer une musique favorite à un utilisateur
	public void delFav(String login, int idMusic) {
		Client user = em.find(Client.class, login);
		List<Favorite> list = user.getFavorites();
		Music music = em.find(Music.class, idMusic);
		if (list.contains(music)) {
			Favorite fav = new Favorite();
			fav.setClient(user);
			fav.setMusic(music);
			list.remove(fav);
			em.remove(fav);
		}
		// for (Favorite fav : list) {
		// 	int id = fav.getMusic().getId();
		// 	if (idMusic.contains(id)) {
		// 		em.remove(fav);
		// 		list.remove(fav);
		// 	}
		// }
	}
}
