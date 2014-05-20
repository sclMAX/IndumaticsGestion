package indumaticsgestion.data.produccion;

import com.db4o.config.annotations.Indexed;
import com.db4o.constraints.UniqueFieldValueConstraint;
import com.db4o.cs.config.ServerConfiguration;
import static indumaticsgestion.data.comun.Utils.now;
import indumaticsgestion.data.comun.annotations.SearchLike;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Perfil {

    @Indexed
    @SearchLike
    private String codigo;
    @SearchLike
    private String descripcion;
    private int largo;
    private int barrasPaquete;
    private int pesoMetro;
    private Set<Matriz> matrices;
    private Date fechaUltAct;
    private final Date fechaIngreso;
    
    public static ServerConfiguration setDBConfig(ServerConfiguration sc){
        sc.common().add(new UniqueFieldValueConstraint(Perfil.class, "codigo"));
        sc.common().objectClass(Perfil.class).objectField("matrices").cascadeOnDelete(true);
        sc.common().objectClass(Perfil.class).objectField("matrices").cascadeOnUpdate(true);
        return sc; 
    }

    public Perfil(String codigo) {
        this.matrices = new HashSet<>();
        this.codigo = codigo;
        this.largo = 6050;
        this.fechaUltAct = now();
        this.fechaIngreso = now();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.fechaUltAct = now();
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.fechaUltAct = now();
        this.descripcion = descripcion;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.fechaUltAct = now();
        this.largo = largo;
    }

    public int getBarrasPaquete() {
        return barrasPaquete;
    }

    public void setBarrasPaquete(int barrasPaquete) {
        this.fechaUltAct = now();
        this.barrasPaquete = barrasPaquete;
    }

    public int getPesoMetro() {
        return pesoMetro;
    }

    public void setPesoMetro(int pesoMetro) {
        this.fechaUltAct = now();
        this.pesoMetro = pesoMetro;
    }

    public Set<Matriz> getMatrices() {
        return matrices;
    }

    public void setMatrices(Set<Matriz> matrices) {
        this.fechaUltAct = now();
        this.matrices = matrices;
    }

    public void addMatriz(Matriz data) {
        this.fechaUltAct = now();
        this.matrices.add(data);
    }

    public boolean removeMatriz(Matriz data) {
        this.fechaUltAct = now();
        return this.matrices.remove(data);
    }

    public void editMatriz(Matriz oldData, Matriz newData) {
        if (removeMatriz(oldData)) {
            addMatriz(newData);
        }
    }

    public Date getFechaUltAct() {
        return fechaUltAct;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    @Override
    public String toString() {
        return codigo;
    }
}
