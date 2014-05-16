/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package indumaticsgestion.data.comun;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Maxi
 */
public class Utils {

    public static final int OK_OPTION = JOptionPane.OK_OPTION;
    public static final int CANCEL_OPTION = JOptionPane.CANCEL_OPTION;
    public static final int NO_OPTION = JOptionPane.NO_OPTION;

    public static Image iconToImage(Icon icon) {
        if (icon instanceof ImageIcon) {
            return ((ImageIcon) icon).getImage();
        } else {
            BufferedImage image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
            icon.paintIcon(null, image.getGraphics(), 0, 0);
            return image;
        }
    }

    public static int confirmMsg(String title, String msg) {
        int option;
        option = JOptionPane.showConfirmDialog(null, msg, title, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        return option;
    }

    public static void errorMsg(String title, String msg) {
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.ERROR_MESSAGE);
    }

    public static void msg(String title, String msg) {
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static Date now(){
        return new Date(System.currentTimeMillis());
    }
    
    public static String DateTimeToStr(Date date){
        SimpleDateFormat dFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        return dFormat.format(date);
    }

    public static boolean validaCuit(String cuit) {
        String consaMult = "5432765432";
        String[] aMult = null;
        aMult = consaMult.split("");
        String[] aCUIT = cuit.split("");

        if (aCUIT.length == 11) {
            int iResult = 0;
            for (int i = 0; i <= 9; i++) {
                iResult += Integer.parseInt(aCUIT[i]) * Integer.parseInt(aMult[i]);
            }
            iResult = (iResult % 11);
            iResult = 11 - iResult;

            if (iResult == 11) {
                iResult = 0;
            }
            if (iResult == 10) {
                iResult = 9;
            }

            if (iResult == Integer.parseInt(aCUIT[10])) {
                return true;
            }
        }
        return false;
    }

    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    /**
     * Validate given email with regular expression.
     *
     * @param email email for validation
     * @return true valid email, otherwise false
     */
    public static boolean validateEmail(String email) {

        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);

        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
