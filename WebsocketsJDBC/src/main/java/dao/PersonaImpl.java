package dao;

import modelo.Persona;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Ubigeo;

public class PersonaImpl extends Conexion implements ICrud<Persona> {

    @Override
    public void registrar(Persona modelo) throws Exception {
        try {
            String sql = "INSERT INTO PERSONA (APEPATPER, APEMATPER, NOMPER, DNIPER, CODUBI, DIRPER, NACPER, GENPER, ESTPER,CELPER,CORPER) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, modelo.getAPEPATPER().toUpperCase());
            ps.setString(2, modelo.getAPEMATPER().toUpperCase());
            ps.setString(3, modelo.getNOMPER());
            ps.setString(4, modelo.getDNIPER());
            ps.setString(5, modelo.getUbigeo().getCODUBI());
            ps.setString(6, modelo.getDIRPER());
            ps.setString(7, "P");
            ps.setString(8, modelo.getGENPER());
            ps.setString(9, "A");
            ps.setString(10, modelo.getCELPER());
            ps.setString(11, modelo.getCORPER());
            ps.executeUpdate();
            ps.clearParameters();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void editar(Persona modelo) throws Exception {
        try {
            eliminar(modelo);
            registrar(modelo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Persona modelo) throws Exception {
        try {
            String sql = "UPDATE PERSONA SET ESTPER=? WHERE IDPER=?";
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ps.setString(1, "I");
            ps.setInt(2, modelo.getIDPER());
            ps.executeUpdate();
            ps.clearParameters();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.desconectar();
        }
    }

    @Override
    public List<Persona> listar() throws Exception {
        List<Persona> lista = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "SELECT persona.IDPER,\n"
                    + "       persona.APEPATPER,\n"
                    + "       persona.APEMATPER,\n"
                    + "       persona.NOMPER,\n"
                    + "       persona.DNIPER,\n"
                    + "       UBIGEO.CODUBI,\n"
                    + "       persona.DIRPER,\n"
                    + "       persona.NACPER,\n"
                    + "       persona.GENPER,\n"
                    + "       persona.ESTPER,\n"
                    + "	   ubigeo.DEPUBI,\n"
                    + "	   ubigeo.PROVUBI,\n"
                    + "	   ubigeo.DISTUBI,"
                    + "     persona.CELPER,"
                    + "     persona.CORPER "
                    + "FROM PERSONA persona\n"
                    + "INNER JOIN UBIGEO ubigeo\n"
                    + "ON persona.CODUBI = ubigeo.CODUBI "
                    + "WHERE persona.ESTPER = 'A'";
            ps = this.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Persona persona = new Persona();
                Ubigeo ubigeo = new Ubigeo();
                persona.setIDPER(rs.getInt(1));
                persona.setAPEPATPER(rs.getString(2));
                persona.setAPEMATPER(rs.getString(3));
                persona.setNOMPER(rs.getString(4));
                persona.setDNIPER(rs.getString(5));
                ubigeo.setCODUBI(rs.getString(6));
                persona.setDIRPER(rs.getString(7));
                persona.setNACPER(rs.getString(8));
                persona.setGENPER(rs.getString(9));
                persona.setESTPER(rs.getString(10));

                ubigeo.setDEPUBI(rs.getString(11));
                ubigeo.setPROVUBI(rs.getString(12));
                ubigeo.setDISTUBI(rs.getString(13));

                persona.setCELPER(rs.getString(14));
                persona.setCORPER(rs.getString(15));

                persona.setUbigeo(ubigeo);
                lista.add(persona);
            }
            ps.closeOnCompletion();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps.isClosed()) {
                ps.clearParameters();
                rs.close();
                this.desconectar();
            }
        }
        return lista;
    }

    @Override
    public Persona obtenerModelo(Persona modelo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Persona> listar(Persona modelo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
