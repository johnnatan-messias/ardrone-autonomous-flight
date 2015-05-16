/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ardrone;

import GUI.MainJFrame;

/**
 *
 * @author Johnnatan
 */
public class Ardrone {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controle.setNameFile("data_" + Sensores.getTimestamp() + ".txt");
        MainJFrame gui = new MainJFrame();
        gui.setVisible(true);
    }
}
