import Controllers.*;
import DAO.Imple.*;
import Entity.*;
import Services.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        //System.out.println(Objects.requireNonNull(PromotionController.listPromotion(1)).get(0).getId());
        CentreController centreController = new CentreController();
        //centreController.CreateCentre("MarjaneNador", "Nador");
        List<Centre> centres = centreController.getAllCentres();
        centres.stream().forEach(centre -> {
            System.out.println(centre.getIdCentre());
            System.out.println(centre.getNomCentre());
            System.out.println(centre.getVilleCentre());
            System.out.println(centre.getCreatedAt());
        });
        //ProduitRepo.CreateProduit("Cherler", 6, 100.00, 7);
        /*List<Produit> produits = ProduitRepo.getAllProduits();
        produits.stream().forEach(produit -> {
            System.out.println(produit.getIdProduit());
            System.out.println(produit.getNomProduit());
            System.out.println(produit.getQuantite());
            System.out.println(produit.getPrix());
            System.out.println(produit.getCategorieId());
            System.out.println(produit.getCreatedAt());
            System.out.println(produit.getUpdatedAt());
        });*/
        //ProduitRepo.DeleteProduit(4);
        /*ProduitRepo.getProduitById(4).ifPresent(produit -> {
            System.out.println(produit.getIdProduit());
            System.out.println(produit.getNomProduit());
            System.out.println(produit.getQuantite());
            System.out.println(produit.getPrix());
            System.out.println(produit.getCategorieId());
            System.out.println(produit.getCreatedAt());
            System.out.println(produit.getUpdatedAt());
        });*/
    }
}
