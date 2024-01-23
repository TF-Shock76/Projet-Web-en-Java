package donnees ;
import java. util. ArrayList;

public class JeuTheme {
    private Jeu jeu;
    private Theme theme;
    /*
    possibilité si pas moyen d'avoir le titre
    private String titre;
    et dans constructeur
    this.titre = jeu.getTitre();
    */
    
    public JeuTheme() {}

    public JeuTheme(Jeu jeu, Theme theme) {
	    this.jeu = jeu;
        this.theme = theme;
    }

    public JeuTheme(int idJeu, int idTheme) {
        
    }
    

    //Jeu
    public Jeu    getJeu()               { return this.jeu;            }
    public void   setTitre(String titre) { this.jeu.setTitre(titre);   }
    public String getTitre()             { return this.jeu.getTitre(); }

    //NbJoueurs
    public int getNbJoueursMin() { return this.jeu.getNbJoueursMin(); }
    public int getNbJoueursMax() { return this.jeu.getNbJoueursMax(); }

    public void setNbJoueursMin(int min) { this.jeu.setNbJoueursMin(min); }
    public void setNbJoueursMax(int max) { this.jeu.setNbJoueursMax(max); }

    //Theme
    public Theme  getTheme()     { return this.theme;                   }
    public void   setThemeNom(String theme) { this.theme.setNom(theme); }
    public String getThemeNom()  { return this.theme.getNom();          }

    //id
    public int getIdJeu()   { return this.jeu.getIdJeu();     }
    public int getIdTheme() { return this.theme.getIdTheme(); }
    //récupérer l'identifiant de chaque?

}