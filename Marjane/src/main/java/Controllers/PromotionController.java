package Controllers;

import DAO.Imple.PromotionDao;
import Entity.Promotion;
import Services.Variable;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PromotionController {

    private static PromotionDao promotionDao = new PromotionDao();
    //
    private static List<Promotion> AllPromotion = promotionDao.all();

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
        if (LocalTime.now().isAfter(LocalTime.of(8, 0, 0)) && LocalTime.now().isBefore(LocalTime.of(12, 0, 0))) {
            return AllPromotion.stream()
                    .filter(promo -> promo.getId() == id)
                    .filter(promo -> Objects.equals(promo.getStatus(), Variable.status.Encours.toString()))
                    .collect(Collectors.toList());
        } else {
            return null;
        }
    }

    public static Boolean ajouterPromotion(int produit_id, String status, float taux, Promotion promotion, long points_fidelite, LocalDate date_fin) {
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

//    public static Boolean modifierPromotion(int id, String status, PromotionDao promotionDAO){
//
//    }

//    public static Boolean refuserPromotion(Long id){
//
//    }
}

