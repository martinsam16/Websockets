package controlador;

import dao.PersonaImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Persona;
import org.primefaces.PrimeFaces;

@Named(value = "personaC")
@SessionScoped
public class PersonaC implements Serializable {

    Persona persona, personaSeleccionada;
    List<Persona> lista, listaFiltrada;
    PersonaImpl daoPersona;

    public PersonaC() {
        persona = new Persona();
        personaSeleccionada = new Persona();
        lista = new ArrayList<>();
        daoPersona = new PersonaImpl();
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
            lista = daoPersona.listar();
            System.out.println("Litado!!!!!!!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registrar() throws Exception {
        try {
            if (lista.contains(persona) == false) {
                daoPersona.registrar(persona);
                PrimeFaces.current().executeScript("enviar('" + persona.getNOMPER() + "');");
//                listar();
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage("Registro Exitoso")
                );
                persona.clear();
            } else {
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage("La persona a la que intentó registrar ya lo está")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void editar() throws Exception {
        try {
            daoPersona.editar(personaSeleccionada);
//            listar();
            PrimeFaces.current().executeScript("enviar('" + personaSeleccionada.getNOMPER() + "');");
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage("Modificacion exitosa")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminar() throws Exception {
        try {
            daoPersona.eliminar(personaSeleccionada);
            PrimeFaces.current().executeScript("enviar('" + personaSeleccionada.getNOMPER() + "');");
//            listar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Persona getPersonaSeleccionada() {
        return personaSeleccionada;
    }

    public void setPersonaSeleccionada(Persona personaSeleccionada) {
        this.personaSeleccionada = personaSeleccionada;
    }

    public List<Persona> getLista() {
        return lista;
    }

    public void setLista(List<Persona> lista) {
        this.lista = lista;
    }

    public List<Persona> getListaFiltrada() {
        return listaFiltrada;
    }

    public void setListaFiltrada(List<Persona> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }

}
