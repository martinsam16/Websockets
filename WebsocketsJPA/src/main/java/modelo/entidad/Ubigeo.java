package modelo.entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(catalog = "", schema = "DBIDOC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ubigeo.findAll", query = "SELECT u FROM Ubigeo u")
    , @NamedQuery(name = "Ubigeo.findByCodubi", query = "SELECT u FROM Ubigeo u WHERE u.codubi = :codubi")
    , @NamedQuery(name = "Ubigeo.findByDepubi", query = "SELECT u FROM Ubigeo u WHERE u.depubi = :depubi")
    , @NamedQuery(name = "Ubigeo.findByProvubi", query = "SELECT u FROM Ubigeo u WHERE u.provubi = :provubi")
    , @NamedQuery(name = "Ubigeo.findByDistubi", query = "SELECT u FROM Ubigeo u WHERE u.distubi = :distubi")})
public class Ubigeo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(nullable = false, length = 6)
    private String codubi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(nullable = false, length = 13)
    private String depubi;
    @Size(max = 25)
    @Column(length = 25)
    private String provubi;
    @Size(max = 36)
    @Column(length = 36)
    private String distubi;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codubi")
    private List<Persona> personaList;

    public Ubigeo() {
    }

    public Ubigeo(String codubi) {
        this.codubi = codubi;
    }

    public Ubigeo(String codubi, String depubi) {
        this.codubi = codubi;
        this.depubi = depubi;
    }

    public String getCodubi() {
        return codubi;
    }

    public void setCodubi(String codubi) {
        this.codubi = codubi;
    }

    public String getDepubi() {
        return depubi;
    }

    public void setDepubi(String depubi) {
        this.depubi = depubi;
    }

    public String getProvubi() {
        return provubi;
    }

    public void setProvubi(String provubi) {
        this.provubi = provubi;
    }

    public String getDistubi() {
        return distubi;
    }

    public void setDistubi(String distubi) {
        this.distubi = distubi;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codubi != null ? codubi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ubigeo)) {
            return false;
        }
        Ubigeo other = (Ubigeo) object;
        if ((this.codubi == null && other.codubi != null) || (this.codubi != null && !this.codubi.equals(other.codubi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Ubigeo[ codubi=" + codubi + " ]";
    }
    
}
