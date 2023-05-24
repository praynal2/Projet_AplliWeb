package Pack;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

public class Facade implements Facade_Itf {

	@PersistenceContext 
	private EntityManager em;

	public Facade() {}

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
	public List<Integer> getFavs(Integer idUser) {
		List<Integer> list = em.createQuery("SELECT m.id FROM Music m JOIN m.fav f WHERE f.client.id = :idUser").getResultList();
		return list;
	}

	// Utilisé pour ajouter des musiques favorites à un utilisateur
	public void addFavs(Integer idUser, List<Integer> idMusic) {
		Client user = em.find(Client.class, idUser);
		for (Integer id : idMusic) {
			Music music = em.find(Music.class, id);
			Favorite fav = new Favorite();
			fav.setClient(user);
			fav.setMusic(music);
			em.persist(fav);
		}
	}

	// Utilisé pour supprimer des musiques favorites à un utilisateur
	public void delFavs(Integer idUser, List<Integer> idMusic) {
		for (Integer id : idMusic) {
			List<Favorite> list = em.createQuery("SELECT f FROM Favorite f WHERE f.client.id = :idUser AND f.music.id = :idMusic").getResultList();
			for (Favorite fav : list) {
				em.remove(fav);
			}
		}
	}
}
