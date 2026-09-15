# Gestion Bibliothèque

Application Java console pour la gestion des livres et des emprunts d'une bibliothèque.

## Stack
- Java 26
- Maven

## Statut
Projet en cours de développement (séance 1 - exercice 1).

## Modèle du domaine

- `AbstractEntity` : classe abstraite portant l'identifiant commun (id)
- `Livre` : id, titre, auteur, isbn, disponible — hérite d'AbstractEntity, déclarée final
- `Emprunt` : id, livreId, nomEmprunteur, dateEmprunt, dateRetourPrevue, statut — hérite d'AbstractEntity, déclarée final
- `StatutEmprunt` : enum (EN_COURS, TERMINE, EN_RETARD)

### Relation
Un livre peut être emprunté plusieurs fois ; un emprunt concerne un seul livre.
Cardinalité : Livre 1 -------- 0..* Emprunt
Représentation choisie : Emprunt porte un `livreId` (association par identifiant, pas de référence directe à l'objet Livre).

`Livre` et `Emprunt` sont déclarées `final` car aucun sous-type n'est requis dans cet exercice.


## Données de démonstration
La classe `Demo` initialise 5 livres et 2 emprunts en mémoire (ArrayList), afin de vérifier que le modèle fonctionne correctement. Aucune base de données n'est utilisée à ce stade.