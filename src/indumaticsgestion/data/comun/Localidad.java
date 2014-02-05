package indumaticsgestion.data.comun;

/**
 *
 * @author Maxi
 */
public class Localidad {

    private String localidad;
    private String provincia;
    private String pais;

    public Localidad(String localidad, String provincia, String pais) {
        this.localidad = localidad;
        this.provincia = provincia;
        this.pais = pais;
    }

    public Localidad() {
    }
    
    
    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">

    /**
     * @return the localidad
     */
    public String getLocalidad() {
        return localidad;
    }

    /**
     * @param localidad the localidad to set
     */
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    /**
     * @return the provincia
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * @param provincia the provincia to set
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     * @return the pais
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param pais the pais to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }
     //</editor-fold>

}
