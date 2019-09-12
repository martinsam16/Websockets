package controlador;

import dao.UbigeoImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import modelo.Ubigeo;

@Named(value = "ubigeoC")
@SessionScoped
public class UbigeoC implements Serializable {

    List<Ubigeo> listaUbigeo;
    UbigeoImpl daoUbigeo;

    public UbigeoC() {
        listaUbigeo = new ArrayList<>();
        daoUbigeo = new UbigeoImpl();
    }

    @PostConstruct
    public void onInit() {
        try {
            listar();
        } catch (Exception e) {
        }
    }

    public void listar() throws Exception {
        try {
            listaUbigeo = daoUbigeo.listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Ubigeo> getListaUbigeo() {
        return listaUbigeo;
    }

    public void setListaUbigeo(List<Ubigeo> listaUbigeo) {
        this.listaUbigeo = listaUbigeo;
    }

}
