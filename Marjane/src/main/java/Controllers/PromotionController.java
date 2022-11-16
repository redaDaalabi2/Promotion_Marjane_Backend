package Controllers;

import DAO.Imple.PromotionDao;
import Entity.Produit;
import Entity.Promotion;
import Services.Variable;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class PromotionController {

    private static PromotionDao promotionDao = new PromotionDao();

    private static List<Promotion> AllPromotion = promotionDao.all();

    public static List<Promotion> getAllPromotions() {
        return promotionDao.all();
    }

    public static List<Promotion> getAllPromotionsResponssableRayon() {
        if (LocalTime.now().isAfter(LocalTime.of(8, 0, 0)) && LocalTime.now().isBefore(LocalTime.of(12, 0, 0))){
            return promotionDao.all();
        }else {
            return null;
        }
    }

    public static List<Promotion> listPromotion(Integer id) {
        if (LocalTime.now().isAfter(LocalTime.of(8, 0, 0)) && LocalTime.now().isBefore(LocalTime.of(16, 0, 0))) {
            return AllPromotion.stream()
                    .filter(promo -> promo.getId() == id)
                    .collect(Collectors.toList());
        } else {
            return null;
        }
    }

    public static List<Promotion> listEncoursPromotion(Integer id) {
        if (LocalTime.now().isAfter(LocalTime.of(8, 0, 0)) && LocalTime.now().isBefore(LocalTime.of(20, 0, 0))) {
            return AllPromotion.stream()
                    .filter(promo -> promo.getId() == id)
                    .filter(promo -> Objects.equals(promo.getStatus(), Variable.status.Encours.toString()))
                    .collect(Collectors.toList());
        } else {
            return null;
        }
    }

    public static Boolean ajouterPromotion(int produit_id, String status, float taux, Promotion promotion, long points_fidelite, LocalDate date_fin) {
        List<Promotion> promotions = promotionDao.all();
        if(checkPromotionExists(promotions, produit_id)){
            return null;
        } else {
            for (Entity.Promotion promotion1: promotions){
                if(promotion1.getProduitId().equals(produit_id))
                    return null;
            }
            PromotionDao promotionDAO = new PromotionDao();
            promotion.setProduitId(produit_id);
            promotion.setStatus(status);
            promotion.setTaux(taux);
            promotion.setPoints_fidelite(points_fidelite);
            promotion.setDate_debut(LocalDate.now());
            promotion.setDate_fin(date_fin);
            promotion.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            promotion.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            return promotionDAO.save(promotion) != null;
        }
    }

    public static boolean checkPromotionExists(List<Promotion> promotions, int id){
        for (Entity.Promotion promotion: promotions){
            if (Objects.equals(id, promotion.getId())) {
                return true;
            }
        }
        return false;
    }

    public static boolean updatePromotionStatus(Integer id, String status) {
        Promotion promotion = promotionDao.get(id);
        promotion.setId(id);
        promotion.setStatus(status);
        if(promotionDao.update(Long.valueOf(id), promotion)){
            return true;
        }else {
            return false;
        }
    }

}

