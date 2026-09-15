package sn.woy.bibliotheque;

public final class Livre extends AbstractEntity {

    private String titre;
    private String auteur;
    private String isbn;
    private boolean disponible;

    public Livre(Long id, String titre, String auteur, String isbn) {
        super(id);
        this.titre = titre;
        this.auteur = auteur;
        this.isbn = isbn;
        this.disponible = true;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void marquerEmprunte() {
        this.disponible = false;
    }

    public void marquerDisponible() {
        this.disponible = true;
    }
}
