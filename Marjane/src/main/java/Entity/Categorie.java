package Entity;

import jakarta.persistence.*;

@Entity
public class Categorie {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_categorie")
    private int idCategorie;
    @Basic
    @Column(name = "nom_categorie")
    private String nomCategorie;
    @Basic
    @Column(name = "created_at")
    private Object createdAt;
    @Basic
    @Column(name = "updated_at")
    private Object updatedAt;

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
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

        Categorie categorie = (Categorie) o;

        if (idCategorie != categorie.idCategorie) return false;
        if (nomCategorie != null ? !nomCategorie.equals(categorie.nomCategorie) : categorie.nomCategorie != null)
            return false;
        if (createdAt != null ? !createdAt.equals(categorie.createdAt) : categorie.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(categorie.updatedAt) : categorie.updatedAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCategorie;
        result = 31 * result + (nomCategorie != null ? nomCategorie.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }
}
