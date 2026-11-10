# Pâtisserie MVP

Application backend en **Java**, **terminal uniquement** (console), pour la gestion d'une pâtisserie.
C'est un **MVP** : toujours privilégier la solution la plus simple. Ne pas ajouter de fonctionnalités non demandées.

## Stack

- Java 17+
- Maven
- Aucune dépendance externe au début (pas de Spring, pas d'ORM)
- Stockage : en mémoire (`ArrayList`) d'abord, puis fichiers CSV dans `data/`

## Structure du projet

```
src/main/java/com/patisserie/
├── Main.java
├── model/      entités et enums (Produit, Ingredient, Employe, Vente, ...)
├── service/    logique métier (PatisserieService)
├── storage/    lecture/écriture des données (FileStorage)
└── ui/         interface terminal (menus, Scanner, System.out)
data/           fichiers CSV de sauvegarde
```

## Règles d'architecture (à respecter strictement)

Le flux va dans un seul sens : `ui → service → storage`, avec `model` utilisé par toutes les couches.

- `ui` : seul endroit où l'on utilise `Scanner` et `System.out`. N'accède jamais directement à `storage`.
- `service` : logique métier uniquement. **Aucun** `System.out.println` ni `Scanner`.
- `storage` : lecture/écriture des données uniquement. Aucune logique métier.
- `model` : attributs, getters/setters, petites règles locales (`calculerTotal()`, `peutVendre()`). Aucune I/O.
- Un seul `Scanner` partagé, créé dans `Main` et passé aux menus.

## Modèle de données

- `Produit` (id, nom, prix, categorie, quantiteStock)
- `Ingredient` (id, nom, quantiteStock, unite)
- `LigneRecette` (quantiteNecessaire) : lie un `Produit` à un `Ingredient`
- `Vente` (id, date) + `LigneVente` (quantite, prixUnitaire) : composition
- `Production` (id, date, quantiteProduite) : liée à un `Produit` et à un `Employe`
- `Employe` (id, nom, prenom, login, motDePasse, role)
- Enums : `Categorie` (GATEAU, VIENNOISERIE, TARTE, BISCUIT), `RoleEmploye` (CAISSIER, PATISSIER, CHEF_PATISSIER, GERANT)

## Permissions par rôle

| Rôle | Vendre | Produire | Gérer stock/ingrédients | Gérer employés |
|---|---|---|---|---|
| CAISSIER | oui | non | non | non |
| PATISSIER | non | oui | non | non |
| CHEF_PATISSIER | non | oui | oui | non |
| GERANT | oui | oui | oui | oui |

## Règles métier clés

- Une `Production` augmente le stock du `Produit` et déduit les ingrédients selon la recette.
- Une `Vente` diminue le stock du `Produit` ; refuser la vente si le stock est insuffisant.
- Un compte gérant par défaut (`admin` / `admin`) est créé au premier lancement.
- Ne pas stocker les mots de passe en clair à terme (hachage SHA-256 minimum).

## Conventions de code

- Packages : `com.patisserie.<couche>`
- Classes en `PascalCase`, méthodes et variables en `camelCase`, constantes en `UPPER_SNAKE_CASE`
- Noms du domaine en **français** (`Produit`, `Vente`, `enregistrerVente`), mots techniques Java en anglais
- Utiliser `LocalDateTime` pour les dates, jamais `Date`
- Valider les saisies utilisateur dans `ui` (nombres, choix de menu) sans faire planter le programme
- Lever des exceptions claires dans `service` (ex. `IllegalArgumentException`, stock insuffisant), les afficher dans `ui`
- Méthodes courtes, une responsabilité par méthode

## Commandes

```bash
mvn compile                          # compiler
mvn exec:java -Dexec.mainClass=com.patisserie.Main   # lancer l'application
mvn package                          # générer le jar
java -jar target/patisserie-1.0.jar  # lancer le jar
mvn test                             # lancer les tests
```
## Hors périmètre du MVP (ne pas implémenter sauf demande explicite)

Clients, commandes à retirer, paiements, fournisseurs, approvisionnements, API REST, base de données, interface graphique.

## Ordre de développement

1. `model` (enums puis entités)
2. `service` en mémoire
3. `ui` : connexion puis menus selon le rôle
4. `storage` : sauvegarde CSV
5. Fonctionnalités : connexion, produits, ventes, ingrédients, production

## Façon de travailler

- Avant de modifier plusieurs fichiers, expliquer brièvement le plan.
- Ne pas refactorer du code qui n'est pas concerné par la tâche.
- Après une modification, vérifier que `mvn compile` passe.
- Répondre et commenter en français.