package indumaticsgestion.data.comun;

import com.db4o.config.annotations.Indexed;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Maxi
 */
public class Persona {
    @Indexed
    String nombre;
    String direccion;
    Set<Telefono> telefonos = new HashSet<>();
    String cp;
    Localidad localidad;
    Set<Zona> emails = new HashSet<>();
    PosGPS posGPS;

    
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

    public String getCp(){
        return cp;
    }
    
    public void setCp(String cp){
        this.cp = cp;
    }
    
    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
    
     public Set<Zona> getEmails() {
        return emails;
    }

    public void setEmails(Set<Zona> emails) {
        this.emails = emails;
    }
    
    public void addEmail(Zona email){
        this.emails.add(email);
    }
    
    public boolean removeEmail(Zona email){
        return this.emails.remove(email);
    }
    
    public void updateEmail(Zona email) throws Exception{
        if(removeEmail(email)){
            addEmail(email);
        }
        throw new Exception("Error al modificar el Email!");
    }
    
    //</editor-fold>

   
   

}
