package donnees ;


public class Theme {
    private int idTheme;
    private String nom;

    public Theme() {
    }

    public Theme(String nom) {
        this.nom = nom;    
    }

    public Theme(int idTheme, String nom) {
	    this.idTheme = idTheme;
        this.nom = nom;	   
    }
    
    public int getIdTheme()
    {
        return this.idTheme;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public String getNom()
    {
        return this.nom;
    }

}
