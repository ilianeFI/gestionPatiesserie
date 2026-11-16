# Plan de travail — Application de gestion de pâtisserie

## 1. Objectif du projet

Développer une application Java utilisable dans le terminal pour gérer une
pâtisserie. L'application doit permettre de gérer les employés, les produits,
les ingrédients, les ventes et les productions.

Le projet doit rester basé sur les notions étudiées en classe :

- classes, objets et classes imbriquées si elles sont utiles ;
- interfaces et interfaces fonctionnelles ;
- expressions lambda et Streams ;
- collections Java ;
- lecture et écriture de fichiers avec `Files`, entrées et sorties ;
- exceptions ;
- Maven ;
- interface utilisateur dans le terminal.

Aucun framework, aucune base de données et aucune interface graphique ne sont
nécessaires.

## 2. Répartition générale

| Personne | Responsabilité principale |
|---|---|
| Personne 1 | Tests des règles métier, du service, du stockage et de l'interface |
| Personne 2 | Développement de `PatisserieService.java` |
| Personne 3 | Développement de `FileStorage.java` et configuration Maven |
| Personne 4 | Gestion du projet, coordination et management |

---

## 3. Personne 1 — Tests et validation

### Mission

Vérifier que les différentes parties de l'application fonctionnent correctement
et que les règles métier sont respectées.

### A. Tests des règles métier du modèle

- [ ] Vérifier le calcul du sous-total d'une `LigneVente`.
- [ ] Vérifier le calcul du total d'une `Vente`.
- [ ] Vérifier qu'un produit peut être vendu lorsque le stock est suffisant.
- [ ] Vérifier qu'une vente est refusée lorsque le stock est insuffisant.
- [ ] Vérifier l'ajout et le retrait du stock d'un produit.
- [ ] Vérifier l'ajout et le retrait du stock d'un ingrédient.
- [ ] Vérifier les permissions de chaque rôle.
- [ ] Vérifier qu'une quantité négative ou nulle est refusée quand nécessaire.

### B. Tests de `PatisserieService`

- [ ] Tester l'ajout et la liste des produits.
- [ ] Tester l'ajout et la liste des ingrédients.
- [ ] Tester l'ajout et la liste des employés.
- [ ] Tester la recherche d'un élément par son identifiant.
- [ ] Tester une connexion avec des informations correctes.
- [ ] Tester une connexion avec un mauvais login ou mot de passe.
- [ ] Tester l'enregistrement d'une vente.
- [ ] Vérifier la diminution du stock après une vente.
- [ ] Tester l'enregistrement d'une production.
- [ ] Vérifier la consommation des ingrédients après une production.
- [ ] Vérifier l'augmentation du stock du produit fabriqué.

### C. Tests de `FileStorage`

- [ ] Tester la sauvegarde des produits dans un fichier CSV.
- [ ] Tester le chargement des produits.
- [ ] Tester la sauvegarde et le chargement des ingrédients.
- [ ] Tester la sauvegarde et le chargement des employés.
- [ ] Tester la sauvegarde et le chargement des ventes.
- [ ] Vérifier le comportement lorsque le fichier n'existe pas.
- [ ] Vérifier le comportement avec un fichier vide.
- [ ] Vérifier que les données chargées correspondent aux données sauvegardées.

### D. Tests de l'interface terminal

- [ ] Tester la connexion et la déconnexion.
- [ ] Vérifier que chaque rôle ouvre le bon menu.
- [ ] Vérifier les choix de menu incorrects.
- [ ] Vérifier la saisie de lettres à la place d'un nombre.
- [ ] Vérifier que les messages d'erreur sont compréhensibles.
- [ ] Réaliser un scénario complet : connexion, production, vente et sauvegarde.

### Livrables

- classes de tests ou programme de test manuel clairement organisé ;
- tableau des tests réussis et échoués ;
- liste des anomalies avec les étapes permettant de les reproduire ;
- scénario de démonstration finale.

### Branche Git conseillée

`test/validation-application`

