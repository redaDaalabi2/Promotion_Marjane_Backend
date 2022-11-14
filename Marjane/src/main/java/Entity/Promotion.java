package Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
public class Promotion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "taux")
    private Float taux;
    @Basic
    @Column(name = "points_fidelite")
    private long points_fidelite;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "produit_id")
    private Integer produitId;
    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at")
    private Timestamp updatedAt;
    @Basic
    @Column(name = "date_debut")
    private LocalDate date_debut;
    @Basic
    @Column(name = "date_fin")
    private LocalDate date_fin;
    @ManyToOne
    @JoinColumn(name = "produit_id", referencedColumnName = "id_produit", nullable = false, insertable = false, updatable = false)
    private Produit produitByProduitId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Float getTaux() {
        return taux;
    }

    public void setTaux(Float taux) {
        this.taux = taux;
    }
    public long getPoints_fidelite() {
        return points_fidelite;
    }
    public void setPoints_fidelite(long points_fidelite) {
        this.points_fidelite = points_fidelite;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Integer getProduitId() {
        return produitId;
    }

    public void setProduitId(Integer produitId) {
        this.produitId = produitId;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDate getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(LocalDate date_debut) {
        this.date_debut = date_debut;
    }

    public LocalDate getDate_fin(){
        return date_fin;
    }

    public void setDate_fin(LocalDate date_fin){
        this.date_fin = date_fin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Promotion promotion = (Promotion) o;

        if (id != promotion.id) return false;
        if (taux != null ? !taux.equals(promotion.taux) : promotion.taux != null)
            return false;
        if (status != null ? !status.equals(promotion.status) : promotion.status != null) return false;
        if (produitId != null ? !produitId.equals(promotion.produitId) : promotion.produitId != null) return false;
        if (createdAt != null ? !createdAt.equals(promotion.createdAt) : promotion.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(promotion.updatedAt) : promotion.updatedAt != null) return false;
        if (date_debut != null ? !date_debut.equals(promotion.date_debut) : promotion.date_debut != null) return false;
        if (date_fin != null ? !date_fin.equals(promotion.date_fin) : promotion.date_fin != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (taux != null ? taux.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (produitId != null ? produitId.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (date_debut != null ? date_debut.hashCode() : 0);
        result = 31 * result + (date_fin != null ? date_fin.hashCode() : 0);
        return result;
    }

    public Produit getProduitByProduitId() {
        return produitByProduitId;
    }

    public void setProduitByProduitId(Produit produitByProduitId) {
        this.produitByProduitId = produitByProduitId;
    }

}
