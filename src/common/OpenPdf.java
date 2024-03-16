package common;


import java.io.File;
import javax.swing.JOptionPane;

public class OpenPdf {

    public void OpenById(String id) {
        try {
            String desktopPath = System.getProperty("user.home") + "/Desktop/";
            String filePath = desktopPath + "Tirupati/" + id + ".pdf";

            File file = new File(filePath);

            if (file.exists()) {
                Process p = Runtime.getRuntime().exec("open " + filePath);
            } else {
                JOptionPane.showMessageDialog(null, "File doesn't exist");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