---

## 4. Personne 2 — Service et logique métier

### Mission

Développer `PatisserieService.java`. Cette classe centralise la logique métier
et manipule les collections de l'application.

### A. Collections à gérer

- [ ] Créer une collection de produits.
- [ ] Créer une collection d'ingrédients.
- [ ] Créer une collection d'employés.
- [ ] Créer une collection de ventes.
- [ ] Créer une collection de productions.

### B. Gestion des employés

- [ ] Ajouter un employé.
- [ ] Lister les employés.
- [ ] Rechercher un employé par son identifiant.
- [ ] Vérifier que le login est unique.
- [ ] Connecter un employé avec son login et son mot de passe.
- [ ] Créer le compte gérant par défaut si aucun employé n'existe.

### C. Gestion des produits et ingrédients

- [ ] Ajouter un produit et un ingrédient.
- [ ] Lister les produits et les ingrédients.
- [ ] Rechercher un produit ou un ingrédient par son identifiant.
- [ ] Mettre à jour les quantités en stock.
- [ ] Utiliser les Streams et lambdas pour les recherches lorsque cela reste clair.

### D. Gestion des ventes

- [ ] Vérifier que l'employé a le droit de vendre.
- [ ] Vérifier que la vente contient au moins une ligne.
- [ ] Vérifier le stock de tous les produits avant de modifier les quantités.
- [ ] Diminuer le stock des produits vendus.
- [ ] Enregistrer la vente dans la collection.
- [ ] Lever une exception claire si la vente est impossible.

### E. Gestion des productions

- [ ] Vérifier que l'employé a le droit de produire.
- [ ] Vérifier que la quantité produite est positive.
- [ ] Calculer les quantités d'ingrédients nécessaires.
- [ ] Vérifier tous les ingrédients avant de modifier les stocks.
- [ ] Retirer les ingrédients utilisés.
- [ ] Augmenter le stock du produit fabriqué.
- [ ] Enregistrer la production dans la collection.

### Contraintes

- ne pas utiliser `Scanner` ou `System.out` dans le service ;
- ne pas lire directement les fichiers dans les méthodes métier ;
- utiliser des exceptions avec des messages explicites ;
- garder des méthodes courtes avec une seule responsabilité.

### Livrable

Un fichier `PatisserieService.java` fonctionnel et documenté, prêt à être appelé
par les menus et testé par la personne 1.

### Branche Git conseillée

`feature/patisserie-service`

---

## 5. Personne 3 — Stockage des données et Maven

### Mission

Développer `FileStorage.java`, préparer les fichiers CSV et configurer Maven.

### A. Configuration Maven

- [ ] Compléter le fichier `pom.xml`.
- [ ] Configurer le projet pour Java 17.
- [ ] Indiquer `com.patisserie.Main` comme classe principale.
- [ ] Vérifier la commande `mvn compile`.
- [ ] Vérifier la commande `mvn test`.
- [ ] Préparer la création d'un fichier JAR exécutable.

### B. Stockage CSV

- [ ] Créer le dossier `data` s'il n'existe pas.
- [ ] Sauvegarder et charger les employés.
- [ ] Sauvegarder et charger les produits.
- [ ] Sauvegarder et charger les ingrédients.
- [ ] Sauvegarder et charger les ventes.
- [ ] Définir clairement le format de chaque fichier CSV.
- [ ] Convertir une ligne CSV en objet Java.
- [ ] Convertir un objet Java en ligne CSV.
- [ ] Gérer les fichiers inexistants ou vides.
- [ ] Gérer les erreurs de lecture et d'écriture.

### Contraintes

- utiliser `Path`, `Files`, les Streams et les entrées/sorties étudiées ;
- ne placer aucune règle métier dans `FileStorage` ;
- ne pas utiliser `Scanner` ou afficher les menus dans cette classe ;
- fermer correctement les ressources ouvertes ;
- ne pas ajouter de bibliothèque externe sans accord de l'équipe.

### Livrables

