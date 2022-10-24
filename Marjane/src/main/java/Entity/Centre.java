package Entity;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Centre {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_centre")
    private int idCentre;
    @Basic
    @Column(name = "nom_centre")
    private String nomCentre;
    @Basic
    @Column(name = "created_at")
    private Object createdAt;
    @OneToMany(mappedBy = "centreByCentreId")
    private Collection<Admin> adminsByIdCentre;

    public int getIdCentre() {
        return idCentre;
    }

    public void setIdCentre(int idCentre) {
        this.idCentre = idCentre;
    }

    public String getNomCentre() {
        return nomCentre;
    }

    public void setNomCentre(String nomCentre) {
        this.nomCentre = nomCentre;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Centre centre = (Centre) o;

        if (idCentre != centre.idCentre) return false;
        if (nomCentre != null ? !nomCentre.equals(centre.nomCentre) : centre.nomCentre != null) return false;
        if (createdAt != null ? !createdAt.equals(centre.createdAt) : centre.createdAt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCentre;
        result = 31 * result + (nomCentre != null ? nomCentre.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        return result;
    }

    public Collection<Admin> getAdminsByIdCentre() {
        return adminsByIdCentre;
    }

    public void setAdminsByIdCentre(Collection<Admin> adminsByIdCentre) {
        this.adminsByIdCentre = adminsByIdCentre;
    }
}
