package donnees ;
import java. util. ArrayList;

public class Jeu {
    private int idJeu;
    private String titre;
    private int nbJoueursMin;
    private int nbJoueursMax;
    private ArrayList<Theme> alThemes;

    //Constructeur vide
    public Jeu() 
    {
        this.alThemes = new ArrayList<Theme>();
    }

    //Constructeur sans id
    public Jeu(String titre, int nbJoueursMin, int nbJoueursMax) {
        this.titre = titre.toUpperCase();
        this.nbJoueursMin = nbJoueursMin;
        this.nbJoueursMax = nbJoueursMax;   
        this.alThemes = new ArrayList<Theme>();    
    }

    //Constructeur avec id
    public Jeu(int idJeu, String titre, int nbJoueursMin, int nbJoueursMax) {
        this.idJeu = idJeu;
        this.titre = titre;
        this.nbJoueursMin = nbJoueursMin;
        this.nbJoueursMax = nbJoueursMax;
        this.alThemes = new ArrayList<Theme>();
    }

    //Constructeur titre
    public Jeu(String titre) 
    {
        this.titre = titre; 
        this.alThemes = new ArrayList<Theme>();
    }

    //Titre
    public void setTitre(String titre) { this.titre = titre.toUpperCase(); }
    public String getTitre()           { return this.titre;                }

    //id
    public int getIdJeu() { return this.idJeu; }

    //NbJoueurs
    public int getNbJoueursMin() { return this.nbJoueursMin; }
    public int getNbJoueursMax() { return this.nbJoueursMax; }

    public void setNbJoueursMin(int min) { this.nbJoueursMin = min; }
    public void setNbJoueursMax(int max) { this.nbJoueursMax = max; }

    //Theme

    public void addThemeNom(String nom) { this.alThemes.add(new Theme(nom)); }
    public void addTheme(Theme theme)   { this.alThemes.add(theme);          }

    public void setNom(int id, String theme) { this.alThemes.get(id).setNom(theme); }
    
    public ArrayList<Theme> getThemes() { return this.alThemes;                  }
    public Theme getTheme(int id)       { return this.alThemes.get(id);          }
    public String getThemeNom(int id)   { return this.alThemes.get(id).getNom(); }

}
