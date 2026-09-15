package sn.woy.bibliotheque;

import java.time.LocalDate;

public final class Emprunt extends AbstractEntity {

    private Long livreId;
    private String nomEmprunteur;
    private LocalDate dateEmprunt;
    private LocalDate dateRetourPrevue;
    private StatutEmprunt statut;

    public Emprunt(Long id, Long livreId, String nomEmprunteur,
                    LocalDate dateEmprunt, LocalDate dateRetourPrevue) {
        super(id);
        this.livreId = livreId;
        this.nomEmprunteur = nomEmprunteur;
        this.dateEmprunt = dateEmprunt;
        this.dateRetourPrevue = dateRetourPrevue;
        this.statut = StatutEmprunt.EN_COURS;
    }

    public Long getLivreId() {
        return livreId;
    }

    public String getNomEmprunteur() {
        return nomEmprunteur;
    }

    public LocalDate getDateEmprunt() {
        return dateEmprunt;
    }

    public LocalDate getDateRetourPrevue() {
        return dateRetourPrevue;
    }

    public StatutEmprunt getStatut() {
        return statut;
    }

    public void cloturer() {
        this.statut = StatutEmprunt.TERMINE;
    }
}
