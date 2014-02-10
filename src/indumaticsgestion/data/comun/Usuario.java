package indumaticsgestion.data.comun;

/**
 *
 * @author Maxi
 */
public class Usuario {
    private String user;
    private char[] password;

    public Usuario(String user, char[] password) {
        this.user = user;
        this.password = password;
    }

    
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password.toString();
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return user ;
    }
    
    
    
}
