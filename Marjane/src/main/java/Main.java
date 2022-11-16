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
//        CentreController centreController = new CentreController();
//        centreController.CreateCentre("MarjaneDakhla", "Dakhla");
//        List<Centre> centres = centreController.getAllCentres();
//        centres.stream().forEach(centre -> {
//            System.out.println(centre.getIdCentre());
//            System.out.println(centre.getNomCentre());
//            System.out.println(centre.getVilleCentre());
//            System.out.println(centre.getCreatedAt());
//        });
//        PromotionController.updatePromotionStatus(6, "Encours");
//        ProduitController.CreateProduit("Bavette", 800, 2.00, 7);
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
//        PromotionDao promotionDao = new PromotionDao();
//        Promotion promotion = promotionDao.get(6);
//        System.out.println(promotion.getId());
//        System.out.println(promotion.getProduitId());
//        System.out.println(promotion.getStatus());
//        System.out.println(promotion.getTaux());
//        System.out.println(promotion.getPoints_fidelite());
//        System.out.println(promotion.getDate_fin());
//        System.out.println(promotion.getCreatedAt());
//        System.out.println(promotion.getUpdatedAt());
//        List <Promotion> promotions = PromotionController.getAllPromotions();
//        promotions.stream().forEach(promotion -> {
//            System.out.println(promotion.getId());
//            System.out.println(promotion.getProduitId());
//            System.out.println(promotion.getStatus());
//            System.out.println(promotion.getTaux());
//            System.out.println(promotion.getPoints_fidelite());
//            System.out.println(promotion.getDate_debut());
//            System.out.println(promotion.getDate_fin());
//            System.out.println(promotion.getCreatedAt());
//            System.out.println(promotion.getUpdatedAt());
//        });
//        List <Admin> admins = AdminController.countAllAdmin();
//        System.out.println(admins.toString());
        //ProduitRepo.DeleteProduit(4);
//        ProduitController.getProduitById(2).ifPresent(produit -> {
//            System.out.println(produit.getIdProduit());
//            System.out.println(produit.getNomProduit());
//            System.out.println(produit.getQuantite());
//            System.out.println(produit.getPrix());
//            System.out.println(produit.getCategorieId());
//            System.out.println(produit.getCreatedAt());
//            System.out.println(produit.getUpdatedAt());
//        });
    }
}
