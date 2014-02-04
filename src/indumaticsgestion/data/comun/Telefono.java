package indumaticsgestion.data.comun;

/**
 *
 * @author Maxi
 */
public final class Telefono {

    public String numero;
    public String tipo;
    public String contacto;
    public String comentario;

    public Telefono(String numero, String tipo, String contacto, String comentario) {
        this.setNumero(numero);
        this.setTipo(tipo);
        this.setContacto(contacto);
        this.setComentario(comentario);
    }

    public Telefono() {
    }
    
    

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the contacto
     */
    public String getContacto() {
        return contacto;
    }

    /**
     * @param contacto the contacto to set
     */
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    /**
     * @return the comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comentario the comentario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    //</editor-fold>
    @Override
    public String toString() {
        return  numero;
    }

}
