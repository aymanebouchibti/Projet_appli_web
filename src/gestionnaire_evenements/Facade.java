package gestionnaire_evenements;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Stateful;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


@Stateful
public class Facade implements FacadeLocal, FacadeRemote {
	
	@PersistenceContext
	EntityManager em;
	
	
	public void ajouterInscrit(String nom, String prenom, String email, String motDePasse) {
		Inscrit ins = new Inscrit(nom, prenom, email, motDePasse);
		em.persist(ins);
	}
	
	public void ajouterEvenement(String description, Categorie categorie, boolean enligne) {
		Evenement eve = new Evenement(description, categorie, enligne);
		em.persist(eve);
	}

	public void ajouterParticipant(int idParticipant, int idEvenement) {
		Inscrit par = em.find(Inscrit.class, idParticipant);
		Evenement event = em.find(Evenement.class, idEvenement);
		event.getListeParticipants().add(par);
		
	}

	public void ajouterInteresse(int idInteresse, int idEvenement) {
		Inscrit inter = em.find(Inscrit.class, idInteresse);
		Evenement event = em.find(Evenement.class, idEvenement);
		event.getListeInteresses().add(inter);
	}
	
	public Collection<Evenement> listerEvenements() {
		TypedQuery<Evenement> query = em.createQuery("select e from Evenement e", Evenement.class);
		return query.getResultList();
	}
	
	public Evenement afficherEvenement(int idEvenement) {
		Evenement event = em.find(Evenement.class, idEvenement);
		return event;
	}
	public boolean verifierCompte(String mail, String pass) {
		Query q = em.createNativeQuery("select u.email, u.motDePasse from Inscrit u");
		List<Object[]> emails = q.getResultList();
		
		for (Object[] e : emails) {
			if (e[0].equals(mail) && e[1].equals(pass)) {
				return true;
			}
		}
		return false;
	}
	
	public int getUserId(String mail) {
		Query q = em.createNativeQuery("select u.id, u.email from Inscrit u");
		List<Object[]> emails = q.getResultList();
		
		for (Object[] e : emails) {
			if (e[1].equals(mail)) {
				return (int) e[0];
			}
		}
		return 0;
	}
	
	public Categorie getCategorie(String c) {
		if (c.equals("famille")) {
			return Categorie.FAMILLE;
		}
		else if (c.equals("sport")) {
			return Categorie.SPORT;
		}
		else if (c.equals("science")) {
			return Categorie.SCIENCE;
		}
		else if (c.equals("celebration")) {
			return Categorie.CELEBRATION;
		}
		else if (c.equals("musique")) {
			return Categorie.MUSIQUE;
		}
		else if (c.equals("culture")) {
			return Categorie.CULTURE;
		}
		else if (c.equals("politique")) {
			return Categorie.POLITIQUE;
		}
		else return null;
	}
	
	
	
	

}
