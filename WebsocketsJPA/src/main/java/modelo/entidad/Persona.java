package modelo.entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(catalog = "", schema = "DBIDOC")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findByIdper", query = "SELECT p FROM Persona p WHERE p.idper = :idper")
    , @NamedQuery(name = "Persona.findByApepatper", query = "SELECT p FROM Persona p WHERE p.apepatper = :apepatper")
    , @NamedQuery(name = "Persona.findByApematper", query = "SELECT p FROM Persona p WHERE p.apematper = :apematper")
    , @NamedQuery(name = "Persona.findByNomper", query = "SELECT p FROM Persona p WHERE p.nomper = :nomper")
    , @NamedQuery(name = "Persona.findByDniper", query = "SELECT p FROM Persona p WHERE p.dniper = :dniper")
    , @NamedQuery(name = "Persona.findByDirper", query = "SELECT p FROM Persona p WHERE p.dirper = :dirper")
    , @NamedQuery(name = "Persona.findByNacper", query = "SELECT p FROM Persona p WHERE p.nacper = :nacper")
    , @NamedQuery(name = "Persona.findByGenper", query = "SELECT p FROM Persona p WHERE p.genper = :genper")
    , @NamedQuery(name = "Persona.findByEstper", query = "SELECT p FROM Persona p WHERE p.estper = :estper")
    , @NamedQuery(name = "Persona.findByCorper", query = "SELECT p FROM Persona p WHERE p.corper = :corper")
    , @NamedQuery(name = "Persona.findByCelper", query = "SELECT p FROM Persona p WHERE p.celper = :celper")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Long idper;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String apepatper;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String apematper;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(nullable = false, length = 50)
    private String nomper;
    @Size(max = 8)
    @Column(length = 8)
    private String dniper;
    @Size(max = 100)
    @Column(length = 100)
    private String dirper;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Character nacper;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Character genper;
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Character estper;
    @Size(max = 100)
    @Column(length = 100)
    private String corper;
    @Size(max = 9)
    @Column(length = 9)
    private String celper;
    @JoinColumn(name = "CODUBI", referencedColumnName = "CODUBI", nullable = false)
    @ManyToOne(optional = false)
    private Ubigeo codubi;

    public Persona() {
    }

    public Persona(Long idper) {
        this.idper = idper;
    }

    public Persona(Long idper, String apepatper, String apematper, String nomper, Character nacper, Character genper, Character estper) {
        this.idper = idper;
        this.apepatper = apepatper;
        this.apematper = apematper;
        this.nomper = nomper;
        this.nacper = nacper;
        this.genper = genper;
        this.estper = estper;
    }

    public Long getIdper() {
        return idper;
    }

    public void setIdper(Long idper) {
        this.idper = idper;
    }

    public String getApepatper() {
        return apepatper;
    }

    public void setApepatper(String apepatper) {
        this.apepatper = apepatper;
    }

    public String getApematper() {
        return apematper;
    }

    public void setApematper(String apematper) {
        this.apematper = apematper;
    }

    public String getNomper() {
        return nomper;
    }

    public void setNomper(String nomper) {
        this.nomper = nomper;
    }

    public String getDniper() {
        return dniper;
    }

    public void setDniper(String dniper) {
        this.dniper = dniper;
    }

    public String getDirper() {
        return dirper;
    }

    public void setDirper(String dirper) {
        this.dirper = dirper;
    }

    public Character getNacper() {
        return nacper;
    }

    public void setNacper(Character nacper) {
        this.nacper = nacper;
    }

    public Character getGenper() {
        return genper;
    }

    public void setGenper(Character genper) {
        this.genper = genper;
    }

    public Character getEstper() {
        return estper;
    }

    public void setEstper(Character estper) {
        this.estper = estper;
    }

    public String getCorper() {
        return corper;
    }

    public void setCorper(String corper) {
        this.corper = corper;
    }

    public String getCelper() {
        return celper;
    }

    public void setCelper(String celper) {
        this.celper = celper;
    }

    public Ubigeo getCodubi() {
        return codubi;
    }

    public void setCodubi(Ubigeo codubi) {
        this.codubi = codubi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idper != null ? idper.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idper == null && other.idper != null) || (this.idper != null && !this.idper.equals(other.idper))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.entidad.Persona[ idper=" + idper + " ]";
    }
    
}
