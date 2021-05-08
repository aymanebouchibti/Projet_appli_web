package gestionnaire_evenements;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Evenement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String adresse;
	private int prix;
    private int nbPlacesRestantes;
    private Date dateEvent; 
	private int idOrganisateur;
	private String description;
	private Categorie categorie;
	private boolean enligne;
	
	@ManyToMany()
	@JoinTable(name = "evenement_participants")
	private Collection<Inscrit> listeParticipants;
	
	@ManyToMany()
	@JoinTable(name = "evenement_interesses")
	private Collection<Inscrit> listeInteresses;


	public Evenement() {
		
	}
	public Evenement(String d, Categorie c, boolean e) {
    	description = d;
    	categorie = c;
    	enligne = e;
    }

	public Collection<Inscrit> getListeParticipants() {
		return listeParticipants;
	}


	public void setListeParticipants(Collection<Inscrit> listeParticipants) {
		this.listeParticipants = listeParticipants;
	}


	public Collection<Inscrit> getListeInteresses() {
		return listeInteresses;
	}


	public void setListeInteresses(Collection<Inscrit> listeInteresses) {
		this.listeInteresses = listeInteresses;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public int getPrix() {
		return prix;
	}


	public void setPrix(int prix) {
		this.prix = prix;
	}


	public int getNbPlacesRestantes() {
		return nbPlacesRestantes;
	}


	public void setNbPlacesRestantes(int nbPlacesRestantes) {
		this.nbPlacesRestantes = nbPlacesRestantes;
	}


	public Date getDateEvent() {
		return dateEvent;
	}


	public void setDateEvent(Date dateEvent) {
		this.dateEvent = dateEvent;
	}



	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getIdOrganisateur() {
		return idOrganisateur;
	}


	public void setIdOrganisateur(int idOrganisateur) {
		this.idOrganisateur = idOrganisateur;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public boolean isEnligne() {
		return enligne;
	}

	public void setEnligne(boolean enligne) {
		this.enligne = enligne;
	}
	
	
}
