package modelo;

import java.util.Objects;

public class Persona {

    private int IDPER;
    private String APEPATPER, APEMATPER, NOMPER,
            DNIPER, DIRPER, NACPER, GENPER, ESTPER,
            CORPER, CELPER;
    private Ubigeo ubigeo = new Ubigeo();

    public void clear() {
        this.IDPER = 0;
        this.APEPATPER = null;
        this.APEMATPER = null;
        this.NOMPER = null;
        this.DNIPER = null;
        this.DIRPER = null;
        this.NACPER = null;
        this.GENPER = null;
        this.ESTPER = null;
        this.CORPER = null;
        this.CELPER = null;
        this.ubigeo.clear();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.DNIPER);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        return Objects.equals(this.DNIPER, other.DNIPER);
    }

    public int getIDPER() {
        return IDPER;
    }

    public void setIDPER(int IDPER) {
        this.IDPER = IDPER;
    }

    public String getAPEPATPER() {
        return APEPATPER;
    }

    public void setAPEPATPER(String APEPATPER) {
        this.APEPATPER = APEPATPER;
    }

    public String getAPEMATPER() {
        return APEMATPER;
    }

    public void setAPEMATPER(String APEMATPER) {
        this.APEMATPER = APEMATPER;
    }

    public String getNOMPER() {
        return NOMPER;
    }

    public void setNOMPER(String NOMPER) {
        this.NOMPER = NOMPER;
    }

    public String getDNIPER() {
        return DNIPER;
    }

    public void setDNIPER(String DNIPER) {
        this.DNIPER = DNIPER;
    }

    public String getDIRPER() {
        return DIRPER;
    }

    public void setDIRPER(String DIRPER) {
        this.DIRPER = DIRPER;
    }

    public String getNACPER() {
        return NACPER;
    }

    public void setNACPER(String NACPER) {
        this.NACPER = NACPER;
    }

    public String getGENPER() {
        return GENPER;
    }

    public void setGENPER(String GENPER) {
        this.GENPER = GENPER;
    }

    public String getESTPER() {
        return ESTPER;
    }

    public void setESTPER(String ESTPER) {
        this.ESTPER = ESTPER;
    }

    public String getCORPER() {
        return CORPER;
    }

    public void setCORPER(String CORPER) {
        this.CORPER = CORPER;
    }

    public String getCELPER() {
        return CELPER;
    }

    public void setCELPER(String CELPER) {
        this.CELPER = CELPER;
    }

    public Ubigeo getUbigeo() {
        return ubigeo;
    }

    public void setUbigeo(Ubigeo ubigeo) {
        this.ubigeo = ubigeo;
    }
    
    
}
