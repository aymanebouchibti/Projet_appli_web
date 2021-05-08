package gestionnaire_evenements;

import java.util.Collection;

import javax.ejb.Local;


@Local
public interface FacadeLocal {
	public void ajouterInscrit(String nom, String prenom, String email, String motDePasse);
	public void ajouterEvenement(String description, Categorie categorie, boolean enligne);
	public void ajouterParticipant(int idParticipant, int idEvenement);
	public void ajouterInteresse(int idInteresse, int idEvenement);
	public Collection<Evenement> listerEvenements();
	public Evenement afficherEvenement(int idEvenement);
	public Categorie getCategorie(String c);
	public boolean verifierCompte(String mail, String pass);
	public int getUserId(String mail);
}
