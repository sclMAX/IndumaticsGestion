package indumaticsgestion.data.comun;

/**
 *
 * @author Maxi
 */
public class Email {

    String email;
    String comentario;

    public Email(String email, String comentario) {
        this.email = email;
        this.comentario = comentario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception {
        if (Utils.validateEmail(email)) {
            this.email = email;
        }
        throw new Exception("Email no valido!");
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

}
