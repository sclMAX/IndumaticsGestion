package indumaticsgestion.data.comun;

import com.db4o.config.annotations.Indexed;

/**
 *
 * @author Maxi
 */
public class Usuario {
    @Indexed
    private String user;
    private char[] password;
    private boolean isAdministrador;

    public Usuario(String user, char[] password) {
        this.user = user;
        this.password = password;
    }

    public Usuario() {
    }

    
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        String s = null;
        if(password != null){
            s = new String(password);
        }
        return s;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return user ;
    }

    public boolean isIsAdministrador() {
        return isAdministrador;
    }

    public void setIsAdministrador(boolean isAdministrador) {
        this.isAdministrador = isAdministrador;
    }    
}
