package Controllers;

import DAO.Imple.ProduitDao;
import Entity.Produit;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public class ProduitController {

    private static final ProduitDao produitDao = new ProduitDao();

    public static Boolean CreateProduit(String nom_produit, Integer quantite, Double prix, Integer categorie_id) {
        Produit newProduit = new Produit();
        newProduit.setNomProduit(nom_produit);
        newProduit.setQuantite(quantite);
        newProduit.setPrix(prix);
        newProduit.setCategorieId(Math.toIntExact(categorie_id));
        newProduit.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        newProduit.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return produitDao.save(newProduit) != null;
    }

    public static Boolean UpdateProduit(Integer id_produit, String nom_produit, Integer quantite, Double prix, Integer categorie_id) {
        Produit newProduit = new Produit();
        newProduit.setIdProduit(id_produit);
        newProduit.setNomProduit(nom_produit);
        newProduit.setQuantite(quantite);
        newProduit.setPrix(prix);
        newProduit.setCategorieId(Math.toIntExact(categorie_id));
        newProduit.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        newProduit.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return produitDao.update(Long.valueOf(id_produit), newProduit) != null;
    }

    public static Boolean DeleteProduit(Integer id_produit) {
        return produitDao.delete(Long.valueOf(id_produit));
    }

    public static List<Produit> getAllProduits() {
        return produitDao.all();
    }

    public static Optional<Produit> getProduitById(Integer id_produit) {
        return produitDao.findById(Long.valueOf(id_produit));
    }

    

}
