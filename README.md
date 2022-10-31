# Promotion_Marjane_Backend

Gestion des Promotions Marjane Partie 1 ( backend )

![](https://simplonline.co/_next/image?url=https%3A%2F%2Fsimplonline-v3-prod.s3.eu-west-3.amazonaws.com%2Fmedia%2Fimage%2Fjpg%2F59d08616-073c-4400-87b9-9a3e1cc183b1.jpg&w=1280&q=75)

## Contexte du projet

---

> <h4> L’hypermarché Marjane Maroc souhaite simplifier la gestion des promotions de ses produits au niveau de tous les centres du royaume. </h4>

---

`L’ADMIN GENERAL` du groupe Marjane va prendre en charge :

- la gestion de chaque admin du centre par ville,

  > cette dernière peut avoir 1 ou plusieurs centre et chaque centre est géré par un seul `ADMIN`. <br>

- [x] La gestion de promotion est gérée chaque jour au niveau du centre.<br>

`ADMIN` **(crée par `L’ADMIN GENERAL` email et mot de passe provisoir envoyé par email)**

- crée une liste des promotions par catégorie des produits,
  > par exemple dans la catégorie multimédia on va ajouter une promotion des pc portable qui va être de 10% avec 100dhs gagné sur la carte fidélité

`RESPONSABLE DE RAYON __`(crée par `l'ADMIN`, email et mot de passe provisoire envoyé par email)\_\_ multimédia se connecte à son interface pour consulter sa liste des promotions pour accepter ou refuser selon la quantité du stock disponible dans le centre,

> si par exemple la quantité du stock des pc portable est de 80 unités, il va accepter la promotion en ajoutant un commentaire qui détermine la quantité des produits disponible.

## Règle générale

---

- Chaque promotion ne doit pas dépasser 50% du prix du produit.
- Chaque 5% de réduction vaut 50dhs de points de fidélité gagnés.
- La promotion des produits multimédia ne doit pas dépasser 20%.
- Chaque opération faite dans le système est enregistrée dans fichier de journalisation et dans la base de données.
- visualiser les statistiques des promotions appliquées et non apliquées
- Chaque Promotion est valable selon la quantité du stock disponible et consultable une fois entre 8h-12h.
