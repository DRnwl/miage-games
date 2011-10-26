package jsf;

class Utilisateur {

    private String login;
    protected String password;
    private final String nom;
    private final String prenom;

    Utilisateur(String nom, String prenom) {
        this.nom=nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
