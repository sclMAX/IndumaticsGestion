package indumaticsgestion.data.comun;

/**
 *
 * @author Maxi
 */
public class PosGPS {
   private double lat;
   private double lon;

    public PosGPS(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public PosGPS() {
        this.lat = 0;
        this.lon = 0;
    }
    
    

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
   
   
}