- `FileStorage.java` fonctionnel ;
- `pom.xml` complet ;
- description du format des fichiers CSV ;
- commandes de compilation et d'exécution dans le `README.md`.

### Branche Git conseillée

`feature/storage-maven`

---

## 6. Personne 4 — Gestion du projet et management

### Mission

Organiser le travail de l'équipe, suivre l'avancement et assurer l'intégration
cohérente des différentes parties.

### A. Planification

- [ ] Définir les objectifs de chaque semaine.
- [ ] Transformer les tâches de ce document en tickets.
- [ ] Attribuer chaque ticket à une personne.
- [ ] Définir une date limite pour chaque étape.
- [ ] Identifier les dépendances entre les tâches.
- [ ] Organiser de courtes réunions de suivi.

### B. Suivi du projet

- [ ] Maintenir un tableau `À faire / En cours / Terminé`.
- [ ] Vérifier régulièrement l'avancement de chaque personne.
- [ ] Noter les difficultés et décider de leur priorité.
- [ ] S'assurer que le projet reste limité aux fonctionnalités demandées.
- [ ] Mettre à jour le `README.md` et la documentation générale.

### C. Gestion de Git

- [ ] Créer et protéger la branche principale.
- [ ] Vérifier que chaque personne travaille sur sa propre branche.
- [ ] Organiser les fusions dans le bon ordre.
- [ ] Relire les modifications avant chaque fusion.
- [ ] Résoudre les conflits avec les personnes concernées.
- [ ] Vérifier que le projet compile après chaque fusion.

### D. Préparation de la livraison

- [ ] Organiser la démonstration finale.
- [ ] Vérifier que tous les livrables sont présents.
- [ ] Préparer la répartition de la présentation orale.
- [ ] Vérifier les scénarios de test avec la personne 1.
- [ ] Préparer une version stable et identifiable du projet.

### Livrables

- planning du projet ;
- tableau de suivi des tâches ;
- comptes rendus courts des réunions ;
- documentation finale ;
- version intégrée et prête pour la présentation.

### Branche Git conseillée

La personne 4 ne développe pas directement sur la branche principale. Elle
prépare et vérifie les fusions à partir des branches des autres membres.

---

## 7. Dépendances et ordre conseillé

1. Vérifier ensemble les classes du dossier `model` et les signatures attendues.
2. La personne 2 développe le service en mémoire.
3. La personne 3 prépare Maven et commence le stockage CSV en parallèle.
4. La personne 1 écrit les scénarios de test dès que les signatures sont fixées.
5. La personne 4 organise les intégrations progressives.
6. La personne 1 réalise les tests d'intégration après chaque fusion.
7. Toute l'équipe corrige les anomalies puis prépare la démonstration.

## 8. Règles communes de travail

- Une personne ne modifie pas le fichier d'une autre sans la prévenir.
- Chaque commit doit représenter une modification précise.
- Le code doit être relu avant d'être fusionné.
- Le projet doit compiler après chaque fusion.
- Les messages et les noms du domaine restent en français.
- Les menus utilisent `Scanner` et `System.out`.
- Le service contient la logique métier.
- Le stockage contient uniquement la lecture et l'écriture des données.
- Les classes du modèle ne réalisent aucune entrée ou sortie.

## 9. Critères de fin du projet

Le projet est considéré comme terminé lorsque :

- [ ] un employé peut se connecter ;
- [ ] le menu affiché correspond à son rôle ;
- [ ] les produits, ingrédients et employés peuvent être gérés ;
- [ ] une production consomme les ingrédients et augmente le stock du produit ;
- [ ] une vente diminue le stock du produit ;
- [ ] une opération impossible affiche une erreur claire ;
- [ ] les données sont sauvegardées et rechargées depuis les fichiers CSV ;
- [ ] les principaux tests sont réussis ;
- [ ] `mvn compile`, `mvn test` et l'exécution de l'application fonctionnent ;
- [ ] la documentation explique comment lancer et utiliser le projet.

