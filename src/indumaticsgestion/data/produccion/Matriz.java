package indumaticsgestion.data.produccion;

import com.db4o.config.annotations.Indexed;
import com.db4o.constraints.UniqueFieldValueConstraint;
import com.db4o.cs.config.ServerConfiguration;
import static indumaticsgestion.data.comun.Utils.now;
import indumaticsgestion.data.comun.annotations.SearchLike;
import java.util.Date;

public class Matriz {

    @Indexed
    @SearchLike
    private String codigo;
    private double areaPerfil;
    private int bocas;
    private int largoTocho;
    private int barrasSalida;
    private int maxTochosTirada;
    private int tempMatriz;
    private int tempTocho;
    private Date fechaIngreso;
    private Date fechaUltAct;

    public static ServerConfiguration setDBConfig(ServerConfiguration sc) {
        sc.common().add(new UniqueFieldValueConstraint(Matriz.class, "codigo"));
        return sc;
    }

    public Matriz(String codigo, double areaPerfil, int bocas) {
        this.codigo = codigo;
        this.areaPerfil = areaPerfil;
        this.bocas = bocas;
        this.fechaUltAct = now();
        this.fechaIngreso = now();
    }

    public Matriz() {
    }

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.fechaUltAct = now();
        this.codigo = codigo;
    }

    /**
     * @return the areaPerfil
     */
    public double getAreaPerfil() {
        return areaPerfil;
    }

    /**
     * @param areaPerfil the areaPerfil to set
     */
    public void setAreaPerfil(double areaPerfil) {
        this.fechaUltAct = now();
        this.areaPerfil = areaPerfil;
    }

    /**
     * @return the bocas
     */
    public int getBocas() {
        return bocas;
    }

    /**
     * @param bocas the bocas to set
     */
    public void setBocas(int bocas) {
        this.fechaUltAct = now();
        this.bocas = bocas;
    }

    /**
     * @return the largoTocho
     */
    public int getLargoTocho() {
        return largoTocho;
    }

    /**
     * @param largoTocho the largoTocho to set
     */
    public void setLargoTocho(int largoTocho) {
        this.fechaUltAct = now();
        this.largoTocho = largoTocho;
    }

    /**
     * @return the barrasSalida
     */
    public int getBarrasSalida() {
        return barrasSalida;
    }

    /**
     * @param barrasSalida the barrasSalida to set
     */
    public void setBarrasSalida(int barrasSalida) {
        this.fechaUltAct = now();
        this.barrasSalida = barrasSalida;
    }

    /**
     * @return the maxTochosTirada
     */
    public int getMaxTochosTirada() {
        return maxTochosTirada;
    }

    /**
     * @param maxTochosTirada the maxTochosTirada to set
     */
    public void setMaxTochosTirada(int maxTochosTirada) {
        this.fechaUltAct = now();
        this.maxTochosTirada = maxTochosTirada;
    }

    /**
     * @return the tempMatriz
     */
    public int getTempMatriz() {
        return tempMatriz;
    }

    /**
     * @param tempMatriz the tempMatriz to set
     */
    public void setTempMatriz(int tempMatriz) {
        this.fechaUltAct = now();
        this.tempMatriz = tempMatriz;
    }

    /**
     * @return the tempTocho
     */
    public int getTempTocho() {
        return tempTocho;
    }

    /**
     * @param tempTocho the tempTocho to set
     */
    public void setTempTocho(int tempTocho) {
        this.fechaUltAct = now();
        this.tempTocho = tempTocho;
    }

    @Override
    public String toString() {
        return codigo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public Date getFechaUltAct() {
        return fechaUltAct;
    }
}
