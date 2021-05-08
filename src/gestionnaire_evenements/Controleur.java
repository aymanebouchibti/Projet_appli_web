package gestionnaire_evenements;


import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Controleur
 */
@WebServlet("/Controleur")
public class Controleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private FacadeLocal facade;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controleur() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String op = request.getParameter("op");
		if (op.equals("creerEvenement")) {
			String titre = request.getParameter("titre");
			String organisateur = request.getParameter("organisateur");
			String categorie = request.getParameter("cathegorie");
			String enligne = request.getParameter("enligne");
			String lieu = request.getParameter("lieu");
			String dateDebut = request.getParameter("dateDebut");
			String dateFin = request.getParameter("dateFin");
			String heureDebut = request.getParameter("heureDebut");
			String heureFin = request.getParameter("heureFin");
			
			// creer la description de l'evenemnt
			String description = titre + " // " + organisateur  + " // " + lieu;
			// creer la date de debut et de fin
//			String[] ddebut = dateDebut.split("-");
//			String[] dfin = dateFin.split("-");
//			String[] hdebut = heureDebut.split(":");
//			String[] hfin = heureFin.split(":");
			
			
			facade.ajouterEvenement(description, facade.getCategorie(categorie), (enligne.equals("distanciel")?true:false));
			request.getRequestDispatcher("accueil.html").forward(request, response);
		}
		else if(op.equals("listerEvenements")) {
			request.setAttribute("listeEvenements", facade.listerEvenements());
			request.getRequestDispatcher("decouvrir.jsp").forward(request, response);
			
		}
		else if(op.equals("sinscrire")) {
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String mail = request.getParameter("adresse_mail");
			String pswd = request.getParameter("pswd");
			
			facade.ajouterInscrit(nom, prenom, mail, pswd);
			// a modifier
			request.getRequestDispatcher("SeConnecter.html").forward(request, response);
		}
		else if(op.equals("afficherEvenement")) {
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("event", facade.afficherEvenement(id));
			request.getRequestDispatcher("afficherEvenement.jsp").forward(request, response);
			
		}
		else if(op.equals("seConnecter")) {
			String email = request.getParameter("mail");
			String pswd = request.getParameter("password");
			if (facade.verifierCompte(email,pswd)) {
				int id = facade.getUserId(email);
				HttpSession session = request.getSession();
				session.setAttribute("userId", id);
				request.getRequestDispatcher("accueil.html").forward(request, response);
			}
			else {
				
			}
		}
		else if(op.equals("seDeconnecter")) {
			HttpSession session = request.getSession();
			session.invalidate();
			request.getRequestDispatcher("index.html").forward(request, response);
		}
		else if(op.equals("participerEvenement")) {
			int ide = Integer.parseInt(request.getParameter("ide"));
			int idu = Integer.parseInt(request.getParameter("idu"));
			facade.ajouterParticipant(idu, ide);
			request.getRequestDispatcher("accueil.html").forward(request, response);
		}
		else if(op.equals("interesserEvenement")) {
			int ide = Integer.parseInt(request.getParameter("ide"));
			int idu = Integer.parseInt(request.getParameter("idu"));
			facade.ajouterInteresse(idu, ide);
			request.getRequestDispatcher("accueil.html").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
