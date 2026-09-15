# DevLog — Exercice 1 : Gestion d'une bibliothèque

## Git et GitHub
Git est un système de gestion de versions distribué qui fonctionne localement, indépendamment de GitHub. GitHub est une plateforme distante qui héberge les dépôts Git et ajoute des fonctionnalités de collaboration (Pull Requests, Issues). Git gère l'historique (commits, branches, tags) ; GitHub sert à sauvegarder ce dépôt à distance et à le partager.

## Branches créées et leur rôle
- `main` : branche stable, réservée aux releases finales (v1.0.0, v2.0.0). Reste vide à ce stade, conformément à la logique du Semantic Versioning.
- `develop` : branche d'intégration, reçoit les fusions de toutes les branches feature terminées.
- `feature/00-tooling` : mise en place de l'outillage (Maven, .gitignore, README).
- `feature/01-domain` : modélisation du domaine (AbstractEntity, Livre, Emprunt, StatutEmprunt).
- `feature/02-demo-data` : création des données de démonstration en mémoire.

## Tags posés et leur signification
- `v0.1.0` : outillage Git et Maven initialisé.
- `v0.2.0` : modèle objet du domaine terminé.
- `v0.3.0` : premières données en mémoire disponibles.

## Ce que Maven apporte au projet
Maven standardise la structure du projet et automatise la compilation, l'exécution et l'empaquetage via un cycle de phases (`clean`, `compile`, `test`, `package`). Le fichier `pom.xml` décrit le projet (groupId, artifactId, version) et sa configuration (ici, `maven.compiler.release=26`).

## Diagramme de classes
AbstractEntity
|
+---- Livre
|
+---- Emprunt

Livre 1 -------- 0..* Emprunt

## Pourquoi AbstractEntity est abstraite
`AbstractEntity` ne représente aucun concept concret du domaine à elle seule — c'est une base commune qui factorise l'identifiant (`id`). La rendre abstraite empêche de l'instancier directement, ce qui n'aurait pas de sens métier (une "entité" seule, sans être ni un Livre ni un Emprunt, n'existe pas).

## Pourquoi Livre et Emprunt sont final
Aucun sous-type de `Livre` ou `Emprunt` n'est requis dans cet exercice. Déclarer ces classes `final` empêche un héritage non prévu et non justifié par le domaine, évitant ainsi une hiérarchie inutile ou fragile.

## Relation entre Livre et Emprunt
Un livre peut être emprunté plusieurs fois au cours de sa vie ; un emprunt concerne un seul livre. Cardinalité : `Livre 1 -------- 0..* Emprunt`. La relation est représentée par association (Option A) : `Emprunt` porte un `livreId` (Long), plutôt qu'une référence directe à l'objet `Livre`.

