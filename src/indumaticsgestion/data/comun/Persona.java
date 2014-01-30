package indumaticsgestion.data.comun;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Maxi
 */
public class Persona {

    String nombre;
    String direccion;
    Set<Telefono> telefonos = new HashSet<>();
    Localidad localidad;
    Set<Email> emails = new HashSet<>();

    
    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Set<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(Set<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    public void addTelefono(Telefono telefono) {
        this.telefonos.add(telefono);
    }

    public boolean removeTelefono(Telefono telefono) {
        return this.telefonos.remove(telefono);
    }

    /**
     *
     * @param telefono
     */
    public void updateTelefono(Telefono telefono) {
        if (removeTelefono(telefono)) {
            addTelefono(telefono);
        }
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
    
     public Set<Email> getEmails() {
        return emails;
    }

    public void setEmails(Set<Email> emails) {
        this.emails = emails;
    }
    
    public void addEmail(Email email){
        this.emails.add(email);
    }
    
    public boolean removeEmail(Email email){
        return this.emails.remove(email);
    }
    
    public void updateEmail(Email email) throws Exception{
        if(removeEmail(email)){
            addEmail(email);
        }
        throw new Exception("Error al modificar el Email!");
    }
    
    //</editor-fold>

   
   

}
