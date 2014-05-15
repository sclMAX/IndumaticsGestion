package indumaticsgestion.servidor.clases;

import indumaticsgestion.data.comun.Usuario;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Maxi
 */
public class ServerConfig {
    private String dbpath;
    private int port;
    private Set<Usuario> users = new HashSet<>();

    public ServerConfig(String dbpath, int port) {
        this.dbpath = dbpath;
        this.port = port;
    }

    public ServerConfig() {
        this.dbpath = "indumatics.db4o";
        this.port = 8080;
    }

    public Set<Usuario> getUsers() {
        return users;
    }

    public void setUsers(Set<Usuario> users) {
        this.users = users;
    }

    public void addUser(Usuario user) {
        this.users.add(user);
    }

    public boolean removeUser(Usuario user) {
        return this.users.remove(user);
    }

    public void updateUser(Usuario user) {
        if (removeUser(user)) {
            addUser(user);
        }
    }

    public String getDbpath() {
        return dbpath;
    }

    public void setDbpath(String dbpath) {
        this.dbpath = dbpath;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
