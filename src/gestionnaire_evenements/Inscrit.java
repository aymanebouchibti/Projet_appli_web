package gestionnaire_evenements;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Inscrit {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String nom;
	private String prenom;
	private String email;
	private String motDePasse;
	
	@ManyToMany(mappedBy = "listeParticipants")
	private Collection<Evenement> evenementsParticipes;
	
	@ManyToMany(mappedBy = "listeInteresses")
	private Collection<Evenement> evenementsInteresses;
	
	
	public Inscrit() {
		
	}
	
	public Inscrit(String nom, String prenom, String email, String motDePasse) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = motDePasse;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public Collection<Evenement> getEvenementsParticipes() {
		return evenementsParticipes;
	}
	public void setEvenementsParticipes(Collection<Evenement> evenementsParticipes) {
		this.evenementsParticipes = evenementsParticipes;
	}
	public Collection<Evenement> getEvenementsInteresses() {
		return evenementsInteresses;
	}
	public void setEvenementsInteresses(Collection<Evenement> evenementsInteresses) {
		this.evenementsInteresses = evenementsInteresses;
	}
	
	
	

}
