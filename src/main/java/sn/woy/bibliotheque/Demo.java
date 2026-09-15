package sn.woy.bibliotheque;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        List<Livre> livres = new ArrayList<>();
        livres.add(new Livre(1L, "1984", "George Orwell", "978-0451524935"));
        livres.add(new Livre(2L, "Le Petit Prince", "Antoine de Saint-Exupery", "978-2070408504"));
        livres.add(new Livre(3L, "Les Miserables", "Victor Hugo", "978-2253096344"));
        livres.add(new Livre(4L, "L'Etranger", "Albert Camus", "978-2070360024"));
        livres.add(new Livre(5L, "Candide", "Voltaire", "978-2081210481"));

        List<Emprunt> emprunts = new ArrayList<>();
        emprunts.add(new Emprunt(1L, 1L, "Awa Diop",
                LocalDate.of(2026, 9, 1), LocalDate.of(2026, 9, 15)));
        emprunts.add(new Emprunt(2L, 3L, "Moussa Ndiaye",
                LocalDate.of(2026, 9, 5), LocalDate.of(2026, 9, 19)));

        for (Livre livre : livres) {
            System.out.println(livre.getTitre() + " - " + livre.getAuteur()
                    + " (disponible: " + livre.isDisponible() + ")");
        }

        System.out.println("---");

        for (Emprunt emprunt : emprunts) {
            System.out.println("Emprunt #" + emprunt.getId() + " - livre id "
                    + emprunt.getLivreId() + " - " + emprunt.getNomEmprunteur()
                    + " - statut: " + emprunt.getStatut());
        }
    }
}