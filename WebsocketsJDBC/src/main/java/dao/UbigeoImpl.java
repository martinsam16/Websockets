package dao;

import modelo.Ubigeo;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UbigeoImpl extends Conexion implements ICrud<Ubigeo> {

    @Override
    public void registrar(Ubigeo modelo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void editar(Ubigeo modelo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Ubigeo modelo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ubigeo> listar() throws Exception {
        List<Ubigeo> listaTemporal = new ArrayList<>();
        try {
            String sql = "SELECT ubigeo.CODUBI, ubigeo.DEPUBI, ubigeo.PROVUBI, ubigeo.DISTUBI FROM UBIGEO ubigeo ";
//                    + "WHERE ubigeo.PROVUBI = 'CAÑETE'";
            ResultSet rs = this.conectar().createStatement().executeQuery(sql);
            while (rs.next()) {
                Ubigeo ubigeo = new Ubigeo();
                ubigeo.setCODUBI(rs.getString(1));
                ubigeo.setDEPUBI(rs.getString(2));
                ubigeo.setPROVUBI(rs.getString(3));
                ubigeo.setDISTUBI(rs.getString(4));
                listaTemporal.add(ubigeo);
            }
            rs.clearWarnings();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.desconectar();
        }
        return listaTemporal;
    }

    @Override
    public Ubigeo obtenerModelo(Ubigeo modelo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ubigeo> listar(Ubigeo modelo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
