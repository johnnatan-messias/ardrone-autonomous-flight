/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ardrone;

import com.codeminders.ardrone.NavData;
import com.codeminders.ardrone.NavDataListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Johnnatan
 */
public class Sensores implements NavDataListener {

    private String datas;
    private String printFile;
    private PrintWriter printWriter;
    private static int battery;
    private static float altitude;
    private static float longitude;
    private static float pitch;
    private static float roll;
    private static int sequence;
    private static float vx;
    private static float vz;
    private static float yaw;

    public Sensores(String fileName) {
        try {
            printWriter = new PrintWriter(fileName);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Sensores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void navDataReceived(NavData nd) {
        setParameters(nd);
        datas = "Bateria=" + getBattery() + "%" + "\t"
                + "Altitude=" + getAltitude() + "\t" + "Vy="
                + getLongitude() + "\t" + "Pitch="
                + getPitch() + "\t" + "Roll=" + getRoll()
                + "\t" + "Sequence=" + getSequence() + "\t"
                + "Vx=" + getVx() + "\t" + "Vz=" + getVz()
                + "\t" + "Yaw=" + getYaw();
        saveFile();
        System.out.println(datas);

    }

    public PrintWriter getFile() {
        return printWriter;
    }

    private void saveFile() {
        printFile = getTimestamp() + ";" + getBattery() + ";"
                + getAltitude() + ";"
                + getLongitude() + ";"
                + getPitch() + ";" + getRoll()
                + ";" + getSequence() + ";"
                + getVx() + ";" + getVz()
                + ";" + getYaw();
        printWriter.write(printFile + "\n");
    }

    private void setParameters(NavData nd) {
        battery = nd.getBattery();
        altitude = nd.getAltitude();
        longitude = nd.getLongitude();
        pitch = nd.getPitch();
        roll = nd.getRoll();
        sequence = nd.getSequence();
        vx = nd.getVx();
        vz = nd.getVz();
        yaw = nd.getYaw();
       
    }

    public static int getBattery() {
        return battery;
    }

    public static float getAltitude() {
        return altitude;
    }

    public static float getLongitude() {
        return longitude;
    }

    public static float getPitch() {
        return pitch;
    }

    public static float getRoll() {
        return roll;
    }

    public static int getSequence() {
        return sequence;
    }

    public static float getVx() {
        return vx;
    }

    public static float getVz() {
        return vz;
    }

    public static float getYaw() {
        return yaw;
    }

    public static String getTimestamp() {
        Date date = new Date();
        String dateTimestamp = String.valueOf(date.getTime() / 1000);
        return dateTimestamp;
    }

    public void closeFile() {
        printWriter.close();
    }

    public String getData() {
        return datas;
    }
}
