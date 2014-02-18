package indumaticsgestion.data.comun;

import com.db4o.config.annotations.Indexed;

/**
 *
 * @author Maxi
 */
public class Usuario {
    @Indexed
    private String user;
    private String password;

    public Usuario(String user, char[] password) {
        this.user = user;
        this.password = new String(password);
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
        return this.password;
    }

    public void setPassword(char[] password) {
        this.password = new String(password);
    }

    @Override
    public String toString() {
        return user ;
    }
    
    
    
}
