patisserie/
├── pom.xml
├── data/                          (si sans base de donnees)
│   ├── produits.csv
│   ├── ingredients.csv
│   ├── employes.csv
│   └── ventes.csv
└── src/
    └── main/
        └── java/
            └── com/patisserie/
                ├── Main.java
                │
                ├── model/                  (entités )
                │   ├── Categorie.java
                │   ├── RoleEmploye.java
                │   ├── Employe.java
                │   ├── Produit.java
                │   ├── Ingredient.java
                │   ├── LigneRecette.java
                │   ├── Vente.java
                │   ├── LigneVente.java
                │   └── Production.java
                │
                ├── service/                (logique métier)
                │   └── PatisserieService.java
                │
                ├── storage/                (sauvegarde des données)
                │   └── FileStorage.java
                │
                └── ui/                     (interface terminal)
                    ├── MenuPrincipal.java
                    ├── MenuCaissier.java
                    ├── MenuPatissier.java
                    └── MenuGerant.java
                    