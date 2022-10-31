package Controllers;

import DAO.Imple.PromotionDao;
import DAO.Imple.CategorieDao;
import Entity.Promotion;
import Entity.Categorie;
import Services.Variable;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class PromotionController {

    private static PromotionDao promotionDao = new PromotionDao();

    private static List<Promotion> AllPromotion = promotionDao.all();

    public static List<Promotion> listPromotion(Integer id){
        if(LocalTime.now().isAfter(LocalTime.of(8,0,0)) && LocalTime.now().isBefore(LocalTime.of(16,0,0))){
            return AllPromotion.stream()
                    .filter(promo -> promo.getId() == id)
                    .collect(Collectors.toList());
        }else{
            return null;
        }
    }

    public static List<Promotion> listEncoursPromotion(Integer id){
        if(LocalTime.now().isAfter(LocalTime.of(8,0,0)) && LocalTime.now().isBefore(LocalTime.of(12,0,0))){
            return AllPromotion.stream()
                    .filter(promo ->  promo.getId() == id)
                    .filter(promo -> Objects.equals(promo.getStatus(), Variable.status.Encours.toString()))
                    .collect(Collectors.toList());
        }else{
            return null;
        }
    }

    public static Boolean addPromotion(Promotion promo) {
        AtomicReference<Boolean> returnStatus = new AtomicReference<>(false);
        Optional<Categorie> categorie = new CategorieDao().findById((long) promo.getCategorieId());
        categorie.ifPresent(c -> {
            if (!(c.getNomCategorie().equalsIgnoreCase("Multimedia"))) {
                returnStatus.set(true);
            }
        });
        promo.setStatus(Variable.status.Accepter.toString());
        return returnStatus.get() && promotionDao.save(promo) != null;
    }

    public static Boolean accepterPromotion(Long id){
        AtomicReference<Boolean> rtnValue = new AtomicReference<>(false);
        PromotionDao promotionDao = new PromotionDao();
        Optional<Promotion> promotion = promotionDao.findById(id);
        promotion.ifPresent(pr -> {
            if(Objects.equals(pr.getStatus(), Variable.status.Encours.toString())) {
                pr.setStatus(Variable.status.Accepter.toString());
                if (promotionDao.update((long) pr.getId(), pr)) {
                    rtnValue.set(true);
                }
            }
        });
        return rtnValue.get();
    }

    // refuse the promotion by manager
    public static Boolean refuserPromotion(Long id){
        AtomicReference<Boolean> rtnValue = new AtomicReference<>(false);
        PromotionDao promotionDao = new PromotionDao();
        Optional<Promotion> promotion = promotionDao.findById(id);
        promotion.ifPresent(pr -> {
            if(Objects.equals(pr.getStatus(), Variable.status.Encours.toString())) {
                pr.setStatus(Variable.status.Refuser.toString());
                if (promotionDao.update((long) pr.getId(), pr)) {
                    rtnValue.set(true);
                }
            }
        });
        return rtnValue.get();
    }

}
