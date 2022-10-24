package Entity;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
public class Promotion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "pourcentage")
    private BigInteger pourcentage;
    @Basic
    @Column(name = "produit_id")
    private Integer produitId;
    @Basic
    @Column(name = "categorie_id")
    private Integer categorieId;
    @Basic
    @Column(name = "created_at")
    private Object createdAt;
    @Basic
    @Column(name = "updated_at")
    private Object updatedAt;
    @ManyToOne
    @JoinColumn(name = "produit_id", referencedColumnName = "id_produit")
    private Produit produitByProduitId;
    @ManyToOne
    @JoinColumn(name = "categorie_id", referencedColumnName = "id_categorie")
    private Categorie categorieByCategorieId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigInteger getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(BigInteger pourcentage) {
        this.pourcentage = pourcentage;
    }

    public Integer getProduitId() {
        return produitId;
    }

    public void setProduitId(Integer produitId) {
        this.produitId = produitId;
    }

    public Integer getCategorieId() {
        return categorieId;
    }

    public void setCategorieId(Integer categorieId) {
        this.categorieId = categorieId;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Promotion promotion = (Promotion) o;

        if (id != promotion.id) return false;
        if (pourcentage != null ? !pourcentage.equals(promotion.pourcentage) : promotion.pourcentage != null)
            return false;
        if (produitId != null ? !produitId.equals(promotion.produitId) : promotion.produitId != null) return false;
        if (categorieId != null ? !categorieId.equals(promotion.categorieId) : promotion.categorieId != null)
            return false;
        if (createdAt != null ? !createdAt.equals(promotion.createdAt) : promotion.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(promotion.updatedAt) : promotion.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (pourcentage != null ? pourcentage.hashCode() : 0);
        result = 31 * result + (produitId != null ? produitId.hashCode() : 0);
        result = 31 * result + (categorieId != null ? categorieId.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }

    public Produit getProduitByProduitId() {
        return produitByProduitId;
    }

    public void setProduitByProduitId(Produit produitByProduitId) {
        this.produitByProduitId = produitByProduitId;
    }

    public Categorie getCategorieByCategorieId() {
        return categorieByCategorieId;
    }

    public void setCategorieByCategorieId(Categorie categorieByCategorieId) {
        this.categorieByCategorieId = categorieByCategorieId;
    }
}
